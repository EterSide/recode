package com.example.recode.controiler;

import com.example.recode.entity.Player;
import com.example.recode.service.PlayerService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/player")
public class PlayerController {

    @Autowired
    private final PlayerService playerService;

    @PostMapping(value = "/save")
    public void savePlayer(@RequestBody Player player) {
        Player p = new Player();
        p.setPlayer_name(player.getPlayer_name());
        p.setTribes(player.getTribes());
        playerService.save(p);
    }

}
