package com.example.safewell.dto;

import lombok.Data;

@Data
public class EmergencyContactUpdateRequest {
    private Long contactId;
    private String name;
    private String phone;
    private String relationship;
    
    //Getters and Setters...
	public Long getContactId() {
		return contactId;
	}
	public void setContactId(Long contactId) {
		this.contactId = contactId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getRelationship() {
		return relationship;
	}
	public void setRelationship(String relationship) {
		this.relationship = relationship;
	}
    
    
}
