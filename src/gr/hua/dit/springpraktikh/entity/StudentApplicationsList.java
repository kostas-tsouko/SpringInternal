package gr.hua.dit.springpraktikh.entity;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

import org.springframework.stereotype.Component;

@XmlRootElement(name="StudentApplicationsList")
@Component
public class StudentApplicationsList {
	List<StudentApplications> StdAppsList;
	
	public List<StudentApplications> getStdAppsList(){
		return StdAppsList; 
	}
	
	public void setStdAppsList(List<StudentApplications> StdAppsList) {
		this.StdAppsList=StdAppsList;
	}
}
