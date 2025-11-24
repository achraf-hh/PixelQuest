package com.project.Projet.Service;

import com.project.Projet.Domain.PlayerDomain;
import com.project.Projet.Entity.Player;
import com.project.Projet.Repository.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PlayerService {

    @Autowired
    private PlayerRepository playerRepository;

    // Créer un joueur
    public PlayerDomain createPlayer(PlayerDomain playerDomain) {
        Player player = new Player(playerDomain.getUsername(), playerDomain.getEmail());
        Player saved = playerRepository.save(player);
        return new PlayerDomain(saved.getId(), saved.getUsername(), saved.getEmail());
    }

    // Lister tous les joueurs
    public List<PlayerDomain> getAllPlayers() {
        return playerRepository.findAll()
                .stream()
                .map(p -> new PlayerDomain(p.getId(), p.getUsername(), p.getEmail()))
                .collect(Collectors.toList());
    }

    // Supprimer un joueur par ID
    public void deletePlayer(Long id) {
        playerRepository.deleteById(id);
    }
}
