package com.antaal.dataLayer.repository;

import com.antaal.dataLayer.model.Category;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends CrudRepository<Category, Integer> {
    public Iterable<Category> findByName(String name);
    public Iterable<Category> findByProductsName(String name);
}
