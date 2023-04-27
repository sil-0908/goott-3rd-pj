package com.goott.pj3.plan.controller;

import com.goott.pj3.plan.dto.PlanDTO;
import com.goott.pj3.plan.service.CartService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
// 2023.04.24 길영준
@Controller
public class CartController {
    final
    CartService cartService;

    public CartController(CartService cartService) {
        this.cartService = cartService;
    }

    // 카트추가
    @PostMapping(value = "/addcart", consumes = "application/json")
    @ResponseBody
    public Map<String, Object> planCart(@RequestBody PlanDTO planDTO) {
        cartService.addCart(planDTO);
        Map<String, Object> map = new HashMap<>();
        map.put("cart", "카트담기");
        return map;
    }
    //카트 보여주기 데모
    @GetMapping("cart")
    public ModelAndView cart(ModelAndView mv, PlanDTO planDTO, HttpSession httpSession){
        String user = (String)httpSession.getAttribute("user_id");
        planDTO.setUser_id(user);
        mv.addObject("cart", cartService.getCart(planDTO));
        mv.setViewName("cart/cart_demo");
        return mv;
    }
    //카트 삭제
    @DeleteMapping("cart/delete")
    public String delete(@RequestParam("delList") List<Integer> list) {
        for (Integer plan_idx : list) cartService.deleteCart(plan_idx);
        return "redirect:/cart";
    }
}
