package com.example.USLTEST.domain.DTO;

import lombok.Data;

import java.util.Set;

@Data
public class RouteDto {
    private Long routeId;          // Matches the entity's routeId
    private String startLocation;
    private String endLocation;
    private String duration;
    private Set<Long> busIds;      // Represents the IDs of buses associated with the route
    private Set<Long> ticketIds;   // Represents the IDs of tickets associated with the route
}
