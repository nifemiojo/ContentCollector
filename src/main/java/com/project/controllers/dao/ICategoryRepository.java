package com.project.controllers.dao;

import com.project.controllers.entities.Category;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ICategoryRepository extends CrudRepository<Category, Long> {

    @Override
    public List<Category> findAll();
}
