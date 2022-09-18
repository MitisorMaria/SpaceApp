package com.example.demo.bll;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Component
@Entity
@Table(name="crews")
public class Crew {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "captain", referencedColumnName = "id")
    //@JsonIgnore
    private Captain captain;

    @OneToMany(mappedBy = "crew", cascade = CascadeType.ALL)
    @JsonManagedReference
    @JsonIgnore
    private List<Robot> robots;

    @OneToOne(mappedBy = "crew")
    private Planet planet;

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

}
