package com.example.recode.controiler;

import com.example.recode.entity.Map;
import com.example.recode.service.MapService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class MapController {

    private final MapService mapService;

    @PostMapping("/save")
    public void save(@RequestBody Map map) {
        Map m = new Map();
        m.setMap_name(map.getMap_name());
        mapService.saveMap(m);
    }


}
