package gr.hua.dit.springpraktikh.dao;

import java.util.List;

import gr.hua.dit.springpraktikh.entity.Authorities;


public interface AuthoritiesDAO {
	public List<Authorities> getAuthorities();

	public void saveAuthorities(Authorities authorities);
	
	public Authorities getAuthority(int id);

	public void deleteAuthority(int id);
}
