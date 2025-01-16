package com.example.recode.repository;

import com.example.recode.entity.Map;
import com.example.recode.entity.Map;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MapRepository extends JpaRepository<Map, Long> {


}
