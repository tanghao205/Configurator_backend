package com.example.configurator.service;

import com.example.configurator.db.entity.Option;
import com.example.configurator.dto.forms.ModelForm;

import java.util.*;

public interface OptionService {
    List<Option> getOptions(ModelForm modelForm);
}
