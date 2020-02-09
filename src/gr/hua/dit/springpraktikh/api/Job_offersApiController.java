package gr.hua.dit.springpraktikh.api;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import gr.hua.dit.springpraktikh.Service.CompanyService;
import gr.hua.dit.springpraktikh.Service.Job_offersService;
import gr.hua.dit.springpraktikh.entity.Company;
import gr.hua.dit.springpraktikh.entity.Job_offers;
import gr.hua.dit.springpraktikh.entity.Job_offersList;
import gr.hua.dit.springpraktikh.entity.Office;
import gr.hua.dit.springpraktikh.entity.OfficeList;
import gr.hua.dit.springpraktikh.entity.StudentApplications;
import gr.hua.dit.springpraktikh.entity.StudentApplicationsList;

@RestController
@RequestMapping("/api/job_offers")
public class Job_offersApiController {

	@Autowired
	private Job_offersService job_offersService;

	@Autowired
	private SessionFactory sessionFactory;

	@Autowired
	private Job_offersList job_offersList;

	@Autowired
	private CompanyService companyService;

	@RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = { "application/json", "application/xml" })
	public Job_offers getJob_offer(@PathVariable("id") int id) {

		Job_offers job_offers = job_offersService.getJob_offer(id);
		System.out.println("job_offers :" + job_offers);

		return job_offers;
	}

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE, produces = { "application/json",
			"application/xml" })
	public ResponseEntity deleteJob_offer(@PathVariable("id") int id) {
		job_offersService.deleteJob_offer(id);
		return new ResponseEntity(HttpStatus.OK);
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST, produces = { "application/json", "application/xml" })
	public Job_offers createJob_offers(@RequestParam("company_name") String companyName,
			@RequestParam("job_name") String jobName, @RequestParam("available_positions") int availablePositions,
			@RequestParam("job_description") String jobDescription) {

		// add the given information from parameters to the object
		Job_offers job_offer = new Job_offers();
		job_offer.setCompanyName(companyName);
		job_offer.setJobName(jobName);
		job_offer.setAvailablePositions(availablePositions);
		job_offer.setJobDescription(jobDescription);
		job_offer.setEnabled(0);

		// save the job offer
		job_offersService.saveJob_offers(job_offer);
		return job_offer;

	}

	@RequestMapping(value = "/update", method = RequestMethod.POST, produces = { "application/json",
			"application/xml" })
	@Transactional
	public Job_offers updateJob_offers(@RequestParam("id") int id, @RequestParam("company_name") String companyName,
			@RequestParam("job_name") String jobName, @RequestParam("available_positions") int availablePositions,
			@RequestParam("job_description") String jobDescription) {
		Session currentSession = sessionFactory.getCurrentSession();// get the current session

		// add the given information from parameters to the object
		Job_offers job_offer = new Job_offers();
		job_offer.setId(id);
		job_offer.setCompanyName(companyName);
		job_offer.setJobName(jobName);
		job_offer.setAvailablePositions(availablePositions);
		job_offer.setJobDescription(jobDescription);
		job_offer.setEnabled(0);

		// update the job offer
		currentSession.update(job_offer);
		return job_offer;

	}

	@RequestMapping(value = "/jsonadd", method = RequestMethod.POST, produces = { "application/json",
			"application/xml" })
	public Job_offers createJob_offersfromJson(@RequestBody Job_offers job_offer) {
		job_offersService.saveJob_offers(job_offer);
		return job_offer;
	}

	@RequestMapping(value = "/offersforcompanies", method = RequestMethod.GET, produces = { "application/json",
			"application/xml" })
	public Job_offersList getOffersList() {

		// get the credentials of the user
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String username = ((UserDetails) principal).getUsername();
		int id = Integer.parseInt(username);
		System.out.println(username);

		// get the info of the logged in company
		Company company = new Company();
		company = companyService.getCompany(id);

		// get the job offers made by the user
		List<Job_offers> tempJobOffer = job_offersService.getJob_offers();
		Job_offers tempjoboffers = new Job_offers();
		List<Job_offers> jobOffers = new ArrayList<Job_offers>();

		for (int i = 0; i < tempJobOffer.size(); i++) {

			if (tempJobOffer.get(i).getCompanyName().equals(company.getCompany_name())) {
				//if we find a job offer that matches our criteria, get that offer
				tempjoboffers = tempJobOffer.get(i);
				//add the job offer to our temporary list
				jobOffers.add(tempjoboffers);
			}

		}
		//return all the job offers made by the user
		this.job_offersList.setJob_offersList(jobOffers);
		return this.job_offersList;
	}
}
