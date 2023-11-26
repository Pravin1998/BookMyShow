package com.example.BookMyShow.Service;

import com.example.BookMyShow.Models.Movie;
import com.example.BookMyShow.Repository.MovieRepository;
import com.example.BookMyShow.RequestDtos.AddMovieRequest;
import com.example.BookMyShow.Transformers.MovieTransformers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MovieService {

    @Autowired
    MovieRepository movieRepository;

    public String addMovie(AddMovieRequest addMovieRequest) throws Exception{

        Movie movie = MovieTransformers.convertMovieRequestToEntity(addMovieRequest);

        movieRepository.save(movie);


        return "Movie has been added to the DB successfully";
    }
}
