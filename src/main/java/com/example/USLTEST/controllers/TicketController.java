package com.example.USLTEST.controllers;

import com.example.USLTEST.domain.DTO.TicketDto;
import com.example.USLTEST.service.TicketService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/user/tickets")
@RequiredArgsConstructor
public class TicketController {
    private final TicketService ticketService;

    @PostMapping
    public ResponseEntity<TicketDto> createTicket(@RequestBody TicketDto ticketDto) {
        return ticketService.createTicket(ticketDto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TicketDto> updateTicket(@RequestBody TicketDto ticketDto, @PathVariable Long id) {
        return ticketService.updateTicket(ticketDto, id);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTicket(@PathVariable Long id) {
        return ticketService.deleteTicket(id);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TicketDto> getTicketById(@PathVariable Long id) {
        return ticketService.getTicketById(id);
    }

    @GetMapping
    public ResponseEntity<List<TicketDto>> getAllTickets() {
        return ticketService.getAllTickets();
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<TicketDto>> getTicketsByUserId(@PathVariable Long userId) {
        return ticketService.getTicketsByUserId(userId);
    }

    @GetMapping("/route/{routeId}")
    public ResponseEntity<List<TicketDto>> getTicketsByRouteId(@PathVariable Long routeId) {
        return ticketService.getTicketsByRouteId(routeId);
    }

    @GetMapping("/bus/{busId}")
    public ResponseEntity<List<TicketDto>> getTicketsByBusId(@PathVariable Long busId) {
        return ticketService.getTicketsByBusId(busId);
    }
}
