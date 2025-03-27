package com.example.music_lib.controller;

import com.example.music_lib.entity.User;
import com.example.music_lib.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
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

    @PostMapping("/session/login")
    public ResponseEntity<Object> isValidUser(@RequestBody User user, HttpServletRequest request){

        User eu = userService.findByEmail(user.getEmail());

        if(eu.getPassword().equals(user.getPassword())){

            var session = request.getSession();
            session.setAttribute("username", user.getName());
            Map<String, String> data = new HashMap<>();
            data.put("msg" , "Login Successful");
            data.put("userid", String.valueOf(eu.getId()));

            return ResponseEntity.status(HttpStatus.OK).body(data);
        }

        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid Credentials");
    }

}
