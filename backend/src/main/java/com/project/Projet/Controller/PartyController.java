package com.project.Projet.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.project.Projet.Entity.Party;
import com.project.Projet.Entity.Difficulty;


import com.project.Projet.Service.PartyService;

@RestController
@RequestMapping("/parties")
public class PartyController {

    @Autowired
    private PartyService partyService;

    @PostMapping
    public Party create(@RequestParam Long playerId,
                        @RequestParam Long labyrinthId,
                        @RequestParam Difficulty difficulty) {

        return partyService.createParty(playerId, labyrinthId, difficulty);
    }
}
