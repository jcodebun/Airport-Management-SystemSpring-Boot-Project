package com.abc.airport.mgt.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;
@Setter
@Getter
@Entity
@Table(name = "allot")
public class AllotHangerDTO extends BaseDTO {

	
	@ManyToOne
	@JoinColumn(name="manager",nullable=false)
	private UserDTO manager;
	private long manager_id;
	
	@ManyToOne
	@JoinColumn(name="hanger",nullable=false)
	private AddHangerDTO hanger;
	private long hangerId;
	
	@ManyToOne
	@JoinColumn(name="plane",nullable=false)
	private PlaneDTO plane;
	private long planeId;
	@Column(name = "status",nullable = false)
	private String status;

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
