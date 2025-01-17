package com.example.recode.controiler;

import com.example.recode.entity.Map;
import com.example.recode.entity.Player;
import com.example.recode.entity.Recode;
import com.example.recode.service.MapService;
import com.example.recode.service.PlayerService;
import com.example.recode.service.RecodeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;

import java.util.List;
import java.util.Optional;

@Controller
@RequiredArgsConstructor
public class MainController {

    private final RecodeService recodeService;
    private final PlayerService playerService;
    private final MapService mapService;

    @GetMapping("/")
    public String index(Model model) {
        List<Recode> recodes = recodeService.recodeList();
        model.addAttribute("recodes", recodes);
        return "index";
    }

    @GetMapping("/lists")
    public String tables(Model model) {
        List<Recode> recodes = recodeService.recodeList();
        model.addAttribute("recodes", recodes);
        return "tables";
    }

    @GetMapping("/player/{id}")
    public String player(@PathVariable Long id,Model model) {

        Player player = playerService.getPlayer(id).get();
        List<Recode> recodes = recodeService.getPlayerRecode(player);
        model.addAttribute("recodes", recodes);
        return "player.html";
    }

    @GetMapping("/map/{id}")
    public String map(Model model,@PathVariable Long id) {
        Map map = mapService.getMap(id).get();
        List<Recode> recodes = recodeService.getMapRecode(map);
        model.addAttribute("recodes", recodes);
        return "map";
    }

}
