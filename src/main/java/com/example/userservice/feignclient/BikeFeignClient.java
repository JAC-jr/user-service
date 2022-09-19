package com.example.userservice.feignclient;

import com.example.userservice.Models.Bike;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "service2", path = "/bikes", url = "http://localhost:8020")
public interface BikeFeignClient {

    @PostMapping
    Bike save (@RequestBody Bike bike);
}

