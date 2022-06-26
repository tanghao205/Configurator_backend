package com.example.configurator.db.repository;

import com.example.configurator.db.entity.Option;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OptionRepository extends JpaRepository<Option, Long> {
    List<Option> findAllByModelName(String model);

    @Query("select op from Option op where op.optionName in :optionList")
    List<Option> findByOptionList(List<String> optionList);
}
