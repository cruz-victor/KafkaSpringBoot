package com.ubicuosoft.redis.advanced.entity;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class Item implements Serializable {

    private String id;
    private String name;
    private double price;

    // Getters and Setters (puedes generarlos automáticamente con tu IDE)
}