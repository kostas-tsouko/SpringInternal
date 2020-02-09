package gr.hua.dit.springpraktikh.Service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import gr.hua.dit.springpraktikh.dao.StudentDAO;
import gr.hua.dit.springpraktikh.entity.Student;


@Service
public class StudentServiceImpl implements StudentService{
	// inject the CustomerDAO
		@Autowired
		private StudentDAO studentDAO;
		
		@Override
		@Transactional
		public List<Student> getStudents() {
			return studentDAO.getStudents();
		}

		@Override
		@Transactional
		public void saveStudent(Student student) {
			studentDAO.saveStudent(student);
		}

		@Override
		@Transactional
		public Student getStudent(int id) {
			return studentDAO.getStudent(id);
		}

		@Override
		@Transactional
		public void deleteStudent(int id) {
			studentDAO.deleteStudent(id);
		}
}
