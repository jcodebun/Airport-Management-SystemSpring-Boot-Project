package com.abc.airport.mgt.form;

import javax.validation.constraints.NotEmpty;

import com.abc.airport.mgt.dto.BaseDTO;
import com.abc.airport.mgt.dto.DestinationLocDTO;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class DestinationLocForm extends BaseForm{

	@NotEmpty(message = "It cannot be empty")
	private String destinationLoc;
	@Override
	public BaseDTO getDTO() {
		// TODO Auto-generated method stub
		DestinationLocDTO bean = new DestinationLocDTO();
		bean.setId(id);
		bean.setDestinationLoc(destinationLoc);
		bean.setCreatedBy(createdBy);
		bean.setModifiedBy(modifiedBy);
		bean.setCreatedDatetime(createdDateTime);
		bean.setModifiedDatetime(modifiedDateTime);
		return bean;
	}

	@Override
	public void populate(BaseDTO bDto) {
		// TODO Auto-generated method stub
		DestinationLocDTO bean = (DestinationLocDTO)bDto;
		id= bean.getId();
		destinationLoc = bean.getDestinationLoc();
		createdBy=bean.getCreatedBy();
		modifiedBy=bean.getModifiedBy();
		createdDateTime=bean.getCreatedDatetime();
		modifiedDateTime=bean.getModifiedDatetime();
	}

}
