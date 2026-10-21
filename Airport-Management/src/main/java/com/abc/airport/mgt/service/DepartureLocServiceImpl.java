package com.abc.airport.mgt.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.abc.airport.mgt.dao.DepartureLocDAOInt;
import com.abc.airport.mgt.dao.WaypointsDAOInt;
import com.abc.airport.mgt.dto.DepartureLocDTO;
import com.abc.airport.mgt.dto.WaypointsDTO;
import com.abc.airport.mgt.exception.DuplicateRecordException;

@Service
public class DepartureLocServiceImpl implements DepartureLocServiceInt {

	@Autowired
	private DepartureLocDAOInt dao;
	@Override
	@Transactional
	public long add(DepartureLocDTO dto) throws DuplicateRecordException {
		// TODO Auto-generated method stub
		long pk = dao.add(dto);
		//log.info("RoomServiceImpl Add method end");
		return pk;
	}

	@Override
	public void delete(DepartureLocDTO dto) {
		// TODO Auto-generated method stub
		dao.delete(dto);
	}

	@Override
	@Transactional
	public DepartureLocDTO findBypk(long pk) {
		// TODO Auto-generated method stub
		DepartureLocDTO dto=dao.findBypk(pk);
		return dto;
	}

	@Override
	@Transactional
	public DepartureLocDTO findByLogin(String login) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(DepartureLocDTO dto) throws DuplicateRecordException {
		// TODO Auto-generated method stub
		DepartureLocDTO existdto=dao.findByModelNumber(dto.getDepLoc());
		if(existdto !=null && dto.getId()!=existdto.getId())
			throw new DuplicateRecordException("Model no already Exist");
		dao.update(dto);
	}

	@Override
	@Transactional
	public List<DepartureLocDTO> list() {
		// TODO Auto-generated method stub
		List<DepartureLocDTO> list=dao.list();
		return list;
	}

	@Override
	public List<DepartureLocDTO> list(int pageNo, int pageSize) {
		// TODO Auto-generated method stub
		List<DepartureLocDTO> list=dao.list(pageNo, pageSize);
		return list;
	}

	@Override
	public List<DepartureLocDTO> search(DepartureLocDTO dto) {
		// TODO Auto-generated method stub
		List<DepartureLocDTO> list=dao.search(dto);
		return list;
	}

	@Override
	public List<DepartureLocDTO> search(DepartureLocDTO dto, int pageNo, int pageSize) {
		// TODO Auto-generated method stub
		List<DepartureLocDTO> list=dao.search(dto, pageNo, pageSize);
		return list;
	}

	@Override
	public DepartureLocDTO findByModelNumber(String modelNumber) {
		// TODO Auto-generated method stub
		return null;
	}
}
