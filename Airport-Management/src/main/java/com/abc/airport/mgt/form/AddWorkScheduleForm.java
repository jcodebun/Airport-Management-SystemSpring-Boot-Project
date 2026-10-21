package com.abc.airport.mgt.form;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

import com.abc.airport.mgt.dto.AddWorkScheduleDTO;
import com.abc.airport.mgt.dto.BaseDTO;
import com.abc.airport.mgt.dto.UserDTO;

import lombok.Getter;
import lombok.Setter;
@Setter
@Getter
public class AddWorkScheduleForm extends BaseForm {

	@Min(value = 1, message = "Destination Location field is required")
	private long destinationLocationId;
	/*
	 * @NotEmpty(message = "Please select Pilot") private UserDTO pilot;
	 */
	@NotNull(message = "Please select date")
	//@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "mm/dd/yyyy")
	private Date date;
	//@NotEmpty(message = "Select Plane")
	@Min(value = 1,message = "Please select")
	private long pilotId;
	@NotEmpty(message = "Desription is required")
	private String description;
	@NotEmpty(message = "Timeslot is required")
	public String timeSlot;
	@Override
	public BaseDTO getDTO() {
		// TODO Auto-generated method stub
		AddWorkScheduleDTO bean = new AddWorkScheduleDTO();
		bean.setId(id);
		bean.setDestinationLocationId(destinationLocationId);
		bean.setPilotId(pilotId);
		bean.setDate(date);
		bean.setDescription(description);
		bean.setTimeSlot(timeSlot);
		bean.setCreatedBy(createdBy);
		bean.setModifiedBy(modifiedBy);
		bean.setCreatedDatetime(createdDateTime);
		bean.setModifiedDatetime(modifiedDateTime);
		return bean;
	}

	@Override
	public void populate(BaseDTO bDto) {
		// TODO Auto-generated method stub
		AddWorkScheduleDTO bean = (AddWorkScheduleDTO)bDto;
		id = bean.getId();
		destinationLocationId = bean.getDestinationLocationId();
		pilotId = bean.getPilotId();
		date = bean.getDate();
		description = bean.getDescription();
		timeSlot = bean.getTimeSlot();
		createdBy=bean.getCreatedBy();
		modifiedBy=bean.getModifiedBy();
		createdDateTime=bean.getCreatedDatetime();
		modifiedDateTime=bean.getModifiedDatetime();
		
	}

}
