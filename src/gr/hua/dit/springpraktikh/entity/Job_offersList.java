package gr.hua.dit.springpraktikh.entity;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

import org.springframework.stereotype.Component;

@XmlRootElement(name="Job_offersList")
@Component
public class Job_offersList {
	List<Job_offers> job_offersList;
	
	public List<Job_offers> getJob_offersList(){
		return job_offersList; 
	}
	
	public void setJob_offersList(List<Job_offers> job_offersList) {
		this.job_offersList=job_offersList;
	}
}
