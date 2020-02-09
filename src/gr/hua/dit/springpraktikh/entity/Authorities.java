package gr.hua.dit.springpraktikh.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "Authorities")
@Entity
@Table(name = "authorities")
public class Authorities {
	private static final long serialVersionUID = 4310661683443846471L;

	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Column(name = "authority")
	private String authority;

	public Authorities() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Authorities(int id, String authority) {
		super();
		this.id = id;
		this.authority = authority;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAuthority() {
		return authority;
	}

	public void setAuthority(String authority) {
		this.authority = authority;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "Authorities [id=" + id + ", authority=" + authority + "]";
	}
	
	
	
}
