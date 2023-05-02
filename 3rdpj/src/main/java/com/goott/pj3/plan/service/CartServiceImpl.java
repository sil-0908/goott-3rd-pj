package com.goott.pj3.plan.service;

import com.goott.pj3.plan.dto.PlanDTO;
import com.goott.pj3.plan.repo.CartDAO;
import org.springframework.stereotype.Service;

import java.util.List;

//2023.04.24 길영준
//2023.04.26 길영준 주석추가
@Service
public class CartServiceImpl implements CartService {
    final
    CartDAO cartDAO;

    public CartServiceImpl(CartDAO cartDAO) {
        this.cartDAO = cartDAO;
    }

    //카트추가
    @Override
    public void addCart(PlanDTO planDTO) {
        cartDAO.addCart(planDTO);
    }

    //카트불러오기
    @Override
    public List<PlanDTO> getCart(PlanDTO planDTO) {
        return cartDAO.getCart(planDTO);
    }

    //카트삭제
    @Override
    public void deleteCart(int planIdx) {
        cartDAO.deleteCart(planIdx);

    }
}
