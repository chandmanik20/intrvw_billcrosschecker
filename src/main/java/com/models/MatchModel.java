package com.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class MatchModel {
	
	@JsonIgnore
	private boolean matched;
	private String location;
	private float totalcollection;
	private float sumoforder;
	private String locationid;
	
	
	public MatchModel() {
		super();
	}

	public MatchModel(boolean matched, String location, float totalcollection, float sumoforder, String locationid) {
		super();
		this.matched = matched;
		this.location = location;
		this.totalcollection = totalcollection;
		this.sumoforder = sumoforder;
		this.locationid = locationid;
	}
	
	public boolean isMatched() {
		return matched;
	}
	
	public String getLocation() {
		return location;
	}
	
	public float getTotalcollection() {
		return totalcollection;
	}

	public float getSumoforder() {
		return sumoforder;
	}

	public String getLocationid() {
		return locationid;
	}
	
	
}
