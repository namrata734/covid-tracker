package com.example.pandemictracker.service;

import com.example.pandemictracker.entity.ZoneResult;
import com.example.pandemictracker.entity.ZoneType;
import com.example.pandemictracker.exception.ZoneDoseNotExistException;
import com.example.pandemictracker.repository.ZoneRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ZoneService {

    private final ZoneRepository zoneRepository;

    public ZoneResult getZone(String zone) throws ZoneDoseNotExistException {
        int count = zoneRepository.getCount(zone);
        ZoneType zoneType;
        if(count<=0){
            zoneType = ZoneType.Green;
        }else if(count<=5){
            zoneType = ZoneType.Orange;
        }else{
            zoneType = ZoneType.Red;
        }
        return ZoneResult.builder()
                .count(count)
                .zoneType(zoneType)
                .build();
    }
}
