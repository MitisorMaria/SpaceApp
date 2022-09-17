package com.example.demo.controllers;

import com.example.demo.bll.Planet;
import com.example.demo.services.PlanetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/")
public class PlanetController {
    @Autowired
    private PlanetService planetService;

    @PostMapping(value="planet")
    public ResponseEntity<?> addPlanet(@RequestBody Planet planet) {
        planetService.addPlanet(planet);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("planet")
    public List<Planet> getAllPlanets() {
        return planetService.findAllPlanets();
    }

    @PutMapping("planet")
    public ResponseEntity<?> updatePlanet(@RequestBody Planet planet) {
        planetService.updatePlanet(planet);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
