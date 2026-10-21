package com.abc.airport.mgt.form;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.abc.airport.mgt.dto.AllotHangerDTO;
import com.abc.airport.mgt.dto.BaseDTO;

import lombok.Getter;
import lombok.Setter;
@Setter
@Getter
public class AllotHangerForm extends BaseForm{
	@NotNull( message = "Id is required")
	private long manager_id;
	@NotNull( message = "hanger is required")
	private long hangerId;
	@NotNull(message = "Plane is required")
	private long planeId;
	//@NotNull(message = "Click status required")
	private String status;
	@Override
	public BaseDTO getDTO() {
		// TODO Auto-generated method stub
		AllotHangerDTO bean = new AllotHangerDTO();
		bean.setId(id);
		bean.setManager_id(manager_id);
		bean.setHangerId(hangerId);
		bean.setPlaneId(planeId);
		bean.setStatus(status);
		bean.setCreatedBy(createdBy);
		bean.setModifiedBy(modifiedBy);
		bean.setCreatedDatetime(createdDateTime);
		bean.setModifiedDatetime(modifiedDateTime);
		return bean;
	}
	@Override
	public void populate(BaseDTO bDto) {
		// TODO Auto-generated method stub
		AllotHangerDTO bean = (AllotHangerDTO)bDto;
		id = bean.getId();
		manager_id = bean.getManager_id();
		hangerId = bean.getHangerId();
		planeId = bean.getPlaneId();
		status = bean.getStatus();
		createdBy=bean.getCreatedBy();
		modifiedBy=bean.getModifiedBy();
		createdDateTime=bean.getCreatedDatetime();
		modifiedDateTime=bean.getModifiedDatetime();
	}

}
