package com.example.demo.bll;

import org.springframework.stereotype.Component;

import javax.persistence.*;

@Component
@Entity
@Table(name="captains")
public class Captain {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private long id;

    @Column (name = "name")
    private String name;

    @OneToOne(mappedBy = "captain")
    private Crew crew;

    public Captain() {

    }

    public Captain(long id, String name) {
        this.id = id;
        this.name = name;
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
