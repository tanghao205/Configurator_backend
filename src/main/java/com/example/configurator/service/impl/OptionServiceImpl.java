package com.example.configurator.service.impl;

import com.example.configurator.db.entity.Option;
import com.example.configurator.db.repository.OptionRepository;
import com.example.configurator.dto.forms.ModelForm;
import com.example.configurator.service.OptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OptionServiceImpl implements OptionService {

    @Autowired
    OptionRepository optionRepository;

    @Override
    public List<Option> getOptions(ModelForm modelForm) {
        var result  = optionRepository.findAllByModelName(modelForm.getModel());
        return result;
    }
}
