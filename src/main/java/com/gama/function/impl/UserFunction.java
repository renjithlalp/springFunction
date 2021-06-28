package com.gama.function.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.gama.function.beans.User;
import com.gama.function.domains.ResponseDTO;
import com.gama.function.service.UserService;

import java.util.function.Function;

@Configuration
public class UserFunction {
    @Autowired
    private UserService userService;

    @Bean("userSave")
    public Function<User, ResponseDTO> save() {
        return user -> userService.save(user);
    }

    @Bean("userUpdate")
    public Function<User, ResponseDTO> update() {
        return user -> userService.update(user);
    }

    @Bean("userGet")
    public Function<Integer, ResponseDTO> get() {
        return id -> userService.get(id);
    }

    @Bean("userDelete")
    public Function<Integer, ResponseDTO> delete() {
        return id -> userService.delete(id);
    }

    @Bean("userProfile")
    public Function<String, ResponseDTO> userProfile() {
        return id -> userService.userProfile(id);
    }
}
