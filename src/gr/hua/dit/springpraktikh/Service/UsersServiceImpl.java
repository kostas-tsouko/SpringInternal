package gr.hua.dit.springpraktikh.Service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gr.hua.dit.springpraktikh.dao.UsersDAO;
import gr.hua.dit.springpraktikh.entity.Users;


@Service
public class UsersServiceImpl implements UsersService{
	// inject the CustomerDAO
		@Autowired
		private UsersDAO userDAO;
		
		@Override
		@Transactional
		public Users getUsers(int id) {
			// TODO Auto-generated method stub
			return userDAO.getUsers(id);
		}
		@Override
		@Transactional
		public void saveUsers(Users users) {
			userDAO.saveUsers(users);
		}

	
		/*@Transactional
		public Customer getCustomer(int id) {
			return userDAO.getCustomer(id);
		}*/

		@Override
		@Transactional
		public void deleteUsers(int id) {
			userDAO.deleteUsers(id);
		}

		
}
