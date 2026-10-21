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
import org.springframework.transaction.annotation.Transactional;

import com.abc.airport.mgt.dto.AllotHangerDTO;







@Repository
public class AllotHangerDAOImpl implements AllotHangerDAOInt{
	private static Logger log = Logger.getLogger(AllotHangerDAOImpl.class.getName());

	@Autowired
	private EntityManager entityManager;
	@Override
	public long add(AllotHangerDTO dto) {
		// TODO Auto-generated method stub
		log.info("AllotHnagerDAOImpl Add method Start");
		Session session = entityManager.unwrap(Session.class);
		long pk = (long) session.save(dto);
		log.info("AllotHangerDAOImpl Add method End");
		return pk;
	}

	@Override
	public void delete(AllotHangerDTO dto) {
		// TODO Auto-generated method stub
		log.info("AllotHangerDAOImpl Delete method Start");
		entityManager.remove(entityManager.contains(dto) ? dto : entityManager.merge(dto));
		log.info("AllotHangerDAOImpl Delete method End");
	}

	@Override
	public AllotHangerDTO findBypk(long pk) {
		log.info("AllotHangerDAOImpl FindByPk method Start");
		Session session = entityManager.unwrap(Session.class);
		AllotHangerDTO dto = (AllotHangerDTO) session.get(AllotHangerDTO.class, pk);
		log.info("AllothangerDAOImpl FindByPk method End");
		return dto;
	}

	@Override
	public AllotHangerDTO findByName(String name) {
		log.info("AllotHanbgerDAOImpl FindByLogin method Start");
		Session session = entityManager.unwrap(Session.class);
		Criteria criteria = session.createCriteria(AllotHangerDTO.class);
		criteria.add(Restrictions.eq("name",name));
		AllotHangerDTO dto = (AllotHangerDTO) criteria.uniqueResult();
		log.info("AllothangerDAOImpl FindByLogin method End");
		return dto;
	}

	@Override
	public void update(AllotHangerDTO dto) {
		// TODO Auto-generated method stub
		log.info("AllotHangerDAOImpl Update method Start");
		Session session = entityManager.unwrap(Session.class);
		session.merge(dto);
		log.info("AllotHangerDAOImpl update method End");
	}

	@Override
	public List<AllotHangerDTO> list() {
		// TODO Auto-generated method stub
		return list(0, 0);
	}

	@Override
	public List<AllotHangerDTO> list(int pageNo, int pageSize) {
		log.info("AllotHangerDAOImpl List method Start");
		Session session = entityManager.unwrap(Session.class);
		Query<AllotHangerDTO> query = session.createQuery("from AllotHangerDTO", AllotHangerDTO.class);
		List<AllotHangerDTO> list = query.getResultList();
		log.info("AllotHangerDAOImpl List method End");
		return list;
	}

	@Override
	public List<AllotHangerDTO> search(AllotHangerDTO dto) {
		// TODO Auto-generated method stub
		return search(dto, 0, 0);
	}

	@Override
	public List<AllotHangerDTO> search(AllotHangerDTO dto, int pageNo, int pageSize) {
		log.info("AllotHnagerDAOImpl Search method Start");
		Session session = entityManager.unwrap(Session.class);
		StringBuffer hql = new StringBuffer("from AllotHangerDTO as u where 1=1 ");
		if (dto != null) {
			if (dto.getId() > 0) {
				hql.append("and u.id = " + dto.getId());
			}
			
			if (dto.getHangerId() > 0) {
				hql.append("and u.roomId = " + dto.getHangerId());
			}
		
		}
		Query<AllotHangerDTO> query = session.createQuery(hql.toString(), AllotHangerDTO.class);
		if (pageNo > 0) {
			pageNo = (pageNo - 1) * pageSize;
			query.setFirstResult(pageNo);
			query.setMaxResults(pageSize);
		}
		List<AllotHangerDTO> list = query.getResultList();
		log.info("AllotHangerDAOImpl Search method End");
		return list;
	}

	@Override
	public AllotHangerDTO findByPlaneId(long pid) {
		log.info("AllotHanbgerDAOImpl FindByLogin method Start");
		Session session = entityManager.unwrap(Session.class);
		Criteria criteria = session.createCriteria(AllotHangerDTO.class);
		criteria.add(Restrictions.eq("planeId",pid));
		AllotHangerDTO dto = (AllotHangerDTO) criteria.uniqueResult();
		log.info("AllothangerDAOImpl FindByLogin method End");
		return dto;
	}

	@Override
	@Transactional
	public void deleteById(long id) {
		AllotHangerDTO dto = entityManager.find(AllotHangerDTO.class, id);
		if(dto!=null) {
			//entityManager.getTransaction().begin();
			entityManager.remove(dto);
			//entityManager.getTransaction().commit();
		}
	}
}


