package com.abc.airport.mgt.dto;

import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(name = "user")
public class UserDTO extends BaseDTO {
	
	@Column(name = "first_name", length = 255)
	private String firstName;
	@Column(name = "last_name", length = 255)
	private String lastName;
	@Column(name = "dob", length = 255)
	private Date dob;
	@Column(name = "gender", length = 255)
	private String gender;
	@Column(name = "contactNo", length = 255)
	private String contactNo;
	@Column(name = "login", length = 255)
	private String login;
	@Column(name = "password", length = 255)
	private String password;
	@Column(name = "role_id", length = 255)
	private long roleId;
	@Column(name = "designation", length = 255)
	private String designation;
	@Column(name = "secret_ans1", length = 455)
	private String secretAns1;
	@Column(name = "secret_ans2", length = 455)
	private String secretAns2;
	@Column(name = "secret_ans3", length = 455)
	private String secretAns3;
	@Column(name = "status", length = 200)
	private String status;
	@Column(name = "employee_id", length = 20)
	private String employeeId;
	@Transient
	private String confirmPassword;
	@Column(name = "ROLE_NAME",length = 225)
	private String roleName;
	
	

	
	  @OneToMany(cascade = CascadeType.ALL, mappedBy = "manager")
	  private  Set<AllotHangerDTO> allots;
	  
	/* @OneToMany(cascade = CascadeType.ALL, mappedBy = "pilotId") private
	 * Set<FlightPlanDTO> updateFlightPlan;
	 */
	
	@Override
	public String getKey() {
		// TODO Auto-generated method stub
		return String.valueOf(id);
	}

	@Override
	public String getValue() {
		// TODO Auto-generated method stub
		return firstName + lastName;
	}

}
