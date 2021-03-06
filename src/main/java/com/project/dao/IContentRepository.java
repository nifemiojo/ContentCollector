package com.project.dao;

import com.project.entities.Category;
import com.project.entities.Content;
import com.project.entities.UserAccount;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

// Mechanism to access data in the DB
// Crud Repo has generic type of the Entity and the type of its ID
// Here we can also write custom queries
@Repository
public interface IContentRepository extends CrudRepository<Content, Long> {

    @Override
    public List<Content> findAll();

//    @Query(nativeQuery = true, value = "SELECT * FROM content WHERE username = :login")
//    public List<Content> getAllUserContent(String login);

    public List<Content> findContentsByUser(UserAccount user);

    public void deleteContentById(Long id);

}
