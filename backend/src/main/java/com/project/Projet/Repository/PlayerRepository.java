package com.project.Projet.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.project.Projet.Entity.Player;

public interface PlayerRepository extends JpaRepository<Player, Long> {}