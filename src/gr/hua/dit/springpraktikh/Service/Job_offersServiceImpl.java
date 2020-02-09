package gr.hua.dit.springpraktikh.Service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import gr.hua.dit.springpraktikh.dao.Job_offersDAO;
import gr.hua.dit.springpraktikh.dao.OfficeDAO;
import gr.hua.dit.springpraktikh.entity.Job_offers;
import gr.hua.dit.springpraktikh.entity.Office;


@Service
public class Job_offersServiceImpl implements Job_offersService {
	// inject the CustomerDAO
				@Autowired
				private Job_offersDAO job_offersDAO;
				
				@Override
				@Transactional
				public List<Job_offers> getJob_offers(){
					return job_offersDAO.getJob_offers();
				}

				@Override
				@Transactional
				public void saveJob_offers(Job_offers office) {
					job_offersDAO.saveJob_offers(office);
				}

				@Override
				@Transactional
				public Job_offers getJob_offer(int id) {
					return job_offersDAO.getJob_offer(id);
				}

				@Override
				@Transactional
				public void deleteJob_offer(int id) {
					job_offersDAO.deleteJob_offer(id);
				}


}
