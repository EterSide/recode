package com.example.recode.controiler;

import com.example.recode.entity.Player;
import com.example.recode.entity.Recode;
import com.example.recode.service.MapService;
import com.example.recode.service.PlayerService;
import com.example.recode.service.RecodeService;
import com.example.recode.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/recode")
public class RecodeController {

    private final RecodeService recodeService;
    private final PlayerService playerService;
    private final MapService mapService;
    private final UserService userService;

    @PostMapping(value = "/save")
    @ResponseBody
    public void savePlayer(@RequestBody Recode recode, Long player1_id, Long player2_id, Long map_id, Long user_id) {

        Recode r = new Recode();
        Recode r1 = new Recode();
        Player p1 = playerService.getPlayer(player1_id).get();
        Player p2 = playerService.getPlayer(player2_id).get();

        r.setPlayer1(p1);
        r.setPlayer2(p2);
        r.setUser(userService.getUser(user_id).get());
        r.setMap(mapService.getMap(map_id).get());
        r.setResult(true);
        recodeService.save(r);
        p1.setWin(p1.getWin()+1);
        p2.setLose(p1.getLose()+1);
        playerService.save(p1);
        playerService.save(p2);

        r1.setPlayer1(p2);
        r1.setPlayer2(p1);
        r1.setUser(userService.getUser(user_id).get());
        r1.setMap(mapService.getMap(map_id).get());

        recodeService.save(r1);

    }

    @GetMapping("/lists")
    public String getRecodes(Model model) {
        List<Recode> recodes = recodeService.recodeList();
        model.addAttribute("recodes", recodes);
        return "index";
    }


}
