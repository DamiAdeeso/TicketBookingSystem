package com.example.USLTEST.service.impl;

import com.example.USLTEST.domain.DTO.TicketDto;
import com.example.USLTEST.domain.entity.TicketEntity;
import com.example.USLTEST.domain.mapper.Mapper;
import com.example.USLTEST.repository.TicketRepository;
import com.example.USLTEST.service.TicketService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TicketServiceImpl implements TicketService {
    private final TicketRepository ticketRepository;

    private final Mapper<TicketEntity, TicketDto> ticketMapper;

    @Override
    public ResponseEntity<TicketDto> createTicket(TicketDto ticketDto) {
        TicketEntity ticket = ticketMapper.mapFrom(ticketDto);
        TicketEntity savedTicket = ticketRepository.save(ticket);
        return new ResponseEntity<>(ticketMapper.mapTo(savedTicket), HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<TicketDto> updateTicket(TicketDto ticketDto, Long id) {
        if (ticketRepository.existsById(id)) {
            return ticketRepository.findById(id).map(existingTicket -> {
                Optional.ofNullable(ticketDto.getSeatNumber()).ifPresent(existingTicket::setSeatNumber);
                Optional.ofNullable(ticketDto.getPrice()).ifPresent(existingTicket::setPrice);
                Optional.ofNullable(ticketDto.getStatus()).ifPresent(existingTicket::setStatus);

                TicketDto savedTicketDto = ticketMapper.mapTo(ticketRepository.save(existingTicket));
                return new ResponseEntity<>(savedTicketDto, HttpStatus.OK);
            }).orElseThrow(() -> new RuntimeException("Ticket Did Not Update"));
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public ResponseEntity<Void> deleteTicket(Long id) {
        if (ticketRepository.existsById(id)) {
            ticketRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public ResponseEntity<TicketDto> getTicketById(Long id) {
        return ticketRepository.findById(id)
                .map(ticket -> new ResponseEntity<>(ticketMapper.mapTo(ticket), HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @Override
    public ResponseEntity<List<TicketDto>> getAllTickets() {
        List<TicketDto> tickets = ticketRepository.findAll()
                .stream()
                .map(ticketMapper::mapTo)
                .collect(Collectors.toList());
        return new ResponseEntity<>(tickets, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<TicketDto>> getTicketsByUserId(Long userId) {
        List<TicketDto> tickets = ticketRepository.findByUser_UserId(userId)
                .stream()
                .map(ticketMapper::mapTo)
                .collect(Collectors.toList());
        return new ResponseEntity<>(tickets, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<TicketDto>> getTicketsByRouteId(Long routeId) {
        List<TicketDto> tickets = ticketRepository.findByUser_UserId(routeId)
                .stream()
                .map(ticketMapper::mapTo)
                .collect(Collectors.toList());
        return new ResponseEntity<>(tickets, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<TicketDto>> getTicketsByBusId(Long busId) {
        List<TicketDto> tickets = ticketRepository.findByBus_BusId(busId)
                .stream()
                .map(ticketMapper::mapTo)
                .collect(Collectors.toList());
        return new ResponseEntity<>(tickets, HttpStatus.OK);
    }
}
