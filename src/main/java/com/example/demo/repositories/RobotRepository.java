package com.example.demo.repositories;

import com.example.demo.bll.Robot;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RobotRepository  extends JpaRepository<Robot, Long> {
}
