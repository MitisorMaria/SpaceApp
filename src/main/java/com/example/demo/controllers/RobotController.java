package com.example.demo.controllers;

import com.example.demo.bll.Planet;
import com.example.demo.bll.Robot;
import com.example.demo.services.PlanetService;
import com.example.demo.services.RobotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

}
