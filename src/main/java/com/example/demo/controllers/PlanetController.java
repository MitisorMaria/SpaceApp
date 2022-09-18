package com.example.demo.controllers;

import com.example.demo.bll.Crew;
import com.example.demo.bll.Planet;
import com.example.demo.bll.STATUS;
import com.example.demo.services.CrewService;
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

    @Autowired
    private CrewService crewService;

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
    public ResponseEntity<?> updatePlanetStatus(@RequestParam("id") Long id, @RequestParam("status") STATUS status) {
        Planet planetFromDB = planetService.findById(id);
        if (planetFromDB != null) {
            planetFromDB.setStatus(status);
            planetService.addPlanet(planetFromDB);
        }
        //planetService.updatePlanet(planet);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("crew-to-planet")
    public ResponseEntity<?> assignCrewToPlanet(@RequestParam("id") Long id, @RequestParam("crew-id") Long crewId) {
        Planet planetFromDB = planetService.findById(id);
        Crew crew = crewService.findById(crewId);

        if (planetFromDB != null) {
            planetFromDB.setCrew(crew);
            planetService.addPlanet(planetFromDB);
        }
        //planetService.updatePlanet(planet);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
