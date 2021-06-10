package com.cinema.core.DAO;

import com.cinema.core.entity.Film;
import com.cinema.core.repository.FilmRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Component
public class FilmDao implements IFilmDao {
    private final FilmRepository filmRepository;

    @Autowired
    public FilmDao(FilmRepository filmRepository) {
        this.filmRepository = filmRepository;
    }

    public Boolean addFilm(String title, String description) throws DAOException { //method to add new film into database
        try{
            Film newFilm = new Film(title, description);
            filmRepository.save(newFilm);//if saved true
            return true;
        }catch (Exception e){//if not saved false
            throw new DAOException("add film exception", e);
        }
    }

    public Boolean removeFilmById(Long id) throws DAOException { //method to remove film by film id
        try{
            filmRepository.deleteById(id); //if removed true
            return true;
        }catch (Exception e){
            throw new DAOException("remove film by id exception" + e);
        }
    }

    public Boolean updateFilmById(Long id, String newTitle, String newDescription) throws DAOException {//update film info
        try{
            Optional<Film> filmToUpdateOptional = filmRepository.findById(id);
            if(filmToUpdateOptional.isPresent()){ //if there is film with id
                Film filmToUpdate = filmToUpdateOptional.get(); //update film title, description
                filmToUpdate.setTitle(newTitle);
                filmToUpdate.setDescription(newDescription);
                filmRepository.save(filmToUpdate); //update film
                return true;
            }
         return false;
        }catch (Exception e){
            throw new DAOException("filed update film by id", e);
        }
    }

    public List<Film> getListOfFilms() throws DAOException {
        try {
            List<Film> films = filmRepository.findAll(); //find all films
            if (films == null) {
                return Collections.emptyList(); // if there no films return empty list
            }
            return films;//or return all films
        }catch (Exception e){
            throw new DAOException("failed to get an a list of Films", e);
        }
    }
}
