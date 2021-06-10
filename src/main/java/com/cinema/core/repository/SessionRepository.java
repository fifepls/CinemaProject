package com.cinema.core.repository;

import com.cinema.core.entity.Session;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SessionRepository extends JpaRepository<Session, Long> {
    public List<Session> findAllByFilmId(Long filmId);
}
