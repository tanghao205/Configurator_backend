package com.example.configurator.dto;

import lombok.Data;

@Data
public class OrderDto {
    String orderNumber;
    String modelName;
    String optionName;

    public OrderDto(String orderNumber, String modelName, String optionName){
        this.orderNumber = orderNumber;
        this.modelName = modelName;
        this.optionName = optionName;
    }
}
