package gr.hua.dit.springpraktikh.Service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gr.hua.dit.springpraktikh.dao.OfficeDAO;
import gr.hua.dit.springpraktikh.dao.StudentApplicationsDAO;
import gr.hua.dit.springpraktikh.entity.Office;
import gr.hua.dit.springpraktikh.entity.StudentApplications;


@Service
public class StudentApplicationsServiceImpl implements StudentApplicationsService{
	// inject the CustomerDAO
				@Autowired
				private StudentApplicationsDAO stdappDAO;
				
				@Override
				@Transactional
				public List<StudentApplications> getStdApps(){
					return stdappDAO.getStdApps();
				}

				@Override
				@Transactional
				public void saveStdApps(StudentApplications stdapp) {
					stdappDAO.saveStdApps(stdapp);
				}

				@Override
				@Transactional
				public StudentApplications getStdApps(int id) {
					return stdappDAO.getStdApps(id);
				}

				@Override
				@Transactional
				public void deleteStdApps(int id) {
					stdappDAO.deleteStdApps(id);
				}
				
}
