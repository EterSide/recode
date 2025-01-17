package com.example.recode.controiler;

import com.example.recode.entity.Recode;
import com.example.recode.service.RecodeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class MainController {

    private final RecodeService recodeService;

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

    @GetMapping("/player")
    public String player(Model model) {
        List<Recode> recodes = recodeService.recodeList();
        model.addAttribute("recodes", recodes);
        return "player";
    }

    @GetMapping("/map")
    public String map(Model model) {
        List<Recode> recodes = recodeService.recodeList();
        model.addAttribute("recodes", recodes);
        return "map";
    }

}
