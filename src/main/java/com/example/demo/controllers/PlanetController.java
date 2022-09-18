package com.example.demo.controllers;

import com.example.demo.bll.Crew;
import com.example.demo.bll.Planet;
import com.example.demo.bll.STATUS;
import com.example.demo.services.CrewService;
import com.example.demo.services.PlanetService;
import java.sql.Blob;
import com.sun.org.apache.xerces.internal.impl.dv.util.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.imageio.ImageIO;
import javax.sql.rowset.serial.SerialBlob;
import javax.sql.rowset.serial.SerialException;
import javax.validation.Valid;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("/")
public class PlanetController {
    @Autowired
    private PlanetService planetService;

    @Autowired
    private CrewService crewService;

    @PostMapping(value="planet")
    public ResponseEntity<?> addPlanet(@RequestBody @Valid Planet planet) {
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
        //planetService.updatePlanet(planet); not working
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("planet/{id}")
    public ResponseEntity<?> deletePlanet(@PathVariable("id") Long id) {
        planetService.deletePlanetById(id);
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
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("planet-image")
    public ResponseEntity<?> assignImageToPlanet(@RequestParam("id") Long id, @RequestBody String path) {
        Blob imageEncoded = null;
        try {
            BufferedImage sourceimage = null;
            sourceimage = ImageIO.read(new File(path));
            ByteArrayOutputStream bytes = new ByteArrayOutputStream();
            ImageIO.write(sourceimage, "jpg", bytes);
            imageEncoded = new SerialBlob(bytes.toByteArray());
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (SerialException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        Planet planetFromDB = planetService.findById(id);
        planetFromDB.setImage(imageEncoded);
        planetService.addPlanet(planetFromDB);

        return new ResponseEntity<>(HttpStatus.OK);
    }
}
