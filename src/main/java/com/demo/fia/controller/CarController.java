package com.demo.fia.controller;

import com.demo.fia.entity.Car;
import com.demo.fia.service.CarService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cars")
@RequiredArgsConstructor
public class CarController {

    private final CarService carService;

    @PostMapping
    public Car create(@RequestBody Car car) {
        return carService.create(car);
    }

    @GetMapping
    public List<Car> readAll() {
        return carService.readAll();
    }
}
