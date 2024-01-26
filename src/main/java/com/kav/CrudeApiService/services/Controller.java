package com.kav.CrudeApiService.services;


import com.kav.CrudeApiService.dto.UserDetailsDto;
import com.kav.CrudeApiService.exception.DuplicateUserException;
import com.kav.CrudeApiService.exception.UserNotFoundException;
import io.swagger.v3.oas.annotations.Hidden;
import io.swagger.v3.oas.annotations.Operation;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class Controller {

    @Autowired
    UserService service;

    @PostMapping("/addUser")
    @Operation(description = "Inserting new user")
    public UserDetailsDto addUser(@RequestBody UserDetailsDto user) throws  DuplicateUserException {
        UserDetailsDto userById = null;
        try {
            userById = getUserById(user.getUserId());
        } catch (UserNotFoundException e) {
            throw new RuntimeException(e);
        }
        if(userById != null)
             throw new DuplicateUserException("User already exits in db ");
        return service.saveUser(user);
    }

    @PostMapping("/addUsers")
    public List<UserDetailsDto> addUsers(@RequestBody List<UserDetailsDto> users) {
        return service.saveUsers(users);
    }

    @GetMapping("/getAllUsers")
    public List<UserDetailsDto> getAllUser(){
        return service.getUsers();
    }

    @GetMapping("/getUserById/{id}")
    public UserDetailsDto getUserById(@PathVariable  String id) throws UserNotFoundException {
        try {
            Integer.parseInt(id);
        }catch (Exception e){
            throw new UserNotFoundException("User not found");
        }
        return service.getUserByID(id);
    }

    @GetMapping("/getUserByEmail/{email}")
    public UserDetailsDto getUserByEmail(@PathVariable String email){
        return service.getUserByEmail(email);
    }

    @PutMapping("/updateUser")
    public UserDetailsDto updateUser(@RequestBody UserDetailsDto user) {
        return service.updateUser(user);
    }

    @DeleteMapping("/deleteUser/{id}")
    @Hidden
    public String deleteUser(@PathVariable String id) {
        return service.deleteProduct(id);
    }


}
