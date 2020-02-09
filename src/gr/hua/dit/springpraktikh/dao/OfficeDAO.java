package gr.hua.dit.springpraktikh.dao;

import java.util.List;

import gr.hua.dit.springpraktikh.entity.Job_offers;
import gr.hua.dit.springpraktikh.entity.Office;

public interface OfficeDAO {
	public List<Office> getOffices();

	public void saveOffice(Office office);
	
	public Office getOffice(int id);

	public void deleteOffice(int id);
}
