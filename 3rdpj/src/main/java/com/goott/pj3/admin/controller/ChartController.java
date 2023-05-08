package com.goott.pj3.admin.controller;

import com.goott.pj3.admin.dto.ChartDTO;
import com.goott.pj3.admin.service.AdminUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.*;

@Controller
@RequestMapping("/admin/**")
public class ChartController {

    @Autowired
    AdminUserService adminUserService;

    /**
     * 신진영 23.05.03
     * 사용자 권한별 가입자 수 데이터를 활용하여 차트 생성
     * @param mv ModelAndView 객체
     * @return 사용자 권한별 가입자 수 데이터를 활용하여 생성된 차트 페이지
     */
    @RequestMapping(value = "/userchart", method = RequestMethod.GET)
    public ModelAndView userChart(ModelAndView mv) {
        // 권한 'auth_a'에 해당하는 사용자들의 월별 가입 인원수 데이터를 조회하여 모델에 추가
        mv.addObject("auth_a", makeData(adminUserService.getUserMonthByAuth("auth_a")));
        // 권한 'auth_b'에 해당하는 사용자들의 월별 가입 인원수 데이터를 조회하여 모델에 추가
        mv.addObject("auth_b", makeData(adminUserService.getUserMonthByAuth("auth_b")));
        // 권한 'auth_c'에 해당하는 사용자들의 월별 가입 인원수 데이터를 조회하여 모델에 추가
        mv.addObject("auth_c", makeData(adminUserService.getUserMonthByAuth("auth_c")));
        // 사용자 월별 가입 인원수 차트 페이지로 이동
        mv.setViewName("admin/chart/userchart");
        return mv; // 생성된 차트 페이지 반환
    }
    /**
     * 신진영 23.05.03 ChartDTO 리스트를 받아서 월별 count 데이터를 문자열 리스트로 변환하는 메서드
     * @param list ChartDTO 리스트
     * @return 월별 count 데이터를 담은 문자열 리스트
     */
    public List<String> makeData(List<ChartDTO> list) {
        Map<Integer, Integer> authMap = new HashMap<>(); // 각 월별 count 데이터를 담을 Map 초기화
        for (int i = 1; i < 13; i++) { // 1월부터 12월까지 월별 데이터 초기화
            authMap.put(i, 0);
        }
        for (int i = 0; i < list.size(); i++) { // 받아온 ChartDTO 리스트를 순회하며 데이터 집어넣기
            int month = list.get(i).getMonth(); // month 정보
            int count = list.get(i).getCount(); // count 정보
            authMap.put(month, count); // 해당 월의 count 데이터 Map에 추가
        }
        List<String> countList = new ArrayList<>(); // 각 월별 count 데이터를 담은 리스트 생성
        for (int i = 1; i < 13; i++) {
            countList.add(String.valueOf(authMap.get(i)));
        }
        return countList; // 최종 불러올 리스트 반환
    }
//
//    @RequestMapping(value = "/saleschart", method = RequestMethod.GET)
//    public String salesChart(){
//        adminUserService.salesChart();
//        return "admin/saleschart";
//    }


}
