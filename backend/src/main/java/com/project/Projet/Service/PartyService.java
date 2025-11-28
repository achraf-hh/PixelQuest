package com.project.Projet.Service;

import java.time.LocalDateTime;

import com.project.Projet.Entity.Party;
import com.project.Projet.Entity.Player;
import com.project.Projet.Entity.PlayerLevel;
import com.project.Projet.Entity.Difficulty;
import com.project.Projet.Entity.Labyrinth;

import com.project.Projet.Repository.LabyrinthRepository;
import com.project.Projet.Repository.PartyRepository;
import com.project.Projet.Repository.PlayerRepository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PartyService {

    private final PartyRepository partyRepository;
    private final PlayerRepository playerRepository;
    private final LabyrinthRepository labyrinthRepository;

    // Fitts law constants
    private final double A = 0.2;
    private final double B = 0.1;

    /**
     * Create a party before the player starts playing.
     */
    public Party startParty(Long playerId, Long labyrinthId, Difficulty difficulty) {

        Player player = playerRepository.findById(playerId)
                .orElseThrow(() -> new RuntimeException("Player not found"));

        Labyrinth labyrinth = labyrinthRepository.findById(labyrinthId)
                .orElseThrow(() -> new RuntimeException("Labyrinth not found"));

        Party party = new Party();
        party.setPlayer(player);
        party.setLabyrinth(labyrinth);
        party.setDifficulty(difficulty);
        party.setCreationDate(LocalDateTime.now());

        return partyRepository.save(party);
    }

    /**
     * Called when embedded system returns time & distance.
     */
    public Party finishParty(Long partyId, double timeTaken, double distance) {

        Party party = partyRepository.findById(partyId)
                .orElseThrow(() -> new RuntimeException("Party not found"));

        // 1. Compute Fitts expected time
        double expectedTime = A + B * (Math.log(distance + 1) / Math.log(2));

        // 2. Compute XP gained in this party
        double xp = party.getDifficulty().getMultiplier()
                * 50
                * (expectedTime / timeTaken);

        xp = Math.max(xp, 0);      // no negative XP
        xp = Math.min(xp, 500);    // max cap (optional design)

        // Save XP score into party
        party.setScore(xp);
        partyRepository.save(party);

        // 3. Update player cumulative XP
        updatePlayerLevel(party.getPlayer().getId(), (int) xp);

        return party;
    }

    /**
     * Add XP to the player & update level + rank.
     */
    public Player updatePlayerLevel(Long playerId, int gainedScore) {

        Player player = playerRepository.findById(playerId)
                .orElseThrow(() -> new RuntimeException("Player not found"));

        PlayerLevel level = player.getLevel();

        // If first time: initialize a level
        if (level == null) {
            level = new PlayerLevel(0);
        }

        // Add XP + auto-update rank
        level.addScore(gainedScore);

        // Attach updated level
        player.setLevel(level);

        return playerRepository.save(player);
    }

    public Party createParty(Long playerId, Long labyrinthId, Difficulty difficulty) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'createParty'");
    }
}
