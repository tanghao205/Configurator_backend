package com.example.configurator.db.entity;

import com.sun.istack.NotNull;
import lombok.Data;
import net.minidev.json.annotate.JsonIgnore;
import org.hibernate.annotations.Generated;
import org.hibernate.annotations.GenerationTime;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Data
@Entity
@Table(name = "order_table", schema = "public")
public class Order extends DefaultEntity{

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name = "order_id")
    private Integer orderId;

    @Column(name = "order_number")
    private String orderNumber;

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

    @JsonIgnore
    @ManyToMany
    @JoinTable(name = "order_option",
        joinColumns = @JoinColumn(name = "order_id"),
        inverseJoinColumns = @JoinColumn(name = "option"))
    private Set<Option> optionSet;

    public Order(){

    }

}
