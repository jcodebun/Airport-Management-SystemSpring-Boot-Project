package com.abc.airport.mgt.dto;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(name = "post_flight")
public class PostFlightModeDTO extends BaseDTO {
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "plane", nullable = false)
	private PlaneDTO plane;
	private long planeId;
	
	private String masterSwitch;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "hanger", nullable = false)
	private AddHangerDTO hanger;
	private long hangerId;
	

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
