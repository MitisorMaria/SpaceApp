package com.example.demo.bll;

import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Component
@Entity
@Table(name="crews")
public class Crew {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    //@OneToOne(mappedBy = "crew")
    private Long id;
    //@OneToOne(cascade = CascadeType.ALL)
    //@JoinColumn(name = "captain_id", referencedColumnName = "id")
    @Column(name = "captain")
    private Captain captain;
    @OneToMany(mappedBy = "crew", cascade = CascadeType.ALL)
    private List<Robot> robots;

    public Crew() {

    }
    public Crew(Captain captain, ArrayList<Robot> robots) {
        this.captain = captain;
        this.robots = robots;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setRobots(List<Robot> robots) {
        this.robots = robots;
    }

    public Captain getCaptain() {
        return captain;
    }

    public void setCaptain(Captain captain) {
        this.captain = captain;
    }

    public List<Robot> getRobots() {
        return robots;
    }

    public void setRobots(ArrayList<Robot> robots) {
        this.robots = robots;
    }
}
