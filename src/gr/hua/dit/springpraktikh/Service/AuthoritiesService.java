package gr.hua.dit.springpraktikh.Service;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

import org.springframework.stereotype.Component;

import gr.hua.dit.springpraktikh.entity.Authorities;
import gr.hua.dit.springpraktikh.entity.Office;

@XmlRootElement(name="AuthoritiesService")
@Component
public interface AuthoritiesService {
	public List<Authorities> getAuthorities();

	public void saveAuthorities(Authorities authorities);
	
	public Authorities getAuthority(int id);

	public void deleteAuthority(int id);

}
