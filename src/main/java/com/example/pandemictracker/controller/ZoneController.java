package com.example.pandemictracker.controller;

import com.example.pandemictracker.entity.ZoneResult;
import com.example.pandemictracker.exception.ZoneDoseNotExistException;
import com.example.pandemictracker.service.ZoneService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/zone")
public class ZoneController {

    private final ZoneService zoneService;

    @GetMapping("/pinCode/{zone}")
    public ResponseEntity<ZoneResult> getZoneType(@PathVariable(name = "zone") String zone) throws ZoneDoseNotExistException {
        return ResponseEntity.ok().body(zoneService.getZone(zone));
    }
}
