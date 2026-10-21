package com.abc.airport.mgt.dto;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(name = "destinationLoc")
public class DestinationLocDTO extends BaseDTO{
	@Column(name = "des_loc",length = 255)
	private String destinationLoc;

	@OneToMany(cascade = CascadeType.ALL,mappedBy = "desLoc")
	private Set<AddWorkScheduleDTO> addWorkSchedule;
	
	@OneToMany(cascade = CascadeType.ALL,mappedBy = "desLoc")
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
