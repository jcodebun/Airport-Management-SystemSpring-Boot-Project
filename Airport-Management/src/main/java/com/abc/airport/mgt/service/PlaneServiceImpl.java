package com.abc.airport.mgt.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.abc.airport.mgt.dao.PlaneDAOInt;
import com.abc.airport.mgt.dto.PlaneDTO;
import com.abc.airport.mgt.dto.UserDTO;
import com.abc.airport.mgt.exception.DuplicateRecordException;



@Service
public class PlaneServiceImpl implements PlaneServiceInt {

	@Autowired
	private PlaneDAOInt planeDAO;
	@Override
	@Transactional
	public long add(PlaneDTO dto) throws DuplicateRecordException {
		//log.info("RoomServiceImpl Add method start");
		PlaneDTO existDTO = planeDAO.findByModelNumber(dto.getModelNumber());
		if (existDTO != null)
			throw new DuplicateRecordException("Plane Is Already Exist");
		long pk = planeDAO.add(dto);
		//log.info("RoomServiceImpl Add method end");
		return pk;
	}

	@Override
	public void delete(PlaneDTO dto) {
		// TODO Auto-generated method stub
		planeDAO.delete(dto);
	}

	@Override
	public PlaneDTO findBypk(long pk) {
		// TODO Auto-generated method stub
		//log.info("UserServiceImpl findBypk method start");
		PlaneDTO dto=planeDAO.findBypk(pk);
		//log.info("UserServiceImpl findBypk method end");
		return dto;
	}

	@Override
	public PlaneDTO findByModelNumber(String modelNumber) {
		//log.info("UserServiceImpl findByUserName method start");
		PlaneDTO dto=planeDAO.findByModelNumber(modelNumber);
		//log.info("UserServiceImpl findByUserName method end");
		return dto;
	}

	@Override
	@Transactional
	public void update(PlaneDTO dto) throws DuplicateRecordException {
		// TODO Auto-generated method stub
		//log.info("UserServiceImpl update method start");
		PlaneDTO existdto=planeDAO.findByModelNumber(dto.getModelNumber());
		if(existdto !=null && dto.getId()!=existdto.getId())
			throw new DuplicateRecordException("Model no already Exist");
		planeDAO.update(dto);
		//log.info("UserServiceImpl update method end");
	}

	@Override
	@Transactional
	public List<PlaneDTO> list() {
		//log.info("UserServiceImpl list method start");
		List<PlaneDTO> list=planeDAO.list();
		//log.info("UserServiceImpl list method end");
		return list;
	}

	@Override
	@Transactional
	public List<PlaneDTO> list(int pageNo, int pageSize) {
		//log.info("UserServiceImpl list method start");
		List<PlaneDTO> list=planeDAO.list(pageNo, pageSize);
		//log.info("UserServiceImpl list method end");
		return list;
	}

	@Override
	@Transactional
	public List<PlaneDTO> search(PlaneDTO dto) {
		//log.info("UserServiceImpl search method start");
		List<PlaneDTO> list=planeDAO.search(dto);
		//log.info("UserServiceImpl search method end");
		return list;
	}

	@Override
	public List<PlaneDTO> search(PlaneDTO dto, int pageNo, int pageSize) {
		//log.info("UserServiceImpl search method start");
		List<PlaneDTO> list=planeDAO.search(dto, pageNo, pageSize);
		//log.info("UserServiceImpl search method end");
		return list;
	}

	@Override
	public PlaneDTO findByLogin(String login) {
		// TODO Auto-generated method stub
		return null;
	}

}
