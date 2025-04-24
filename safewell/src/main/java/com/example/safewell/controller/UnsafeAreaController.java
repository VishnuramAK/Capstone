package com.example.safewell.controller;



import com.example.safewell.dto.UnsafeAreaDTO;
import com.example.safewell.service.UnsafeAreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.Map;

@RestController
@RequestMapping("/unsafe-areas")
public class UnsafeAreaController {

    @Autowired
    private UnsafeAreaService unsafeAreaService;

    @PostMapping("/add")
    public ResponseEntity<String> addUnsafeArea(@RequestBody UnsafeAreaDTO dto, Principal principal) {
        String user = principal != null ? principal.getName() : "ANONYMOUS";
        unsafeAreaService.addUnsafeArea(dto, user);
        return ResponseEntity.ok("Unsafe area added.");
    }

    @PostMapping("/check")
    public ResponseEntity<String> checkLocation(@RequestBody Map<String, Double> location) {
        double lat = location.get("latitude");
        double lon = location.get("longitude");
        boolean isUnsafe = unsafeAreaService.isInUnsafeArea(lat, lon);
        return ResponseEntity.ok(isUnsafe ? "You are in an unsafe area!" : "You are safe.");
    }
}

