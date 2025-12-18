package com.project.Projet.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.project.Projet.Entity.Party;
import com.project.Projet.Entity.Difficulty;


import com.project.Projet.Service.PartyService;

import com.project.Projet.DTO.PointSampleDTO; 
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/parties")
public class PartyController {

    @Autowired
    private PartyService partyService;

    // 1. Start a new game
    // Call this when the target appears on the OLED
    @PostMapping("/start")
    public Party startParty(
            @RequestParam Long playerId,
            @RequestParam Difficulty difficulty,
            @RequestParam int startX,
            @RequestParam int startY,
            @RequestParam int targetX,
            @RequestParam int targetY
    ) {
        return partyService.startParty(playerId, difficulty, startX, startY, targetX, targetY);
    }

    // 2. Send trajectory samples
    // Call this from the ESP32/Client once the target is reached
    @PostMapping("/{partyId}/samples")
    public void addSamples(@PathVariable Long partyId, @RequestBody List<PointSampleDTO> samples) {
        partyService.addSamples(partyId, samples);
    }

    // 3. Finish game & Calculate Score/Analytics
    // Call this immediately after sending samples
    @PostMapping("/{partyId}/finish")
    public Party finishParty(@PathVariable Long partyId) {
        return partyService.finishParty(partyId);
    }
}