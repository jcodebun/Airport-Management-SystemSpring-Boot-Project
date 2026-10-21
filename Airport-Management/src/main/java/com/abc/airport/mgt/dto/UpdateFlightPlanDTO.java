package com.abc.airport.mgt.dto;

import java.sql.Time;
import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Getter;
import lombok.Setter;
@Setter
@Getter
@Entity
@Table(name = "flightplanupdate")
public class UpdateFlightPlanDTO extends BaseDTO{
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "departureLocation", nullable = false)
	private DepartureLocDTO departureLocation;
	private long departureLocId;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "waypoints", nullable = false)
	private WaypointsDTO waypoints;	
	private long waypointsId;
	
	@Column(name = "arr_time",length = 255)
	@DateTimeFormat(pattern = "HH:mm")
	private Date arrivalTime;
	//@Column(name = "des_loc",length = 255)
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "desLoc", nullable = false)
	private DestinationLocDTO desLoc;
	
	private long destinationLocId;
	
	@Column(name = "alt_air",length = 255)
	private String  alternateAirports;
	/*
	 * @Column(name = "aircraft_info",length = 555) private String aircraftInfo;
	 */
	@Column(name = "user_id",length = 255)
	private long userId;
	
	@ManyToOne
	@JoinColumn(name = "plane", nullable = false)
	private PlaneDTO plane;
	private long planeId;
	
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
