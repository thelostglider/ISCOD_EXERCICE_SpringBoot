package com.demo.fia.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

@Entity
@Table(name = "pilot")
@Data
@EqualsAndHashCode(callSuper = true)
public class Pilot extends BaseEntity {

    @Column(nullable = false)
    private String firstname;

    @Column(nullable = false)
    private String lastname;

    @Column(nullable = false)
    private String country;

    @ManyToOne
    @JoinColumn(name = "car_id")
    private Car car;

    @ManyToMany(mappedBy = "pilots")
    private List<Race> races;
}
