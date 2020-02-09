package gr.hua.dit.springpraktikh.dao;

import java.util.List;

import gr.hua.dit.springpraktikh.entity.StudentApplications;

public interface StudentApplicationsDAO {
public List<StudentApplications> getStdApps();
	
	public void saveStdApps(StudentApplications studentApplications);
	
	public StudentApplications getStdApps(int id);

	public void deleteStdApps(int id);
}

