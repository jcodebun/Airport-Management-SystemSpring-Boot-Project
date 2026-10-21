package com.abc.airport.mgt.dao;

import java.util.List;
import java.util.logging.Logger;

import javax.persistence.EntityManager;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.abc.airport.mgt.dto.AddHangerDTO;
import com.abc.airport.mgt.dto.WaypointsDTO;

@Repository
public class WaypointsDAOImpl implements WaypointsDAOInt {

	private static Logger log = Logger.getLogger(WaypointsDTO.class.getName());
	@Autowired
	private EntityManager entityManager;
	@Override
	public long add(WaypointsDTO dto) {
		// TODO Auto-generated method stub
		log.info("UserDAOImpl Add method Start");
		Session session = entityManager.unwrap(Session.class);
		long pk = (long) session.save(dto);
		log.info("UserDAOImpl Add method End");
		return pk;
	}

	@Override
	public void delete(WaypointsDTO dto) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public WaypointsDTO findBypk(long pk) {
		// TODO Auto-generated method stub
		log.info("UserDAOImpl FindByPk method Start");
		Session session = entityManager.unwrap(Session.class);
		WaypointsDTO dto = (WaypointsDTO) session.get(WaypointsDTO.class, pk);
		log.info("UserDAOImpl FindByPk method End");
		return dto;
	}

	@Override
	public WaypointsDTO findByModelNumber(String modelNumber) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(WaypointsDTO dto) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<WaypointsDTO> list() {
		// TODO Auto-generated method stub
		return list(0, 0);
	}

	@Override
	public List<WaypointsDTO> list(int pageNo, int pageSize) {
		// TODO Auto-generated method stub
		log.info("UserDAOImpl List method Start");
		Session session = entityManager.unwrap(Session.class);
		Query<WaypointsDTO> query = session.createQuery("from WaypointsDTO", WaypointsDTO.class);
		List<WaypointsDTO> list = query.getResultList();
		log.info("UserDAOImpl List method End");
		return list;
	}

	@Override
	public List<WaypointsDTO> search(WaypointsDTO dto) {
		// TODO Auto-generated method stub
		return search(dto, 0, 0);
	}

	@Override
	public List<WaypointsDTO> search(WaypointsDTO dto, int pageNo, int pageSize) {
		// TODO Auto-generated method stub
		log.info("UserDAOImpl Search method Start");
		Session session = entityManager.unwrap(Session.class);
		Criteria criteria = session.createCriteria(WaypointsDTO.class);
		if (dto != null) {
			if (dto.getId() > 0) {
				criteria.add(Restrictions.eq("id", dto.getId()));
			}
			if (dto.getWapointsName() != null && dto.getWapointsName().length() > 0) {
				criteria.add(Restrictions.like("wapointsName", dto.getWapointsName() + "%"));
			}
			
			if (pageSize > 0) {
				pageNo = (pageNo - 1) * pageSize;
				criteria.setFirstResult((int) pageNo);
				criteria.setMaxResults(pageSize);
			}
		}
		log.info("UserDAOImpl Search method End");
		return criteria.list();
	}

}
