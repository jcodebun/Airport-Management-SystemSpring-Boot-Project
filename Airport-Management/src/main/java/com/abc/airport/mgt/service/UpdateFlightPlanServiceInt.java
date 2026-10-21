package com.abc.airport.mgt.service;

import java.util.List;

import com.abc.airport.mgt.dto.UpdateFlightPlanDTO;
import com.abc.airport.mgt.exception.DuplicateRecordException;

public interface UpdateFlightPlanServiceInt {

public long add(UpdateFlightPlanDTO dto) throws DuplicateRecordException;
	
	public void delete(UpdateFlightPlanDTO dto);
	
	public UpdateFlightPlanDTO findBypk(long pk);
	
	public UpdateFlightPlanDTO findByName(String name);
	
	public void update(UpdateFlightPlanDTO dto);
	
	public List<UpdateFlightPlanDTO> list();
	
	public List<UpdateFlightPlanDTO>list(int pageNo,int pageSize);
	
	public List<UpdateFlightPlanDTO> search(UpdateFlightPlanDTO dto);
	
	public List<UpdateFlightPlanDTO> search(UpdateFlightPlanDTO dto,int pageNo,int pageSize);
	
	public void deleteById(long id);
}
