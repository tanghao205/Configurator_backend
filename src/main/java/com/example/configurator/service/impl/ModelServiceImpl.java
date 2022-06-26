package com.example.configurator.service.impl;

import com.example.configurator.db.entity.Model;
import com.example.configurator.db.entity.Option;
import com.example.configurator.db.repository.ModelRepository;
import com.example.configurator.service.ModelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ModelServiceImpl implements ModelService {

    @Autowired
    ModelRepository modelRepository;

    @Override
    public List<Model> getModels() {
        var result  = modelRepository.findAll();
        return result;
    }

}
