package gr.hua.dit.springpraktikh.Service;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

import org.springframework.stereotype.Component;

import gr.hua.dit.springpraktikh.entity.Job_offers;
import gr.hua.dit.springpraktikh.entity.Office;

@XmlRootElement(name="Job_offersService")
@Component
public interface Job_offersService {
	public List<Job_offers> getJob_offers();

	public void saveJob_offers(Job_offers job_offers);
	
	public Job_offers getJob_offer(int id);

	public void deleteJob_offer(int id);
}
