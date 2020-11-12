package user.service;

import java.util.List;

import user.dao.CompanyDao;
import user.domain.Company;


public class CompanyService {
	private CompanyDao companyDao = new CompanyDao();
	

	public void registCompany(Company form) throws UserException, ClassNotFoundException, InstantiationException, IllegalAccessException{
		
		
		Company comp = companyDao.findByCompanyID(form.getId());
		int compID = comp.getId();
		int formID = form.getId();
		
		if(compID == formID)
			throw new UserException("This Company ID has already been in your Database!");
		
		companyDao.addCompany(form);
	}
	
	public void updateCompany(Company comp) throws InstantiationException, IllegalAccessException, ClassNotFoundException{
		companyDao.updateCompany(comp);

	}
	
	public void deleteCompany(Company comp) throws InstantiationException, IllegalAccessException, ClassNotFoundException{
		companyDao.deleteCompany(comp);

	}
 
	public List<Object> findallCompany() throws InstantiationException, IllegalAccessException, ClassNotFoundException{
		return companyDao.findallCompany();
		
	}

	
	public Company findByCompanyID(int id) throws InstantiationException, IllegalAccessException, ClassNotFoundException{
		Company finding = companyDao.findByCompanyID(id);
		return finding;
	}

}