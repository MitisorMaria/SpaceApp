package com.example.demo.controllers;

import com.example.demo.bll.Crew;
import com.example.demo.bll.Planet;
import com.example.demo.bll.Robot;
import com.example.demo.services.PlanetService;
import com.example.demo.services.RobotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/")
public class RobotController {
    @Autowired
    private RobotService robotService;

    @PostMapping(value="robot")
    public ResponseEntity<?> addRobot(@RequestBody Robot robot) {
        robotService.addRobot(robot);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("robot")
    public List<Robot> getAllRobots() {
        return robotService.findAllRobots();
    }

    @GetMapping("robot/{id}")
    public Robot getRobot(@PathVariable("id") Long id) {
        return robotService.findById(id);
    }

    @DeleteMapping("robot/{id}")
    public ResponseEntity<?> deleteRobot(@PathVariable("id") Long id) {
        robotService.deleteRobot(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
