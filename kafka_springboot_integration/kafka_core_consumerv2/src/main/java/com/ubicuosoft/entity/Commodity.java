package com.ubicuosoft.entity;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Commodity {
    private String name;
    private double price;
    private String messurement;
    private long timestamp;
}
