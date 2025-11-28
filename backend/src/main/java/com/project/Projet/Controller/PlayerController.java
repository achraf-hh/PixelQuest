package com.project.Projet.Controller;

import com.project.Projet.Domain.PlayerDomain;
import com.project.Projet.Service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:5173") // autorise ton frontend Vite
@RestController
@RequestMapping("/api/players")
public class PlayerController {

    @Autowired
    private PlayerService playerService;

    // Créer un joueur
    @PostMapping
    public PlayerDomain createPlayer(@RequestBody PlayerDomain playerDomain) {
        return playerService.createPlayer(playerDomain);
    }

    // Lister tous les joueurs
    @GetMapping
    public List<PlayerDomain> getAllPlayers() {
        return playerService.getAllPlayers();
    }

    // Supprimer un joueur par ID
    @DeleteMapping("/{id}")
    public void deletePlayer(@PathVariable Long id) {
        playerService.deletePlayer(id);
    }
}
