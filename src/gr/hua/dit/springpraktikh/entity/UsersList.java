package gr.hua.dit.springpraktikh.entity;

import java.util.List;

public class UsersList {

	List<Users> userList;
	
	public List<Users> getUsersList(){
		return userList; 
	}
	
	public void setUsersList(List<Users> userList) {
		this.userList=userList;
	}
}
