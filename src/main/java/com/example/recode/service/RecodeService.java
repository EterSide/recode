package com.example.recode.service;

import com.example.recode.entity.Recode;
import com.example.recode.repository.RecodeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RecodeService {

    private final RecodeRepository recodeRepository;

    public void save(Recode recode) {
        recodeRepository.save(recode);
    }

    public List<Recode> recodeList() {
        return recodeRepository.findAll();
    }


}
