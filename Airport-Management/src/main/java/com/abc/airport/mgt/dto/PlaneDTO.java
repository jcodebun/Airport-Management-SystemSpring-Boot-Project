package com.abc.airport.mgt.dto;

import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
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
@Table(name = "plane")
public class PlaneDTO extends BaseDTO{
	
	@Column(name = "model_number", length = 255)
	private String modelNumber;
	@Column(name = "purchase_date")
	private String purchaseDate;
	@Column(name = "last_service_date")
	private String lastServiceDate;
	@Column(name = "price")
	private long price;
	@OneToMany(cascade = CascadeType.ALL,mappedBy = "plane")
	private Set<UpdateFlightPlanDTO> flightPlanUpdate;
	
	@OneToMany(cascade = CascadeType.ALL,mappedBy = "plane") private
	Set<AllotHangerDTO> allots;
	 
	@OneToMany(cascade = CascadeType.ALL,mappedBy = "plane") 
	private Set<PreFlightModeDTO> preFlight;

	  
	@Override
	public String getKey() {
		// TODO Auto-generated method stub
		return String.valueOf(id);
	}

	@Override
	public String getValue() {
		// TODO Auto-generated method stub
		return modelNumber;
	}

}
