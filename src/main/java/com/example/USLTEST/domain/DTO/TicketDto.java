package com.example.USLTEST.domain.DTO;

import lombok.Data;

@Data
public class TicketDto {
    private Long id;
    private String seatNumber;
    private Double price;
    private String status;
    private Long userId;
    private Long routeId;
    private Long busId;
}
