package com.abc.airport.mgt.dto;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(name = "work_schedule")
public class AddWorkScheduleDTO extends BaseDTO{
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "desLoc", nullable = false)
	private DestinationLocDTO desLoc;
	private long destinationLocationId;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "pilot")
	private UserDTO pilot;
	@Column(name = "workdate")
	//@Temporal(TemporalType.DATE)
	private Date date;
	private long pilotId;
	@Column(name = "description",length = 555)
	private String description;
	@Column(name = "timeslot", length = 255)
	public String timeSlot;

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
