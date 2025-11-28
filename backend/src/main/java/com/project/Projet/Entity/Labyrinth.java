package com.project.Projet.Entity;

import jakarta.persistence.*;

@Entity
public class Labyrinth {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Column(columnDefinition = "TEXT")
    private String matrix;

    public Labyrinth() {}

    // Getters & Setters

    public Long getId() {
        return id;
    }
    

     }