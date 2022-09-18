package com.example.demo.services;

import com.example.demo.bll.Captain;
import com.example.demo.repositories.CaptainRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CaptainServiceImpl implements CaptainService{

    @Autowired
    private CaptainRepository captainRepository;

    @Override
    public void addCaptain(Captain captain) {
        captainRepository.save(captain);
    }

    @Override
    public List<Captain> findAllCaptains() {
        return captainRepository.findAll();
    }

    @Override
    public Captain findById(Long id) {
        return captainRepository.findById(id).get();
    }

    @Override
    public void deleteCaptainById(Long id) {
        captainRepository.deleteById(id);
    }

    @Override
    public void updateCaptain(Captain captain) {

    }
}
