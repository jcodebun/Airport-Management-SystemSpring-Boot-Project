package com.abc.airport.mgt.dao;

import java.util.List;

import com.abc.airport.mgt.dto.AddWorkScheduleDTO;
import com.abc.airport.mgt.dto.AllotHangerDTO;


public interface AddWorkScheduleDAOInt {
	
	public long add(AddWorkScheduleDTO dto);

	public void delete(AddWorkScheduleDTO dto);
	
	public AddWorkScheduleDTO findBypk(long pk);
	
	public AddWorkScheduleDTO findByName(String name);
	
	public void update(AddWorkScheduleDTO dto);
	
	public List<AddWorkScheduleDTO> list();
	
	public List<AddWorkScheduleDTO>list(int pageNo,int pageSize);
	
	public List<AddWorkScheduleDTO> search(AddWorkScheduleDTO dto);
	
	public List<AddWorkScheduleDTO> search(AddWorkScheduleDTO dto,int pageNo,int pageSize);
	
	public AddWorkScheduleDTO findByPlaneId(long pid);
	
	public void deleteById(long id);
}
