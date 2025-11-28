package com.project.Projet.Repository;


import org.springframework.data.jpa.repository.JpaRepository;
import com.project.Projet.Entity.Labyrinth;

public interface LabyrinthRepository extends JpaRepository<Labyrinth, Long> {
	}
