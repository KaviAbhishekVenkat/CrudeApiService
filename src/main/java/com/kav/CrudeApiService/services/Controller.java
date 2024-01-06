package com.kav.CrudeApiService.services;


import com.kav.CrudeApiService.dto.UserDetailsDto;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class Controller {

    @Autowired
    UserService service;

    @PostMapping("/addUser")
    public UserDetailsDto addUser(@RequestBody UserDetailsDto user) {
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
    public UserDetailsDto getUserById(@PathVariable  String id){
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
    public String deleteUser(@PathVariable String id) {
        return service.deleteProduct(id);
    }


}
