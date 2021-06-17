package com.cinema.core.service.impl;

import com.cinema.core.DAO.DAOException;
import com.cinema.core.entity.Film;
import com.cinema.core.repository.FilmRepository;
import com.cinema.core.service.FilmService;
import com.cinema.core.service.exception.FilmNotAddedException;
import com.cinema.core.service.exception.FilmNotRemovedException;
import com.cinema.core.service.exception.FilmNotUpdatedException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.Collections;
import java.util.List;

@Service
public class FilmServiceImpl implements FilmService {
    private final FilmRepository filmRepository;
    private final Logger logger = LoggerFactory.getLogger(FilmServiceImpl.class);

    public FilmServiceImpl(FilmRepository filmRepository) {
        this.filmRepository = filmRepository;
    }

    public Film addNewFilm(String title, String description) throws FilmNotUpdatedException {
        try{
            if(title == null || description == null){
                logger.error("title or description is null, film doesnt added");
                throw new FilmNotAddedException("title or description is null, film doesnt added");
            }

            Film newFilm = new Film(title,description);
            return filmRepository.save(newFilm);
        }catch (FilmNotAddedException e){
            logger.error("failed to add new film", e);
            throw new FilmNotUpdatedException("failed to add new film",e);
        }
    }

    @Transactional(rollbackOn = Exception.class)
    public Boolean removeFilmById(Long id) throws FilmNotRemovedException {
        try{
            if(id == null){
                logger.error("id is null, film not removed");
                throw new FilmNotRemovedException("id is null, film not removed");
            }

            filmRepository.deleteById(id);
            return true;
        }catch (FilmNotRemovedException e){
            logger.error("failed to remove film by id", e);
            throw new FilmNotRemovedException("failed to remove film by id",e);
        }
    }

    @Transactional(rollbackOn = Exception.class)
    public Film updateFilmById(Long filmId, String newTitle, String newDescription) throws FilmNotUpdatedException {
        try{
            if(filmId == null){
                logger.error("film id is empty, film doesnt updated");
                throw new FilmNotUpdatedException("film id is empty, film doesnt updated");
            }
            Film filmToUpdate = filmRepository.findById(filmId).orElseThrow(DAOException::new);
            filmToUpdate.setTitle(newTitle);
            filmToUpdate.setDescription(newDescription);
            return filmRepository.save(filmToUpdate);
        }catch (DAOException e){
            logger.error("film not found by id, film doesnt updated",e);
            throw new FilmNotUpdatedException("film doesnt updated", e);
        }
    }

    @Transactional(rollbackOn = Exception.class)
    public List<Film> getAllFilms(){
        try{
            return filmRepository.findAll();
        }catch (Exception e){
            return Collections.emptyList();
        }
    }

}
