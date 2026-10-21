package com.abc.airport.mgt.dao;

import java.util.List;


import com.abc.airport.mgt.dto.UpdateFlightPlanDTO;

public interface UpdateFlightPlanDAOInt {

public long add(UpdateFlightPlanDTO dto);
	
	public void delete(UpdateFlightPlanDTO dto);
	
	public UpdateFlightPlanDTO findBypk(long pk);
	
	public UpdateFlightPlanDTO findByModelNumber(String modelNumber);

	public void update(UpdateFlightPlanDTO dto);
	
	public List<UpdateFlightPlanDTO> list();
	
	public List<UpdateFlightPlanDTO>list(int pageNo,int pageSize);
	
	public List<UpdateFlightPlanDTO> search(UpdateFlightPlanDTO dto);
	
	public List<UpdateFlightPlanDTO> search(UpdateFlightPlanDTO dto,int pageNo,int pageSize);

	UpdateFlightPlanDTO findByPlaneId(long pid);
}
