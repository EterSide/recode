package com.example.recode.repository;

import com.example.recode.entity.Player;
import com.example.recode.entity.Recode;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RecodeRepository extends JpaRepository<Recode, Long> {

    public List<Recode> findByPlayer1_id(Long id);

    public List<Recode> findByMap_id(Long id);

}
