package gr.hua.dit.springpraktikh.dao;

import gr.hua.dit.springpraktikh.entity.Users;

public interface UsersDAO {

	
	public void saveUsers(Users users);
	
	public Users getUsers(int id);

	public void deleteUsers(int id);
}
