package com.project.Projet.Domain;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class PartyDomain {
    private Long id;
    private String name;
    private List<Long> playerIds = new ArrayList<>();
    private LocalDateTime createdAt;

    // Constructeur par défaut
    public PartyDomain() {
        this.createdAt = LocalDateTime.now();
    }

    // Constructeur avec paramètres
    public PartyDomain(String name, List<Long> playerIds) {
        this.name = name;
        this.playerIds = playerIds;
        this.createdAt = LocalDateTime.now();
    }

    // Getters et setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Long> getPlayerIds() {
        return playerIds;
    }

    public void setPlayerIds(List<Long> playerIds) {
        this.playerIds = playerIds;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}
