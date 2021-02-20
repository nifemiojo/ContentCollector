package com.project.dao;

import com.project.entities.Category;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ICategoryRepository extends CrudRepository<Category, Long> {

    @Override
    public List<Category> findAll();

    @Query(nativeQuery = true, value = "SELECT c.id, c.name FROM user_category uc " +
            "FULL JOIN user_accounts ua ON uc.user_id = ua.user_id " +
            "FULL JOIN category c ON uc.category_id = c.id "  +
            "WHERE ua.username = :login " +
            "ORDER BY c.name")
    public List<Category> getUsersCategories(String login);

    public Category findCategoryById(Long id);
}
