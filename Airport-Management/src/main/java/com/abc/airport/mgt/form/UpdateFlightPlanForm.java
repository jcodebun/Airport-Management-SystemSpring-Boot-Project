package com.abc.airport.mgt.form;

import java.sql.Time;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

import com.abc.airport.mgt.dto.BaseDTO;
import com.abc.airport.mgt.dto.UpdateFlightPlanDTO;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class UpdateFlightPlanForm extends BaseForm {

	//@NotEmpty(message = "Location is required")
	private long departureLocationId;
	//@NotEmpty(message = "waypoints is required")
	private long waypointsId;
	//@NotNull(message = "arrivalTime is required")
	//@DateTimeFormat(pattern = "dd/MM/yyyy")
	@DateTimeFormat(pattern = "HH:mm")
	//@Temporal(TemporalType.DATE)
	private Date arrivalTime;
	//@NotEmpty(message = "destinationLocation is required")
	private long destinationLocationId;
	@NotEmpty(message = "alternateAirports is required")
	private String  alternateAirports;
	/*
	 * @NotEmpty(message = "aircraftInfo is required") private String aircraftInfo;
	 */
	//@NotEmpty(message = "Location is required")
	private long userId;
	@NotNull(message = "Plane is required")
	private long planeId;
	@Override
	public BaseDTO getDTO() {
		// TODO Auto-generated method stub
		UpdateFlightPlanDTO bean = new UpdateFlightPlanDTO();
		bean.setId(id);
		bean.setDepartureLocId(departureLocationId);
		bean.setWaypointsId(waypointsId);
		bean.setArrivalTime(arrivalTime);
		bean.setDestinationLocId(destinationLocationId);
		bean.setAlternateAirports(alternateAirports);
		bean.setPlaneId(planeId);
		bean.setUserId(userId);
		bean.setCreatedBy(createdBy);
		bean.setModifiedBy(modifiedBy);
		bean.setCreatedDatetime(createdDateTime);
		bean.setModifiedDatetime(modifiedDateTime);
		return bean;
	}
	@Override
	public void populate(BaseDTO bDto) {
		// TODO Auto-generated method stub
		UpdateFlightPlanDTO bean = (UpdateFlightPlanDTO)bDto;
		id = bean.getId();
		departureLocationId = bean.getDepartureLocId();
		waypointsId = bean.getWaypointsId();
		arrivalTime = bean.getArrivalTime();
		destinationLocationId = bean.getDestinationLocId();
		alternateAirports = bean.getAlternateAirports();
		planeId = bean.getPlaneId();
		userId = bean.getUserId();
		createdBy=bean.getCreatedBy();
		modifiedBy=bean.getModifiedBy();
		createdDateTime=bean.getCreatedDatetime();
		modifiedDateTime=bean.getModifiedDatetime();
	}
}
