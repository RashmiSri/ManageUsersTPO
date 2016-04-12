package org.crce.interns.service;
import java.util.ArrayList;
import java.util.List;
import org.crce.interns.beans.UserBean;
import org.crce.interns.dao.ManageUsersDao;
import org.crce.interns.model.Company;
import org.crce.interns.model.User;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service("crudService")
@Transactional(propagation=Propagation.SUPPORTS, readOnly=true)
public class ManageUsersService {
	@Autowired
	private ManageUsersDao crudDao;
	public void createDetails(UserBean userBean){
		User user=new User();
		BeanUtils.copyProperties(userBean, user);
		System.out.println("Service "+user.getUsername()+user.getCompany_id());
		crudDao.createDetails(user);
	}
	
	@SuppressWarnings("unchecked")
	public List<User> retreiveDetails(String company){
		List<User> userList=new ArrayList<User>();
		userList.addAll(crudDao.retreiveDetails(company));
		return userList;
	}
	
	public List<Company> retrieveCompany_id(){
		List<Company> list=new ArrayList<Company>();
		list.addAll(crudDao.retrieveCompany_id());
		return list;
	}
	public void deleteDetails(UserBean userBean){
		User user=new User();
		BeanUtils.copyProperties(userBean, user);
		crudDao.deleteDetails(user);
	}

}
