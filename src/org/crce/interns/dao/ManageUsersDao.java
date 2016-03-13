package org.crce.interns.dao;
import java.util.List;
import org.crce.interns.model.User;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

@Repository("crudDao")
public class ManageUsersDao {
	private SessionFactory sessionFactory;
	
	public void createDetails(User user){
		sessionFactory.getCurrentSession().save(user);
	}
	
	@SuppressWarnings("unchecked")
	public List<User> retreiveDetails(String company){
		Criteria criteria=sessionFactory.getCurrentSession().createCriteria(User.class, company);
		return criteria.list();
	}
	
	public void deleteDetails(User user){
		User usr=(User) sessionFactory.getCurrentSession().get(User.class, user.getUserName());
		Session session=sessionFactory.openSession();
		session.delete(usr);
	}

}
