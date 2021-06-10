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

    public Boolean addFilm(String title, String description){ //method to add new film into database
        try{
            Film newFilm = new Film(title, description);
            filmRepository.save(newFilm);//if saved true
            return true;
        }catch (Exception e){//if not saved false
            return false;
        }
    }

    public Boolean removeFilmById(Long id){ //method to remove film by film id
        try{
            filmRepository.deleteById(id); //if removed true
            return true;
        }catch (Exception e){
            return false; //if not removed false
        }
    }

    public Boolean updateFilmById(Long id, String newTitle, String newDescription){//update film info
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
            return false;
        }
    }

    public List<Film> getListOfFilms(){
        try {
            List<Film> films = filmRepository.findAll(); //find all films
            if (films == null) {
                return Collections.emptyList(); // if there no films return empty list
            }
            return films;//or return all films
        }catch (Exception e){
            return Collections.emptyList();
        }
    }
}
