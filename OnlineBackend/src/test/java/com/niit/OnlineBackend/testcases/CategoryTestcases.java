package com.niit.OnlineBackend.testcases;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.OnlineBackend.dao.CategoryDAO;
import com.niit.OnlineBackend.model.Category;

public class CategoryTestcases
{
private static AnnotationConfigApplicationContext context;
private static CategoryDAO categoryDAO;
private Category category;

@BeforeClass
public static void intit()
{
	context=new AnnotationConfigApplicationContext();
	context.scan("com.niit.OnlineBackend");
	context.refresh();
	categoryDAO=(CategoryDAO)context.getBean("categoryDAO");
}

@Test
public void testAddCategory()
{
	category=new Category();
	category.setName("television");
	category.setDescription("desrcription about tv");
	category.setImageURL("cat_106.png");
	assertEquals("successfully added a category inside table",true,categoryDAO.add(category));
}


@Test
public void testUpdateCategory()
{
	category=categoryDAO.get(2);
	category.setName("TV");
	assertEquals("successfully updated a single category in the table!",true,categoryDAO.update(category));
}

@Test
public void testGetCategory()
{
	category=categoryDAO.get(1);
	assertEquals("successfully fetched the list of categories from the table!","television",category.getName());
}

 
 
@Test
public void testDeleteCategory()
{
	category=categoryDAO.get(3);
	
	assertEquals("successfully deleted a single category in the table!",true,categoryDAO.delete(category));
}

@Test
public void testListCategory()
{
	category=categoryDAO.get(3);
	
	assertEquals("successfully fetched the list of categories from the table!",3,categoryDAO.list().size());
}


}
