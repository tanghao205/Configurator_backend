package com.example.configurator.dto;

import lombok.Data;

@Data
public class OptionDto {
    String optionName;

    public OptionDto(String optionName) {
        this.optionName = optionName;
    }

}
