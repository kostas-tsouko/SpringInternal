package gr.hua.dit.springpraktikh.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import gr.hua.dit.springpraktikh.entity.Company;


@Repository
public class CompanyDAOImpl implements CompanyDAO {
	@Autowired
	private SessionFactory sessionFactory;
	
	
	@Override
	@Transactional
	public List<Company> getCompanies() {
		// get current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();

		// create a query
		Query<Company> query = currentSession.createQuery("from Company order by id", Company.class);

		// execute the query and get the results list
		List<Company> companies = query.getResultList();

		// return the results
		return companies;
	}

	@Override
	@Transactional
	public void saveCompany(Company company) {
		Session currentSession = sessionFactory.getCurrentSession();

		if (company.getId() != 0) {
			// update the Company
			currentSession.update(company);
		} else {
			// save the Company
			currentSession.save(company);
		}
	}

	@Override
	public Company getCompany(int id) {
		// get current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();

		// get and return Company
		Company company = currentSession.get(Company.class, id);
		return company;
	}

	@Override
	@Transactional
	public void deleteCompany(int id) {
		Session currentSession = sessionFactory.getCurrentSession();

		// find the Company
		Company company = currentSession.get(Company.class, id);

		// delete Company
		currentSession.delete(company);
	}

}
