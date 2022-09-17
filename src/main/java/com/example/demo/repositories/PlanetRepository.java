package com.example.demo.repositories;
import com.example.demo.bll.Planet;
import com.example.demo.bll.STATUS;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface PlanetRepository extends JpaRepository<Planet, Long> {
    @Modifying
    @Query("update Planet p set p.crew = ?1, p.status = ?2 where p.id = ?3")
    void updatePlanetById(Long crewId, STATUS status, Long id);
}
