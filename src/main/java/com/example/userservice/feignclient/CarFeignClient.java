package com.example.userservice.feignclient;

import com.example.userservice.Models.Car;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(name = "service1", url = "http://localhost:8011")
@RequestMapping("/cars")
public interface CarFeignClient {

    @PostMapping
    Car save(@RequestBody Car car);
}
