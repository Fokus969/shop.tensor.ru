package com.springjpa.repo;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.springjpa.model.Category;

public interface CategoryRepository extends CrudRepository<Category, Long> {
	List<Category> findByName(String name);
}
