package com.example.BookMyShow.Controllers;

import com.example.BookMyShow.RequestDtos.AddShowRequest;
import com.example.BookMyShow.RequestDtos.AddShowSeatsRequest;
import com.example.BookMyShow.Service.ShowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("show")
public class ShowController {

    @Autowired
    private ShowService showService;

    @PostMapping("/addShow")
    public String addShow(@RequestBody AddShowRequest addShowRequest){

        return showService.addShow(addShowRequest);
    }

    @PostMapping("/createShowSeats")
    public String createShowSeats(@RequestBody AddShowSeatsRequest addShowSeatsRequest){
        String result = showService.createShowSeats(addShowSeatsRequest);
        return result;
    }


}
