package com.example.demo.services;

import com.example.demo.bll.Robot;

import java.util.List;

public interface RobotService {
    public void addRobot(Robot robot);
    public void deleteRobot(Long id);
    public Robot getRobot(Long id);
    public void updateRobot(Robot robot);
    public List<Robot> findAllRobots();
}
