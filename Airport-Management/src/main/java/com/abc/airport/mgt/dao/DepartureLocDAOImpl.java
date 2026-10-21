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

import com.abc.airport.mgt.dto.DepartureLocDTO;
import com.abc.airport.mgt.dto.WaypointsDTO;

@Repository
public class DepartureLocDAOImpl implements DepartureLocDAOInt {

	private static Logger log = Logger.getLogger(WaypointsDTO.class.getName());
	@Autowired
	private EntityManager entityManager;
	@Override
	public long add(DepartureLocDTO dto) {
		// TODO Auto-generated method stub
		log.info("UserDAOImpl Add method Start");
		Session session = entityManager.unwrap(Session.class);
		long pk = (long) session.save(dto);
		log.info("UserDAOImpl Add method End");
		return pk;
	}

	@Override
	public void delete(DepartureLocDTO dto) {
		// TODO Auto-generated method stub
		entityManager.remove(entityManager.contains(dto) ? dto : entityManager.merge(dto));
	}

	@Override
	public DepartureLocDTO findBypk(long pk) {
		// TODO Auto-generated method stub
		log.info("UserDAOImpl FindByPk method Start");
		Session session = entityManager.unwrap(Session.class);
		DepartureLocDTO dto = (DepartureLocDTO) session.get(DepartureLocDTO.class, pk);
		log.info("UserDAOImpl FindByPk method End");
		return dto;
	}

	@Override
	public DepartureLocDTO findByModelNumber(String modelNumber) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(DepartureLocDTO dto) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<DepartureLocDTO> list() {
		// TODO Auto-generated method stub
		return list(0, 0);
	}

	@Override
	public List<DepartureLocDTO> list(int pageNo, int pageSize) {
		// TODO Auto-generated method stub
		log.info("UserDAOImpl List method Start");
		Session session = entityManager.unwrap(Session.class);
		Query<DepartureLocDTO> query = session.createQuery("from DepartureLocDTO", DepartureLocDTO.class);
		List<DepartureLocDTO> list = query.getResultList();
		log.info("UserDAOImpl List method End");
		return list;
	}

	@Override
	public List<DepartureLocDTO> search(DepartureLocDTO dto) {
		// TODO Auto-generated method stub
		return search(dto, 0, 0);
	}

	@Override
	public List<DepartureLocDTO> search(DepartureLocDTO dto, int pageNo, int pageSize) {
		// TODO Auto-generated method stub
		log.info("UserDAOImpl Search method Start");
		Session session = entityManager.unwrap(Session.class);
		Criteria criteria = session.createCriteria(DepartureLocDTO.class);
		if (dto != null) {
			if (dto.getId() > 0) {
				criteria.add(Restrictions.eq("id", dto.getId()));
			}
			if (dto.getDepLoc() != null && dto.getDepLoc().length() > 0) {
				criteria.add(Restrictions.like("depLoc", dto.getDepLoc() + "%"));
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
