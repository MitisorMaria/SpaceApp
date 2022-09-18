package com.example.demo.controllers;

import com.example.demo.bll.Crew;
import com.example.demo.bll.Captain;
import com.example.demo.bll.STATUS;
import com.example.demo.services.CaptainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/")
public class CaptainController {
    @Autowired
    private CaptainService captainService;

    @PostMapping("captain")
    public ResponseEntity<?> addCaptain(@RequestBody @Valid Captain captain) {
        captainService.addCaptain(captain);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("captain")
    public List<Captain> getAllCaptains() {
        return captainService.findAllCaptains();
    }

    @GetMapping("captain/{id}")
    public Captain getCaptain(@PathVariable("id") Long id) {
        return captainService.findById(id);
    }

    @DeleteMapping("captain/{id}")
    public ResponseEntity<?> deleteCaptain(@PathVariable("id") Long id) {
        captainService.deleteCaptainById(id);
        System.out.println("Delete");
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("captain")
    public ResponseEntity<?> updateCaptain(@RequestBody @Valid Captain captain) {
        Long captainId = captain.getId();
        Crew crew = captain.getCrew();
        String name = captain.getName();

        Captain captainFromDB = captainService.findById(captainId);
        if (captainFromDB != null) {
            captainFromDB.setCrew(crew);
            captainFromDB.setName(name);
            captainService.addCaptain(captainFromDB);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
