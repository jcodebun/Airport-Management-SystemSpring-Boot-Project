package com.abc.airport.mgt.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.abc.airport.mgt.dto.AllotHangerDTO;
import com.abc.airport.mgt.exception.DuplicateRecordException;

public interface AllotHangerServiceInt {

	public long add(AllotHangerDTO dto) throws DuplicateRecordException;
	
	public void delete(AllotHangerDTO dto);
	
	public AllotHangerDTO findBypk(long pk);
	
	public AllotHangerDTO findByName(String name);
	
	public void update(AllotHangerDTO dto);
	
	public List<AllotHangerDTO> list();
	
	public List<AllotHangerDTO>list(int pageNo,int pageSize);
	
	public List<AllotHangerDTO> search(AllotHangerDTO dto);
	
	public List<AllotHangerDTO> search(AllotHangerDTO dto,int pageNo,int pageSize);
	
	public void deleteById(long id);
}
