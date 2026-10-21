package com.abc.airport.mgt.dao;

import java.util.List;

import com.abc.airport.mgt.dto.AddHangerDTO;


public interface AddHangerDAOInt {

	public long add(AddHangerDTO dto);
	
	public void delete(AddHangerDTO dto);
	
	public AddHangerDTO findBypk(long pk);
	
	public AddHangerDTO findByModelNumber(String modelNumber);

	public void update(AddHangerDTO dto);
	
	public List<AddHangerDTO> list();
	
	public List<AddHangerDTO>list(int pageNo,int pageSize);
	
	public List<AddHangerDTO> search(AddHangerDTO dto);
	
	public List<AddHangerDTO> search(AddHangerDTO dto,int pageNo,int pageSize);
}
