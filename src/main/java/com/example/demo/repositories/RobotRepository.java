package com.example.demo.repositories;

import com.example.demo.bll.Robot;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface RobotRepository  extends JpaRepository<Robot, Long> {
    @Modifying
    @Query("update Robot r set r.name = ?1, r.crew = ?2 where r.id = ?3")
    void updateRobotById(String name, Long crewId, Long id);
}
