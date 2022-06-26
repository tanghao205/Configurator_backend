package com.example.configurator.service.impl;

import com.example.configurator.db.entity.Model;
import com.example.configurator.db.entity.Option;
import com.example.configurator.db.entity.Order;
import com.example.configurator.db.repository.ModelRepository;
import com.example.configurator.db.repository.OptionRepository;
import com.example.configurator.db.repository.OrderRepository;
import com.example.configurator.dto.forms.OrderForm;
import com.example.configurator.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.OffsetDateTime;
import java.util.HashSet;
import java.util.Set;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    OrderRepository orderRepository;

    @Autowired
    ModelRepository modelRepository;

    @Autowired
    OptionRepository optionRepository;

    @Override
    @Transactional
    public Order placeOrder(OrderForm orderForm) {
        Order newOrder = new Order();


        Long count = orderRepository.count();
        String orderNumber = String.valueOf(600000001l + count);
        newOrder.setOrderNumber(orderNumber);
        newOrder.setStatus(true);
        newOrder.setCreateDate(OffsetDateTime.now());
        newOrder.setCreatedBy("System");

        Set<Option> optionSet = new HashSet<>(optionRepository.findByOptionList(orderForm.getOptionList()));
        Model model = modelRepository.findByModel(orderForm.getModel());

        newOrder.setOptionSet(optionSet);
        newOrder.setModel(model);
        newOrder.setModelName(model.getModel());

        Order result = orderRepository.save(newOrder);
        return result;
    }
}
