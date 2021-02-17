package com.project.services;

import com.project.dao.ICategoryRepository;
import com.project.dao.IContentRepository;
import com.project.entities.Category;
import com.project.entities.Content;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

    @Autowired
    ICategoryRepository categoryRepository;

    public Category save(Category category) {
        return categoryRepository.save(category);
    }

    public List<Category> findAll(){
        return categoryRepository.findAll();
    }

    public Optional<Category> findById(Long id) {
        return categoryRepository.findById(id);
    }

    public void deleteById(Long id) {
        categoryRepository.deleteById(id);
    }

}
