package com.demo.fia.service;

import com.demo.fia.entity.Pilot;
import com.demo.fia.entity.Race;
import com.demo.fia.repository.RaceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class RaceService {

    private final RaceRepository raceRepository;
    private final PilotService pilotService;

    public List<String> start(UUID racePublicId, int speed) {
        Race race = raceRepository.findByPublicId(racePublicId);
        if (race == null) {
            throw new RuntimeException("Race not found");
        }

        List<Pilot> pilots = pilotService.readSpeedCompatiblePilots(speed);
        if (pilots.isEmpty()) {
            throw new RuntimeException("No pilots with compatible cars found");
        }

        return pilots.stream()
                .map(pilot -> String.format(
                        "Le pilote '%s %s' peut participer à la course '%s' avec sa voiture '%s'",
                        pilot.getFirstname(),
                        pilot.getLastname(),
                        race.getName(),
                        pilot.getCar().getName()
                ))
                .toList();
    }

    public Race create(Race race) {
        return raceRepository.save(race);
    }

    public List<Race> readAll( ) {
        return raceRepository.findAll();
    }

    public Race updatePilots(UUID racePublicId, List<UUID> pilotsPublicIds) {
        Race race = raceRepository.findByPublicId(racePublicId);
        if (race == null) {
            throw new RuntimeException("Race not found");
        }

        List<Pilot> pilots = pilotService.readMany(pilotsPublicIds);
        if (pilots.size() != pilotsPublicIds.size()) {
            throw new RuntimeException("Some pilots not found");
        }

        race.setPilots(pilots);
        return raceRepository.save(race);
    }
}
