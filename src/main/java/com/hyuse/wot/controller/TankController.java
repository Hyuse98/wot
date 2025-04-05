package com.hyuse.wot.controller;

import com.hyuse.wot.model.Tank;
import com.hyuse.wot.service.TankService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/api/tanks")
public class TankController {

    private final TankService tankService;

    public TankController(TankService tankService) {
        this.tankService = tankService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Tank> findTankById(@PathVariable Long id) {

        var tank = tankService.findTankById(id);
        return ResponseEntity.ok(tank);
    }

    @PostMapping
    public ResponseEntity<Tank> createTank(@RequestBody Tank tank) {

        var tankCreated = tankService.create(tank);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(tankCreated.getId())
                .toUri();

        return ResponseEntity.created(location).body(tankCreated);
    }
}
