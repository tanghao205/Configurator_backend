package com.example.configurator.controller;


import com.example.configurator.db.entity.Model;
import com.example.configurator.db.entity.Option;
import com.example.configurator.db.repository.ModelRepository;
import com.example.configurator.db.repository.OptionRepository;
import com.example.configurator.dto.forms.ModelForm;
import com.example.configurator.dto.forms.OrderForm;
import com.example.configurator.service.ModelService;
import com.example.configurator.service.OptionService;
import com.example.configurator.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping(value = "/order")
public class OrderController {

    @Autowired
    OrderService orderService;

    @Autowired
    ModelService modelService;

    @Autowired
    OptionService optionService;

    @GetMapping(value="/model")
    public ResponseEntity getModels() {
        return new ResponseEntity<>(modelService.getModels(), HttpStatus.OK);
    }

    @PostMapping(value="/option")
    public ResponseEntity getOptions(@RequestBody ModelForm modelForm) {
        return new ResponseEntity<>(optionService.getOptions(modelForm), HttpStatus.OK);
    }

    @PostMapping(value="/placeOrder")
    public ResponseEntity placeOrderApi(@RequestBody OrderForm orderForm) {
        return new ResponseEntity<>(orderService.placeOrder(orderForm), HttpStatus.OK);
    }

}
