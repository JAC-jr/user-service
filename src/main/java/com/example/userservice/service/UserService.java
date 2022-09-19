package com.example.userservice.service;

import com.example.userservice.Models.Bike;
import com.example.userservice.Models.Car;
import com.example.userservice.entity.Users;
import com.example.userservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    RestTemplate restTemplate;

    public List<Users> getAll(){
        return userRepository.findAll();
    }

    public Users getUserById(int id){
        return userRepository.findById(id).orElse(null);
    }

    public Users saveUser(Users user){
        Users userNew = userRepository.save(user);
        return userNew;
    }

    public List<Car> getCars(int userId){
        List<Car> cars = restTemplate.getForObject("http://localhost:8010/cars/byUserId/" + userId, List.class);
        return cars;
    }

    public List<Bike> getBike(int userId){
        List<Bike> bike = restTemplate.getForObject("http://localhost:8020/bikes/byUserId/" + userId, List.class);
        return bike;
    }
}
