package com.example.BookMyShow.Service;

import com.example.BookMyShow.Enums.SeatType;
import com.example.BookMyShow.Models.Theater;
import com.example.BookMyShow.Models.TheaterSeat;
import com.example.BookMyShow.Repository.TheaterRepository;
import com.example.BookMyShow.RequestDtos.AddTheaterRequest;
import com.example.BookMyShow.Transformers.TheaterTransformers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TheaterService {

    @Autowired
    private TheaterRepository theaterRepository;

    public String addTheater(AddTheaterRequest addTheaterRequest){

        //1. create theater entity

        Theater theater = TheaterTransformers.convertAddTheaterRequestToEntity(addTheaterRequest);
        //create the theater seat entity

        createTheaterSeats(theater,addTheaterRequest);

        return "Theater and its seats have been saved successfully to the DB";

    }

    public void createTheaterSeats(Theater theater,AddTheaterRequest addTheaterRequest){
        int noOfClassicSeats = addTheaterRequest.getNoOfClassicSeats();
        int noOfPremiumSeats = addTheaterRequest.getNoOfPremiumSeats();

        int seatsPerRow = addTheaterRequest.getNoOfSeatsPerRow();

         //create the primary seats entities

        List<TheaterSeat> theaterSeatList = new ArrayList<>();

        int row = 0;
        char ch = 'A';

        for(int i=1; i<=noOfClassicSeats; i++){

            if(i%seatsPerRow==1){
                row++;
                ch = 'A';
            }

            String seatNo = row+""+ch;
            ch = (char)(ch+1);

            TheaterSeat theaterSeat = TheaterSeat.builder()
                    .seatNo(seatNo)
                    .seatType(SeatType.CLASSIC)
                    .theater(theater) //setting the FK also
                    .build();

            theaterSeatList.add(theaterSeat);

        }
        //similar numbering I will do for the Premium seats
        ch = 'A';

        for(int i=1; i<=noOfPremiumSeats; i++){

            if(i%seatsPerRow==1){
                row++;
                ch = 'A';
            }

            String seatNo = row+""+ch;
            ch = (char)(ch+1);

            TheaterSeat theaterSeat = TheaterSeat.builder()
                    .seatNo(seatNo)
                    .seatType(SeatType.PREMIUM)
                    .theater(theater) //setting the FK also
                    .build();

            theaterSeatList.add(theaterSeat);

        }

        //this is done for bidirectional mapping
        theater.setTheaterSeatList(theaterSeatList);

        theaterRepository.save(theater);



    }

}
