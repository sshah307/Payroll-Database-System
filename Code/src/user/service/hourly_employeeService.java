package user.service;

import java.util.List;

import user.dao.hourly_employeeDao;
import user.domain.Hourly_employee;

public class hourly_employeeService {
private hourly_employeeDao hourly_employeeDao = new hourly_employeeDao();
	

	
	public void registhourly_employee(Hourly_employee form) throws UserException, ClassNotFoundException, InstantiationException, IllegalAccessException{
		
		// check the user name
		Hourly_employee hrs = hourly_employeeDao.findByHourly_ssn(form.gethourly_ssn());
		String hrsID = hrs.gethourly_ssn();
		String formID = form.gethourly_ssn();
		
		if(hrsID == formID)
			throw new UserException("This Employee ID has already been in your Database!");
		
		hourly_employeeDao.add(form);
	}
	

	public List<Object> findallHourly_employee() throws InstantiationException, IllegalAccessException, ClassNotFoundException{
		return hourly_employeeDao.findallHourly_employee();
		
	}
	
	
	
	public Hourly_employee findByHourly_ssn(String ssn) throws InstantiationException, IllegalAccessException, ClassNotFoundException{
		Hourly_employee finding = hourly_employeeDao.findByHourly_ssn(ssn);
		return finding;
	}
	
	
	
	
	public void updateHourly_employee(Hourly_employee hrs) throws InstantiationException, IllegalAccessException, ClassNotFoundException{
		hourly_employeeDao.updateHourly_employee(hrs);
		}
	
	public void deleteHourly_employee(Hourly_employee hrs) throws InstantiationException, IllegalAccessException, ClassNotFoundException{
		 hourly_employeeDao.deleteHourly_employee(hrs);
	}

	}