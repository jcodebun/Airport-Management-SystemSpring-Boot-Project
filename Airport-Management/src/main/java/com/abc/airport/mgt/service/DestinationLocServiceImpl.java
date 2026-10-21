package com.abc.airport.mgt.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.abc.airport.mgt.dao.DepartureLocDAOInt;
import com.abc.airport.mgt.dao.DestinationLocDAOInt;
import com.abc.airport.mgt.dto.DepartureLocDTO;
import com.abc.airport.mgt.dto.DestinationLocDTO;
import com.abc.airport.mgt.exception.DuplicateRecordException;

@Service
public class DestinationLocServiceImpl implements DestinationLocServiceInt {

	@Autowired
	private DestinationLocDAOInt dao;
	@Override
	@Transactional
	public long add(DestinationLocDTO dto) throws DuplicateRecordException {
		// TODO Auto-generated method stub
		long pk = dao.add(dto);
		//log.info("RoomServiceImpl Add method end");
		return pk;
	}

	@Override
	public void delete(DestinationLocDTO dto) {
		// TODO Auto-generated method stub
		dao.delete(dto);
	}

	@Override
	@Transactional
	public DestinationLocDTO findBypk(long pk) {
		// TODO Auto-generated method stub
		DestinationLocDTO dto=dao.findBypk(pk);
		return dto;
	}

	@Override
	@Transactional
	public DestinationLocDTO findByLogin(String login) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(DestinationLocDTO dto) throws DuplicateRecordException {
		// TODO Auto-generated method stub
		DestinationLocDTO existdto=dao.findByModelNumber(dto.getDestinationLoc());
		if(existdto !=null && dto.getId()!=existdto.getId())
			throw new DuplicateRecordException("Model no already Exist");
		dao.update(dto);
	}

	@Override
	@Transactional
	public List<DestinationLocDTO> list() {
		// TODO Auto-generated method stub
		List<DestinationLocDTO> list=dao.list();
		return list;
	}

	@Override
	public List<DestinationLocDTO> list(int pageNo, int pageSize) {
		// TODO Auto-generated method stub
		List<DestinationLocDTO> list=dao.list(pageNo, pageSize);
		return list;
	}

	@Override
	public List<DestinationLocDTO> search(DestinationLocDTO dto) {
		// TODO Auto-generated method stub
		List<DestinationLocDTO> list=dao.search(dto);
		return list;
	}

	@Override
	public List<DestinationLocDTO> search(DestinationLocDTO dto, int pageNo, int pageSize) {
		// TODO Auto-generated method stub
		List<DestinationLocDTO> list=dao.search(dto, pageNo, pageSize);
		return list;
	}

	@Override
	public DestinationLocDTO findByModelNumber(String modelNumber) {
		// TODO Auto-generated method stub
		return null;
	}
}
