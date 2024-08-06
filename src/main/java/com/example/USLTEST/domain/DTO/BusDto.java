package com.example.USLTEST.domain.DTO;

import lombok.Data;

@Data
public class BusDto {
    private Long busId;
    private String busNumber;
    private int capacity;
    private Long userId;  // Reference to the associated user
    private Long routeId; // Reference to the associated route
}
