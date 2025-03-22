package com.example.music_lib.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long uid;

    private String name;
    private String password;
    private String email;

    public User(){}

    public User(String _name,String _password,String _email) {
        this.name = _name;
        this.password = _password;
        this.email = _email;
    }

    public void setName(String _name){
        this.name = _name;
    }

    public String getName(){
        return name;
    }

    public void setPassword(String _password){
        this.password = _password;
    }

    public String getPassword(){
        return password;
    }

    public void setEmail(String _email){
        this.email = _email;
    }

    public String getEmail(){
        return email;
    }

    public long getId(){
        return uid;
    }

}
