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
import org.springframework.stereotype.Service;

import com.abc.airport.mgt.dto.PlaneDTO;
import com.abc.airport.mgt.dto.UserDTO;
@Repository
public class PlaneDAOImp implements PlaneDAOInt {
	
	private static Logger log = Logger.getLogger(PlaneDAOImp.class.getName());
	@Autowired
	private EntityManager entityManager;

	@Override
	public long add(PlaneDTO dto) {
		// TODO Auto-generated method stub
		log.info("UserDAOImpl Add method Start");
		Session session = entityManager.unwrap(Session.class);
		long pk = (long) session.save(dto);
		log.info("UserDAOImpl Add method End");
		return pk;
	}

	@Override
	public void delete(PlaneDTO dto) {
		// TODO Auto-generated method stub
		entityManager.remove(entityManager.contains(dto) ? dto : entityManager.merge(dto));
	}

	@Override
	public PlaneDTO findBypk(long pk) {
		// TODO Auto-generated method stub
		log.info("UserDAOImpl FindByPk method Start");
		Session session = entityManager.unwrap(Session.class);
		PlaneDTO dto = (PlaneDTO) session.get(PlaneDTO.class, pk);
		log.info("UserDAOImpl FindByPk method End");
		return dto;
	}

	

	@Override
	public void update(PlaneDTO dto) {
		// TODO Auto-generated method stub
		log.info("UserDAOImpl Update method Start");
		Session session = entityManager.unwrap(Session.class);
		session.merge(dto);
		//session.update(dto);
		log.info("UserDAOImpl update method End");
	}

	@Override
	public List<PlaneDTO> list() {
		// TODO Auto-generated method stub
		return list(0, 0);
	}

	@Override
	public List<PlaneDTO> list(int pageNo, int pageSize) {
		log.info("UserDAOImpl List method Start");
		Session session = entityManager.unwrap(Session.class);
		Query<PlaneDTO> query = session.createQuery("from PlaneDTO", PlaneDTO.class);
		List<PlaneDTO> list = query.getResultList();
		log.info("UserDAOImpl List method End");
		return list;
	}

	@Override
	public List<PlaneDTO> search(PlaneDTO dto) {
		// TODO Auto-generated method stub
		return search(dto, 0, 0);
	}

	@Override
	public List<PlaneDTO> search(PlaneDTO dto, int pageNo, int pageSize) {
		log.info("UserDAOImpl Search method Start");
		Session session = entityManager.unwrap(Session.class);
		Criteria criteria = session.createCriteria(PlaneDTO.class);
		if (dto != null) {
			if (dto.getId() > 0) {
				criteria.add(Restrictions.eq("id", dto.getId()));
			}
			if (dto.getModelNumber() != null && dto.getModelNumber().length() > 0) {
				criteria.add(Restrictions.like("modelNumber", dto.getModelNumber() + "%"));
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
	public PlaneDTO findByModelNumber(String modelNumber) {
		log.info("UserDAOImpl FindByLogin method Start");
		Session session = entityManager.unwrap(Session.class);
		Criteria criteria = session.createCriteria(PlaneDTO.class);
		criteria.add(Restrictions.eq("modelNumber", modelNumber));
		PlaneDTO dto = (PlaneDTO) criteria.uniqueResult();
		log.info("UserDAOImpl FindByLogin method End");
		return dto;
	}


}
