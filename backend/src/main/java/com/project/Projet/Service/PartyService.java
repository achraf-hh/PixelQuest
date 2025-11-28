package com.project.Projet.Service;

import com.project.Projet.Domain.PartyDomain;
import com.project.Projet.Entity.Party;
import com.project.Projet.Entity.Player;
import com.project.Projet.Repository.PartyRepository;
import com.project.Projet.Repository.PlayerRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PartyService {

    private final PartyRepository partyRepository;
    private final PlayerRepository playerRepository;

    public PartyService(PartyRepository partyRepository, PlayerRepository playerRepository) {
        this.partyRepository = partyRepository;
        this.playerRepository = playerRepository;
    }

    public Party createParty(PartyDomain domain) {
        List<Player> players = domain.getPlayerIds().stream()
                .map(playerRepository::findById)
                .filter(Optional::isPresent)
                .map(Optional::get)
                .collect(Collectors.toList());

        Party party = new Party(domain.getName(), players);
        return partyRepository.save(party);
    }

    public List<Party> getAllParties() {
        return partyRepository.findAll();
    }

    public void deleteParty(Long id) {
        partyRepository.deleteById(id);
    }
}