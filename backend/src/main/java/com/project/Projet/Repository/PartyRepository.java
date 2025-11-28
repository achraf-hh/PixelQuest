package com.project.Projet.Repository;

import com.project.Projet.Entity.Party;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface PartyRepository extends JpaRepository<Party, Long> {
    @Query("SELECT COALESCE(SUM(p.score),0) FROM Party p WHERE p.player.id = :playerId")
    double sumXpByPlayer(@Param("playerId") Long playerId);

}
