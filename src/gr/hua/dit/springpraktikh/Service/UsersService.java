package gr.hua.dit.springpraktikh.Service;

import gr.hua.dit.springpraktikh.entity.Users;

public interface UsersService {
	public void saveUsers(Users users);
	
	public Users getUsers(int id);
	
	public void deleteUsers(int id);
}
