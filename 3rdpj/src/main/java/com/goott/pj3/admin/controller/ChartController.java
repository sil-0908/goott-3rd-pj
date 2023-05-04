package com.goott.pj3.admin.controller;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.goott.pj3.admin.dto.chartDTO;
import com.goott.pj3.admin.service.AdminUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.*;

@Controller
@RequestMapping("/admin/**")
public class ChartController {

    @Autowired
    AdminUserService adminUserService;

    @RequestMapping(value = "/userchart", method = RequestMethod.GET)
    public ModelAndView userchart(ModelAndView mv) {
        mv.addObject("auth_a", makeData(adminUserService.getUserMonthByAuth("auth_a")));
        mv.addObject("auth_b", makeData(adminUserService.getUserMonthByAuth("auth_b")));
        mv.addObject("auth_c", makeData(adminUserService.getUserMonthByAuth("auth_c")));
        mv.setViewName("admin/chart/userchart");
        return mv;
    }
    public List<String> makeData(List<chartDTO> list){
        Map<Integer, Integer> authMap = new HashMap<>();
        for (int i = 1; i < 13; i++) { // month 셋팅, 데이터 초기화
            authMap.put(i, 0);
        }
        for (int i = 0; i < list.size(); i++) { // 데이터 집어넣기
            int month = list.get(i).getMonth();
            int count = list.get(i).getCount();
            authMap.put(month, count);
        }
        List<String> countList = new ArrayList<>();
        for (int i = 1; i < 13; i++) { // 집어넣은 데이터 끄내기
            countList.add(String.valueOf(authMap.get(i)));
        }
        return countList; // 최종 불러올 리스트
    }

}
