package com.example.BookMyShow.Transformers;

import com.example.BookMyShow.Models.Theater;
import com.example.BookMyShow.RequestDtos.AddTheaterRequest;

public class TheaterTransformers {

    public static Theater convertAddTheaterRequestToEntity(AddTheaterRequest addTheaterRequest){

        Theater theater = Theater.builder().
                city(addTheaterRequest.getCity())
                .address(addTheaterRequest.getAddress())
                .build();

        return theater;
    }
}
