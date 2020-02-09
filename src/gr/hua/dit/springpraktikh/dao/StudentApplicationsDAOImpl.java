package gr.hua.dit.springpraktikh.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import gr.hua.dit.springpraktikh.entity.Student;
import gr.hua.dit.springpraktikh.entity.StudentApplications;


@Repository
public class StudentApplicationsDAOImpl implements StudentApplicationsDAO {
	@Autowired
	private SessionFactory sessionFactory;
	
	
	@Override
	@Transactional
	public List<StudentApplications> getStdApps() {
		// get current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();

		// create a query
		Query<StudentApplications> query = currentSession.createQuery("from StudentApplications order by id", StudentApplications.class);

		// execute the query and get the results list
		List<StudentApplications> Studentapplications = query.getResultList();

		// return the results
		return Studentapplications;
	}

	@Override
	@Transactional
	public void saveStdApps(StudentApplications Studentapplications) {
		Session currentSession = sessionFactory.getCurrentSession();
			
				
				if (Studentapplications.getId()!=0) {
					currentSession.update(Studentapplications);
				} else {
					currentSession.save(Studentapplications);
				}
		
	}

	@Override
	public StudentApplications getStdApps(int id) {

		Session currentSession = sessionFactory.getCurrentSession();

		StudentApplications Studentapplications = currentSession.get(StudentApplications.class, id);
		
		return Studentapplications;
	}

	@Override
	@Transactional
	public void deleteStdApps(int id) {
		Session currentSession = sessionFactory.getCurrentSession();

		StudentApplications Studentapplications = currentSession.get(StudentApplications.class, id);

		currentSession.delete(Studentapplications);
	}

}



