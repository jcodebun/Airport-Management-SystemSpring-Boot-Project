package com.abc.airport.mgt.dto;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(name = "waypoints")
public class WaypointsDTO extends BaseDTO{
	@Column(name = "wapoints_name", length = 255)
	private String wapointsName;
	

	@OneToMany(cascade = CascadeType.ALL,mappedBy = "waypoints")
	private Set<UpdateFlightPlanDTO> flightPlanUpdate;
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
