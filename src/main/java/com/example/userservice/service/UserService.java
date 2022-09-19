package com.example.userservice.service;

import com.example.userservice.Models.Bike;
import com.example.userservice.Models.Car;
import com.example.userservice.entity.Users;
import com.example.userservice.feignclient.BikeFeignClient;
import com.example.userservice.feignclient.CarFeignClient;
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

    @Autowired
    CarFeignClient carFeignClient;

    @Autowired
    BikeFeignClient bikeFeignClient;

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
        List<Car> cars = restTemplate.getForObject("http://localhost:8011/cars/byUserId/" + userId, List.class);
        return cars;
    }

    public List<Bike> getBike(int userId){
        List<Bike> bike = restTemplate.getForObject("http://localhost:8020/bikes/byUserId/" + userId, List.class);
        return bike;
    }

    public Car saveCar(int userId,Car car){
        car.setUserId(userId);
        Car carNew = carFeignClient.save(car);
        return carNew;
    }

    public Bike saveBike(int userId,Bike bike){
        bike.setUserId(userId);
        Bike bikeNew = bikeFeignClient.save(bike);
        return bikeNew;
    }
}
