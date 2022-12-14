package com.example.demo.bll;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.sql.Blob;


@Component
@Entity
@Table(name="planets")
@JsonSerialize
public class Planet {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    @NotBlank(message = "Name is mandatory")
    private String name;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "crew", referencedColumnName = "id")
    @JsonManagedReference
    private Crew crew;

    @Column(name = "status")
    private STATUS status;

    @Column(name = "img")
    private Blob image;

    public Planet() {

    }
    public Planet(Long id, String name, Crew crew, STATUS status, Blob image){
        this.id = id;
        this.name = name;
        this.crew = crew;
        this.status = status;
        this.image = image;
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

    public Blob getImage() {
        return image;
    }

    public void setImage(Blob image) {
        this.image = image;
    }

}
