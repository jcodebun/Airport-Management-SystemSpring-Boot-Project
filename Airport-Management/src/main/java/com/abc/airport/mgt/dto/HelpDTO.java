package com.abc.airport.mgt.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(name = "help")
public class HelpDTO extends BaseDTO{
	@Column(name = "issue", length = 255)
	private String issue;
	@Column(name = "description", length = 455)
	private String description;
	@Column(name = "user_id")
	private String userId;
	@Column(name="answer",length = 225)
	private String ansQuery;
	
	
	
	

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
