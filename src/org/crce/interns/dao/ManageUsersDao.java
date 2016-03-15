package org.crce.interns.dao;
import java.util.ArrayList;
import java.util.List;

import org.crce.interns.model.User;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("crudDao")
public class ManageUsersDao {
	
	@Autowired
	private SessionFactory sessionFactory;
	Session session=null;
	Transaction tx=null;
	public void createDetails(User user){
		System.out.println("dao "+user.getUserName());
		session=this.sessionFactory.openSession();
		tx=session.beginTransaction();
		session.save(user);
		tx.commit();
		//sessionFactory.getCurrentSession().save(user);
		//sessionFactory.getCurrentSession().persist(user);
		//sessionFactory.getCurrentSession().saveOrUpdate(user);
		System.out.println("After sf");
		//session.save("User.class",user);
		//session.close();
	}
	
	@SuppressWarnings("unchecked")
	public List<User> retreiveDetails(String company){
		Criteria criteria=sessionFactory.getCurrentSession().createCriteria(User.class, company);
		List<User> list=new ArrayList<User>();
		List<User> userList=new ArrayList<User>();
		list.addAll(criteria.list());
		for(User d:list){
			if(d.getCompany().equals(company)) userList.add(d);
		}
		return userList;
	}
	
	public void deleteDetails(User user){
		User usr=(User) sessionFactory.getCurrentSession().get(User.class, user.getUserName());
		//Session session=sessionFactory.openSession();
		//session.delete(usr);
		session=this.sessionFactory.openSession();
		tx=session.beginTransaction();
		session.delete(usr);
		tx.commit();
		session.close();
	}

}
