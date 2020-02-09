package gr.hua.dit.springpraktikh.dao;

import java.util.List;

import gr.hua.dit.springpraktikh.entity.Company;

public interface CompanyDAO {
	
	public List<Company> getCompanies();

	public void saveCompany(Company company);
	
	public Company getCompany(int id);

	public void deleteCompany(int id);
}
