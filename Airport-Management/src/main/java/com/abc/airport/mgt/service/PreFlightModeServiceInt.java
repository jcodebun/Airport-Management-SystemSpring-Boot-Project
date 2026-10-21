package com.abc.airport.mgt.service;

import java.util.List;

import com.abc.airport.mgt.dto.PreFlightModeDTO;
import com.abc.airport.mgt.exception.DuplicateRecordException;

public interface PreFlightModeServiceInt {
public long add(PreFlightModeDTO dto) throws DuplicateRecordException;
	
	public void delete(PreFlightModeDTO dto);
	
	public PreFlightModeDTO findBypk(long pk);
	
	public PreFlightModeDTO findByName(String name);
	
	public void update(PreFlightModeDTO dto);
	
	public List<PreFlightModeDTO> list();
	
	public List<PreFlightModeDTO>list(int pageNo,int pageSize);
	
	public List<PreFlightModeDTO> search(PreFlightModeDTO dto);
	
	public List<PreFlightModeDTO> search(PreFlightModeDTO dto,int pageNo,int pageSize);
	
	public void deleteById(long id);
}
