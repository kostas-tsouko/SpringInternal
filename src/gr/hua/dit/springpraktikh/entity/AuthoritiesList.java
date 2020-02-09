package gr.hua.dit.springpraktikh.entity;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

import org.springframework.stereotype.Component;

@XmlRootElement(name="AuthoritiesList")
@Component
public class AuthoritiesList {
List<Authorities> authoritiesList;
	
	public List<Authorities> getAuthoritiesList(){
		return authoritiesList; 
	}
	
	public void setAuthoritiesList(List<Authorities> authoritiesList) {
		this.authoritiesList=authoritiesList;
	}
}
