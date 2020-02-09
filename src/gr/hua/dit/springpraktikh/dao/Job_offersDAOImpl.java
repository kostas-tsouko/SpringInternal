package gr.hua.dit.springpraktikh.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import gr.hua.dit.springpraktikh.entity.Job_offers;
import gr.hua.dit.springpraktikh.entity.Office;


@Repository
public class Job_offersDAOImpl implements Job_offersDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	@Transactional
	public List<Job_offers> getJob_offers() {
		Session currentSession = sessionFactory.getCurrentSession();

		// create a query
		Query<Job_offers> query = currentSession.createQuery("from Job_offers order by id", Job_offers.class);

		// execute the query and get the results list
		List<Job_offers> job_offers = query.getResultList();

		// return the results
		return job_offers;
	}

	@Override
	//@Transactional
	public void saveJob_offers(Job_offers job_offers) {
		Session currentSession = sessionFactory.getCurrentSession();

		if (job_offers.getId() != 0) {
			currentSession.update(job_offers);
		} else {
			currentSession.save(job_offers);
		}
	}

	@Override
	public Job_offers getJob_offer(int id) {
		Session currentSession = sessionFactory.getCurrentSession();

		Job_offers job_offer = currentSession.get(Job_offers.class, id);
		return job_offer;
	}

	@Override
	@Transactional
	public void deleteJob_offer(int id) {
		
		Session currentSession = sessionFactory.getCurrentSession();

		Job_offers job_offers = currentSession.get(Job_offers.class, id);

		currentSession.delete(job_offers);

	}
}

