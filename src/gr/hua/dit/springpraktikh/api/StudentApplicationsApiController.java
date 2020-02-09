package gr.hua.dit.springpraktikh.api;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import gr.hua.dit.springpraktikh.Service.CompanyService;
import gr.hua.dit.springpraktikh.Service.Job_offersService;
import gr.hua.dit.springpraktikh.Service.StudentApplicationsService;
import gr.hua.dit.springpraktikh.entity.Company;
import gr.hua.dit.springpraktikh.entity.Job_offers;
import gr.hua.dit.springpraktikh.entity.StudentApplications;
import gr.hua.dit.springpraktikh.entity.StudentApplicationsList;


@RestController
@RequestMapping("/api/StudentApplications")
public class StudentApplicationsApiController {
	
	@Autowired
	private StudentApplicationsService stdappService;

	@Autowired
	private StudentApplicationsList StdAppList;
	
	@Autowired
	private CompanyService companyService;
	
	@Autowired
	private Job_offersService job_offersService;

	@RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = { "application/json", "application/xml" })
	public StudentApplications getStdApps(@PathVariable("id") int id) {

		StudentApplications stdapp = stdappService.getStdApps(id);
		System.out.println("stdapp :" + stdapp);

		return stdapp;
	}
	
	@RequestMapping(value = "/all", method = RequestMethod.GET, produces = { "application/json", "application/xml" })
	public StudentApplicationsList getStdApps() {
		
		// get the credentials of the user
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String username = ((UserDetails)principal).getUsername();
		int id = Integer.parseInt(username);
		System.out.println(username);
		
		// get the info of the logged in company
		Company company = new Company();		
		company = companyService.getCompany(id);
		
		//get the applications that the company needs to proccess
		List<StudentApplications> tempstudentApplications = stdappService.getStdApps();	//make a temporary list	
		StudentApplications tempstdapps = new StudentApplications();		
		List<StudentApplications> stdapps = new ArrayList<StudentApplications>();//make the list that we are going to send
		
		
		for(int i=0; i<tempstudentApplications.size();i++) {
			
			System.out.println(tempstudentApplications.get(i).getCompanyName());

			
			if(tempstudentApplications.get(i).getCompanyName().equals(company.getCompany_name())) {
				//if we find an application that matches our criteria, get that application
				tempstdapps = tempstudentApplications.get(i);
				//add the application to our temporary list
				stdapps.add(tempstdapps);
			
			}
			

		}
		//send the list of applications
		this.StdAppList.setStdAppsList(stdapps);
		return this.StdAppList;
	}

	@RequestMapping(value = "/jsonadd", method = RequestMethod.POST,  produces = { "application/json", "application/xml" })
	public StudentApplications createStudentApplicationsfromJson(@RequestBody StudentApplications stdapp) {
		stdappService.saveStdApps(stdapp);
		return stdapp;
	}
	
	@RequestMapping(value = "/accept/{id}", method = RequestMethod.PUT,  produces = { "application/json", "application/xml" })
	public StudentApplications acceptStudentApplicationsfromJson(@PathVariable("id") int id) {
		
		
		//efoson exei ginei h epilogh ths aithshs apo thn etairia pernw thn sugkekrimenh aithsh
		StudentApplications studentApplications = new StudentApplications();
		
		Job_offers job_offer = new Job_offers();

		studentApplications = stdappService.getStdApps(id);
		
		//bazw to enabled=1, pou shmainei pws h etairia apodexthke authn thn aithsh
		studentApplications.setEnabled(1);
		
		int k = -1;
		
		// edw 8a meiwsw thn 8esh kata 1 apo to job offers, ka8ws egine h apodoxh enws ma8hth, opote oi 8eseis meiw8hkan kata mia
		List<Job_offers> job_offersList = job_offersService.getJob_offers();
		
		for(int i=0;i<job_offersList.size();i++) {

			
			if(job_offersList.get(i).getCompanyName().equals(studentApplications.getCompanyName()) && job_offersList.get(i).getJobName().equals(studentApplications.getJob())) {
				
				k=i;
				job_offer.setId(job_offersList.get(k).getId());
				job_offer.setCompanyName(job_offersList.get(k).getCompanyName());
				job_offer.setJobDescription(job_offersList.get(k).getJobDescription());
				job_offer.setJobName(job_offersList.get(k).getJobName());
				job_offer.setEnabled(job_offersList.get(k).getEnabled());
				job_offer.setAvailablePositions(job_offersList.get(k).getAvailablePositions()-1);
				job_offer.setEnabled(job_offersList.get(k).getEnabled());
				
				job_offersService.saveJob_offers(job_offer);
				
			}
		}

		stdappService.saveStdApps(studentApplications);
		
		return studentApplications;
	}
	
	// sto deny ginetai akribws h idia diadikasia me thn accept, omws edw den exoume meiwsh 8esewn ka8ws h aithsh aporriptetai
	@RequestMapping(value = "/deny/{id}", method = RequestMethod.PUT,  produces = { "application/json", "application/xml" })
	public StudentApplications denyStudentApplicationsfromJson(@PathVariable("id") int id) {
		
		StudentApplications studentApplications = new StudentApplications();
		
		studentApplications = stdappService.getStdApps(id);
		
		studentApplications.setEnabled(2);
		
		stdappService.saveStdApps(studentApplications);
		
		return studentApplications;
	}
	
	
	
}