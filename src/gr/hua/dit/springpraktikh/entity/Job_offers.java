package gr.hua.dit.springpraktikh.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "Job_offers")
@Entity
@Table(name = "job_offers")
public class Job_offers {

	private static final long serialVersionUID = 4310661683443846471L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
		
	@Column(name = "company_name")
	private String companyName;
	
	@Column(name = "job_name")
	private String jobName;

	@Column(name = "available_positions")
	private int availablePositions;
	
	@Column(name = "job_description")
	private String jobDescription;
	
	@Column(name = "enabled")
	private Integer enabled;

	public Job_offers() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Job_offers(int id, String companyName, String jobName, int availablePositions, String jobDescription,
			Integer enabled) {
		super();
		this.id = id;
		this.companyName = companyName;
		this.jobName = jobName;
		this.availablePositions = availablePositions;
		this.jobDescription = jobDescription;
		this.enabled = enabled;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getJobName() {
		return jobName;
	}

	public void setJobName(String jobName) {
		this.jobName = jobName;
	}

	public int getAvailablePositions() {
		return availablePositions;
	}

	public void setAvailablePositions(int availablePositions) {
		this.availablePositions = availablePositions;
	}

	public String getJobDescription() {
		return jobDescription;
	}

	public void setJobDescription(String jobDescription) {
		this.jobDescription = jobDescription;
	}

	public Integer getEnabled() {
		return enabled;
	}

	public void setEnabled(Integer enabled) {
		this.enabled = enabled;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "Job_offers [id=" + id + ", companyName=" + companyName + ", jobName=" + jobName
				+ ", availablePositions=" + availablePositions + ", jobDescription=" + jobDescription + ", enabled="
				+ enabled + "]";
	}


	
	
}
