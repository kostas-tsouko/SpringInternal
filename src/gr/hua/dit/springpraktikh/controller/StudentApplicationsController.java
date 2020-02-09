package gr.hua.dit.springpraktikh.controller;

import java.util.ArrayList;
import java.util.List;
import javax.transaction.Transactional;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import gr.hua.dit.springpraktikh.dao.CompanyDAO;
import gr.hua.dit.springpraktikh.dao.Job_offersDAO;
import gr.hua.dit.springpraktikh.dao.StudentApplicationsDAO;
import gr.hua.dit.springpraktikh.dao.StudentDAO;
import gr.hua.dit.springpraktikh.entity.Company;
import gr.hua.dit.springpraktikh.entity.Job_offers;
import gr.hua.dit.springpraktikh.entity.Student;
import gr.hua.dit.springpraktikh.entity.StudentApplications;

@Controller
@RequestMapping("/stdapps")									
public class StudentApplicationsController {
	

	@Autowired
	private StudentApplicationsDAO studentapplicationsDAO;
	
	@Autowired
	private StudentDAO studentDAO;
	
	@Autowired
	private CompanyDAO companyDAO;
	
	@Autowired Job_offersDAO job_offersDAO;
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@GetMapping("/addStdapp")
	@Transactional
	//pairnw kai stelnw dedomena apo thn forma 
	public String showAddForm(Model model1, Model model2) {
		
		//pairnw ta stoixeia tou xrhsth kai ton brhskw
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String username = ((UserDetails)principal).getUsername();
		int id = Integer.parseInt(username);
		System.out.println(username);
		Student student = new Student();
		student = studentDAO.getStudent(id);
		System.out.println(student);
		
		//ean o ma8hths mporei na kanei aithsh
		if(student.getEnabled()== 1) {
			
			StudentApplications Studentapplications = new StudentApplications();
			model1.addAttribute("Studentapplications", Studentapplications);
			model1.addAttribute("pageTitle", "Add an Add an std app");			
			
			//pairnw tis aithseis twn etairiwn pou exoun eggri8ei apo thn grammateia kai tis emfanizw ston ma8hth
			List<Job_offers> job_offers = job_offersDAO.getJob_offers();
			model2.addAttribute("job_offers", job_offers);
			
			return "stdapp-form";
		}else {
			//epistrofh mhnumatws la8ous ean o ma8hths den mporei na kanei aithsh
			return "stdapp-error";
		}
		

	}
	
	@RequestMapping("/list")
	public String listStdapps(Model model) {

		List<StudentApplications> studentApplications = studentapplicationsDAO.getStdApps();
		model.addAttribute("studentApplications", studentApplications);
		
		return "list-stdapps";
	}
	
	@PostMapping("/saveStdapps")
	@Transactional
	public String saveStdApps(@ModelAttribute("Studentapplications") StudentApplications Studentapplications) {
		Session currentSession = sessionFactory.getCurrentSession();

		//pairnw ta stoixeia tou xrhsth kai ton brhskw

		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String username = ((UserDetails)principal).getUsername();
		int id = Integer.parseInt(username);
		System.out.println(username);
		Student student = new Student();
		student = studentDAO.getStudent(id);

		
		//sumplhrwnw automata ta stoixeia tou xrhsth gia auton, etsi wste o xrhsths na xreiastei na sumplhrwsei sthn forma
		//mono ta stoixeia ths etairias pou ton endiaferei
		Studentapplications.setId(student.getId());
		Studentapplications.setFirstName(student.getFirstName());
		Studentapplications.setLastName(student.getLastName());
		Studentapplications.setEmail(student.getEmail());
		Studentapplications.setResume(student.getResume());
		
		//8etw automata to enabled ths aithshs tou ma8hth me mhden, ka8ws h etairia 8a prepei na eggrinei h oxi thn aithsh tou
		Studentapplications.setEnabled(0);
		
		currentSession.save(Studentapplications);    
	    
		//aferw to dikaiwma ston ma8hth na kanei allh aithsh, ka8ws ekane molis mia
	    student.setEnabled(0);
	    
		return "redirect:/";
	}
	
	@GetMapping("/deleteStdapps/{id}")
	@Transactional
	public String deleteStdapps(Model model, @PathVariable("id") int id) {
			
		studentapplicationsDAO.deleteStdApps(id);
		
		return "redirect:/stdapps/listforcompanies";
	}
	
	@GetMapping("/accept/{id}")
	@Transactional
	public String accept(Model model, @PathVariable("id") int id) {
		Session currentSession = sessionFactory.getCurrentSession();

		StudentApplications studentApplications = new StudentApplications();
		
		//briskw thn aitoumenh aithsh apo thn etairia kai 8etw thn timh ths se 1, to opoio shmainei pws h etairia apodexthke thn aithsh tou ma8hth
		studentApplications = studentapplicationsDAO.getStdApps(id);
		
		studentApplications.setEnabled(1);
		
		currentSession.update(studentApplications);
		
		
		
		return "redirect:/stdapps/listforcompanies";
	}
	
	@GetMapping("/deny/{id}")
	@Transactional
	public String deny(Model model, @PathVariable("id") int id) {
		Session currentSession = sessionFactory.getCurrentSession();

		StudentApplications studentApplications = new StudentApplications();
		
		studentApplications = studentapplicationsDAO.getStdApps(id);
		
		//h timh ths enabled=2 dhlwnei pws h aithsh aporrif8hke apo thn etairia
		studentApplications.setEnabled(2);
		
		currentSession.update(studentApplications);
		
		
		
		return "redirect:/stdapps/listforcompanies";
	}

	
	//edw ginetai h enfanish twn aithsewn apo tous ma8htes sthn etairia, kai h ka8e etairia blepei mono tis aithseis pou eginan
	//pros authn
	@RequestMapping("/listforcompanies")
	@Transactional
	public String listStdappsComps(Model model) {
		
		//pairnw ta stoixeia tou xrhsth kai ton brhskw
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String username = ((UserDetails)principal).getUsername();
		int id = Integer.parseInt(username);
		System.out.println(username);
		Company company = new Company();
		
		company = companyDAO.getCompany(id);


		List<StudentApplications> tempstudentApplications = studentapplicationsDAO.getStdApps();
		
		StudentApplications tempstdapps = new StudentApplications();
		
		List<StudentApplications> stdapps = new ArrayList<StudentApplications>();
		
		for(int i=0; i<tempstudentApplications.size();i++) {
			

			
			if(tempstudentApplications.get(i).getCompanyName().equals(company.getCompany_name())) {
				
				tempstdapps = tempstudentApplications.get(i);
				
				stdapps.add(tempstdapps);
				
				model.addAttribute("studentApplications", stdapps);
			}
			

		}

		return "list-stdapps";
	}
	
	//edw emfanizetai h aithsh pou exei kanei o ma8hths enw perimenei to apotelesma apo thn etairia
	@RequestMapping("/listforstudents")
	@Transactional
	public String listStdappsStds(Model model) {
		
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String username = ((UserDetails)principal).getUsername();
		int id = Integer.parseInt(username);
		System.out.println(username);
		Student student = new Student();
		student = studentDAO.getStudent(id);
		System.out.println(student);
		

		List<StudentApplications> tempstudentApplications = studentapplicationsDAO.getStdApps();
		
		StudentApplications tempstdapps = new StudentApplications();
		
		List<StudentApplications> stdapps = new ArrayList<StudentApplications>();
		
		for(int i=0; i<tempstudentApplications.size();i++) {
			
			
			System.out.println(tempstudentApplications.get(i).getCompanyName());

			
			if(tempstudentApplications.get(i).getId() == student.getId()) {
				
				
				tempstdapps = tempstudentApplications.get(i);
				
				stdapps.add(tempstdapps);
				
				model.addAttribute("studentApplications", stdapps);
			}
			

		}

		return "list-stdapps";
	}
}
