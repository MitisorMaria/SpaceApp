package com.example.demo.services;

import com.example.demo.bll.Captain;

import java.util.List;

public interface CaptainService {
    public void addCaptain(Captain captain);
    public List<Captain> findAllCaptains();
    public Captain findById(Long id);
    public void deleteCaptainById(Long id);
    public void updateCaptain(Captain captain);
}
