package com.example.safewell.controller;

import com.example.safewell.dto.EmergencyContactRequest;
import com.example.safewell.dto.EmergencyContactUpdateRequest;
import com.example.safewell.service.EmergencyContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/contacts")
public class EmergencyContactController {

    @Autowired
    private EmergencyContactService contactService;

    @PostMapping("/add")
    public String addContact(@RequestBody EmergencyContactRequest request) {
        return contactService.addEmergencyContact(request);
    }

    @PutMapping("/edit/{id}")
    public ResponseEntity<String> updateContact(
            @PathVariable Long id,
            @RequestBody EmergencyContactUpdateRequest contactDto) {
        contactService.updateEmergencyContact(id, contactDto);
        return ResponseEntity.ok("Contact updated successfully");
    }

}
