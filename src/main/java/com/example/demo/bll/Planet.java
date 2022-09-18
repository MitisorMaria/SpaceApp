package com.example.demo.bll;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.*;



@Component
@Entity
@Table(name="planets")
public class Planet {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "crew", referencedColumnName = "id")
    @JsonIgnore
    private Crew crew;

    @Column(name = "status")
    private STATUS status;

   // @Column(name = "image")
    //private MultipartFile image;

    public Planet() {

    }
    public Planet(Long id, String name, Crew crew, STATUS status){//, MultipartFile image) {
        this.id = id;
        this.name = name;
        this.crew = crew;
        this.status = status;
       // this.image = image;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Crew getCrew() {
        return crew;
    }

    public void setCrew(Crew crew) {
        this.crew = crew;
    }

    public STATUS getStatus() {
        return status;
    }

    public void setStatus(STATUS status) {
        this.status = status;
    }

    /*public MultipartFile getImage() {
        return image;
    }

    public void setImage(MultipartFile image) {
        this.image = image;
    }*/




}
