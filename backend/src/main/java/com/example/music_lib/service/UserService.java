package com.example.music_lib.service;

import com.example.music_lib.entity.User;
import com.example.music_lib.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public Optional<User> getUser(long id){
        return userRepository.findById(id);
    }

        public String createUser(User user) {
            try {
                userRepository.save(user);
                return "User created successfully";
            } catch (DataIntegrityViolationException e) {
                if (e.getMessage().contains("Duplicate entry") && e.getMessage().contains("user.email")) {
                    return "Email " + user.getEmail() + " is already registered.";
                }

                System.out.println("DATABASE ERROR: " + e.getMessage());
                return "Failed to create user due to a database error.";
            } catch (Exception e) {
                System.out.println("UNEXPECTED ERROR: " + e.getMessage());
                return "An unexpected error occurred while creating the user.";
            }
        }

    public String updateUser(long id, User user){
        Optional<User> u = userRepository.findById(id);

        User eu = u.get();

        eu.setName(user.getName());
        eu.setEmail(user.getEmail());
        eu.setPassword(user.getPassword());

        userRepository.save(eu);

        return "User updated Successfully";
    }

    public String deleteUser(long id){
        userRepository.deleteById(id);
        return "User with id " + id + " is deleted successfully";
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User findByEmail(String email){
        return userRepository.getUserByEmail(email);
    }

}
