package com.project.services;

import com.project.dao.ICategoryRepository;
import com.project.dao.IUserAccountRepository;
import com.project.entities.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

    @Autowired
    ICategoryRepository categoryRepository;

    @Autowired
    IUserAccountRepository userAccountRepository;

    public Category save(Category category) {
        return categoryRepository.save(category);
    }

    public List<Category> findAll(){
        return categoryRepository.findAll();
    }

    public Category findCategoryById(Long id) {
        return categoryRepository.findCategoryById(id);
    }

    public void deleteById(Long id) {
        categoryRepository.deleteById(id);
    }

    public List<Category> getUsersCategories(String login) {

        return categoryRepository.getUsersCategories(login);
    }

}
