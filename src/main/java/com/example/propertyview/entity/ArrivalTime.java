package com.example.propertyview.entity;

import jakarta.persistence.Embeddable;
import lombok.Data;

import java.time.LocalTime;

@Embeddable
@Data
public class ArrivalTime {

    private LocalTime checkIn;

    private LocalTime checkOut;
}