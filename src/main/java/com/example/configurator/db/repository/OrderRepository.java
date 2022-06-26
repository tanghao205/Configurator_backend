package com.example.configurator.db.repository;

import com.example.configurator.db.entity.Model;
import com.example.configurator.db.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
    Order save(Order order);
}
