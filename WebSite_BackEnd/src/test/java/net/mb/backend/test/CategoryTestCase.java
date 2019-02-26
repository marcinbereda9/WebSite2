package net.mb.backend.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import net.mb.backend.dao.CategoryDAO;
import net.mb.backend.dto.Category;

public class CategoryTestCase {

	private static AnnotationConfigApplicationContext context;
	private static CategoryDAO categoryDAO;
	
	private Category category;
	
	@BeforeClass
	public static void init(){
		context = new AnnotationConfigApplicationContext();
		context.scan("net.mb.backend");
		context.refresh();
		
		categoryDAO = (CategoryDAO)context.getBean("categoryDAO");
	}
	
/*	@Test
	public void testAddCategory(){
		category = new Category();
		category.setName("TestName");
		category.setDescription("This is simpy description for test2");
		category.setImageURL("CAT_2.png");
		assertEquals("Successfully added a new category by test", true, categoryDAO.add(category));
	}*/
	
	/*@Test
	public void testGetCategory(){
		category = categoryDAO.get(1);
		
		assertEquals("Successfully get a single category", "TestName", category.getName());
	}*/
	
	/*@Test
	public void testUpdateCategory(){
		category = categoryDAO.get(1);
		
		category.setName("Dupa");
		
		assertEquals("Successfully updated a single category", true, categoryDAO.update(category));
	}*/
	
	/*@Test
	public void testDeleteCategory(){
		category = categoryDAO.get(1);
		assertEquals("Successfully updated a single category", true, categoryDAO.delete(category));
	}*/
	
	/*
	@Test
	public void testListCategory(){
		assertEquals("Successfully get list category from db", 1, categoryDAO.list().size());
	}*/
	
	@Test
	public void testCRUDCategory() {
		
		//adding operation
		category = new Category();
		category.setName("TestName");
		category.setDescription("This is simpy description for test1");
		category.setImageURL("CAT_2.png");
		assertEquals("Successfully added a new category by test", true, categoryDAO.add(category));
		
		category = new Category();
		category.setName("TestName2");
		category.setDescription("This is simpy description for test2");
		category.setImageURL("CAT_3.png");
		assertEquals("Successfully added a new category by test", true, categoryDAO.add(category));
		
		//updating
		category = categoryDAO.get(1);
		
		category.setName("Dupa");
		
		assertEquals("Successfully updated a single category", true, categoryDAO.update(category));
		
		//delete
		assertEquals("Successfully updated a single category", true, categoryDAO.delete(category));
		
		assertEquals("Successfully get list category from db", 1, categoryDAO.list().size());
	}
	
}
