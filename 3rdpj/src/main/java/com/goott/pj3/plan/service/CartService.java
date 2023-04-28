package com.goott.pj3.plan.service;

import com.goott.pj3.plan.dto.PlanDTO;

import java.util.List;

public interface CartService {
    void addCart(PlanDTO planDTO);
    List<PlanDTO> getCart(PlanDTO planDTO);
    void deleteCart(int planIdx);
}
