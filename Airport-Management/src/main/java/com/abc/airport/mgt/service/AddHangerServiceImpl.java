package com.abc.airport.mgt.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.abc.airport.mgt.dao.AddHangerDAOImp;
import com.abc.airport.mgt.dao.AddHangerDAOInt;
import com.abc.airport.mgt.dto.AddHangerDTO;
import com.abc.airport.mgt.dto.PlaneDTO;
import com.abc.airport.mgt.exception.DuplicateRecordException;
@Service
public class AddHangerServiceImpl implements AddHangerServiceInt {
	@Autowired
	private AddHangerDAOInt addHangerDaoInt;

	@Override
	@Transactional
	public long add(AddHangerDTO dto) throws DuplicateRecordException {
		AddHangerDTO existDTO = addHangerDaoInt.findByModelNumber(dto.getHangerModel());
		if (existDTO != null)
			throw new DuplicateRecordException("Plane Is Already Exist");
		long pk = addHangerDaoInt.add(dto);
		//log.info("RoomServiceImpl Add method end");
		return pk;
	}

	@Override
	public void delete(AddHangerDTO dto) {
		// TODO Auto-generated method stub
		addHangerDaoInt.delete(dto);
	}

	@Override
	public AddHangerDTO findBypk(long pk) {
		// TODO Find by Pk
		AddHangerDTO dto=addHangerDaoInt.findBypk(pk);
		return dto;
	}

	@Override
	public AddHangerDTO findByLogin(String login) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@Transactional
	public void update(AddHangerDTO dto) throws DuplicateRecordException {
		// TODO Auto-generated method stub
		AddHangerDTO existdto=addHangerDaoInt.findByModelNumber(dto.getHangerModel());
		if(existdto !=null && dto.getId()!=existdto.getId())
			throw new DuplicateRecordException("Model no already Exist");
		addHangerDaoInt.update(dto);
	}

	@Override
	@Transactional
	public List<AddHangerDTO> list() {
		// TODO Show list
		List<AddHangerDTO> list=addHangerDaoInt.list();
		return list;
	}

	@Override
	@Transactional
	public List<AddHangerDTO> list(int pageNo, int pageSize) {
		// TODO Get list by pageNo and pageSize
		List<AddHangerDTO> list=addHangerDaoInt.list(pageNo, pageSize);
		return list;
	}

	@Override
	public List<AddHangerDTO> search(AddHangerDTO dto) {
		// TODO search 
		List<AddHangerDTO> list=addHangerDaoInt.search(dto);
		return list;
	}

	@Override
	public List<AddHangerDTO> search(AddHangerDTO dto, int pageNo, int pageSize) {
		// TODO Auto-generated method stub
		List<AddHangerDTO> list=addHangerDaoInt.search(dto, pageNo, pageSize);
		return list;
	}

	@Override
	public AddHangerDTO findByModelNumber(String modelNumber) {
		//log.info("UserServiceImpl findByUserName method start");
				AddHangerDTO dto=addHangerDaoInt.findByModelNumber(modelNumber);
				//log.info("UserServiceImpl findByUserName method end");
				return dto;
	}

}
