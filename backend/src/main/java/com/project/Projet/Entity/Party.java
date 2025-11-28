package com.project.Projet.Entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
public class Party {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Double score;

    @Enumerated(EnumType.STRING)
    private Difficulty difficulty;

    private LocalDateTime creationDate;

    @ManyToOne
    @JoinColumn(name = "player_id")
    private Player player;

    @ManyToOne
    @JoinColumn(name = "labyrinth_id")
    private Labyrinth labyrinth;

    public Party() {}

    // Getters & Setters

    public Long getId() {
        return id;
    }
    public Double getScore() {
        return score;
    }
    public void setScore(double xp) {
        this.score = xp;
    }
    public Difficulty getDifficulty() {
        return difficulty;
    }
    public void setDifficulty(Difficulty difficulty) {
        this.difficulty = difficulty;
    }
    public LocalDateTime getCreationDate() {
        return creationDate;
    }
    public void setCreationDate(LocalDateTime creationDate) {
        this.creationDate = creationDate;
    }
    public Player getPlayer() {
        return player;
    }
    public void setPlayer(Player player) {
        this.player = player;
    }
    public Labyrinth getLabyrinth() {
        return labyrinth;
    }
    public void setLabyrinth(Labyrinth labyrinth) {
        this.labyrinth = labyrinth;
    }

}