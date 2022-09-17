package com.example.demo.bll;

import com.fasterxml.jackson.annotation.JsonBackReference;
import org.springframework.stereotype.Component;

import javax.persistence.*;

@Component
@Entity
@Table(name="robots")
public class Robot {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column (name = "name")
    private String name;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "crew")
    @JsonBackReference
    private Crew crew;

    public Robot() {

    }

    public Robot(long id, String name, Crew crew) {
        this.id = id;
        this.name = name;
        this.crew = crew;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public Crew getCrew() {
        return crew;
    }

    public void setCrew(Crew crew) {
        this.crew = crew;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
