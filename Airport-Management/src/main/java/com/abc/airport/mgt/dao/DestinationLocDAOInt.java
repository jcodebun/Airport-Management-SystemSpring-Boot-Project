package com.abc.airport.mgt.dao;

import java.util.List;

import com.abc.airport.mgt.dto.DepartureLocDTO;
import com.abc.airport.mgt.dto.DestinationLocDTO;

public interface DestinationLocDAOInt {

public long add(DestinationLocDTO dto);
	
	public void delete(DestinationLocDTO dto);
	
	public DestinationLocDTO findBypk(long pk);
	
	public DestinationLocDTO findByModelNumber(String modelNumber);

	public void update(DestinationLocDTO dto);
	
	public List<DestinationLocDTO> list();
	
	public List<DestinationLocDTO>list(int pageNo,int pageSize);
	
	public List<DestinationLocDTO> search(DestinationLocDTO dto);
	
	public List<DestinationLocDTO> search(DestinationLocDTO dto,int pageNo,int pageSize);
}
