package com.abc.airport.mgt.service;

import java.util.List;

import com.abc.airport.mgt.dto.AddWorkScheduleDTO;
import com.abc.airport.mgt.exception.DuplicateRecordException;

public interface AddWorkScheduleServiceInt {

public long add(AddWorkScheduleDTO dto) throws DuplicateRecordException;
	
	public void delete(AddWorkScheduleDTO dto);
	
	public AddWorkScheduleDTO findBypk(long pk);
	
	public AddWorkScheduleDTO findByName(String name);
	
	public void update(AddWorkScheduleDTO dto);
	
	public List<AddWorkScheduleDTO> list();
	
	public List<AddWorkScheduleDTO>list(int pageNo,int pageSize);
	
	public List<AddWorkScheduleDTO> search(AddWorkScheduleDTO dto);
	
	public List<AddWorkScheduleDTO> search(AddWorkScheduleDTO dto,int pageNo,int pageSize);
	
	public void deleteById(long id);
}
