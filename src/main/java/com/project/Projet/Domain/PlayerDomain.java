package com.project.Projet.Domain;

public class PlayerDomain {

    private Long id;
    private String username;
    private String email;

    // Constructeurs
    public PlayerDomain() {}

    public PlayerDomain(String username, String email) {
        this.username = username;
        this.email = email;
    }

    public PlayerDomain(Long id, String username, String email) {
        this.id = id;
        this.username = username;
        this.email = email;
    }

    // Getters & Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
}
