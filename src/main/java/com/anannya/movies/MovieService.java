package com.anannya.movies;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MovieService {
    @Autowired
    private MovieRepository movieRepository;
    public List<Movie> allMovies(){
        return movieRepository.findAll(); //findAll() method is defined inside the MongoRepository class and it return the list of datatype that we have passed
    }

    public Optional<Movie> singleMovie(String imdbId){
        return  movieRepository.findMovieByImdbId(imdbId);
    }
}