package com.abc.airport.mgt.dao;

import java.util.List;

import com.abc.airport.mgt.dto.PlaneDTO;
import com.abc.airport.mgt.dto.UserDTO;

public interface PlaneDAOInt {

	public long add(PlaneDTO dto);
	
	public void delete(PlaneDTO dto);
	
	public PlaneDTO findBypk(long pk);
	
	public PlaneDTO findByModelNumber(String modelNumber);

	public void update(PlaneDTO dto);
	
	public List<PlaneDTO> list();
	
	public List<PlaneDTO>list(int pageNo,int pageSize);
	
	public List<PlaneDTO> search(PlaneDTO dto);
	
	public List<PlaneDTO> search(PlaneDTO dto,int pageNo,int pageSize);
}
