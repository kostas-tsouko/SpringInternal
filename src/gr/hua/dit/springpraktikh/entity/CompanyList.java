package gr.hua.dit.springpraktikh.entity;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

import org.springframework.stereotype.Component;

@XmlRootElement(name="CompanyList")
@Component
public class CompanyList {
List<Company> companyList;
	
	public List<Company> getCompanyList(){
		return companyList; 
	}
	
	public void setCompanyList(List<Company> companyList) {
		this.companyList=companyList;
	}
}
