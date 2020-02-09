package gr.hua.dit.springpraktikh.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "Student")
@Entity
@Table(name = "student")
public class Student {
	
	private static final long serialVersionUID = 4310661683443846471L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Column(name = "first_name")
	private String firstName;
	
	@Column(name = "last_name")
	private String lastName;
	
	@Column(name = "email")
	private String email;
	
	@Column(name = "semester")
	private int semester;
	
	@Column(name = "subjects_owned")
	private int subjects_owned;
	
	@Column(name = "resume")
	private String resume;
	
	@Column(name = "username")
	private String username;
	
	@Column(name = "password")
	private String password;
	
	@Column(name = "enabled")
	private Integer enabled;

	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Student(int id, String firstName, String lastName, String email, int semester, int subjects_owned,
			String resume, String username, String password, Integer enabled) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.semester = semester;
		this.subjects_owned = subjects_owned;
		this.resume = resume;
		this.username = username;
		this.password = password;
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

	public int getSemester() {
		return semester;
	}

	public void setSemester(int semester) {
		this.semester = semester;
	}

	public int getSubjects_owned() {
		return subjects_owned;
	}

	public void setSubjects_owned(int subjects_owned) {
		this.subjects_owned = subjects_owned;
	}

	public String getResume() {
		return resume;
	}

	public void setResume(String resume) {
		this.resume = resume;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
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
		return "Student [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
				+ ", semester=" + semester + ", subjects_owned=" + subjects_owned + ", resume=" + resume + ", username="
				+ username + ", password=" + password + ", enabled=" + enabled + "]";
	}


	
	

}
