package com.cinema.core.service.impl;

import com.cinema.core.DAO.DAOException;
import com.cinema.core.entity.Film;
import com.cinema.core.repository.FilmRepository;
import com.cinema.core.service.FilmService;
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

    public Boolean addNewFilm(String title, String description) {
        try{
            if(title == null || description == null){
                logger.error("title or description is null, film doesnt added");
                throw new DAOException("title or description is null, film doesnt added");
            }

            Film newFilm = new Film(title,description);
            filmRepository.save(newFilm);
            return true;
        }catch (DAOException e){
            logger.error("failed to add new film", e);
            return false;
        }
    }

    @Transactional(rollbackOn = Exception.class)
    public Boolean removeFilmById(Long id){
        try{
            if(id == null){
                logger.error("id is null, film not removed");
                throw new DAOException("id is null, film not removed");
            }

            filmRepository.deleteById(id);
            return true;
        }catch (DAOException e){
            logger.error("failed to remove film by id", e);
            return false;
        }
    }

    @Transactional(rollbackOn = Exception.class)
    public Boolean updateFilmById(Long filmId, String newTitle, String newDescription){
        try{
            if(filmId == null){
                logger.error("film id is empty, film doesnt updated");
                throw new DAOException("film id is empty, film doesnt updated");
            }
            Film filmToUpdate = filmRepository.findById(filmId).orElseThrow(DAOException::new);
            filmToUpdate.setTitle(newTitle);
            filmToUpdate.setDescription(newDescription);
            filmRepository.save(filmToUpdate);
            return true;
        }catch (DAOException e){
            logger.error("film not found by id, film doesnt updated",e);
            return false;
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
