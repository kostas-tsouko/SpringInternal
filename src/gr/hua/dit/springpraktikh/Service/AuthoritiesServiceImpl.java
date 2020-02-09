package gr.hua.dit.springpraktikh.Service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import gr.hua.dit.springpraktikh.dao.AuthoritiesDAO;
import gr.hua.dit.springpraktikh.dao.OfficeDAO;
import gr.hua.dit.springpraktikh.entity.Authorities;
import gr.hua.dit.springpraktikh.entity.Office;

@Service
public class AuthoritiesServiceImpl implements AuthoritiesService{
	// inject the CustomerDAO
				@Autowired
				private AuthoritiesDAO authorityDAO;
				
				@Override
				@Transactional
				public List<Authorities> getAuthorities(){
					return authorityDAO.getAuthorities();
				}

				@Override
				@Transactional
				public void saveAuthorities(Authorities authorities) {
					authorityDAO.saveAuthorities(authorities);
				}

				@Override
				@Transactional
				public Authorities getAuthority(int id) {
					return authorityDAO.getAuthority(id);
				}

				@Override
				@Transactional
				public void deleteAuthority(int id) {
					authorityDAO.deleteAuthority(id);
				}
}
