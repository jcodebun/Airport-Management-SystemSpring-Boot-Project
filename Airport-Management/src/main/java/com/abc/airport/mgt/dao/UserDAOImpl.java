package com.abc.airport.mgt.dao;

import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.logging.Logger;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Property;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.abc.airport.mgt.dto.UserDTO;

@Repository
public class UserDAOImpl implements UserDAOInt{

	private static Logger log = Logger.getLogger(UserDAOImpl.class.getName());
	@Autowired
	private EntityManager entityManager;
	
	@Override
	public long add(UserDTO dto) {
		// TODO Add User
		log.info("UserDAOImpl Add method Start");
		Session session = entityManager.unwrap(Session.class);
		/*
		 * Random r = new Random(); HashSet<Integer> set = new HashSet<>();
		 * while(set.size()<1) { int random = r.nextInt(999)+10;//this will store random
		 * number within the range set.add(random); } for(int randoNum: set) {
		 * dto.setEmployeeId(String .valueOf(randoNum)); }
		 */
		Integer eid = Integer.parseInt(findByMaxEmployeeId())+1;
		System.out.println("*********"+eid);
	//	String empId = String.valueOf( eid)+1;
		dto.setEmployeeId(String.valueOf(eid));
		long pk = (long) session.save(dto);
		
		
		log.info("UserDAOImpl Add method End");
		return pk;
	}

	@Override
	public void delete(UserDTO dto) {
		// TODO Delete
		log.info("UserDAOImpl Delete method Start");
		entityManager.remove(entityManager.contains(dto) ? dto : entityManager.merge(dto));
		log.info("UserDAOImpl Delete method End");
	}

	@Override
	public UserDTO findBypk(long pk) {
		// TODO find by pk
		log.info("UserDAOImpl FindByPk method Start");
		Session session = entityManager.unwrap(Session.class);
		UserDTO dto = (UserDTO) session.get(UserDTO.class, pk);
		//System.out.println("dto "+dto.getPassword());
		//System.out.println("dto name "+dto.getFirstName());
		log.info("UserDAOImpl FindByPk method End");
		return dto;
	}
	@Override
	public UserDTO findByEmployeeId(String employeeId) {
		// TODO find by pk
		System.out.println("pk is "+employeeId);
		log.info("UserDAOImpl FindByPk method Start");
		Session session = entityManager.unwrap(Session.class);
		Query q = session.createNativeQuery("select * from user where employee_id like '"+employeeId+"'");
		//q.setParameter(1, employeeId);
		//q.setParameter("employeeId", employeeId);
		UserDTO dto = (UserDTO)q.uniqueResult();
		//UserDTO dto = (UserDTO) criteria.uniqueResult();
		System.out.println("dto  "+dto);
		System.out.println("dto name "+dto.getFirstName());
		log.info("UserDAOImpl FindByPk method End");
		return dto;
	}

	@Override
	public UserDTO findByLogin(String login) {
		// TODO Auto-generated method stub
		log.info("UserDAOImpl FindByLogin method Start");
		Session session = entityManager.unwrap(Session.class);
		Criteria criteria = session.createCriteria(UserDTO.class);
		criteria.add(Restrictions.eq("login", login));
		UserDTO dto = (UserDTO) criteria.uniqueResult();
		log.info("UserDAOImpl FindByLogin method End");
		return dto;
	}

	@Override
	public void update(UserDTO dto) {
		// TODO Auto-generated method stub
		log.info("UserDAOImpl Update method Start");
		Session session = entityManager.unwrap(Session.class);
		session.merge(dto);
		log.info("UserDAOImpl update method End");
	}

	@Override
	public List<UserDTO> list() {
		// TODO Auto-generated method stub
		return list(0, 0);
	}

	@Override
	public List<UserDTO> list(int pageNo, int pageSize) {
		// TODO Auto-generated method stub
		log.info("UserDAOImpl List method Start");
		Session session = entityManager.unwrap(Session.class);
		Query<UserDTO> query = session.createQuery("from UserDTO", UserDTO.class);
		List<UserDTO> list = query.getResultList();
		log.info("UserDAOImpl List method End");
		return list;
	}

	@Override
	public List<UserDTO> search(UserDTO dto) {
		// TODO Auto-generated method stub
		return search(dto, 0, 0);
	}

	@Override
	public List<UserDTO> search(UserDTO dto, int pageNo, int pageSize) {
		// TODO Auto-generated method stub
		log.info("UserDAOImpl Search method Start");
		Session session = entityManager.unwrap(Session.class);
		Criteria criteria = session.createCriteria(UserDTO.class);
		if (dto != null) {
			if (dto.getId() > 0) {
				criteria.add(Restrictions.eq("id", dto.getId()));
			}
			if (dto.getFirstName() != null && dto.getFirstName().length() > 0) {
				criteria.add(Restrictions.like("firstName", dto.getFirstName() + "%"));
			}
			if (dto.getLastName() != null && dto.getLastName().length() > 0) {
				criteria.add(Restrictions.like("lastName", dto.getLastName() + "%"));
			}
			if (dto.getLogin() != null && dto.getLogin().length() > 0) {
				criteria.add(Restrictions.like("login", dto.getLogin() + "%"));
			}
			if (dto.getRoleId() > 0) {
				criteria.add(Restrictions.eq("roleId", dto.getRoleId()));
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
	public UserDTO authentication(UserDTO dto) {
		// TODO Auto-generated method stub
		log.info("UserDAOImpl Authentication method Start");
		Session session = entityManager.unwrap(Session.class);
		Query<UserDTO> query = session
				.createQuery("from UserDTO where employeeId=:employeeId and password=:password and status =: status", UserDTO.class);
		query.setParameter("employeeId",dto.getEmployeeId());
		query.setParameter("password",dto.getPassword());
		query.setParameter("status", "1");
		dto = null;
		try {
			dto = query.getSingleResult();
		} catch (NoResultException nre) {
			
		}
		log.info("UserDAOImpl Authentication method End");
		return dto;
	}
	
	
	@Override
	public String findByMaxEmployeeId() {
		// TODO Auto-generated method stub
	//	log.debug("User Model findbylogin method start");
		Session session = null;
		UserDTO bean = null;
		try {
			session = entityManager.unwrap(Session.class);

			DetachedCriteria maxId = DetachedCriteria.forClass(UserDTO.class)
				    .setProjection( Projections.max("employeeId") );
			
			Criteria criteria = session.createCriteria(UserDTO.class);
			criteria.add(Property.forName("employeeId").eq(maxId));
			List list = criteria.list();

			if (list.size() >0) {
				bean = (UserDTO) list.get(0);
			} else {
				bean = null;
			}
		} catch (HibernateException e) {

		//throw new ApplicationException("exception in getting user by login");
		} finally {
			session.close();
		}
		//log.debug("User Model findbylogin method end");
		System.out.println("Empl id :" +bean.getEmployeeId());
		return bean.getEmployeeId();
	}

	@Override
	public UserDTO findAll(String employeeId, String login, String secretAns1, String secretANs2, String secretAns3) {
		// TODO Auto-generated method stub
		Session session =null;
		session = entityManager.unwrap(Session.class);
		Query<UserDTO> query = session
				.createQuery("from UserDTO where employeeId=:employeeId and secretAns1 =:secretAns1 and secretAns2 =:secretANs2 and secretAns3 =: secretAns3 and login=:login  ", UserDTO.class);
		query.setParameter("employeeId",employeeId);
		
		query.setParameter("secretAns1",secretAns1 );
		query.setParameter("secretANs2",secretANs2 );
		query.setParameter("secretAns3",secretAns3 );
		query.setParameter("login",login);
		UserDTO dto =null;
		//dto = null;
		try {
			dto = query.getSingleResult();
		} catch (NoResultException nre) {
			
		}
		log.info("UserDAOImpl Authentication method End");
		return dto;
	}

}
