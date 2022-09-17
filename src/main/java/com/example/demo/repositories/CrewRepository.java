package com.example.demo.repositories;

import com.example.demo.bll.Crew;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CrewRepository  extends JpaRepository<Crew, Long> {
}
