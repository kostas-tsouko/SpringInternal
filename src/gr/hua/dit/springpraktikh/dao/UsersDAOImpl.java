package gr.hua.dit.springpraktikh.dao;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import gr.hua.dit.springpraktikh.entity.Users;


@Repository
public class UsersDAOImpl implements UsersDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	
	@Override
	@Transactional
	public void saveUsers(Users users) {

		Session currentSession = sessionFactory.getCurrentSession();
		
		currentSession.save(users);
	}

	@Override
	@Transactional
	public Users getUsers(int id) {
		Session currentSession = sessionFactory.getCurrentSession();

		// get and return Users
		Users users = currentSession.get(Users.class, id);
		return users;
	}

	@Override
	@Transactional
	public void deleteUsers(int id) {
		Session currentSession = sessionFactory.getCurrentSession();

		// find the Users
		Users users = currentSession.get(Users.class, id);

		// delete Users
		currentSession.delete(users);
	}

}
