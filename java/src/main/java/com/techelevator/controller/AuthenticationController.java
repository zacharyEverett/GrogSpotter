package com.techelevator.controller;

import javax.validation.Valid;

import com.techelevator.dao.JdbcUserDao;
import com.techelevator.model.*;
import com.techelevator.model.dto.LoginDto;
import com.techelevator.model.dto.LoginResponseDto;
import com.techelevator.model.dto.RegisterUserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import com.techelevator.dao.UserDao;
import com.techelevator.security.jwt.JWTFilter;
import com.techelevator.security.jwt.TokenProvider;

import java.security.Principal;

@RestController
@CrossOrigin
public class AuthenticationController {

    private final TokenProvider tokenProvider;
    private final AuthenticationManagerBuilder authenticationManagerBuilder;
    private UserDao userDao;
    @Autowired
    private JdbcUserDao jdbc;

    public AuthenticationController(TokenProvider tokenProvider, AuthenticationManagerBuilder authenticationManagerBuilder, UserDao userDao) {
        this.tokenProvider = tokenProvider;
        this.authenticationManagerBuilder = authenticationManagerBuilder;
        this.userDao = userDao;
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ResponseEntity<LoginResponseDto> login(@Valid @RequestBody LoginDto loginDto) {

        UsernamePasswordAuthenticationToken authenticationToken =
                new UsernamePasswordAuthenticationToken(loginDto.getUsername(), loginDto.getPassword());

        Authentication authentication = authenticationManagerBuilder.getObject().authenticate(authenticationToken);
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = tokenProvider.createToken(authentication, false);
        
        User user = userDao.findByUsername(loginDto.getUsername());

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add(JWTFilter.AUTHORIZATION_HEADER, "Bearer " + jwt);
        return new ResponseEntity<>(new LoginResponseDto(jwt, user), httpHeaders, HttpStatus.OK);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public void register(@Valid @RequestBody RegisterUserDto newUser) {
        try {
            User user = userDao.findByUsername(newUser.getUsername());
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "User Already Exists.");
        } catch (UsernameNotFoundException e) {
            userDao.create(newUser.getUsername(),newUser.getPassword(), newUser.getRole());
        }
    }

    /**
     * Endpoint that gets called by the front end to assess the type of the user from the database.
     * Returns true if the user is of type brewer
     *
     * Author: Zach E
     */
    @GetMapping("/verify")
    public boolean getUserType(Principal user){
        return jdbc.getUserType(user.getName()).equals("ROLE_BREWER");
    }

}

