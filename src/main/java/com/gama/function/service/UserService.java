package com.gama.function.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.gama.function.beans.User;
import com.gama.function.domains.ResponseDTO;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {
    private static List<User> users = new ArrayList<>();
    @Autowired
    private RestTemplate restTemplate;

    @PostConstruct
    public void init() {
        User user1 = new User();
        user1.setId(1);
        user1.setName("Renjithlal");
        user1.setEmail("renjithlalp@gmail.com");
        
        User user2 = new User();
        user2.setId(2);
        user2.setName("Vighnehwar");
        user2.setEmail("vigneshwar@gmail.com");
        users.add(user1);
        users.add(user2);
    }

    public ResponseDTO save(User user) {
        users.add(user);
        ResponseDTO responseDTO = new ResponseDTO();
        responseDTO.setMessage("Success");
        responseDTO.setData(user);
        return responseDTO;
    }

    public ResponseDTO update(User user) {
        ResponseDTO responseDTO = new ResponseDTO();
        if (user.getId() != null) {
            users.removeIf(it -> it.getId() == user.getId());
            users.add(user);
            responseDTO.setData(user);
            responseDTO.setStatus(true);
            responseDTO.setMessage("Record Update Successfully ");
        } else {
            responseDTO.setMessage("Record Id is not found");
            responseDTO.setStatus(false);
        }
        return responseDTO;
    }

    public ResponseDTO get(Integer id) {
        ResponseDTO responseDTO = new ResponseDTO();
        if (id != null) {
            User user = users.stream().filter(it -> it.getId() == id).findFirst().get();
            responseDTO.setData(user);
            responseDTO.setStatus(true);
        } else {
            responseDTO.setMessage("Record Id is not found");
            responseDTO.setStatus(false);
        }
        return responseDTO;
    }

    public ResponseDTO delete(Integer id) {
        ResponseDTO responseDTO = new ResponseDTO();
        if (id != null) {
            users.removeIf(it -> it.getId() == id);
            responseDTO.setMessage("Record is deleted successfully");
            responseDTO.setStatus(true);
        } else {
            responseDTO.setMessage("Record Id is not found");
            responseDTO.setStatus(false);
        }
        return responseDTO;
    }

    public ResponseDTO getAll() {
        ResponseDTO responseDTO = new ResponseDTO();
        responseDTO.setData(users);
        return responseDTO;
    }

    public ResponseDTO userProfile(String id) {
        User user = restTemplate.getForEntity("https://jsonplaceholder.typicode.com/todos/" + id, User.class).getBody();
        ResponseDTO responseDTO = new ResponseDTO();
        responseDTO.setData(user);
        return responseDTO;
    }
}
