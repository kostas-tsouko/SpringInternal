package gr.hua.dit.springpraktikh.entity;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

import org.springframework.stereotype.Component;

@XmlRootElement(name="OfficeList")
@Component
public class OfficeList {
List<Office> officeList;
	
	public List<Office> getStudentList(){
		return officeList; 
	}
	
	public void setOfficeList(List<Office> officeList) {
		this.officeList=officeList;
	}
}
