package com.example.safewell.service;



import com.example.safewell.dto.UnsafeAreaDTO;
import com.example.safewell.model.UnsafeArea;
import com.example.safewell.repository.UnsafeAreaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UnsafeAreaService {

    @Autowired
    private UnsafeAreaRepository unsafeAreaRepository;

    public UnsafeArea addUnsafeArea(UnsafeAreaDTO dto, String addedBy) {
        UnsafeArea area = new UnsafeArea();
        area.setAreaName(dto.getAreaName());
        area.setLatitude(dto.getLatitude());
        area.setLongitude(dto.getLongitude());
        area.setRadiusInMeters(dto.getRadiusInMeters());
        area.setAddedBy(addedBy);
        return unsafeAreaRepository.save(area);
    }

    public boolean isInUnsafeArea(double lat, double lon) {
        List<UnsafeArea> areas = unsafeAreaRepository.findAll();
        for (UnsafeArea area : areas) {
            if (distance(lat, lon, area.getLatitude(), area.getLongitude()) <= area.getRadiusInMeters()) {
                return true;
            }
        }
        return false;
    }

    private double distance(double lat1, double lon1, double lat2, double lon2) {
        final int R = 6371000; // Radius of Earth in meters
        double dLat = Math.toRadians(lat2 - lat1);
        double dLon = Math.toRadians(lon2 - lon1);
        double a = Math.sin(dLat / 2) * Math.sin(dLat / 2)
                + Math.cos(Math.toRadians(lat1)) * Math.cos(Math.toRadians(lat2))
                * Math.sin(dLon / 2) * Math.sin(dLon / 2);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
        return R * c;
    }
}
