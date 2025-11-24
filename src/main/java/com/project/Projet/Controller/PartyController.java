package com.project.Projet.Controller;

import com.project.Projet.Domain.PartyDomain;
import com.project.Projet.Entity.Party;
import com.project.Projet.Service.PartyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:5173") // autorise ton frontend Vite
@RestController
@RequestMapping("/api/parties")
public class PartyController {

    @Autowired
    private PartyService partyService;

    // Créer une party
    @PostMapping
    public Party createParty(@RequestBody PartyDomain party) {
        return partyService.createParty(party);
    }

    // Lister toutes les parties
    @GetMapping
    public List<Party> getAllParties() {
        return partyService.getAllParties();
    }

    // Récupérer une party par ID
    //@GetMapping("/{id}")
    //public Optional<Party> getPartyById(@PathVariable Long id) {
    //    return partyService.getPartyById(id);
    //}

    // Supprimer une party par ID
    @DeleteMapping("/{id}")
    public void deleteParty(@PathVariable Long id) {
        partyService.deleteParty(id);
    }
}