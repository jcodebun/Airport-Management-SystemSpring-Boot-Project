package com.abc.airport.mgt.form;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

import com.abc.airport.mgt.dto.BaseDTO;
import com.abc.airport.mgt.dto.PreFlightModeDTO;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class PreFlightModeForm extends BaseForm {
	@NotEmpty(message = "It is required field")
	private String laptopPower;
	@NotEmpty(message = "It is required field")
	private String laptopBattery;
	@NotEmpty(message = "It is required field")
	private String missionPlanner;
	@NotEmpty(message = "It is required field")
	private String Motor;
	@Min(value = 1, message = "Plane field is required")
	private long planeId;

	@Override
	public BaseDTO getDTO() {
		// TODO Auto-generated method stub
		PreFlightModeDTO bean = new PreFlightModeDTO();
		bean.setId(id);
		bean.setLaptopBattery(laptopBattery);
		bean.setLaptopPower(laptopPower);
		bean.setMissionPlanner(missionPlanner);
		bean.setMotor(Motor);
		bean.setPlaneId(planeId);
		bean.setCreatedBy(createdBy);
		bean.setModifiedBy(modifiedBy);
		bean.setCreatedDatetime(createdDateTime);
		bean.setModifiedDatetime(modifiedDateTime);
		return bean;
	}

	@Override
	public void populate(BaseDTO bDto) {
		// TODO Auto-generated method stub
		PreFlightModeDTO bean = (PreFlightModeDTO)bDto;
		id = bean.getId();
		laptopBattery = bean.getLaptopBattery();
		laptopPower = bean.getLaptopBattery();
		missionPlanner = bean.getMissionPlanner();
		Motor = bean.getMotor();
		planeId = bean.getPlaneId();
		createdBy=bean.getCreatedBy();
		modifiedBy=bean.getModifiedBy();
		createdDateTime=bean.getCreatedDatetime();
		modifiedDateTime=bean.getModifiedDatetime();
	}

}
