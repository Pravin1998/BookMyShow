package com.example.BookMyShow.Transformers;


import com.example.BookMyShow.Models.Movie;
import com.example.BookMyShow.RequestDtos.AddMovieRequest;

public class MovieTransformers {

    public static Movie convertMovieRequestToEntity(AddMovieRequest addMovieRequest){

        Movie movie = Movie.builder()
                .movieName(addMovieRequest.getMovieName())
                .genre(addMovieRequest.getGenre())
                .rating(addMovieRequest.getRating())
                .releaseDate(addMovieRequest.getReleaseDate())
                .build();

        return movie;
    }

}
