package com.abc.airport.mgt.dto;

import javax.persistence.Table;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(name = "deploc")
public class DepartureLocDTO extends BaseDTO{

	@Column(name = "dep_loc", length = 255)
	private String depLoc;

	@OneToMany(cascade = CascadeType.ALL,mappedBy = "departureLocation")
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
