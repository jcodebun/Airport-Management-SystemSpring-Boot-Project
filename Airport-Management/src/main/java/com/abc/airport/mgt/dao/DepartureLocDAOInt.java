package com.abc.airport.mgt.dao;

import java.util.List;

import com.abc.airport.mgt.dto.DepartureLocDTO;
import com.abc.airport.mgt.dto.WaypointsDTO;


public interface DepartureLocDAOInt {
	public long add(DepartureLocDTO dto);
	
	public void delete(DepartureLocDTO dto);
	
	public DepartureLocDTO findBypk(long pk);
	
	public DepartureLocDTO findByModelNumber(String modelNumber);

	public void update(DepartureLocDTO dto);
	
	public List<DepartureLocDTO> list();
	
	public List<DepartureLocDTO>list(int pageNo,int pageSize);
	
	public List<DepartureLocDTO> search(DepartureLocDTO dto);
	
	public List<DepartureLocDTO> search(DepartureLocDTO dto,int pageNo,int pageSize);

}
