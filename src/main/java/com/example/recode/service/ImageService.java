package com.example.recode.service;

import com.example.recode.entity.Image;
import com.example.recode.repository.ImageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ImageService {

    private final ImageRepository imageRepository;

    public void save(Image image) {
        imageRepository.save(image);
    }

}
