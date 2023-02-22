package com.serviceops.ecommerce.dto.order;

import jakarta.validation.constraints.NotNull;

public class OrderDto {

    private Integer id;
    private @NotNull Integer userId;

    public OrderDto(){}
    public OrderDto(Integer id, Integer userId) {
        this.id = id;
        this.userId = userId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }
}
