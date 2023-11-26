package com.example.BookMyShow.Service;

import com.example.BookMyShow.Models.*;
import com.example.BookMyShow.Repository.*;
import com.example.BookMyShow.RequestDtos.BookTicketRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TicketService {

    @Autowired
    private ShowRepository showRepository;

    @Autowired
    private TheaterRepository theaterRepository;

    @Autowired
    private MovieRepository movieRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private TicketRepository ticketRepository;
    public String bookTicket(BookTicketRequest bookTicketRequest){
        Show show = findRightShow(bookTicketRequest);

        //my steps are

        List<ShowSeat> showSeatList = show.getShowSeatList();

        //whatever are the requested seats : mark them as not available in show seats
        //calculate total price
        int totalPrice = 0;
        for(ShowSeat showSeat: showSeatList){

            if(bookTicketRequest.getRequestedSeatNos().contains(showSeat.getSeatNo())){
                showSeat.setAvailable(false);
                totalPrice+= showSeat.getCost();

            }
        }

        User user = userRepository.findById(bookTicketRequest.getUserId()).get();


        Ticket ticket = Ticket.builder()
                .movieName(show.getMovie().getMovieName())
                .theaterAddress(show.getTheater().getAddress())
                .showDate(show.getShowDate())
                .showTime(show.getShowTime())
                .bookedSeats(bookTicketRequest.getRequestedSeatNos().toString())
                .user(user)
                .show(show)
                .totalPrice(totalPrice)
                .build();

        //we also need to add it to the booked tickets against user
        show.getTicketList().add(ticket);
        user.getTicketList().add(ticket);


        ticketRepository.save(ticket);

        return "ticket has been booked";


    }

    private Show findRightShow(BookTicketRequest bookTicketRequest){
        Movie movie = movieRepository.findMovieByMovieName(bookTicketRequest.getMovieName());

        Theater theater = theaterRepository.findById(bookTicketRequest.getTheaterId()).get();

        Show show = showRepository.findShowByShowDateAndShowTimeAndMovieAndTheater(bookTicketRequest.getShowDate(),bookTicketRequest.getShowTime(),movie,theater);

        return show;


        }
}
