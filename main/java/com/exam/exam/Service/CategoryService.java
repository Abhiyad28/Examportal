package com.exam.exam.Service;

//import java.util.Locale.Category;
import java.util.Set;

import org.springframework.stereotype.Service;

import com.exam.exam.Model.Category;

//import com.exam.exam.Model.Cateogry;

@Service
public interface CategoryService {

	
	public Category addCategory(Category category);
	
	public Set<Category> getAllCategory();
	
	public Category getCategory(int cid);
	
	public Category updateCategories(Category  category);
	
	public void deleteCategory(int cid);
	
}
