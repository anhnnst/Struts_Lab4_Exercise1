package edu.poly.service;

import java.util.List;

import javax.persistence.Query;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

import edu.poly.model.User;

@Transactional
public class UserService implements IUserService {

	private SessionFactory sessionFactory;

	public UserService(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Transactional
	public List<User> list() {
		@SuppressWarnings("unchecked")
		List<User> listUser = (List<User>) sessionFactory.getCurrentSession().createCriteria(User.class)
				.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();

		return listUser;
	}

	@Transactional
	public void saveOrUpdate(User user) {
		sessionFactory.getCurrentSession().saveOrUpdate(user);
	}

	@Transactional
	public void delete(String username) {
		User userToDelete = new User();
		userToDelete.setUserName(username);
		;
		sessionFactory.getCurrentSession().delete(userToDelete);
	}

	@Transactional
	public User get(String id) {
		User user = sessionFactory.getCurrentSession().find(User.class, id);

		return user;
	}

	public List<User> search(String name) {
		String hql = "from User where name like :name";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		query.setParameter("name", "%"+name +"%");
		
		@SuppressWarnings("unchecked")
		List<User> listUser = (List<User>) query.getResultList();

		return listUser;
	}

	public User checkLogin(String username, String password) {
		User user = get(username);

		if (user != null && user.getPassword().equals(password)) {
			return user;
		}
		return null;
	}
}
