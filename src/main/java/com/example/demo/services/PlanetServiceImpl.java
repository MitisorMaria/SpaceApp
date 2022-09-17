package com.example.demo.services;

import com.example.demo.bll.Planet;
import com.example.demo.repositories.PlanetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PlanetServiceImpl implements PlanetService{
    @Autowired
    private PlanetRepository planetRepository;
    @Override
    public void addPlanet(Planet planet) {
        planetRepository.save(planet);
    }
}
