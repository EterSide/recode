package com.example.recode.service;

import com.example.recode.entity.Player;
import com.example.recode.repository.PlayerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PlayerService {

    private final PlayerRepository playerRepository;

    public void save(Player player) {
        playerRepository.save(player);
    }

    public Optional<Player> getPlayer(Long player_id) {
        return playerRepository.findById(player_id);
    }

    public void update(Long player_id, Player player) {
        Player pr = playerRepository.findById(player_id).get();
        pr.setWin(player.getWin());
        pr.setLose(player.getLose());
        playerRepository.save(pr);

    }

}
