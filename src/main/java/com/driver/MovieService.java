package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MovieService {

    @Autowired
    MovieRepositary movieRepositary;
    public String addMovie(Movie movie){
        return movieRepositary.addMovie(movie);
    }

    public String addDirector(Director director){
        return movieRepositary.addDirector(director);
    }

    public String addMovieDirectorPair(String mname,String dname){
        return movieRepositary.addMovieDirectorPair(mname,dname);
    }

    public Movie getMovieByName(String name){
        return movieRepositary.getMovieByName(name);
    }

    public Director getDirectorByName(String name){
        return movieRepositary.getDirectorByName(name);
    }

    public List<String> getMoviesByDirectorName(String director){
        return movieRepositary.getMoviesByDirectorName(director);
    }


    public List<String> findAllMovies(){
        return movieRepositary.findAllMovies();
    }

    public String deleteDirectorByName(String name){
        return movieRepositary.deleteDirectorByName(name);
    }

    public String deleteAllDirectors(){
        return movieRepositary.deleteAllDirectors();
    }




}
