package com.cinema.core.service;

import com.cinema.core.entity.Film;
import com.cinema.core.repository.FilmRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Collections;
import java.util.List;

@Service
public class FilmService {
    private final FilmRepository filmRepository;

    @Autowired
    public FilmService(FilmRepository filmRepository) {
        this.filmRepository = filmRepository;
    }

    public List<Film> getListOfFilms(){
        List <Film> films = filmRepository.findAll();
        if(films == null){
            return Collections.emptyList();
        }

        return films;
    }
}
