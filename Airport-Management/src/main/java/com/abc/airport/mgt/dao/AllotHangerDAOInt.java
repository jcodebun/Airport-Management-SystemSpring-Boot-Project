package com.abc.airport.mgt.dao;

import java.util.List;

import com.abc.airport.mgt.dto.AllotHangerDTO;



public interface AllotHangerDAOInt {

public long add(AllotHangerDTO dto);
	
	public void delete(AllotHangerDTO dto);
	
	public AllotHangerDTO findBypk(long pk);
	
	public AllotHangerDTO findByName(String name);
	
	public void update(AllotHangerDTO dto);
	
	public List<AllotHangerDTO> list();
	
	public List<AllotHangerDTO>list(int pageNo,int pageSize);
	
	public List<AllotHangerDTO> search(AllotHangerDTO dto);
	
	public List<AllotHangerDTO> search(AllotHangerDTO dto,int pageNo,int pageSize);
	
	public AllotHangerDTO findByPlaneId(long pid);
	
	public void deleteById(long id);
	
}
