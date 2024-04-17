package com.utadeo.taskapp.controller;

import org.springframework.web.bind.annotation.RestController;

import com.utadeo.taskapp.model.User;
import com.utadeo.taskapp.service.IUserService;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
public class UserController {

    private IUserService userService;

    UserController(IUserService userService){
        this.userService = userService;
    }

    @PostMapping("user/")
    public User store(@RequestBody User user){
        return this.userService.createUser(user);
    }
    
    @PutMapping("user/{id}") 
    public User update(@PathVariable Long id, @RequestBody User user){
         return this.userService.updateUser(id, user); }

    @GetMapping("user/{id}")
     public User show(@PathVariable Long id){ 
        return this.userService.getById(id); }

    @GetMapping("users")
     public List<User> index(){ 
        return this.userService.getAllUsers(); }

    @DeleteMapping("user/{id}")
     public void destroy(@PathVariable Long id){ 
        this.userService.deleteUser(id); } 
}
