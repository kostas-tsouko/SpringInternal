package gr.hua.dit.springpraktikh.controller;

import java.util.List;
import javax.transaction.Transactional;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import gr.hua.dit.springpraktikh.dao.AuthoritiesDAO;
import gr.hua.dit.springpraktikh.dao.Job_offersDAO;
import gr.hua.dit.springpraktikh.dao.StudentApplicationsDAO;
import gr.hua.dit.springpraktikh.dao.StudentDAO;
import gr.hua.dit.springpraktikh.dao.UsersDAO;
import gr.hua.dit.springpraktikh.entity.Job_offers;

@Controller
@RequestMapping("/job_offers")
public class Job_offersController {

	@Autowired
	private Job_offersDAO job_offersDAO;

	@Autowired
	private SessionFactory sessionFactory;
	
	@GetMapping("/addJob_offers")
	public String showAddForm(Model model) {
		Job_offers job_offers = new Job_offers();
		model.addAttribute("job_offers", job_offers);

		model.addAttribute("pageTitle", "Add an Office");
		return "job-offers-form";									
	}
	
	@GetMapping("/updatejob_offersList")
	public String showUpdateForm(Model model) {
		Job_offers job_offers = new Job_offers();
		model.addAttribute("job_offers", job_offers);

		model.addAttribute("pageTitle", "Update a job offer");
		return "update-job_offers-form";							
	}
	
	@PostMapping("/saveJob_offers")
	@Transactional
	public String saveJob_offers(@ModelAttribute("job_offers") Job_offers job_offers) {
		
		Session currentSession = sessionFactory.getCurrentSession();

		System.out.println(job_offers.getEnabled());
		
		//ean den uparxei timh sthn enabled, shmainei oti h apo8hkeush exei ginei apo thn etairia, opote h timh enabled
		//h opoia deixnei an h aithsh exei ginei apodexth h oxi apo thn grammateia einai 0(dhladh den thn exei apodextei, akoma)
		if(job_offers.getEnabled()==null) {
			job_offers.setEnabled(0);
		}
		

	    currentSession.save(job_offers);   

		return "redirect:/job_offers/list";
	}
	
	@PostMapping("/updateJob_offers")
	@Transactional
	public String updateJob_offers(@ModelAttribute("job_offers") Job_offers job_offers) {
		Session currentSession = sessionFactory.getCurrentSession();

		if(job_offers.getEnabled()==null) {
		job_offers.setEnabled(0);
		}
		  
	    currentSession.update(job_offers);   
	    

		return "redirect:/job_offers/list";
	}
	
	@RequestMapping("/list")
	public String listJob_offers(Model model) {

		List<Job_offers> job_offers = job_offersDAO.getJob_offers();

		model.addAttribute("job_offers", job_offers);
		

		
		return "list-job_offers";																				
	}
	
	@GetMapping("/deleteJob_offers/{id}")
	public String deleteJob_offers(Model model, @PathVariable("id") int id) {
			
		job_offersDAO.deleteJob_offer(id);
		

		return "redirect:/job_offers/list";
	}
	
	@GetMapping("/accepted/{id}")
	@Transactional
	public String Accepted(Model model, @PathVariable("id") int id) {
		
		Job_offers job_offers = new Job_offers();
		
		job_offers = job_offersDAO.getJob_offer(id);
		
		job_offers.setEnabled(1);
		
		job_offersDAO.saveJob_offers(job_offers);
		
		
		
		return "redirect:/job_offers/list";
	}
}
