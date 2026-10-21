package com.abc.airport.mgt.service;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.abc.airport.mgt.dao.AllotHangerDAOInt;
import com.abc.airport.mgt.dao.UpdateFlightPlanDAOInt;
import com.abc.airport.mgt.dto.AllotHangerDTO;
import com.abc.airport.mgt.dto.UpdateFlightPlanDTO;
import com.abc.airport.mgt.exception.DuplicateRecordException;

@Service
public class UpdateFlightPlanServiceImpl implements UpdateFlightPlanServiceInt {

	private static Logger log = Logger.getLogger(UpdateFlightPlanDTO.class.getName());

	@Autowired
	private UpdateFlightPlanDAOInt dao;

	@Override
	@Transactional
	public long add(UpdateFlightPlanDTO dto) throws DuplicateRecordException {
		// TODO Auto-generated method stub
		log.info("AllotHangerServiceImpl Add method start");
		UpdateFlightPlanDTO existDTO = dao.findByPlaneId(dto.getPlaneId());
		
		 if (existDTO != null) 
			 throw new DuplicateRecordException("Plane arleady Scheduled");
		 
		long pk = dao.add(dto); 
		log.info("AllotHangerServiceImpl Add method end");
		return pk;
	}

	@Override
	@Transactional
	public void delete(UpdateFlightPlanDTO dto) {
		// TODO Auto-generated method stub
		log.info("AllotHangerServiceImpl Delete method start");
		dao.delete(dto);
		log.info("AllotHangerServiceImpl Delete method end");
	}

	@Override
	@Transactional
	public UpdateFlightPlanDTO findBypk(long pk) {
		// TODO Auto-generated method stub
		log.info("AllotHangerServiceImpl findBypk method start");
		UpdateFlightPlanDTO dto = dao.findBypk(pk);
		log.info("AllotHnagerServiceImpl findBypk method end");
		return dto;
	}

	@Override
	public UpdateFlightPlanDTO findByName(String name) {
		// TODO Auto-generated method stub
		log.info("AllotHnagerServiceImpl findByAllotHnagerName method start");
		UpdateFlightPlanDTO dto = dao.findByModelNumber(name);
		log.info("AllotHangerServiceImpl findByAllotHangerName method end");
		//UpdateFlightPlanDTO dto =null;
		return dto;
	}

	@Override
	@Transactional
	public void update(UpdateFlightPlanDTO dto) {
		// TODO Auto-generated method stub
		log.info("AllotHnagerServiceImpl update method start");
		/*
		 * AllotRoomDTO existDTO = dao.findByName(dto.getName()); if (existDTO != null
		 * && dto.getId() != existDTO.getId()) throw new
		 * DuplicateRecordException("AllotRoom Is Already Exist");
		 */
		dao.update(dto);
		log.info("AllotHnagerServiceImpl update method end");
	}

	@Override
	public List<UpdateFlightPlanDTO> list() {
		// TODO Auto-generated method stub
		log.info("AllotHangerServiceImpl list method start");
		List<UpdateFlightPlanDTO> list = dao.list();
		log.info("AllotHangerServiceImpl list method end");
		return list;
	}

	@Override
	@Transactional
	public List<UpdateFlightPlanDTO> list(int pageNo, int pageSize) {
		// TODO Auto-generated method stub
		log.info("AllotHangerServiceImpl list method start");
		List<UpdateFlightPlanDTO> list = dao.list(pageNo, pageSize);
		log.info("AllotHnagerServiceImpl list method end");
		return list;
	}

	@Override
	@Transactional
	public List<UpdateFlightPlanDTO> search(UpdateFlightPlanDTO dto) {
		// TODO Auto-generated method stub
		log.info("AllotHangerServiceImpl search method start");
		List<UpdateFlightPlanDTO> list = dao.search(dto);
		log.info("AllotHnaerServiceImpl search method end");
		return list;
	}

	@Override
	@Transactional
	public List<UpdateFlightPlanDTO> search(UpdateFlightPlanDTO dto, int pageNo, int pageSize) {
		// TODO Auto-generated method stub
		log.info("AllotHnagerServiceImpl search method start");
		List<UpdateFlightPlanDTO> list = dao.search(dto, pageNo, pageSize);
		log.info("AllotHnagerServiceImpl search method end");
		return list;
	}

	@Override
	public void deleteById(long id) {
		// TODO Auto-generated method stub
		
	}

}
