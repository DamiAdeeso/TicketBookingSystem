package com.example.USLTEST.controllers;


import com.example.USLTEST.domain.DTO.ChangePasswordRequest;
import com.example.USLTEST.domain.DTO.SignInRequest;
import com.example.USLTEST.domain.DTO.SignInResponse;
import com.example.USLTEST.domain.DTO.SignUpDto;
import com.example.USLTEST.service.AuthenticationService;
import com.example.USLTEST.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/auth")
@RequiredArgsConstructor
public class AuthenticationController {

    private final AuthenticationService authenticationService;

    private final UserService userService;

    @PostMapping(path="/register")
    public ResponseEntity register(@RequestBody SignUpDto signUpDto){
       return  authenticationService.signUp(signUpDto);
    }
    @PostMapping(path="/signin")
    public ResponseEntity<SignInResponse> signIn(@RequestBody SignInRequest signInRequest){
        return  new ResponseEntity<>(authenticationService.signIn(signInRequest), HttpStatus.OK);
    }
    @GetMapping(path="/check-mail/{email}")
    public ResponseEntity<?> findUser (@PathVariable String email){

        String mail = authenticationService.checkMail(email);

       if(mail == null){
           return new ResponseEntity<>(HttpStatus.FOUND);
       }else{
           return new ResponseEntity<>(mail,HttpStatus.FOUND);
       }
    }

    @PatchMapping(path="/change-password/{id}")
    public ResponseEntity changePassword(@RequestBody ChangePasswordRequest newPassword, @PathVariable Long id){
        return userService.changePassword(newPassword,id);
    }

}
