package com.example.BookMyShow.RequestDtos;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AddUserRequest {
    private String name;

    @Column(unique = true)
    private String emailId;

    private String mobNo;

    private Integer age;

}
