package com.example.USLTEST.controllers;

import com.example.USLTEST.domain.DTO.BusDto;
import com.example.USLTEST.service.BusService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class BusController {

    private final BusService busService;

    @PostMapping("/admin/buses")
    public ResponseEntity<BusDto> createBus(@RequestBody BusDto busDto) {
        return busService.createBus(busDto);
    }

    @PutMapping("/admin/buses/{id}")
    public ResponseEntity<BusDto> updateBus(@RequestBody BusDto busDto, @PathVariable Long id) {
        return busService.updateBus(busDto, id);
    }

    @DeleteMapping("/admin/buses/{id}")
    public ResponseEntity<Void> deleteBus(@PathVariable Long id) {
        return busService.deleteBus(id);
    }

    @GetMapping("/user/buses/{id}")
    public ResponseEntity<BusDto> getBusById(@PathVariable Long id) {
        return busService.getBusById(id);
    }

    @GetMapping("/user/buses/")
    public ResponseEntity<List<BusDto>> getAllBuses() {
        return busService.getAllBuses();
    }
}
