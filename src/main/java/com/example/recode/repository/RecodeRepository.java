package com.example.recode.repository;

import com.example.recode.entity.Recode;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecodeRepository extends JpaRepository<Recode, Long> {
}
