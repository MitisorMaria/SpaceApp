package com.example.demo.services;

import com.example.demo.bll.Crew;

import java.util.List;

public interface CrewService {
    public void addCrew(Crew crew);
    public List<Crew> findAllCrews();
    public Crew findById(Long id);
    public void deleteCrewById(Long id);
    public void updateCrew(Crew crew);
}
