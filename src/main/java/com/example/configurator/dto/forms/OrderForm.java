package com.example.configurator.dto.forms;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class OrderForm {
    String model;
    List<String> optionList;

}
