package com.demo.fia.controller;

import com.demo.fia.entity.Race;
import com.demo.fia.service.RaceService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/races")
@RequiredArgsConstructor
public class RaceController {

    private final RaceService raceService;

    @PostMapping
    public Race create(@RequestBody Race race) {
        return raceService.create(race);
    }

    @PostMapping("/{racePublicId}/{speed}/start")
    public List<String> start(@PathVariable UUID racePublicId, @PathVariable int speed) {
        return raceService.start(racePublicId, speed);
    }

    @GetMapping
    public List<Race> readAll() {
        return raceService.readAll();
    }

    @PatchMapping("/{racePublicId}/pilots")
    public Race updatePilots(@PathVariable("racePublicId") UUID racePublicId, @RequestBody List<UUID> pilotsPublicIds) {
        return raceService.updatePilots(racePublicId, pilotsPublicIds);
    }
}
