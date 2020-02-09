package gr.hua.dit.springpraktikh.Service;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

import org.springframework.stereotype.Component;

import gr.hua.dit.springpraktikh.entity.Office;
import gr.hua.dit.springpraktikh.entity.StudentApplications;

@XmlRootElement(name="StudentApplicationsService")
@Component
public interface StudentApplicationsService {
	public List<StudentApplications> getStdApps();

	public void saveStdApps(StudentApplications office);
	
	public StudentApplications getStdApps(int id);

	public void deleteStdApps(int id);
}
