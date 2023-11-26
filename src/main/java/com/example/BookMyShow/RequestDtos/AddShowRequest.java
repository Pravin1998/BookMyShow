package com.example.BookMyShow.RequestDtos;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalTime;

@Getter
@Setter


public class AddShowRequest {

    private LocalDate showDate;

    private LocalTime showTime;

    private String movieName;//movie name is unique so uniquely identified

    private Integer theaterId;


}
