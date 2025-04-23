package com.example.safewell.model;


import jakarta.persistence.*;


@Entity

public class UnsafeArea {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String areaName;
    public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getAreaName() {
		return areaName;
	}
	public void setAreaName(String areaName) {
		this.areaName = areaName;
	}
	public double getLatitude() {
		return latitude;
	}
	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}
	public double getLongitude() {
		return longitude;
	}
	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}
	public double getRadiusInMeters() {
		return radiusInMeters;
	}
	public void setRadiusInMeters(double radiusInMeters) {
		this.radiusInMeters = radiusInMeters;
	}
	public String getAddedBy() {
		return addedBy;
	}
	public void setAddedBy(String addedBy) {
		this.addedBy = addedBy;
	}
	private double latitude;
    private double longitude;
    private double radiusInMeters;
    private String addedBy; // ADMIN or user email
}
