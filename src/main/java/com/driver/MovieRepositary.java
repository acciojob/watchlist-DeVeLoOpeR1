package com.driver;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Repository
public class MovieRepositary {


    HashMap<String,Movie> movieDb = new HashMap<String,Movie>();
    HashMap<String,Director> directorDb = new HashMap<String,Director>();
    HashMap<String, List<String>>  directorMovieDb = new HashMap<String,List<String>>();


    public String addMovie(Movie movie){
        movieDb.put(movie.getName(),movie);
        return "success movie added successfully ";
    }

    public String addDirector(Director director){
       directorDb.put(director.getName(),director);
       return "success director added succesfully ";
    }

    public String addMovieDirectorPair(String mname,String dname){
        List<String> l;
        if(directorMovieDb.containsKey(dname)){
            l = directorMovieDb.get(dname);
        }
     else{
            l = new ArrayList<String>();
        }
        l.add(mname);
        directorMovieDb.put(dname,l);
        return ("success movie director pair is added");
    }

    public Movie getMovieByName(String name){
        return movieDb.get(name);
    }

    public Director getDirectorByName(String name){
        return directorDb.get(name);
    }

    public List<String> getMoviesByDirectorName(String director){
      return directorMovieDb.get(director);
    }


    public List<String> findAllMovies(){
      List<String> l = new ArrayList<>();
              for(String h : movieDb.keySet()){
                  l.add(h);
              }
      return l;
    }

    public String deleteDirectorByName(String name){
        if(directorMovieDb.containsKey(name)){
            for(String m:directorMovieDb.get(name)){
                if(movieDb.containsKey(m)){
                    movieDb.remove(m);
                }
            }
        }
        if(directorDb.containsKey(name)){
            directorDb.remove(name);
        }
        return ("success director " + name + " is deleted");
    }

    public String deleteAllDirectors(){
        for(String d:directorDb.keySet()){
            deleteDirectorByName(d);
        }
        return "success All Director are deleted";
    }





}
