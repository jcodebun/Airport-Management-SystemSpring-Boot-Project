package com.abc.airport.mgt.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.abc.airport.mgt.dao.AddHangerDAOInt;
import com.abc.airport.mgt.dao.WaypointsDAOInt;
import com.abc.airport.mgt.dto.AddHangerDTO;
import com.abc.airport.mgt.dto.WaypointsDTO;
import com.abc.airport.mgt.exception.DuplicateRecordException;

@Service
public class WaypointsServiceImpl implements WaypointsServiceInt{

	@Autowired
	private WaypointsDAOInt dao;
	@Override
	@Transactional
	public long add(WaypointsDTO dto) throws DuplicateRecordException {
		// TODO Auto-generated method stub
		long pk = dao.add(dto);
		//log.info("RoomServiceImpl Add method end");
		return pk;
	}

	@Override
	public void delete(WaypointsDTO dto) {
		// TODO Auto-generated method stub
		dao.delete(dto);
	}

	@Override
	@Transactional
	public WaypointsDTO findBypk(long pk) {
		// TODO Auto-generated method stub
		WaypointsDTO dto=dao.findBypk(pk);
		return dto;
	}

	@Override
	@Transactional
	public WaypointsDTO findByLogin(String login) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(WaypointsDTO dto) throws DuplicateRecordException {
		// TODO Auto-generated method stub
		WaypointsDTO existdto=dao.findByModelNumber(dto.getWapointsName());
		if(existdto !=null && dto.getId()!=existdto.getId())
			throw new DuplicateRecordException("Model no already Exist");
		dao.update(dto);
	}

	@Override
	@Transactional
	public List<WaypointsDTO> list() {
		// TODO Auto-generated method stub
		List<WaypointsDTO> list=dao.list();
		return list;
	}

	@Override
	public List<WaypointsDTO> list(int pageNo, int pageSize) {
		// TODO Auto-generated method stub
		List<WaypointsDTO> list=dao.list(pageNo, pageSize);
		return list;
	}

	@Override
	public List<WaypointsDTO> search(WaypointsDTO dto) {
		// TODO Auto-generated method stub
		List<WaypointsDTO> list=dao.search(dto);
		return list;
	}

	@Override
	public List<WaypointsDTO> search(WaypointsDTO dto, int pageNo, int pageSize) {
		// TODO Auto-generated method stub
		List<WaypointsDTO> list=dao.search(dto, pageNo, pageSize);
		return list;
	}

	@Override
	public WaypointsDTO findByModelNumber(String modelNumber) {
		// TODO Auto-generated method stub
		return null;
	}

	
}
