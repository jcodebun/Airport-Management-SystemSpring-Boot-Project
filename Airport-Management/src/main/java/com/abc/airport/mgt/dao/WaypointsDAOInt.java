package com.abc.airport.mgt.dao;

import java.util.List;

import com.abc.airport.mgt.dto.AddHangerDTO;
import com.abc.airport.mgt.dto.WaypointsDTO;

public interface WaypointsDAOInt {

public long add(WaypointsDTO dto);
	
	public void delete(WaypointsDTO dto);
	
	public WaypointsDTO findBypk(long pk);
	
	public WaypointsDTO findByModelNumber(String modelNumber);

	public void update(WaypointsDTO dto);
	
	public List<WaypointsDTO> list();
	
	public List<WaypointsDTO>list(int pageNo,int pageSize);
	
	public List<WaypointsDTO> search(WaypointsDTO dto);
	
	public List<WaypointsDTO> search(WaypointsDTO dto,int pageNo,int pageSize);
}
