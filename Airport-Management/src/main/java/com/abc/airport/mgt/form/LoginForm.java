package com.abc.airport.mgt.form;

import javax.validation.constraints.NotEmpty;

import com.abc.airport.mgt.dto.BaseDTO;
import com.abc.airport.mgt.dto.UserDTO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoginForm  extends BaseForm{
	
	@NotEmpty(message = "Employee Id is required")
	private String employeeId;
	@NotEmpty(message = "Password is required")
	private String password;

	@Override
	public BaseDTO getDTO() {
		// TODO Auto-generated method stub
		UserDTO bean=new UserDTO();
		bean.setEmployeeId(employeeId);
		bean.setPassword(password);
		return bean;
	}

	@Override
	public void populate(BaseDTO bDto) {
		// TODO Auto-generated method stub
		UserDTO entity=(UserDTO) bDto;
		employeeId=entity.getEmployeeId();
		password=entity.getPassword();
	}

	
}
