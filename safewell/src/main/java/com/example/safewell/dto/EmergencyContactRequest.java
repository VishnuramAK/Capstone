package com.example.safewell.dto;

import lombok.Data;

@Data
public class EmergencyContactRequest {
    private Long userId;
    private String name;
    private String phone;
    private String relationship;
    
    //Getters and Setters...
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
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

