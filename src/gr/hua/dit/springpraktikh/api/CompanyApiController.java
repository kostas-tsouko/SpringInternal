package gr.hua.dit.springpraktikh.api;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import gr.hua.dit.springpraktikh.Service.AuthoritiesService;
import gr.hua.dit.springpraktikh.Service.CompanyService;
import gr.hua.dit.springpraktikh.Service.UsersService;
import gr.hua.dit.springpraktikh.entity.Authorities;
import gr.hua.dit.springpraktikh.entity.Company;
import gr.hua.dit.springpraktikh.entity.CompanyList;
import gr.hua.dit.springpraktikh.entity.Users;

@RestController
@RequestMapping("/api/company")
public class CompanyApiController {

	@Autowired
	private CompanyService companyService;

	@Autowired
	private AuthoritiesService authoritiesService;

	@Autowired
	private UsersService usersService;

	@Autowired
	private CompanyList companyList;

	@RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = { "application/json", "application/xml" })
	public Company getCompany(@PathVariable("id") int id) {

		Company company = companyService.getCompany(id);// get the company that matches the given id
		System.out.println("company :" + company);

		return company;
	}

	@RequestMapping(value = "/all", method = RequestMethod.GET, produces = { "application/json", "application/xml" })
	public CompanyList getCompanies() {

		// pairnw ta stoixeia tou xrhsth, kai ton briskw
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String username = ((UserDetails) principal).getUsername();
		int id = Integer.parseInt(username);
		System.out.println(username);

		// pairnw tis plhrofories ths etairias
		Company company = new Company();
		company = companyService.getCompany(id);
		List<Company> companyList = new ArrayList<Company>();
		companyList.add(company);

		// epistrefw thn etairia
		this.companyList.setCompanyList(companyList);
		return this.companyList;
	}

	@RequestMapping(value = "/jsonadd", method = RequestMethod.POST, produces = { "application/json",
			"application/xml" })
	public Company createCompanyfromJson(@RequestBody Company company) {
		companyService.saveCompany(company);
		return company;
	}

	//elegxw na dw an h etairia me ton sundiasmo tou dwsmenou kwdiko kai id uparxei
	@RequestMapping(value = "/exists", method = RequestMethod.POST, produces = { "application/json", "application/xml" })
	public boolean hash(@RequestParam("id") int id, @RequestParam("password") String password) {
		boolean exists;//h metablhth pou 8a mas dei3ei an h etairia pou psaxnoume uparxei (true uparxei, false den uparxei)
		PasswordEncoder encoder = new BCryptPasswordEncoder();
		Company company = new Company();
		company = companyService.getCompany(id);// briskw thn etairia me to dwsmeno id

		exists = encoder.matches(password, company.getPassword());//elegxw an o dw8hsas kwdikos kai o kruptografimenos kwdikos tairiazoun
		return exists;

	}
}
