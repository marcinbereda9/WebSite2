package net.mb.backend.daoimpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import net.mb.backend.dao.CategoryDAO;
import net.mb.backend.dto.Category;


@Repository("categoryDAO")
public class CategoryDAOimpl implements CategoryDAO {

	
	public static List<Category> categories = new ArrayList<>();
	
	static {
		Category category = new Category();
		category.setId(1);
		category.setName("Marcin");
		category.setDescription("This is simpy description for test");
		category.setImageURL("CAT_1.png");
		categories.add(category);
		
		Category category2 = new Category();
		category2.setId(2);
		category2.setName("Daniel");
		category2.setDescription("This is simpy description for test2");
		category2.setImageURL("CAT_2.png");
		categories.add(category2);
		
		Category category3 = new Category();
		category3.setId(3);
		category3.setName("Zbyszek");
		category3.setDescription("This is simpy description for test3");
		category3.setImageURL("CAT_3.png");
		categories.add(category3);
	}
	
	@Override
	public List<Category> list() {
		// TODO Auto-generated method stub
		return categories;
	}

	@Override
	public Category get(int id) {
		for(Category category : categories){
			if(category.getId() == id ) return category;
		}
		return null;
	}

	
}
