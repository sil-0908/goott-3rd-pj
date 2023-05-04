package com.goott.pj3.admin.dto;

import java.util.Date;

public class chartDTO {

    int count, month;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    @Override
    public String toString() {
        return "chartDTO{" +
                "count='" + count + '\'' +
                ", month='" + month + '\'' +
                '}';
    }
}
