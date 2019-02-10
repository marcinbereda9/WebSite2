package net.mb.backend.dao;

import java.util.List;

import net.mb.backend.dto.Category;

public interface CategoryDAO {

	List<Category> list();
	Category get(int id);
	
}
