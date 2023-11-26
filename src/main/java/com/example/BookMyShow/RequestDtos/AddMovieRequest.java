package com.example.BookMyShow.RequestDtos;

import com.example.BookMyShow.Enums.Genre;
import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AddMovieRequest {

    private String movieName;

    private Double rating;

    private Genre genre;

    private LocalDate releaseDate;


}
