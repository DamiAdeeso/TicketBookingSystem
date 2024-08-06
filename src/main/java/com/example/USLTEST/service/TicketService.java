package com.example.USLTEST.service;

import com.example.USLTEST.domain.DTO.TicketDto;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface TicketService {
    ResponseEntity<TicketDto> createTicket(TicketDto ticketDto);
    ResponseEntity<TicketDto> updateTicket(TicketDto ticketDto, Long id);
    ResponseEntity<Void> deleteTicket(Long id);
    ResponseEntity<TicketDto> getTicketById(Long id);
    ResponseEntity<List<TicketDto>> getAllTickets();
    ResponseEntity<List<TicketDto>> getTicketsByUserId(Long userId);
    ResponseEntity<List<TicketDto>> getTicketsByRouteId(Long routeId);
    ResponseEntity<List<TicketDto>> getTicketsByBusId(Long busId);
}
