package com.abc.airport.mgt.form;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

import com.abc.airport.mgt.dto.BaseDTO;
import com.abc.airport.mgt.dto.UserDTO;
import com.abc.airport.mgt.util.DataUtility;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class PilotForm extends BaseForm {
	//@NotEmpty(message = "First Name is required")
	//@Pattern(regexp = "(^[A-Za-z ]*)*$",message = "First Name is Invalid")
	private String firstName;
	//@NotEmpty(message = "Last Name is required")
	//@Pattern(regexp = "(^[A-Za-z ]*)*$",message = "Last Name is Invalid")
	private String lastName;
	//@NotEmpty(message = "Dob is required")
	//@Pattern(regexp = "^(1[0-2]|0[1-9])/(3[01]|[12][0-9]|0[1-9])/[0-9]{4}$",message = "Date Of Birth is Invalid")
	private String dob;
	//@NotEmpty(message = "gender is required")
	private String gender;
	//@NotEmpty(message = "Phone No is required")
	//@Pattern(regexp="(^[7-9][0-9]{9})*$",message = "MobileNo is Invalid")
	private String contactNo;
	//@NotEmpty(message = "Email Id is required")
	//@Pattern(regexp="(^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,}))*$",message = "Email id is invalid")
	private String login;
	private String employeeId;
	
	private String statusApproval;

	//@NotEmpty(message = "Designation is required")
	private String designation;
	
	//@NotEmpty(message = "Password is required")
	private String password;
	
	//@NotEmpty(message = "Answer is required")
	private String secretAns1;
	//@NotEmpty(message = "Answer is required")
	private String secretAns2;
	//@NotEmpty(message = "Answer is required")
	private String secretAns3;
	
	@Override
	public BaseDTO getDTO() {
		UserDTO bean = new UserDTO();
		bean.setId(id);
		bean.setFirstName(firstName);
		bean.setLastName(lastName);
		bean.setDob(DataUtility.getDate(dob));
		bean.setContactNo(contactNo);
		bean.setGender(gender);
		bean.setPassword(password);
		bean.setStatus(statusApproval);
		bean.setLogin(login);
		bean.setEmployeeId(employeeId);
		bean.setStatus(statusApproval);
		bean.setDesignation(designation);
		bean.setSecretAns1(secretAns1);
		bean.setSecretAns2(secretAns2);
		bean.setSecretAns3(secretAns3);
		bean.setCreatedBy(createdBy);
		bean.setModifiedBy(modifiedBy);
		bean.setCreatedDatetime(createdDateTime);
		bean.setModifiedDatetime(modifiedDateTime);
		return bean;
	}

	@Override
	public void populate(BaseDTO bDto) {
		// TODO Auto-generated method stub
		UserDTO bean=(UserDTO) bDto;
		id = bean.getId();
		firstName = bean.getFirstName();
		lastName = bean.getLastName();
		dob = DataUtility.getDateString(bean.getDob());
		employeeId = bean.getEmployeeId();
		contactNo = bean.getContactNo();
		gender = bean.getGender();
		password = bean.getPassword();
		login = bean.getLogin();
		statusApproval = bean.getStatus();
		designation = bean.getDesignation();
		secretAns1 = bean.getSecretAns1();
		secretAns2 = bean.getSecretAns2();
		secretAns3 = bean.getSecretAns3();
		createdBy=bean.getCreatedBy();
		modifiedBy=bean.getModifiedBy();
		createdDateTime=bean.getCreatedDatetime();
		modifiedDateTime=bean.getModifiedDatetime();
		
		
	}
}
