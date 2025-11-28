package com.project.Projet.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.Projet.Entity.Player;
import com.project.Projet.Repository.PlayerRepository;

@Service
public class PlayerService {

    @Autowired
    private PlayerRepository playerRepository;

    public Player createPlayer(Player p) {
        return playerRepository.save(p);
    }

    public Player getPlayer(Long id) {
        return playerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Player not found"));
    }
}
