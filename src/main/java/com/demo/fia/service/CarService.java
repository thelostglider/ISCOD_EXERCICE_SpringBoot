package com.demo.fia.service;

import com.demo.fia.entity.Car;
import com.demo.fia.repository.CarRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CarService {

    private final CarRepository repository;

    public Car create(Car car) {
        return repository.save(car);
    }

    public List<Car> readAll() {
        return repository.findAll();
    }

    public Car read(UUID publicId) {
        return repository.findByPublicId(publicId);
    }
}