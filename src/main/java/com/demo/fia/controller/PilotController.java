package com.demo.fia.controller;

import com.demo.fia.entity.Pilot;
import com.demo.fia.service.PilotService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/pilots")
@RequiredArgsConstructor
public class PilotController {

    private final PilotService pilotService;

    @PostMapping
    public Pilot create(@RequestBody Pilot pilot) {
        return pilotService.create(pilot);
    }

    @GetMapping
    public List<Pilot> readAll() {
        return pilotService.readAll();
    }

    @PatchMapping("/{pilotPublicId}/car/{carPublicId}")
    public Pilot updateCar(@PathVariable("pilotPublicId") UUID pilotPublicId, @PathVariable("carPublicId") UUID carPublicId) {
        return pilotService.updateCar(pilotPublicId, carPublicId);
    }

    @DeleteMapping("{publicId}")
    public void delete(@PathVariable UUID publicId) {
        pilotService.delete(publicId);
    }
}
