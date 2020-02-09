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
import gr.hua.dit.springpraktikh.dao.CompanyDAO;
import gr.hua.dit.springpraktikh.dao.UsersDAO;
import gr.hua.dit.springpraktikh.entity.Authorities;
import gr.hua.dit.springpraktikh.entity.Company;
import gr.hua.dit.springpraktikh.entity.Student;
import gr.hua.dit.springpraktikh.entity.Users;

@Controller
@RequestMapping("/company")
public class CompanyController {
	
	@Autowired
	private CompanyDAO companyDAO;
	
	@Autowired
	private AuthoritiesDAO authoritiesDAO;
	
	@Autowired
	private UsersDAO usersDAO;
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@GetMapping("/addCompany")
	public String showAddForm(Model model) {
		// ftiaxnw ena  model attribute gia na parw ta dedomena pou hr8an apo thn forma
		Company company = new Company();
		model.addAttribute("company", company);

		// add page title
		model.addAttribute("pageTitle", "Add a Student");
		return "company-form";											
	}
	
	@GetMapping("/updateCompanyList")
	public String showUpdateForm(Model model) {
		Company company = new Company();
		model.addAttribute("company", company);
		model.addAttribute("pageTitle", "Update a Company");
		return "update-company-form";									
	}
	
	@PostMapping("/saveCompany")
	public String saveStudent(@ModelAttribute("company") Company company) {
		
		Authorities authorities = new Authorities();
		
		PasswordEncoder encoder = new BCryptPasswordEncoder(10);

		//apo8hkeuw thn eggrafh ston pinaka company
		company.setPassword(encoder.encode(company.getPassword()));//kanw thn kruptografish tou do8entws kwdikou apo ton xrhsth
		company.setEnabled(1);
		  
		companyDAO.saveCompany(company);
	    
		//dhmiourgw kai apo8hkeuw ston pinaka authorities ta stoixeia ths neas eggrafhs

	    authorities.setId(company.getId());
		authorities.setAuthority("ROLE_COMPANY");
		
		authoritiesDAO.saveAuthorities(authorities);
		
		//dhmiourgw mia eggrafh ston pinaka users, etsi wste na mporei na eisel8ei o xrhsths sto susthma
		Users users = new Users();
		
		users.setId(company.getId());
		users.setPassword(company.getPassword());
		users.setEnabled(company.getEnabled());
		
		usersDAO.saveUsers(users);

		return "redirect:/company/list";								
	}
	
	@PostMapping("/updateCompany")
    @Transactional
    public String updateCompany(@ModelAttribute("company") Company company) {
        Session currentSession = sessionFactory.getCurrentSession();


        PasswordEncoder encoder = new BCryptPasswordEncoder(10);


        company.setPassword(encoder.encode(company.getPassword()));

        companyDAO.saveCompany(company);

        Users users = new Users();

        //dhmiourgw mia eggrafh ston pinaka users, etsi wste na mporei na eisel8ei o xrhsths sto susthma
        users.setId(company.getId());
        users.setPassword(company.getPassword());
        users.setEnabled(company.getEnabled());

        currentSession.update(users);


        return "redirect:/company/list";
    }
	@RequestMapping("/list")
	public String listCompanies(Model model) {

		List<Company> companies = companyDAO.getCompanies();
		model.addAttribute("companies", companies);
		
		return "list-companies";												
	}
	

	@GetMapping("/deleteCompany/{id}")
	public String deleteCompany(Model model, @PathVariable("id") int id) {
		
		//efoswn diagrafetai h eggrafh apo ton pinaka company, diagrafw kai thn eggrafh apo ton pinaka authorities kai users
		companyDAO.deleteCompany(id);
		
		authoritiesDAO.deleteAuthority(id);
		
		usersDAO.deleteUsers(id);
		
		return "redirect:/company/list";									
	}
	
}
