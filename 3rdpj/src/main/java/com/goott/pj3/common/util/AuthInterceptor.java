package com.goott.pj3.common.util;

import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

//2023.04.18 긿영준 authInterceptor
public class AuthInterceptor extends HandlerInterceptorAdapter {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if (!(handler instanceof HandlerMethod)) {
            return true;
        }
        HandlerMethod handlerMethod = (HandlerMethod) handler;

        Auth auth = handlerMethod.getMethodAnnotation(Auth.class);

        if (auth == null) {
            return true;
        }

        HttpSession httpSession = request.getSession();
        if (httpSession == null) {
            response.sendRedirect(request.getContextPath() + "/user/signin");
            return false;
        }
        String authUser = (String) httpSession.getAttribute("auth");
        if (authUser == null) {
            response.sendRedirect(request.getContextPath() + "/user/signin");
            return false;
        }
        String role = auth.role().toString();
        if ("ADMIN".equals(role)) {
            if (!"auth_a".equals(authUser)) {
                response.sendRedirect(request.getContextPath() + "/user/signin");
                return false;
            }
        }
        if ("PLANNER".equals(role)) {
            if (!"auth_b".equals(authUser)) {
                response.sendRedirect(request.getContextPath() + "/user/signin");
                return false;
            }
        }

        return true;
    }
}
