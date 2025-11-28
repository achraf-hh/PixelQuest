package com.project.Projet.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.project.Projet.Entity.Labyrinth;
import com.project.Projet.Repository.LabyrinthRepository;

@Service
public class LabyrinthService {

    @Autowired
    private LabyrinthRepository labyrinthRepository;

    public Labyrinth create(Labyrinth l) {
        return labyrinthRepository.save(l);
    }

    public Labyrinth get(Long id) {
        return labyrinthRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Labyrinth not found"));
    }
}
