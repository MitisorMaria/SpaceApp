package com.example.demo.controllers;

import com.example.demo.bll.*;
import com.example.demo.bll.Crew;
import com.example.demo.services.CaptainService;
import com.example.demo.services.CrewService;
import com.example.demo.services.RobotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/")
public class CrewController {
    @Autowired
    private CrewService crewService;
    @Autowired
    private CaptainService captainService;
    @Autowired
    private RobotService robotService;

    @PostMapping( value = "crew")
    public ResponseEntity<?> addCrew(@RequestBody Crew crew) {
        crewService.addCrew(crew);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("crew")
    public List<Crew> getAllCrews() {
        return crewService.findAllCrews();
    }

    @GetMapping("crew/{id}")
    public Crew getCrew(@PathVariable("id") Long id) {
        return crewService.findById(id);
    }

    @DeleteMapping("crew/{id}")
    public ResponseEntity<?> deleteCrew(@PathVariable("id") Long id) {
        crewService.deleteCrewById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("captain-to-crew")
    public ResponseEntity<?> assignCaptainToCrew(@RequestParam("id") Long id, @RequestParam("captain-id") Long captainId) {
        Crew crewFromDB = crewService.findById(id);
        Captain captain = captainService.findById(captainId);

        if (crewFromDB != null) {
            crewFromDB.setCaptain(captain);
            crewService.addCrew(crewFromDB);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("robots-to-crew")
    public ResponseEntity<?> assignRobotsToCrew(@RequestParam("id") Long id, @RequestBody List<Robot> robots) {
        Crew crewFromDB = crewService.findById(id);

        if (crewFromDB != null) {
            for (Robot robot: robots) {
                Robot robotFromDB = robotService.findById(robot.getId());
                robotFromDB.setCrew(crewFromDB);
                robotService.addRobot(robotFromDB);
            }
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
