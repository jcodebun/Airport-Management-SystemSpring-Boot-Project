package com.abc.airport.mgt.service;

import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.UUID;
import java.util.logging.Logger;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Property;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.abc.airport.mgt.dao.UserDAOInt;
import com.abc.airport.mgt.dto.UserDTO;
import com.abc.airport.mgt.exception.DuplicateRecordException;
import com.abc.airport.mgt.util.DataUtility;

@Service
public class UserServiceImpl implements UserServiceInt {

	private static Logger log=Logger.getLogger(UserServiceImpl.class.getName());
	@Autowired
	private UserDAOInt dao;
	@Override
	@Transactional
	public long add(UserDTO dto) throws DuplicateRecordException {
		// TODO Auto-generated method stub
		UUID uuid =null;
		log.info("UserServiceImpl Add method start");
		UserDTO existdto=dao.findByLogin(dto.getLogin());
		if(existdto !=null)
			throw new DuplicateRecordException("Login id Already Exist");
		long pk=dao.add(dto);
		log.info("UserServiceImpl Add method end");
		return pk;
	}

	@Override
	@Transactional
	public void delete(UserDTO dto) {
		// TODO Auto-generated method stub
		log.info("UserServiceImpl Delete method start");
		dao.delete(dto);
		log.info("UserServiceImpl Delete method end");
	}

	@Override
	@Transactional
	public UserDTO findBypk(long pk) {
		// TODO Auto-generated method stub
		log.info("UserServiceImpl findBypk method start");
		UserDTO dto=dao.findBypk(pk);
		log.info("UserServiceImpl findBypk method end");
		return dto;
	}
	
	@Override
	@Transactional
	public UserDTO findByEmployeeId(String pk) {
		// TODO Auto-generated method stub
		log.info("UserServiceImpl findBypk method start");
		UserDTO dto=dao.findByEmployeeId(pk);
		log.info("UserServiceImpl findBypk method end");
		return dto;
	}

	@Override
	@Transactional
	public UserDTO findByLogin(String login) {
		// TODO Auto-generated method stub
		log.info("UserServiceImpl findByUserName method start");
		UserDTO dto=dao.findByLogin(login);
		log.info("UserServiceImpl findByUserName method end");
		return dto;
	}

	@Override
	@Transactional
	public void update(UserDTO dto) throws DuplicateRecordException {
		// TODO Auto-generated method stub
		log.info("UserServiceImpl update method start");
		System.out.println("dto get login"+dto.getLogin());
		UserDTO existdto=dao.findByLogin(dto.getLogin());
		if(existdto !=null && dto.getId()!=existdto.getId())
			throw new DuplicateRecordException("Login id already Exist");
		dao.update(dto);
		log.info("UserServiceImpl update method end");
	}

	@Override
	@Transactional
	public List<UserDTO> list() {
		// TODO Auto-generated method stub
		log.info("UserServiceImpl list method start");
		List<UserDTO> list=dao.list();
		log.info("UserServiceImpl list method end");
		return list;
	}

	@Override
	@Transactional
	public List<UserDTO> list(int pageNo, int pageSize) {
		// TODO Auto-generated method stub
		log.info("UserServiceImpl list method start");
		List<UserDTO> list=dao.list(pageNo, pageSize);
		log.info("UserServiceImpl list method end");
		return list;
	}

	@Override
	@Transactional
	public List<UserDTO> search(UserDTO dto) {
		// TODO Auto-generated method stub
		log.info("UserServiceImpl search method start");
		List<UserDTO> list=dao.search(dto);
		log.info("UserServiceImpl search method end");
		return list;
	}

	@Override
	@Transactional
	public List<UserDTO> search(UserDTO dto, int pageNo, int pageSize) {
		// TODO Auto-generated method stub
		log.info("UserServiceImpl search method start");
		List<UserDTO> list=dao.search(dto, pageNo, pageSize);
		log.info("UserServiceImpl search method end");
		return list;
	}

	@Override
	@Transactional
	public UserDTO authentication(UserDTO dto) {
		// TODO Auto-generated method stub
		log.info("UserServiceImpl authentication method start");
		dto=dao.authentication(dto);
		log.info("UserServiceImpl authentication method end");
		return dto;
	}

	
	 @Override
	  
	  @Transactional
	  public boolean changePassword(Long id, String oldPassword, String newPassword) { // TODO Auto-generated method stub
	  log.info("UserServiceImpl  changePassword method start"); UserDTO dtoExist =
	  findBypk(id); if (dtoExist != null &&
	  dtoExist.getPassword().equals(oldPassword)) {
	  dtoExist.setPassword(newPassword); dao.update(dtoExist);
	  log.info("UserServiceImpl  changePassword method end"); return true; } else {
	  return false; } }
	 
	/*
	 * @Override
	 * 
	 * @Transactional public boolean changePassword(String eid, String oldPassword,
	 * String newPassword) { // TODO Auto-generated method stub
	 * System.out.println("eid is **********"+eid);
	 * log.info("UserServiceImpl  changePassword method start"); long id =
	 * Integer.parseInt(eid); System.out.println("||||||||||id||||||||||||"+id);
	 * UserDTO dtoExist = findBypk(id); if (dtoExist != null &&
	 * dtoExist.getPassword().equals(oldPassword)) {
	 * dtoExist.setPassword(newPassword); dao.update(dtoExist);
	 * log.info("UserServiceImpl  changePassword method end"); return true; } else {
	 * return false; }
	 
	}*/

	@Override
	public boolean forgetPassword(String login) {
		// TODO Auto-generated method stub
		UserDTO dtoExist = dao.findByLogin(login);
		if(dtoExist!=null) {
			return true;
		}
		return false;
	}

	@Override
	public UserDTO findByAll(String employeeId, String login, String secretAns1, String secretANs2, String secretAns3) {
		// TODO Auto-generated method stub
		UserDTO dto=dao.findAll(employeeId,login,secretAns1,secretANs2,secretAns3);
		return dto;
	}

	
}
