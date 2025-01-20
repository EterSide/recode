package com.example.recode.controiler;

import com.example.recode.entity.Image;
import com.example.recode.service.ImageService;
import com.example.recode.service.MapService;
import com.example.recode.service.PlayerService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;

@Controller
@RequiredArgsConstructor
@RequestMapping("/image")
public class ImageController {

    private final ImageService imageService;
    private final PlayerService playerService;
    private final MapService mapService;

    @Value("${upload.path}")
    private String uploadPath;

    @PostMapping(value = "/{type}/{id}/upload", consumes ={"multipart/form-data"} )
    @ResponseBody
    public void imageSave(@RequestPart(required = true) MultipartFile file,
                            @PathVariable String type, @PathVariable Long id) throws IOException {

        String fileName = StringUtils.cleanPath(file.getOriginalFilename());
        String timestamp = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss").format(new Date());
        fileName = timestamp + fileName;
        fileName = fileName.replaceAll("[:]", "_");
        Path path = Paths.get(uploadPath + fileName);

        Files.copy(file.getInputStream(), path);
        Image image = new Image();
        image.setFileName(fileName);
        if(type.equals("player")) {
            image.setPlayer(playerService.getPlayer(id).get());
        } else if (type.equals("map")) {
            image.setMap(mapService.getMap(id).get());
        }
        imageService.save(image);
    }

}
