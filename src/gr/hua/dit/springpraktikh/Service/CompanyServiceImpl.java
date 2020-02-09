package gr.hua.dit.springpraktikh.Service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import gr.hua.dit.springpraktikh.dao.CompanyDAO;
import gr.hua.dit.springpraktikh.dao.OfficeDAO;
import gr.hua.dit.springpraktikh.entity.Company;
import gr.hua.dit.springpraktikh.entity.Office;


@Service
public class CompanyServiceImpl implements CompanyService {
	// inject the CustomerDAO
				@Autowired
				private CompanyDAO companyDAO;
				
				@Override
				@Transactional
				public List<Company> getCompanies(){
					return companyDAO.getCompanies();
				}

				@Override
				@Transactional
				public void saveCompany(Company company) {
					companyDAO.saveCompany(company);
				}

				@Override
				@Transactional
				public Company getCompany(int id) {
					return companyDAO.getCompany(id);
				}

				@Override
				@Transactional
				public void deleteCompany(int id) {
					companyDAO.deleteCompany(id);
				}
}
