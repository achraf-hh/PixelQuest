package com.project.Projet.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.Projet.Entity.Player;
import com.project.Projet.Service.PlayerService;

@RestController
@RequestMapping("/players")
public class PlayerController {

    @Autowired
    private PlayerService playerService;

    @PostMapping
    public Player create(@RequestBody Player p) {
        return playerService.createPlayer(p);
    }

    @GetMapping("/{id}")
    public Player get(@PathVariable Long id) {
        return playerService.getPlayer(id);
    }
}
