package gr.hua.dit.springpraktikh.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import gr.hua.dit.springpraktikh.entity.Student;


@Repository
public class StudentDAOImpl implements StudentDAO {
	@Autowired
	private SessionFactory sessionFactory;
	
	
	@Override
	@Transactional
	public void saveStudent(Student student) {
		// get current hibernate session
				Session currentSession = sessionFactory.getCurrentSession();

				if (student.getId() != 0) {
					currentSession.update(student);
				} else {
					currentSession.save(student);
				}

	}

	@Override
	@Transactional
	public List<Student> getStudents() {
		// get current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();

		// create a query
		Query<Student> query = currentSession.createQuery("from Student order by id", Student.class);

		// execute the query and get the results list
		List<Student> students = query.getResultList();

		// return the results
		return students;
	}

	@Override
	@Transactional
	public void deleteStudent(int id) {
		// get current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();

		// find the Student
		Student Student = currentSession.get(Student.class, id);

		// delete Student
		currentSession.delete(Student);

	}

	@Override
	public Student getStudent(int id) {
		// get current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();

		// get and return Student
		Student student = currentSession.get(Student.class, id);
		return student;
	}

}
