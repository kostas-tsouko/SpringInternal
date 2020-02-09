package gr.hua.dit.springpraktikh.controller;

import java.util.List;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import gr.hua.dit.springpraktikh.dao.AuthoritiesDAO;
import gr.hua.dit.springpraktikh.dao.StudentDAO;
import gr.hua.dit.springpraktikh.dao.UsersDAO;
import gr.hua.dit.springpraktikh.entity.Authorities;
import gr.hua.dit.springpraktikh.entity.Student;
import gr.hua.dit.springpraktikh.entity.Users;

@Controller
@RequestMapping("/student")
public class StudentController {
	@Autowired
	private StudentDAO studentDAO;
	
	@Autowired
	private AuthoritiesDAO authoritiesDAO;
	
	@Autowired
	private UsersDAO usersDAO;
	
	@Autowired
	private SessionFactory sessionFactory;

	@GetMapping("/addStudent")
	public String showAddForm(Model model) {
		// create model attribute to get form data
		Student student = new Student();
		model.addAttribute("student", student);

		// add page title
		model.addAttribute("pageTitle", "Add a Student");
		return "student-form";
	}
	
	@GetMapping("/updateStudentList")
	public String showUpdateForm(Model model) {
		Student student = new Student();
		model.addAttribute("student", student);
		model.addAttribute("pageTitle", "Update a Student");
		return "update-student-form";
	}

	@PostMapping("/saveStudent")
	public String saveStudent(@ModelAttribute("student") Student student) {
		
		Authorities authorities = new Authorities();
		
		PasswordEncoder encoder = new BCryptPasswordEncoder(10);

		//apo8hkeuw thn eggrafh ston pinaka student

	    student.setPassword(encoder.encode(student.getPassword()));//kanw thn kruptografish tou do8entws kwdikou apo ton xrhsth
		  
	    studentDAO.saveStudent(student);
	    
		//dhmiourgw kai apo8hkeuw ston pinaka authorities ta stoixeia ths neas eggrafhs

	    authorities.setId(student.getId());
		authorities.setAuthority("ROLE_STUDENT");
		
		authoritiesDAO.saveAuthorities(authorities);
		
		Users users = new Users();
		//dhmiourgw mia eggrafh ston pinaka users, etsi wste na mporei na eisel8ei o xrhsths sto susthma

		users.setId(student.getId());
		users.setPassword(student.getPassword());
		users.setEnabled(student.getEnabled());
		
		usersDAO.saveUsers(users);

		return "redirect:/student/list";
	}

	@PostMapping("/updateStudent")
    @Transactional
    public String updateStudent(@ModelAttribute("student") Student student) {
        Session currentSession = sessionFactory.getCurrentSession();


        PasswordEncoder encoder = new BCryptPasswordEncoder(10);

        student.setPassword(encoder.encode(student.getPassword()));

        studentDAO.saveStudent(student);

        Users users = new Users();

        //dhmiourgw mia eggrafh ston pinaka users, etsi wste na mporei na eisel8ei o xrhsths sto susthma
        users.setId(student.getId());
        users.setPassword(student.getPassword());
        users.setEnabled(student.getEnabled());

        currentSession.update(users);


        return "redirect:/student/list";
    }

	@RequestMapping("/list")
	public String listStudents(Model model) {

		List<Student> students = studentDAO.getStudents();
		model.addAttribute("students", students);
		
		return "list-students";
	}
	

	@GetMapping("/deleteStudent/{id}")
	public String deleteStudent(Model model, @PathVariable("id") int id) {
			
		studentDAO.deleteStudent(id);
		
		authoritiesDAO.deleteAuthority(id);
		
		usersDAO.deleteUsers(id);
		
		return "redirect:/student/list";
	}
	
	
	//h grammateia dhlwnei ean o ma8hths mporei h oxi na kanei aithsh me bash ta krithria
	@GetMapping("/able/{id}")
	@Transactional
	public String Able(Model model, @PathVariable("id") int id) {
		Student student = new Student();
		
		//brhskw ton ma8hth me to id pou dw8hke
		student = studentDAO.getStudent(id);
		
		//allazw thn timh tou enabled apo 0 se 1 ka8ws o ma8hths mporei pleon na kanei aithsh
		student.setEnabled(1);
		
		Users users = new Users();
		
		//allazw kai thn timh ston pinaka users
		users = usersDAO.getUsers(student.getId());
		users.setEnabled(1);
		
		//apo8hkeuw tis allages
		usersDAO.saveUsers(users);
		studentDAO.saveStudent(student);
		
		
		
		return "redirect:/student/list";
	}

}
