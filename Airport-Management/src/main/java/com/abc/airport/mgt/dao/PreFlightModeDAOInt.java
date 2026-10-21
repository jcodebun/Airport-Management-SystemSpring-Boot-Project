package com.abc.airport.mgt.dao;

import java.util.List;

import com.abc.airport.mgt.dto.AddWorkScheduleDTO;
import com.abc.airport.mgt.dto.PreFlightModeDTO;

public interface PreFlightModeDAOInt {

	public long add(PreFlightModeDTO dto);

	public void delete(PreFlightModeDTO dto);
	
	public PreFlightModeDTO findBypk(long pk);
	
	public PreFlightModeDTO findByName(String name);
	
	public void update(PreFlightModeDTO dto);
	
	public List<PreFlightModeDTO> list();
	
	public List<PreFlightModeDTO>list(int pageNo,int pageSize);
	
	public List<PreFlightModeDTO> search(PreFlightModeDTO dto);
	
	public List<PreFlightModeDTO> search(PreFlightModeDTO dto,int pageNo,int pageSize);
	
	public PreFlightModeDTO findByPlaneId(long pid);
	
	public void deleteById(long id);
}
