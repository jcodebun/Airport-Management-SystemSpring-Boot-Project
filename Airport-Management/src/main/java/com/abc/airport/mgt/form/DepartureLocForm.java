package com.abc.airport.mgt.form;

import javax.validation.constraints.NotEmpty;

import com.abc.airport.mgt.dto.BaseDTO;
import com.abc.airport.mgt.dto.DepartureLocDTO;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class DepartureLocForm extends BaseForm{

	@NotEmpty(message = "It cannot be null")
	private String depLoc;

	@Override
	public BaseDTO getDTO() {
		// TODO Auto-generated method stub
		DepartureLocDTO bean = new DepartureLocDTO();
		bean.setId(id);
		bean.setDepLoc(depLoc);
		bean.setCreatedBy(createdBy);
		bean.setModifiedBy(modifiedBy);
		bean.setCreatedDatetime(createdDateTime);
		bean.setModifiedDatetime(modifiedDateTime);
		return bean;
	}

	@Override
	public void populate(BaseDTO bDto) {
		// TODO Auto-generated method stub
		DepartureLocDTO bean = (DepartureLocDTO)bDto;
		id = bean.getId();
		depLoc = bean.getDepLoc();
		createdBy=bean.getCreatedBy();
		modifiedBy=bean.getModifiedBy();
		createdDateTime=bean.getCreatedDatetime();
		modifiedDateTime=bean.getModifiedDatetime();
	}
}
