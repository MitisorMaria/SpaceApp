package com.example.demo.services;

import com.example.demo.bll.Crew;
import com.example.demo.repositories.CrewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CrewServiceImpl implements CrewService{
    @Autowired
    private CrewRepository crewRepository;

    @Override
    public void addCrew(Crew crew) {
        crewRepository.save(crew);
    }

    @Override
    public List<Crew> findAllCrews() {
        return crewRepository.findAll();
    }

    @Override
    public Crew findById(Long id) {
        return crewRepository.findById(id).get();
    }

    @Override
    public void deleteCrewById(Long id) {
        crewRepository.deleteById(id);
    }

    @Override
    public void updateCrew(Crew crew) {

    }
}
