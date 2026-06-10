package com.demo.fia.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Table(name = "car")
@Data
@EqualsAndHashCode(callSuper = true)
public class Car extends BaseEntity {

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private int speed;
}
