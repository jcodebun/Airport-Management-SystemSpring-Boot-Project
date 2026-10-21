package com.abc.airport.mgt.dao;

import java.util.List;

import com.abc.airport.mgt.dto.UserDTO;



public interface UserDAOInt {

	public long add(UserDTO dto);
	
	public void delete(UserDTO dto);
	
	public UserDTO findBypk(long pk);
	
	public UserDTO findByLogin(String login);
	
	public void update(UserDTO dto);
	
	public List<UserDTO> list();
	
	public List<UserDTO>list(int pageNo,int pageSize);
	
	public List<UserDTO> search(UserDTO dto);
	
	public List<UserDTO> search(UserDTO dto,int pageNo,int pageSize);
	
	public UserDTO authentication(UserDTO dto);

	String findByMaxEmployeeId();

	public UserDTO findAll(String employeeId, String login, String secretAns1, String secretANs2, String secretAns3);

	UserDTO findByEmployeeId(String pk);

	//UserDTO findByEmployeeId(String pk);
}
