package com.cinema.core.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "films")
public class Film {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name  = "title",nullable = false, unique = true)
    private String title;

    @Column(name  = "description",nullable = false)
    private String description;


    @OneToMany(mappedBy = "film")
    private List<Session> sessions;


    public Film() {
    }

    public Film(String title, String description, List<Session> sessions) {
        this.title = title;
        this.description = description;
        this.sessions = sessions;
    }

    public Film(String title, String description) {
        this.title = title;
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Session> getSessions() {
        return sessions;
    }

    public void setSessions(List<Session> sessions) {
        this.sessions = sessions;
    }

}
