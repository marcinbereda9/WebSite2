package net.mb.backend.daoimpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import net.mb.backend.dao.ProductDAO;
import net.mb.backend.dto.Product;

@Repository("productDAO")
@Transactional
public class ProductDAOImpl implements ProductDAO{

	@Autowired
	private SessionFactory sessionFactiory;

	@Override
	public Product get(int productId) {
		Product prd = null;
		try{
			prd = sessionFactiory.getCurrentSession().get(Product.class, Integer.valueOf(productId));
		}
		catch (Exception e){
			e.printStackTrace();
		}
		return prd;
	}

	@Override
	public List<Product> list() {
		return sessionFactiory.getCurrentSession().createQuery("FROM Product", Product.class).getResultList();
	}

	@Override
	public boolean add(Product product) {
		try{
			sessionFactiory.getCurrentSession().persist(product);
			return true;
		}
		catch (Exception e){
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean update(Product product) {
		try{
			sessionFactiory.getCurrentSession().update(product);
			return true;
		}
		catch (Exception e){
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean delete(Product product) {
		try{
			product.setActive(false);
			sessionFactiory.getCurrentSession().update(product);
			return true;
		}
		catch (Exception e){
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public List<Product> listActiveProducts() {
		return sessionFactiory.getCurrentSession().createQuery("FROM Product WHERE active = :active", Product.class)
				.setParameter("active", true)
				.getResultList();
	}

	@Override
	public List<Product> listActiveProductsByCategory(int categoryId) {
		return sessionFactiory.getCurrentSession().createQuery("FROM Product WHERE active = :active AND category_id = :category", Product.class)
				.setParameter("active", true)
				.setParameter("category", categoryId)
				.getResultList();
	}

	@Override
	public List<Product> getLatestActiveProducts(int count) {
		return sessionFactiory.getCurrentSession().createQuery("FROM Product WHERE active = :active ORDER BY id", Product.class)
				.setParameter("active", true)
				.setFirstResult(0)
				.setMaxResults(count)
				.getResultList();
	}
	
	
	
}
