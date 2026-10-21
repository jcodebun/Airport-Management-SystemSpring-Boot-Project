package com.abc.airport.mgt.form;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

import com.abc.airport.mgt.dto.BaseDTO;
import com.abc.airport.mgt.dto.PostFlightModeDTO;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class PostFlightModeForm extends BaseForm{

	@Min(value = 1, message = "Plane field is required")
	private long planeId;
	@Min(value = 1, message = "Hanger field is required")
	private long hangerId;
	@NotEmpty(message = "Master Swicth Filed is required")
	private String masterSwitch;
	@Override
	public BaseDTO getDTO() {
		// TODO Auto-generated method stub
		PostFlightModeDTO bean = new PostFlightModeDTO();
		bean.setId(id);
		bean.setPlaneId(planeId);
		bean.setHangerId(hangerId);
		bean.setMasterSwitch(masterSwitch);
		bean.setCreatedBy(createdBy);
		bean.setModifiedBy(modifiedBy);
		bean.setCreatedDatetime(createdDateTime);
		bean.setModifiedDatetime(modifiedDateTime);
		return bean;
	}

	@Override
	public void populate(BaseDTO bDto) {
		// TODO Auto-generated method stub
		PostFlightModeDTO bean = (PostFlightModeDTO)bDto;
		id = bean.getId();
		planeId = bean.getPlaneId();
		hangerId = bean.getHangerId();
		masterSwitch = bean.getMasterSwitch();
		createdBy=bean.getCreatedBy();
		modifiedBy=bean.getModifiedBy();
		createdDateTime=bean.getCreatedDatetime();
		modifiedDateTime=bean.getModifiedDatetime();
	}

}
