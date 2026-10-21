package com.abc.airport.mgt.dto;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(name = "pre_flight")
public class PreFlightModeDTO extends BaseDTO {

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "plane", nullable = false)
	private PlaneDTO plane;
	private long planeId;
	
	private String laptopPower;
	
	private String laptopBattery;
	
	private String missionPlanner;
	
	private String Motor;
	@Override
	public String getKey() {
		// TODO Auto-generated method stub
		return id+ "";
	}

	@Override
	public String getValue() {
		// TODO Auto-generated method stub
		return laptopPower;
	}

	
}
