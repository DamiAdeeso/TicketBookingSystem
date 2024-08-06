package com.example.USLTEST.domain.DTO;

import com.example.USLTEST.domain.entity.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class SignUpDto {

    private String firstName;

    private String lastName;

    private String userName;

    private  String email;

    private String password;

    private String country;

    private String  description;

    private Role role;
}
