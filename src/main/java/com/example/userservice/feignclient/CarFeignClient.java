package com.example.userservice.feignclient;

import com.example.userservice.Models.Car;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "service1",path = "/cars", url = "http://localhost:8011")
public interface CarFeignClient {

    @PostMapping
    Car save(@RequestBody Car car);
}
