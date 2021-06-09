package com.cinema.core.repository;

import com.cinema.core.entity.Film;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FilmRepository extends JpaRepository<Film, Long> {
    public List<Film> findAll();
}
