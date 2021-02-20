package com.project.services;

import com.project.dao.IContentRepository;
import com.project.dao.IUserAccountRepository;
import com.project.entities.Category;
import com.project.entities.Content;
import com.project.entities.UserAccount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.security.Principal;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ContentService {
    
    @Autowired
    IContentRepository contentRepository;

    @Autowired
    IUserAccountRepository userAccountRepository;

    public Content save(Content content, String login) {
        if (content.getUser() == null) {
            UserAccount userAccount = userAccountRepository.findUserAccountByUserName(login);
            content.setUser(userAccount);
        }

        return contentRepository.save(content);
    }

    public List<Content> findAll(){
        return contentRepository.findAll();
    }

    public Optional<Content> findById(Long id) {
        return contentRepository.findById(id);
    }

    public void deleteById(Long id) {
        contentRepository.deleteContentById(id);
    }


    public List<Content> findContentsByUser(UserAccount user){
        return contentRepository.findContentsByUser(user);
    }

}
