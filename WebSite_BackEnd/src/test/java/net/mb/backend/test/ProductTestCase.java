package net.mb.backend.test;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import net.mb.backend.dao.ProductDAO;
import net.mb.backend.dto.Product;
import static org.junit.Assert.assertEquals;
import org.junit.BeforeClass;
import org.junit.Test;

public class ProductTestCase {

	private static AnnotationConfigApplicationContext context;
	private static ProductDAO productDAO;
	
	private Product product;
	
	@BeforeClass
	public static void init(){
		context = new AnnotationConfigApplicationContext();
		context.scan("net.mb.backend");
		context.refresh();
		
		productDAO = (ProductDAO)context.getBean("productDAO");
	}
	
/*	@Test
	public void testCRUDProduct() {
		product = new Product();
		product.setName("Kamizelka");
		product.setBrand("Kamizelex");
		product.setDescription("Odblaskowa");
		product.setUnitPrice(20);
		product.setActive(true);
		product.setCategory_id(4);
		product.setSupplierid(1);
		
		assertEquals("Cos poszlo nie tak przy insercie",true,productDAO.add(product));
		
		Product testProduct = productDAO.get(2);
		testProduct.setName("Alipne AL2300");
		assertEquals("Cos poszlo nie tak przy update", true, productDAO.update(testProduct));
		
		assertEquals("Cos poszlo nie tak przy delete", true, productDAO.delete(testProduct));
		
		assertEquals("nie zgadza sie lista active products", 16, productDAO.list().size());
	}*/
	
	@Test
	public void testLists(){
		assertEquals("nie zgadza sie lista active products", 3, productDAO.listActiveProducts().size());
	}
	
	@Test
	public void test2Lists(){
		assertEquals("nie zgadza sie lista active products", 1, productDAO.listActiveProductsByCategory(2).size());
	}
	
	@Test
	public void test3Lists(){
		assertEquals("nie zgadza sie lista active products", 2, productDAO.getLatestActiveProducts(2).size());
	}
}
