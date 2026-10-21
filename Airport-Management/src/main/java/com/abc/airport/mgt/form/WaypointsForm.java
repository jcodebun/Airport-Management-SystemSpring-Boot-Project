package com.abc.airport.mgt.form;

import javax.validation.constraints.NotEmpty;

import com.abc.airport.mgt.dto.BaseDTO;
import com.abc.airport.mgt.dto.WaypointsDTO;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class WaypointsForm extends BaseForm{

	@NotEmpty(message = "It should not be null")
	private String wapointsName;
	@Override
	public BaseDTO getDTO() {
		// TODO Auto-generated method stub
		WaypointsDTO bean = new WaypointsDTO();
		bean.setId(id);
		bean.setWapointsName(wapointsName);
		return bean;
	}

	@Override
	public void populate(BaseDTO bDto) {
		// TODO Auto-generated method stub
		WaypointsDTO bean = (WaypointsDTO)bDto;
		id = bean.getId();
		wapointsName = bean.getWapointsName();
	}

}
