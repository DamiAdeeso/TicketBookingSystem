package com.example.USLTEST.domain.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@Entity
@Table(name = "routes")
@NoArgsConstructor
public class RouteEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "route_id")
    private Long routeId;

    @Column(name = "start_location")
    private String startLocation;

    @Column(name = "end_location")
    private String endLocation;

    @Column(name = "duration")
    private String duration;

    @OneToMany(mappedBy = "route", fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    private Set<BusEntity> buses;

    @OneToMany(mappedBy = "route", fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    private Set<TicketEntity> tickets;
}
