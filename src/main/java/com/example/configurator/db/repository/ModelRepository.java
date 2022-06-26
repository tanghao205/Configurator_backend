package com.example.configurator.db.repository;

import com.example.configurator.db.entity.Model;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ModelRepository extends JpaRepository<Model, Long> {
    List<Model> findAll();
    Model findByModel(String model);
}
