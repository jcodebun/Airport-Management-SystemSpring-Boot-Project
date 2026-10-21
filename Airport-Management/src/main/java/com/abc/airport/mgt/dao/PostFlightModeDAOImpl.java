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

import com.abc.airport.mgt.dto.PostFlightModeDTO;


@Repository
public class PostFlightModeDAOImpl implements PostFlightModeDAOInt {

	private static Logger log = Logger.getLogger(PostFlightModeDTO.class.getName());

	@Autowired
	private EntityManager entityManager;
	@Override
	public long add(PostFlightModeDTO dto) {
		// TODO Auto-generated method stub
		log.info("AllotHnagerDAOImpl Add method Start");
		Session session = entityManager.unwrap(Session.class);
		long pk = (long) session.save(dto);
		log.info("AllotHangerDAOImpl Add method End");
		return pk;
	}

	@Override
	public void delete(PostFlightModeDTO dto) {
		// TODO Auto-generated method stub
		log.info("AllotHangerDAOImpl Delete method Start");
		entityManager.remove(entityManager.contains(dto) ? dto : entityManager.merge(dto));
		log.info("AllotHangerDAOImpl Delete method End");
	}

	@Override
	public PostFlightModeDTO findBypk(long pk) {
		// TODO Auto-generated method stub
		log.info("AllotHangerDAOImpl FindByPk method Start");
		Session session = entityManager.unwrap(Session.class);
		PostFlightModeDTO dto = (PostFlightModeDTO) session.get(PostFlightModeDTO.class, pk);
		log.info("AllothangerDAOImpl FindByPk method End");
		return dto;
	}

	@Override
	public PostFlightModeDTO findByName(String name) {
		// TODO Auto-generated method stub
		log.info("AllotHanbgerDAOImpl FindByLogin method Start");
		Session session = entityManager.unwrap(Session.class);
		Criteria criteria = session.createCriteria(PostFlightModeDTO.class);
		criteria.add(Restrictions.eq("name",name));
		PostFlightModeDTO dto = (PostFlightModeDTO) criteria.uniqueResult();
		log.info("AllothangerDAOImpl FindByLogin method End");
		return dto;
	}

	@Override
	public void update(PostFlightModeDTO dto) {
		// TODO Auto-generated method stub
		log.info("AllotHangerDAOImpl Update method Start");
		Session session = entityManager.unwrap(Session.class);
		session.merge(dto);
		log.info("AllotHangerDAOImpl update method End");
	}

	@Override
	public List<PostFlightModeDTO> list() {
		// TODO Auto-generated method stub
		return list(0, 0);
	}

	@Override
	public List<PostFlightModeDTO> list(int pageNo, int pageSize) {
		// TODO Auto-generated method stub
		log.info("AllotHangerDAOImpl List method Start");
		Session session = entityManager.unwrap(Session.class);
		Query<PostFlightModeDTO> query = session.createQuery("from PostFlightModeDTO", PostFlightModeDTO.class);
		List<PostFlightModeDTO> list = query.getResultList();
		log.info("AllotHangerDAOImpl List method End");
		return list;
	}

	@Override
	public List<PostFlightModeDTO> search(PostFlightModeDTO dto) {
		// TODO Auto-generated method stub
		return search(dto, 0, 0);
	}

	@Override
	public List<PostFlightModeDTO> search(PostFlightModeDTO dto, int pageNo, int pageSize) {
		// TODO Auto-generated method stub
		log.info("AllotHnagerDAOImpl Search method Start");
		Session session = entityManager.unwrap(Session.class);
		StringBuffer hql = new StringBuffer("from PostFlightModeDTO as u where 1=1 ");
		if (dto != null) {
			if (dto.getId() > 0) {
				hql.append("and u.id = " + dto.getId());
			}
			
			/*
			 * if (dto.get > 0) { hql.append("and u.roomId = " + dto.getHangerId()); }
			 */
		
		}
		Query<PostFlightModeDTO> query = session.createQuery(hql.toString(), PostFlightModeDTO.class);
		if (pageNo > 0) {
			pageNo = (pageNo - 1) * pageSize;
			query.setFirstResult(pageNo);
			query.setMaxResults(pageSize);
		}
		List<PostFlightModeDTO> list = query.getResultList();
		log.info("AddWorkScheduleDTOImpl Search method End");
		return list;
	}

	@Override
	public PostFlightModeDTO findByPlaneId(long pid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteById(long id) {
		// TODO Auto-generated method stub
		
	}

}
