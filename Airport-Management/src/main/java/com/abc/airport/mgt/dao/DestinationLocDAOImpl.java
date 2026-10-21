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
import com.abc.airport.mgt.dto.DestinationLocDTO;
import com.abc.airport.mgt.dto.WaypointsDTO;

@Repository
public class DestinationLocDAOImpl implements DestinationLocDAOInt{

	private static Logger log = Logger.getLogger(DestinationLocDTO.class.getName());
	@Autowired
	private EntityManager entityManager;
	@Override
	public long add(DestinationLocDTO dto) {
		// TODO Auto-generated method stub
		log.info("UserDAOImpl Add method Start");
		Session session = entityManager.unwrap(Session.class);
		long pk = (long) session.save(dto);
		log.info("UserDAOImpl Add method End");
		return pk;
	}

	@Override
	public void delete(DestinationLocDTO dto) {
		// TODO Auto-generated method stub
		entityManager.remove(entityManager.contains(dto) ? dto : entityManager.merge(dto));
	}

	@Override
	public DestinationLocDTO findBypk(long pk) {
		// TODO Auto-generated method stub
		log.info("UserDAOImpl FindByPk method Start");
		Session session = entityManager.unwrap(Session.class);
		DestinationLocDTO dto = (DestinationLocDTO) session.get(DestinationLocDTO.class, pk);
		log.info("UserDAOImpl FindByPk method End");
		return dto;
	}

	@Override
	public DestinationLocDTO findByModelNumber(String modelNumber) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(DestinationLocDTO dto) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<DestinationLocDTO> list() {
		// TODO Auto-generated method stub
		return list(0, 0);
	}

	@Override
	public List<DestinationLocDTO> list(int pageNo, int pageSize) {
		// TODO Auto-generated method stub
		log.info("UserDAOImpl List method Start");
		Session session = entityManager.unwrap(Session.class);
		Query<DestinationLocDTO> query = session.createQuery("from DestinationLocDTO", DestinationLocDTO.class);
		List<DestinationLocDTO> list = query.getResultList();
		log.info("UserDAOImpl List method End");
		return list;
	}

	@Override
	public List<DestinationLocDTO> search(DestinationLocDTO dto) {
		// TODO Auto-generated method stub
		return search(dto, 0, 0);
	}

	@Override
	public List<DestinationLocDTO> search(DestinationLocDTO dto, int pageNo, int pageSize) {
		// TODO Auto-generated method stub
		log.info("UserDAOImpl Search method Start");
		Session session = entityManager.unwrap(Session.class);
		Criteria criteria = session.createCriteria(DestinationLocDTO.class);
		if (dto != null) {
			if (dto.getId() > 0) {
				criteria.add(Restrictions.eq("id", dto.getId()));
			}
			if (dto.getDestinationLoc() != null && dto.getDestinationLoc().length() > 0) {
				criteria.add(Restrictions.like("desLoc", dto.getDestinationLoc() + "%"));
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
