package com.example.USLTEST.domain.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class BusEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "bus_id")
    private Long busId;

    @Column(name = "bus_number", unique = true)
    @NotBlank(message = "Bus number cannot be blank")
    private String busNumber;

    @Column(name = "capacity")
    private int capacity;

    @OneToOne(mappedBy = "bus")
    private UserEntity user;

    @ManyToOne
    @JoinColumn(name = "route_id", nullable = false)
    private RouteEntity route;
}