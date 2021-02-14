package com.project.dao;

import com.project.contentcollector.ContentcollectorApplication;
import com.project.contentcollector.dao.IContentRepository;
import com.project.contentcollector.entities.Content;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlGroup;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;

// Tells Spring where main app starts, if you use the same naming convention as proper app
// e.g. java.com.project.contentcollector.ContentcollectorApplication then you can just use @SpringBootTest
// By default maven will create this
@ContextConfiguration(classes= ContentcollectorApplication.class)
@DataJpaTest
@RunWith(SpringRunner.class) // Required for junit 4 testing

// Without this tables will be derived from entity classes
// These SQL scripts help for consistency because in prod the DB will be created using the same schema.sql file
@SqlGroup({@Sql(executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD, scripts={"classpath:schema.sql", "classpath:data.sql"})})
public class ContentRepositoryIntegrationTest {

    @Autowired
    IContentRepository contentRepository;

    @Test
    public void ifNewContentSaved_thenSuccess() {
        Content content = new Content("Google", "www.google.com");
        contentRepository.save(content);

        assertEquals(3, contentRepository.findAll().size());

    }
}
