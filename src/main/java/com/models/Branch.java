package com.models;

public class Branch {
	String location;
	float totalCollection;
	String locationid;
	
	public Branch() {
		super();
	}
	
	public Branch(String location, float totalCollection, String locationid) {
		super();
		this.location = location;
		this.totalCollection = totalCollection;
		this.locationid = locationid;
	}
	public String getLocation() {
		return location;
	}

	public float getTotalCollection() {
		return totalCollection;
	}
	public void setTotalCollection(float totalCollection) {
		this.totalCollection = totalCollection;
	}
	public String getLocationid() {
		return locationid;
	}
	
	
	
}
