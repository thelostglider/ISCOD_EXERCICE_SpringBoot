package com.demo.fia.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

@Entity
@Table(name = "race")
@Data
@EqualsAndHashCode(callSuper = true)
public class Race extends BaseEntity {

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String country;

    @ManyToMany
    @JoinTable(
            name = "race_pilot",
            joinColumns = @JoinColumn(name = "race_id"),
            inverseJoinColumns = @JoinColumn(name = "pilot_id")
    )
    private List<Pilot> pilots;
}
