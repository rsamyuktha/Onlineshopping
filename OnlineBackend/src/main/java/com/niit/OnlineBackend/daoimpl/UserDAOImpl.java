package com.niit.OnlineBackend.daoimpl;
import java.util.List;
import javax.persistence.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.OnlineBackend.dao.UserDAO;
import com.niit.OnlineBackend.model.User;

@Repository("UserDAO")
@Transactional
public class UserDAOImpl implements UserDAO
{
	@Autowired
	private SessionFactory sessionFactory;
	@Override
	public List<User> list() 
	{
	    String selectActiveCategory="FROM User WHERE active=:active";
	    Query query=sessionFactory.getCurrentSession().createQuery(selectActiveCategory);
	    query.setParameter("active", true);
		return query.getResultList();
	}

	@Override
	public boolean add(User user) 
	{
	   try
	   {
		   sessionFactory.getCurrentSession().persist(user);
		   return true;
	   }
	   catch(Exception e)
	   {
		   e.printStackTrace();
		   return false;
	   }
		   
	}

}
