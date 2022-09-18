package com.example.demo.services;

import com.example.demo.bll.Planet;

import java.util.List;

public interface PlanetService {
    public void addPlanet(Planet planet);
    public List<Planet> findAllPlanets();
    public void updatePlanet(Planet planet);
    public Planet findById(Long id);
    public void deletePlanetById(Long id);
}
