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
import com.abc.airport.mgt.dto.PlaneDTO;
@Repository
public class AddHangerDAOImp implements AddHangerDAOInt {
	
	private static Logger log = Logger.getLogger(AddHangerDAOImp.class.getName());
	@Autowired
	private EntityManager entityManager;

	@Override
	public long add(AddHangerDTO dto) {
		log.info("UserDAOImpl Add method Start");
		Session session = entityManager.unwrap(Session.class);
		long pk = (long) session.save(dto);
		log.info("UserDAOImpl Add method End");
		return pk;
	}

	@Override
	public void delete(AddHangerDTO dto) {
		// TODO Auto-generated method stub
		entityManager.remove(entityManager.contains(dto) ? dto : entityManager.merge(dto));
	}

	@Override
	public AddHangerDTO findBypk(long pk) {
		// TODO Auto-generated method stub
		log.info("UserDAOImpl FindByPk method Start");
		Session session = entityManager.unwrap(Session.class);
		AddHangerDTO dto = (AddHangerDTO) session.get(AddHangerDTO.class, pk);
		log.info("UserDAOImpl FindByPk method End");
		return dto;
	}

	@Override
	public AddHangerDTO findByModelNumber(String modelNumber) {
		log.info("UserDAOImpl FindByLogin method Start");
		Session session = entityManager.unwrap(Session.class);
		Criteria criteria = session.createCriteria(AddHangerDTO.class);
		criteria.add(Restrictions.eq("hangerModel", modelNumber));
		AddHangerDTO dto = (AddHangerDTO) criteria.uniqueResult();
		log.info("UserDAOImpl FindByLogin method End");
		return dto;
	}

	@Override
	public void update(AddHangerDTO dto) {
		// TODO Auto-generated method stub
		log.info("UserDAOImpl Update method Start");
		Session session = entityManager.unwrap(Session.class);
		session.merge(dto);
		//session.update(dto);
		log.info("UserDAOImpl update method End");
	}

	@Override
	public List<AddHangerDTO> list() {
		// TODO Auto-generated method stub
		return list(0, 0);
	}

	@Override
	public List<AddHangerDTO> list(int pageNo, int pageSize) {
		log.info("UserDAOImpl List method Start");
		Session session = entityManager.unwrap(Session.class);
		Query<AddHangerDTO> query = session.createQuery("from AddHangerDTO", AddHangerDTO.class);
		List<AddHangerDTO> list = query.getResultList();
		log.info("UserDAOImpl List method End");
		return list;
	}

	@Override
	public List<AddHangerDTO> search(AddHangerDTO dto) {
		return search(dto, 0, 0);
	}

	@Override
	public List<AddHangerDTO> search(AddHangerDTO dto, int pageNo, int pageSize) {
		// TODO Auto-generated method stub
		log.info("UserDAOImpl Search method Start");
		Session session = entityManager.unwrap(Session.class);
		Criteria criteria = session.createCriteria(AddHangerDTO.class);
		if (dto != null) {
			if (dto.getId() > 0) {
				criteria.add(Restrictions.eq("id", dto.getId()));
			}
			if (dto.getHangerModel() != null && dto.getHangerModel().length() > 0) {
				criteria.add(Restrictions.like("hangerModel", dto.getHangerModel() + "%"));
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
