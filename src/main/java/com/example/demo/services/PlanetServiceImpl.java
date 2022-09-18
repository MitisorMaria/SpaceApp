package com.example.demo.services;

import com.example.demo.bll.Crew;
import com.example.demo.bll.Planet;
import com.example.demo.bll.Robot;
import com.example.demo.repositories.PlanetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlanetServiceImpl implements PlanetService{
    @Autowired
    private PlanetRepository planetRepository;
    @Override
    public void addPlanet(Planet planet) {
        planetRepository.save(planet);
    }

    @Override
    public List<Planet> findAllPlanets() {
        return planetRepository.findAll();
    }

    @Override
    public void updatePlanet(Planet planet){
        Long crewId = planet.getCrew().getId();
        planetRepository.updatePlanetById(crewId, planet.getStatus(), planet.getId());
    }

    @Override
    public Planet findById(Long id) {
        return planetRepository.findById(id).get();
    }
}
