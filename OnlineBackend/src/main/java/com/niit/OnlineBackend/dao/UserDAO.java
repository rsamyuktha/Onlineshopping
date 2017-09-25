package com.niit.OnlineBackend.dao;
import java.util.List;
import com.niit.OnlineBackend.model.User;

	public interface UserDAO 
	{
	  List<User> list();
	  
	  boolean add(User user);
}