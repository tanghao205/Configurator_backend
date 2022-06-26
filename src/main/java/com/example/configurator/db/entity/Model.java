package com.example.configurator.db.entity;


import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "model", schema = "public")
public class Model extends DefaultEntity{

    @Id
    @Column(name = "model_name")
    private String model;
}
