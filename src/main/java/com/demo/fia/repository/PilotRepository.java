package com.demo.fia.repository;

import com.demo.fia.entity.Pilot;

import java.util.List;

public interface PilotRepository extends BaseRepository<Pilot> {
    List<Pilot> findByCarSpeedGreaterThanEqual(int speed);
}
