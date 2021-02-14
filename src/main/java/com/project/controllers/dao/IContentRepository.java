package com.project.controllers.dao;

import com.project.controllers.entities.Content;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

// Mechanism to access data in the DB
// Crud Repo has generic type of the Entity and the type of its ID
// Here we can also write custom queries
public interface IContentRepository extends CrudRepository<Content, Long> {

    @Override
    public List<Content> findAll();
}
