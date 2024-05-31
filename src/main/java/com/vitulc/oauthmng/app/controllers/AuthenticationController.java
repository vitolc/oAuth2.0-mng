package com.vitulc.oauthmng.app.controllers;

import com.vitulc.oauthmng.app.dtos.UserDto;
import com.vitulc.oauthmng.app.services.AuthenticationService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class AuthenticationController {

    private final AuthenticationService authenticationService;

    public AuthenticationController(
            AuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody UserDto userDto){
     return authenticationService.register(userDto);
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/home")
    public ResponseEntity<String> home() {
        return ResponseEntity.ok("boa");
    }

    @GetMapping("/error")
    public ResponseEntity<String> error() {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("presto não");
    }
}
