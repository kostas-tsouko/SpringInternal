package gr.hua.dit.springpraktikh.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "StudentApplications")
@Entity
@Table(name = "student_applications")
public class StudentApplications {
		
	@Id
	@Column(name = "id")
	private int id;
	
	@Column(name = "first_name")
	private String firstName;
	
	@Column(name = "last_name")
	private String lastName;
	
	@Column(name = "email")
	private String email;
	
	@Column(name = "resume")
	private String resume;
	
	@Column(name = "job")
	private String job;
	
	@Column(name = "Company_name")
	private String companyName;
	
	@Column(name = "enabled")
	private int enabled;

	public StudentApplications() {
		super();
		// TODO Auto-generated constructor stub
	}

	public StudentApplications(int id, String firstName, String lastName, String email, String resume, String job,
			String companyName, int enabled) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.resume = resume;
		this.job = job;
		this.companyName = companyName;
		this.enabled = enabled;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getResume() {
		return resume;
	}

	public void setResume(String resume) {
		this.resume = resume;
	}

	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public int getEnabled() {
		return enabled;
	}

	public void setEnabled(int enabled) {
		this.enabled = enabled;
	}

	@Override
	public String toString() {
		return "StudentApplications [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", email="
				+ email + ", resume=" + resume + ", job=" + job + ", companyName=" + companyName + ", enabled="
				+ enabled + "]";
	}



	

}



