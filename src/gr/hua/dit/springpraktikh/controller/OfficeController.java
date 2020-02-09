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
import gr.hua.dit.springpraktikh.dao.OfficeDAO;
import gr.hua.dit.springpraktikh.dao.UsersDAO;
import gr.hua.dit.springpraktikh.entity.Authorities;
import gr.hua.dit.springpraktikh.entity.Office;
import gr.hua.dit.springpraktikh.entity.Student;
import gr.hua.dit.springpraktikh.entity.Users;

@Controller
@RequestMapping("/office")
public class OfficeController {
	
	@Autowired
	private OfficeDAO officeDAO;
	
	@Autowired
	private AuthoritiesDAO authoritiesDAO;
	
	@Autowired
	private UsersDAO usersDAO;

	@Autowired
	private SessionFactory sessionFactory;
	
	@GetMapping("/addOffice")
	public String showAddForm(Model model) {
		Office office = new Office();
		model.addAttribute("office", office);

		model.addAttribute("pageTitle", "Add an Office");
		return "office-form";
	}
	
	@GetMapping("/updateOfficeList")
	public String showUpdateForm(Model model) {
		Office office = new Office();
		model.addAttribute("office", office);

		model.addAttribute("pageTitle", "Update an office");
		return "update-office-form";
	}
	
	@PostMapping("/saveOffice")
	public String saveOffice(@ModelAttribute("office") Office office) {
		
		
		PasswordEncoder encoder = new BCryptPasswordEncoder(10);

		//apo8hkeuw thn eggrafh ston pinaka office
	    office.setPassword(encoder.encode(office.getPassword()));//kanw thn kruptografish tou do8entws kwdikou apo ton xrhsth
		  
	    officeDAO.saveOffice(office);
	    
	    
	    
		Authorities authorities = new Authorities();

		//dhmiourgw kai apo8hkeuw ston pinaka authorities ta stoixeia ths neas eggrafhs
	    authorities.setId(office.getId());
		authorities.setAuthority("ROLE_OFFICE");
		
		authoritiesDAO.saveAuthorities(authorities);
		
		Users users = new Users();
		
		//dhmiourgw mia eggrafh ston pinaka users, etsi wste na mporei na eisel8ei o xrhsths sto susthma
		users.setId(office.getId());
		users.setPassword(office.getPassword());
		users.setEnabled(office.getEnabled());
		
		usersDAO.saveUsers(users);

		return "redirect:/office/list";
	}
	
	@PostMapping("/updateOffice")
    @Transactional
    public String updateOffice(@ModelAttribute("office") Office office) {
        Session currentSession = sessionFactory.getCurrentSession();


        PasswordEncoder encoder = new BCryptPasswordEncoder(10);

        office.setPassword(encoder.encode(office.getPassword()));



        officeDAO.saveOffice(office);

        Users users = new Users();

        //dhmiourgw mia eggrafh ston pinaka users, etsi wste na mporei na eisel8ei o xrhsths sto susthma
        users.setId(office.getId());
        users.setPassword(office.getPassword());
        users.setEnabled(office.getEnabled());

        currentSession.update(users);
        return "redirect:/office/list";
    }
	
	@RequestMapping("/list")
	public String listOffices(Model model) {

		// get Office from the service
		List<Office> offices = officeDAO.getOffices();

		// add the Office to the model
		model.addAttribute("offices", offices);
		


		return "list-offices";
	}
	
	@GetMapping("/deleteOffice/{id}")
	public String deleteOffice(Model model, @PathVariable("id") int id) {
		
		//efoswn diagrafetai h eggrafh apo ton pinaka company, diagrafw kai thn eggrafh apo ton pinaka authorities kai users
		officeDAO.deleteOffice(id);
		
		authoritiesDAO.deleteAuthority(id);
		
		usersDAO.deleteUsers(id);
		
		return "redirect:/office/list";
	}
}
