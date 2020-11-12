package user.service;

import java.util.List;

import user.dao.employeeDao;
import user.domain.Employee;


public class EmployeeService {
	private employeeDao employeeDao = new employeeDao();
	
	
	public void registEmployee(Employee form) throws UserException, ClassNotFoundException, InstantiationException, IllegalAccessException{
		
		Employee empl = employeeDao.findByEmployeeID(form.getEmployee_id());
		int emplID = empl.getEmployee_id();
		int formID = form.getEmployee_id();
		
		if(emplID == formID)
			throw new UserException("This Employee ID has already been in your Database!");
		
		employeeDao.addEmployee(form);
	}
	
	public void updateEmployee(Employee empl) throws InstantiationException, IllegalAccessException, ClassNotFoundException{
		employeeDao.updateEmployee(empl);
	}

	
	public void deleteEmployee(Employee empl) throws InstantiationException, IllegalAccessException, ClassNotFoundException{
		employeeDao.deleteEmployee(empl);	
	}
	
	public List<Object> findallEmployee() throws InstantiationException, IllegalAccessException, ClassNotFoundException{
		return employeeDao.findallEmployee();
		
	}
	
	public Employee findByEmployeeID(int id) throws InstantiationException, IllegalAccessException, ClassNotFoundException{
		Employee finding = employeeDao.findByEmployeeID(id);
		return finding;
	}
}