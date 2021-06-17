package com.cinema.core.entity;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

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


    @OneToMany(mappedBy = "film", cascade = CascadeType.ALL, orphanRemoval = true)
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

    public Film(Long id, String title, String description) {
        this.id = id;
        this.title = title;
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Film film = (Film) o;
        return Objects.equals(title, film.title) && Objects.equals(description, film.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, description);
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
