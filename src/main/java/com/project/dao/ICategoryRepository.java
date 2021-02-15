package com.project.dao;

import com.project.entities.Category;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ICategoryRepository extends CrudRepository<Category, Long> {

    @Override
    public List<Category> findAll();
}
