package com.example.music_lib.controller;

import com.example.music_lib.entity.User;
import com.example.music_lib.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/api/users")
@CrossOrigin(origins = "http://localhost:3000")
public class UserController {


    @Autowired
    private UserService userService;


    @GetMapping("/")
    public List<User> getAllUsers(){
        return userService.getAllUsers();
    }

    @GetMapping("/user/{id}")
    public Optional<User> getUser(@PathVariable("id") long id){
        return userService.getUser(id);
    }

    @PostMapping("/newuser")
    public String createUser(@RequestBody User user){
        return userService.createUser(user);
    }

    @PutMapping("/{id}")
    public String updateUser(@PathVariable("id") long id,@RequestBody User user){
        return userService.updateUser(id, user);
    }

    @DeleteMapping("/deleteuser/{id}")
    public String deleteUser(@PathVariable("id") long id){
        return userService.deleteUser(id);
    }

    @PostMapping("/user")
    public Boolean isValidUser(@RequestBody User user){
        return userService.isValidUser(user);
    }

}
