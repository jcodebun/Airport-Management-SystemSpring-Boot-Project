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


import com.abc.airport.mgt.dto.PlaneDTO;
import com.abc.airport.mgt.dto.UpdateFlightPlanDTO;

@Repository
public class UpdateFlightPlanDAOImpl implements UpdateFlightPlanDAOInt {
	private static Logger log = Logger.getLogger(UpdateFlightPlanDAOImpl.class.getName());

	@Autowired
	private EntityManager entityManager;
	@Override
	public long add(UpdateFlightPlanDTO dto) {
		// TODO Auto-generated method stub
		log.info("AllotHnagerDAOImpl Add method Start");
		Session session = entityManager.unwrap(Session.class);
		long pk = (long) session.save(dto);
		log.info("AllotHangerDAOImpl Add method End");
		return pk;
	}

	@Override
	public void delete(UpdateFlightPlanDTO dto) {
		// TODO Auto-generated method stub
		log.info("AllotHangerDAOImpl Delete method Start");
		entityManager.remove(entityManager.contains(dto) ? dto : entityManager.merge(dto));
		log.info("AllotHangerDAOImpl Delete method End");
	}

	@Override
	public UpdateFlightPlanDTO findBypk(long pk) {
		// TODO Auto-generated method stub
		log.info("AllotHangerDAOImpl FindByPk method Start");
		Session session = entityManager.unwrap(Session.class);
		UpdateFlightPlanDTO dto = (UpdateFlightPlanDTO) session.get(UpdateFlightPlanDTO.class, pk);
		log.info("AllothangerDAOImpl FindByPk method End");
		return dto;
	}

	@Override
	public UpdateFlightPlanDTO findByModelNumber(String modelNumber) {
		// TODO Auto-generated method stub
		log.info("AllotHanbgerDAOImpl FindByLogin method Start");
		Session session = entityManager.unwrap(Session.class);
		Criteria criteria = session.createCriteria(UpdateFlightPlanDTO.class);
		criteria.add(Restrictions.eq("planeId",modelNumber));
		UpdateFlightPlanDTO dto = (UpdateFlightPlanDTO) criteria.uniqueResult();
		log.info("AllothangerDAOImpl FindByLogin method End");
		return dto;
	}

	@Override
	public void update(UpdateFlightPlanDTO dto) {
		// TODO Auto-generated method stub
		log.info("AllotHangerDAOImpl Update method Start");
		Session session = entityManager.unwrap(Session.class);
		session.merge(dto);
		log.info("AllotHangerDAOImpl update method End");
	}

	@Override
	public List<UpdateFlightPlanDTO> list() {
		// TODO Auto-generated method stub
		return list(0, 0);
	}

	@Override
	public List<UpdateFlightPlanDTO> list(int pageNo, int pageSize) {
		// TODO Auto-generated method stub
		log.info("AllotHangerDAOImpl List method Start");
		Session session = entityManager.unwrap(Session.class);
		Query<UpdateFlightPlanDTO> query = session.createQuery("from UpdateFlightPlanDTO", UpdateFlightPlanDTO.class);
		List<UpdateFlightPlanDTO> list = query.getResultList();
		log.info("AllotHangerDAOImpl List method End");
		return list;
	}

	@Override
	public List<UpdateFlightPlanDTO> search(UpdateFlightPlanDTO dto) {
		// TODO Auto-generated method stub
		return search(dto, 0, 0);
	}

	@Override
	public List<UpdateFlightPlanDTO> search(UpdateFlightPlanDTO dto, int pageNo, int pageSize) {
		log.info("UserDAOImpl Search method Start");
		Session session = entityManager.unwrap(Session.class);
		Criteria criteria = session.createCriteria(UpdateFlightPlanDTO.class);
		if (dto != null) {
			if (dto.getId() > 0) {
				criteria.add(Restrictions.eq("id", dto.getId()));
			}
			if (dto.getAlternateAirports() != null && dto.getAlternateAirports().length() > 0) {
				criteria.add(Restrictions.like("alternateAirports", dto.getAlternateAirports() + "%"));
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
	
	@Override
	public UpdateFlightPlanDTO findByPlaneId(long pid) {
		log.info("AllotHanbgerDAOImpl FindByLogin method Start");
		Session session = entityManager.unwrap(Session.class);
		Criteria criteria = session.createCriteria(UpdateFlightPlanDTO.class);
		criteria.add(Restrictions.eq("planeId",pid));
		UpdateFlightPlanDTO dto = (UpdateFlightPlanDTO) criteria.uniqueResult();
		log.info("AllothangerDAOImpl FindByLogin method End");
		return dto;
	}

}
