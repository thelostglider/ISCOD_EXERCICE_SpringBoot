package com.demo.fia.service;

import com.demo.fia.entity.Car;
import com.demo.fia.entity.Pilot;
import com.demo.fia.repository.PilotRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class PilotService {

    private final PilotRepository pilotRepository;
    private final CarService carService;

    public Pilot create(Pilot pilot) {
        return pilotRepository.save(pilot);
    }

    public List<Pilot> readAll() {
        return pilotRepository.findAll();
    }

    public List<Pilot> readMany(List<UUID> publicIds) {
        return pilotRepository.findByPublicIdIn(publicIds);
    }

    public List<Pilot> readSpeedCompatiblePilots(int speed) {
        return pilotRepository.findByCarSpeedGreaterThanEqual(speed);
    }

    public Pilot updateCar(UUID pilotPublicId, UUID carPublicId) {

        Pilot pilot = pilotRepository.findByPublicId(pilotPublicId);
        if (pilot == null) {
            throw new RuntimeException("Pilot not found");
        }

        Car car = carService.read(carPublicId);
        if (car == null) {
            throw new RuntimeException("Car not found");
        }

        pilot.setCar(car);
        return pilotRepository.save(pilot);
    }

    public Pilot delete(UUID publicId) {
        return pilotRepository.deleteByPublicId(publicId);
    }
}
