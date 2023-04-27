package com.goott.pj3.plan.service;

import com.goott.pj3.plan.dto.PlanDTO;
import com.goott.pj3.plan.repo.CartDAO;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CartServiceImpl implements CartService{
    final
    CartDAO cartDAO;

    public CartServiceImpl(CartDAO cartDAO) {
        this.cartDAO = cartDAO;
    }

    @Override
    public void addCart(PlanDTO planDTO) {
            cartDAO.addCart(planDTO);
    }

    @Override
    public List<PlanDTO> getCart(PlanDTO planDTO) {
        return cartDAO.getCart(planDTO);
    }

    @Override
    public void deleteCart(int planIdx) {
        cartDAO.deleteCart(planIdx);

    }
}
