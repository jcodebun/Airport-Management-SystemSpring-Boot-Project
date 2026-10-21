package com.abc.airport.mgt.form;

import javax.validation.constraints.NotEmpty;

import com.abc.airport.mgt.dto.BaseDTO;
import com.abc.airport.mgt.dto.UserDTO;

import lombok.Getter;
import lombok.Setter;
@Setter
@Getter
public class ForgetPasswordForm extends BaseForm{
	@NotEmpty(message = "Employee Id is required")
	private String employeeId;
	@NotEmpty(message = "Login is required")
	private String login;
	@NotEmpty(message = "Secret Answer is required")
	private String secretAns1;
	@NotEmpty(message = "Secret Answer is required")
	private String secretAns2;
	@NotEmpty(message = "Secret Answer is required")
	private String secretAns3;
	

	@Override
	public BaseDTO getDTO() {
		// TODO Auto-generated method stub
		UserDTO bean = new UserDTO();
		bean.setEmployeeId(employeeId);
		bean.setLogin(login);
		bean.setSecretAns1(secretAns1);
		bean.setSecretAns2(secretAns2);
		bean.setSecretAns3(secretAns3);
		return bean;
	}

	@Override
	public void populate(BaseDTO bDto) {
		// TODO Auto-generated method stub
		UserDTO userDTO = (UserDTO)bDto;
		employeeId = userDTO.getEmployeeId();
		login = userDTO.getLogin();
		secretAns1 = userDTO.getSecretAns1();
		secretAns2 = userDTO.getSecretAns2();
		secretAns3 = userDTO.getSecretAns3();
	}

}
