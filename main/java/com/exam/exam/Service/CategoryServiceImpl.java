package com.exam.exam.Service;

import java.util.LinkedHashSet;
//import java.util.Locale.Category;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.exam.exam.Model.Category;
import com.exam.exam.repository.CategoryRepository;

@Service
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	private CategoryRepository categoryRepository;
	@Override
	public Category addCategory(Category category) {
		// TODO Auto-generated method stub
//		category.setDescription(category.getDescription());
//		category.setTitle(category.getTitle());
		return this.categoryRepository.save(category);
	}

	@Override
	public Set<Category> getAllCategory() {
		// TODO Auto-generated method stub
		return new LinkedHashSet<>(this.categoryRepository.findAll());
	}

	@Override
	public Category getCategory(int cid) {
		// TODO Auto-generated method stub
		return this.categoryRepository.findById(cid).get();
	}

	@Override
	public Category updateCategories(Category category) {
		// TODO Auto-generated method stub
		return  this.categoryRepository.save(category);
	}

	@Override
	public void deleteCategory(int cid) {
		// TODO Auto-generated method stub
//		String deletedUser=this.Category.getCategory(cid);
		this.categoryRepository.deleteById(cid);
	}

}
