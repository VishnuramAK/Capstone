package com.example.safewell.service;

import com.example.safewell.dto.EmergencyContactRequest;
import com.example.safewell.dto.EmergencyContactUpdateRequest;
import com.example.safewell.model.EmergencyContact;
import com.example.safewell.model.User;
import com.example.safewell.repository.EmergencyContactRepository;
import com.example.safewell.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EmergencyContactService {

    @Autowired
    private EmergencyContactRepository contactRepo;

    @Autowired
    private UserRepository userRepo;

    public String addEmergencyContact(EmergencyContactRequest request) {
    	if (request.getUserId() == null) {
            return "User ID must not be null.";
        }

        Optional<User> userOpt = userRepo.findById(request.getUserId());
        if (userOpt.isEmpty()) {
            return "User not found.";
        }

        EmergencyContact contact = new EmergencyContact();
        contact.setName(request.getName());
        contact.setPhone(request.getPhone());
        contact.setRelationship(request.getRelationship());
        contact.setUser(userOpt.get());

        contactRepo.save(contact);
        return "Emergency contact added.";
    }

    public String updateEmergencyContact(Long id,EmergencyContactUpdateRequest request) {
        Optional<EmergencyContact> contactOpt = contactRepo.findById(id);
        if (contactOpt.isEmpty()) {
            return "Contact not found.";
        }

        EmergencyContact contact = contactOpt.get();
        contact.setName(request.getName());
        contact.setPhone(request.getPhone());
        contact.setRelationship(request.getRelationship());

        contactRepo.save(contact);
        return "Emergency contact updated.";
    }
}

