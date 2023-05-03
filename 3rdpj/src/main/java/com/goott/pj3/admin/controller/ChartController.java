package com.goott.pj3.admin.controller;

import com.goott.pj3.admin.service.AdminUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/admin/**")
public class ChartController {

    @Autowired
    AdminUserService adminUserService;

    @RequestMapping(value = "/userchart", method = RequestMethod.GET)
    public ModelAndView userchart(ModelAndView mv) {
        List<Map<String, Object>> usersMonthAuthA = adminUserService.getUserMonthByAuth("auth_a");
        List<Map<String, Object>> usersMonthAuthB = adminUserService.getUserMonthByAuth("auth_b");
        List<Map<String, Object>> usersMonthAuthC = adminUserService.getUserMonthByAuth("auth_c");

        mv.addObject("data_a", usersMonthAuthA);
        System.out.println(usersMonthAuthA.toString());
        mv.addObject("data_b", usersMonthAuthB);
        mv.addObject("data_c", usersMonthAuthC);
        mv.setViewName("admin/chart/userchart");
        return mv;
    }
}
