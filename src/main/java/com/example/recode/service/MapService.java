package com.example.recode.service;

import com.example.recode.entity.Map;
import com.example.recode.repository.MapRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MapService {

    private final MapRepository mapRepository;

    public void saveMap(Map map) {
        mapRepository.save(map);
    }

    public Optional<Map> getMap(Long id) {
        return mapRepository.findById(id);
    }



}
