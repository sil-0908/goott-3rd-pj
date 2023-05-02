package com.goott.pj3.common.util.auth;

import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

// 2023.04.18 긿영준 authInterceptor
// 2023. 04.22 길영준 admin이 planner 권한도 패스할수 있게 수정 
// 2023.04.26 주석추가
public class AuthInterceptor extends HandlerInterceptorAdapter {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if (!(handler instanceof HandlerMethod)) {
            return true; //메소드핸들러가 아닐때 실행시킴
        }
        HandlerMethod handlerMethod = (HandlerMethod) handler;

        Auth auth = handlerMethod.getMethodAnnotation(Auth.class); //어노테이션클래스 지정
        if (auth == null) {
            return true;    //어노테이션 지정되지 않았으면 실행시킴
        }

        HttpSession httpSession = request.getSession();
        if (httpSession == null) {
            response.sendRedirect(request.getContextPath() + "/user/signin");
            return false; //어노테이션은 있으나 세션이 없으면 리다이렉트
        }
        String authUser = (String) httpSession.getAttribute("auth");
        if (authUser == null) {
            response.sendRedirect(request.getContextPath() + "/user/signin");
            return false; // 세션에 auth 값이 없으면 리다이렉트
        }
        String role = auth.role().toString();
        if ("ADMIN".equals(role)) {
            if (!"auth_a".equals(authUser)) {
                response.sendRedirect(request.getContextPath() + "/user/signin");
                return false; // 롤이 ADMIN 이 아니면 리다이렉트
            }
        }
        if ("PLANNER".equals(role)) {
            if ("auth_a".equals(authUser)) {
                return true; //롤이 어드민이면 통과
            }
            if (!"auth_b".equals(authUser)) {
                response.sendRedirect(request.getContextPath() + "/user/signin");
                return false; //롤이 플래너가 아니면 통과시키지 않음
            }
        }

        return true;    //해당조건이 false가 아니면 진행시킴
    }
}
