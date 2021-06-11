package com.cinema.core.repository;

import com.cinema.core.entity.Session;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SessionRepository extends JpaRepository<Session, Long> {
    public List<Session> findAllByFilmId(Long filmId);
}
