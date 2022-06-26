package com.example.configurator.db.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.sun.istack.NotNull;
import lombok.Data;
import net.minidev.json.annotate.JsonIgnore;

import javax.persistence.*;

@Data
@Entity
@Table(name = "option", schema = "public")
public class Option extends DefaultEntity{

    @Id
    @Column(name = "option")
    private String optionName;

    @Column(name = "model_name")
    @NotNull
    private String modelName;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "model_name",
            referencedColumnName = "model_name",
            nullable = false,
            insertable = false,
            updatable = false)
    private Model model;

    public Option() {

    }

}
