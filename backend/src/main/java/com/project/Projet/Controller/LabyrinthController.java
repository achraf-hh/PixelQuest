package com.project.Projet.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import com.project.Projet.Entity.Labyrinth;
import com.project.Projet.Service.LabyrinthService;


@RestController
@RequestMapping("/labyrinths")
public class LabyrinthController {

    @Autowired
    private LabyrinthService labyrinthService;

    @PostMapping
    public Labyrinth create(@RequestBody Labyrinth l) {
        return labyrinthService.create(l);
    }
}
