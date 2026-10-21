package com.abc.airport.mgt.dto;

import java.sql.Timestamp;
import java.util.Date;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;
@Setter
@Getter
//@Entity
//@Table(name = "flightplan")
public class FlightPlanDTO extends BaseDTO {
	
	private String departureLocation;
	
	private String waypoints;
	 
	private Timestamp arrivalTime;
	
	private String destinationLocation;
	
	private String alternateAirport;
	
	@ManyToOne
	@JoinColumn(name="plainId",nullable=false)
	private PlaneDTO plain;
	private long plainId;
	
	@ManyToOne
	@JoinColumn(name="pilot",nullable=false)
	private UserDTO pilot;
	private long pilotId;


	@Override
	public String getKey() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getValue() {
		// TODO Auto-generated method stub
		return null;
	}

}
