package org.crce.interns.service;
import java.util.ArrayList;
import java.util.List;

import org.crce.interns.dao.ManageUsersDao;
import org.crce.interns.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service("crudService")
@Transactional(propagation=Propagation.SUPPORTS, readOnly=true)
public class ManageUsersService {
	@Autowired
	private ManageUsersDao crudDao;
	public void createDetails(User user){
		System.out.println("Service "+user.getUserName());
		crudDao.createDetails(user);
		//sessionFactory.getCurrentSession().save(user);
	}
	
	@SuppressWarnings("unchecked")
	public List<User> retreiveDetails(String company){
		List<User> userList=new ArrayList<User>();
		userList.addAll(crudDao.retreiveDetails(company));
		return userList;
	//	Criteria criteria=sessionFactory.getCurrentSession().createCriteria(User.class);
		//return criteria.list();
	}
	
	public void deleteDetails(User user){
		crudDao.deleteDetails(user);
		//User usr=(User) sessionFactory.getCurrentSession().get(User.class, user.getUserName());
		//Session session=sessionFactory.openSession();
		//session.delete(usr);
	}

}
