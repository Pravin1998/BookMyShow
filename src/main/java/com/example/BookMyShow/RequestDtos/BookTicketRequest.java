package com.example.BookMyShow.RequestDtos;

import com.example.BookMyShow.Models.User;
import jakarta.persistence.GeneratedValue;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Getter
@Setter
public class BookTicketRequest {

    private String movieName;
    private Integer theaterId;
    private LocalDate showDate;
    private LocalTime showTime;
    private List<String> seatNos;

    private List<String> requestedSeatNos;

    private Integer userId;

    //do you want to take food coupons : you will add yourself


}