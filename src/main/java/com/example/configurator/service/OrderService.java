package com.example.configurator.service;

import com.example.configurator.db.entity.Order;
import com.example.configurator.dto.forms.OrderForm;

import java.util.List;

public interface OrderService {
    Order placeOrder(OrderForm orderForm);
}
