package com.abc.airport.mgt.form;

import javax.persistence.Column;
import javax.validation.constraints.NotEmpty;

import com.abc.airport.mgt.dto.AddHangerDTO;
import com.abc.airport.mgt.dto.BaseDTO;

import lombok.Getter;
import lombok.Setter;
@Setter
@Getter
public class AddHangerForm extends BaseForm{
	
	@NotEmpty(message = "Hanger Name is required")
	private String hangerName;
	@NotEmpty(message = "Hanger Model is required")
	private String hangerModel;
	@NotEmpty(message = "Hanger Address is required")
	private String hangerAddress;

	@Override
	public BaseDTO getDTO() {
		// TODO Auto-generated method stub
		AddHangerDTO bean = new AddHangerDTO();
		bean.setId(id);
		bean.setHangerModel(hangerModel);
		bean.setHangerName(hangerName);
		bean.setHangerAddress(hangerAddress);
		
		return bean;
	}

	@Override
	public void populate(BaseDTO bDto) {
		// TODO Auto-generated method stub
		AddHangerDTO bean = (AddHangerDTO)bDto;
		id = bean.getId();
		hangerName = bean.getHangerName();
		hangerModel = bean.getHangerModel();
		hangerAddress = bean.getHangerAddress();
		
	}

}
