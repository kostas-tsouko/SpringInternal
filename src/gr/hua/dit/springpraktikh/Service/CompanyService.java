package gr.hua.dit.springpraktikh.Service;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

import org.springframework.stereotype.Component;

import gr.hua.dit.springpraktikh.entity.Company;

@XmlRootElement(name="CompanyService")
@Component
public interface CompanyService {
	public List<Company> getCompanies();

	public void saveCompany(Company company);
	
	public Company getCompany(int id);

	public void deleteCompany(int id);
}
