package com.example.pandemictracker.repository;

import com.example.pandemictracker.entity.Admin;
import com.example.pandemictracker.exception.ZoneDoseNotExistException;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class ZoneRepository {

    Map<String, Integer> zoneMap = new HashMap<>();
    public void addCount(String zone){
        zoneMap.put(zone, zoneMap.getOrDefault(zone, 0)+1);
    }

    public int getCount(String zone) throws ZoneDoseNotExistException {
        if(zoneMap.containsKey(zone)){
            return zoneMap.get(zone);
        }else{
            throw new ZoneDoseNotExistException("zone does not exist"+ zone);
        }
    }

    public void decCount(String zone){
        zoneMap.put(zone, zoneMap.getOrDefault(zone, 0)-1);
    }
}
