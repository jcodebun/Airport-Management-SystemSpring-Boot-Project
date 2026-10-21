package com.abc.airport.mgt.service;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.abc.airport.mgt.dao.AllotHangerDAOInt;
import com.abc.airport.mgt.dto.AllotHangerDTO;
import com.abc.airport.mgt.exception.DuplicateRecordException;




@Service
public class AllotHangerServiceImpl implements AllotHangerServiceInt {
	private static Logger log = Logger.getLogger(AllotHangerServiceImpl.class.getName());

	@Autowired
	private AllotHangerDAOInt dao;

	@Override
	@Transactional
	public long add(AllotHangerDTO dto) throws DuplicateRecordException {
		log.info("AllotHangerServiceImpl Add method start");
		AllotHangerDTO existDTO = dao.findByPlaneId(dto.getPlaneId());
		
		 if (existDTO != null) 
			 throw new DuplicateRecordException("Hanger Already alloted to this Plane");
		 
		long pk = dao.add(dto); 
		log.info("AllotHangerServiceImpl Add method end");
		return pk;
	}

	@Override
	@Transactional
	public void delete(AllotHangerDTO dto) {
		// TODO Auto-generated method stub
		log.info("AllotHangerServiceImpl Delete method start");
		dao.delete(dto);
		log.info("AllotHangerServiceImpl Delete method end");
	}

	@Override
	@Transactional
	public AllotHangerDTO findBypk(long pk) {
		log.info("AllotHangerServiceImpl findBypk method start");
		AllotHangerDTO dto = dao.findBypk(pk);
		log.info("AllotHnagerServiceImpl findBypk method end");
		return dto;
	}

	@Override
	public AllotHangerDTO findByName(String name) {
		log.info("AllotHnagerServiceImpl findByAllotHnagerName method start");
		AllotHangerDTO dto = dao.findByName(name);
		log.info("AllotHangerServiceImpl findByAllotHangerName method end");
		return dto;
	}

	@Override
	@Transactional
	public void update(AllotHangerDTO dto) {
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
	@Transactional
	public List<AllotHangerDTO> list() {
		log.info("AllotHangerServiceImpl list method start");
		List<AllotHangerDTO> list = dao.list();
		log.info("AllotHangerServiceImpl list method end");
		return list;
	}

	@Override
	@Transactional
	public List<AllotHangerDTO> list(int pageNo, int pageSize) {
		log.info("AllotHangerServiceImpl list method start");
		List<AllotHangerDTO> list = dao.list(pageNo, pageSize);
		log.info("AllotHnagerServiceImpl list method end");
		return list;
	}

	@Override
	@Transactional
	public List<AllotHangerDTO> search(AllotHangerDTO dto) {
		log.info("AllotHangerServiceImpl search method start");
		List<AllotHangerDTO> list = dao.search(dto);
		log.info("AllotHnaerServiceImpl search method end");
		return list;
	}

	@Override
	@Transactional
	public List<AllotHangerDTO> search(AllotHangerDTO dto, int pageNo, int pageSize) {
		log.info("AllotHnagerServiceImpl search method start");
		List<AllotHangerDTO> list = dao.search(dto, pageNo, pageSize);
		log.info("AllotHnagerServiceImpl search method end");
		return list;
	}

	@Override
	@Transactional
	public void deleteById(long id) {
		// TODO Auto-generated method stub
		log.info("AllotHangerServiceImpl Delete method start");
		System.out.println("////id////"+id);
		dao.deleteById(id);
		log.info("AllotHangerServiceImpl Delete method end");
	}

}
