package org.crce.interns.dao;
import java.util.ArrayList;
import java.util.List;

import org.crce.interns.model.Company;
import org.crce.interns.model.User;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("crudDao")
public class ManageUsersDao {
	
	@Autowired
	private SessionFactory sessionFactory;
	Session session=null;
	Transaction tx=null;
	public void createDetails(User user){
		System.out.println("dao "+user.getUsername());
		session=this.sessionFactory.openSession();
		Company cpny=new Company(); 
		Company cmpny=new Company();
		cpny.setCompany_id(user.getCompany_id());
		System.out.println(cpny.getCompany_id());
		cmpny=(Company) sessionFactory.getCurrentSession().get(Company.class, cpny.getCompany_id());
		user.setCompany(cmpny.getCompany_name());
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
		System.out.println("company= "+company);
		session=this.sessionFactory.openSession();
		tx=session.beginTransaction();
		Criteria criteria=session.createCriteria(User.class);

	//	Criteria criteria=sessionFactory.getCurrentSession().createCriteria(User.class);
		System.out.println("company= "+company);
		//criteria.add(Restrictions.gt("company_id",company));
		System.out.println("company= "+company);
		List<User> list=new ArrayList<User>();
		//List<User> list=new ArrayList<User>();
		list.addAll(criteria.list());
		List<User> userList=new ArrayList<User>();
		for(User d:list){
			if(d.getCompany_id().equals(company)) userList.add(d);
			System.out.println(d.getUsername()+" "+d.getCompany_id());
	}
		tx.commit();
		session.close();
		
		return userList;
	}
	
	public List<Company> retrieveCompany_id(){
		List<Company> list=new ArrayList<Company>();
		session=this.sessionFactory.openSession();
		tx=session.beginTransaction();
		Criteria criteria=session.createCriteria(Company.class);
		list.addAll(criteria.list());
		return list;
	}
	public void deleteDetails(User user){
		
		User user1=new User();
		//User user2=new User();
		//user.setUsername(name);
		//user2.setCompany_id(company);
		user1=(User) sessionFactory.getCurrentSession().get(User.class,user);
		session=this.sessionFactory.openSession();
		tx=session.beginTransaction();
		session.delete(user1);
		tx.commit();
		session.close();
	}
}

//}
