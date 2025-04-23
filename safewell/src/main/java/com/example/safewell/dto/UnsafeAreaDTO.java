package com.example.safewell.dto;

import lombok.Data;

@Data
public class UnsafeAreaDTO {
    private String areaName;
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
	private double latitude;
    private double longitude;
    private double radiusInMeters;
}
