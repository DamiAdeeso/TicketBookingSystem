package com.example.USLTEST.controllers;

import com.example.USLTEST.domain.DTO.RouteDto;
import com.example.USLTEST.service.RouteService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class RouteController {
    private final RouteService routeService;

    @PostMapping("/admin/routes")
    public ResponseEntity<RouteDto> createRoute(@RequestBody RouteDto routeDto) {
        return routeService.createRoute(routeDto);
    }

    @PutMapping("/admin/routes/{id}")
    public ResponseEntity<RouteDto> updateRoute(@RequestBody RouteDto routeDto, @PathVariable Long id) {
        return routeService.updateRoute(routeDto, id);
    }

    @DeleteMapping("/user/routes/{id}")
    public ResponseEntity<Void> deleteRoute(@PathVariable Long id) {
        return routeService.deleteRoute(id);
    }

    @GetMapping("/user/routes/{id}")
    public ResponseEntity<RouteDto> getRouteById(@PathVariable Long id) {
        return routeService.getRouteById(id);
    }

    @GetMapping("/user/routes")
    public ResponseEntity<List<RouteDto>> getAllRoutes() {
        return routeService.getAllRoutes();
    }

//    @GetMapping("/bus/{busId}")
//    public ResponseEntity<List<RouteDto>> getRoutesByBusId(@PathVariable Long busId) {
////        return routeService.getRoutesByBusId(busId);
//    }

    @GetMapping("/user/routes/search")
    public ResponseEntity<List<RouteDto>> findRoutes(@RequestParam String startLocation, @RequestParam String endLocation) {
        return routeService.findRoutes(startLocation, endLocation);
    }
}
