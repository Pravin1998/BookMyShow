package com.example.BookMyShow.Service;

import com.example.BookMyShow.Models.User;
import com.example.BookMyShow.Repository.UserRepository;
import com.example.BookMyShow.RequestDtos.AddUserRequest;
import com.example.BookMyShow.Transformers.UserTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;
    public String addUser(AddUserRequest addUserRequest){

        //i need to create the user object and
        //save it to the database

//        User user = new User();
//
//        user.setAge(addUserRequest.getAge());
//        user.setEmailId(addUserRequest.getEmailId());
//        user.setMobNo(addUserRequest.getMobNo());
//        user.setName(addUserRequest.getName());

        User userObj = UserTransformer.convertAddUserReqToUserEntity(addUserRequest);

        userRepository.save(userObj);
        return "User added successfully";
    }

}
