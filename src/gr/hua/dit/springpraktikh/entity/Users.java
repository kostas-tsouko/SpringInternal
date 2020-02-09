package gr.hua.dit.springpraktikh.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "Users")
@Entity
@Table(name = "users")
public class Users {

	
	@Id
	@Column(name = "id")
	private int id;
	
	@Column(name = "password")
	private String password;
	
	@Column(name = "enabled")
	private Integer enabled;


	public Users() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Users(int id, String password, Integer enabled) {
		super();
		this.id = id;
		this.password = password;
		this.enabled = enabled;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	@Override
	public String toString() {
		return "Users [id=" + id + ", password=" + password + ", enabled=" + enabled + "]";
	}

	
	

	
	
}
