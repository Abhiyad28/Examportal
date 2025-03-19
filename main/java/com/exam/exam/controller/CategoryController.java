package com.exam.exam.controller;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.exam.exam.Model.Category;
import com.exam.exam.Service.CategoryService;

@RestController
@RequestMapping("/category")
public class CategoryController {

	@Autowired
	private CategoryService categoryService;
	
	@PostMapping()
	public Category addCategory(@RequestBody  Category category) {
		
		return this.categoryService.addCategory(category);
	}
	
	@GetMapping("/{cid}")
	public Category getCategory(@PathVariable int cid) {
		return this.categoryService.getCategory(cid);
	}
	
	@DeleteMapping("/{cid}")
	public void deleteCategory(@PathVariable int cid){
		
		this.categoryService.deleteCategory(cid);
	}
	
	@PutMapping()
	public  Category updateCategory(@RequestBody Category category){
		return this.categoryService.updateCategories(category);
	}
	
	@GetMapping()
	public Set<Category> getAllCategory() {
		return this.categoryService.getAllCategory();
	}
}
