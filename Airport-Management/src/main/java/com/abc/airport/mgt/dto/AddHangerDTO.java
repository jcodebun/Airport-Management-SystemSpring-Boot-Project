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
@Table(name = "hanger")
public class AddHangerDTO extends BaseDTO{
	@Column(name = "hanger_name", length = 245)
	private String hangerName;
	@Column(name = "hanger_model",length = 255)
	private String hangerModel;
	@Column(name = "hanger_address",length = 455)
	private String hangerAddress;
	@OneToMany(cascade = CascadeType.ALL,mappedBy = "hanger")
	private Set<AllotHangerDTO> allots;

	@OneToMany(cascade = CascadeType.ALL,mappedBy = "hanger") 
	private Set<PostFlightModeDTO> postFlight;
	
	@Override
	public String getKey() {
		// TODO Auto-generated method stub
		return id+ "";
	}

	@Override
	public String getValue() {
		// TODO Auto-generated method stub
		return hangerName;
	}

}
