package com.example.demo.services;

import com.example.demo.bll.Planet;
import com.example.demo.bll.Robot;
import com.example.demo.repositories.PlanetRepository;
import com.example.demo.repositories.RobotRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RobotServiceImpl implements RobotService{
    @Autowired
    private RobotRepository robotRepository;


    @Override
    public void addRobot(Robot robot) {
        robotRepository.save(robot);
    }

    @Override
    public void deleteRobot(Long id) {
        robotRepository.deleteById(id);
    }

    @Override
    public Robot getRobot(Long id) {
        return robotRepository.getReferenceById(id);
    }

    @Override
    public void updateRobot(Robot robot) {
        robotRepository.updateRobotById(robot.getName(), robot.getId(), robot.getCrew().getId());
    }

    @Override
    public List<Robot> findAllRobots() {
        return robotRepository.findAll();
    }
}
