package com.example.configurator.db.entity;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(schema = "public", name = "order_option")
@IdClass(OrderOptionId.class)
@Getter
@Setter
public class OrderOption {

    @Id
    @Column(name = "order_id")
    private Integer orderId;

    @Id
    @Column(name = "option")
    private String option;

}
