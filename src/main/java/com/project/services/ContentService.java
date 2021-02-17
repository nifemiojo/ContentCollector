package com.project.services;

import com.project.dao.IContentRepository;
import com.project.entities.Content;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ContentService {
    
    @Autowired
    IContentRepository contentRepository;

    public Content save(Content content) {
        return contentRepository.save(content);
    }

    public List<Content> findAll(){
        return contentRepository.findAll();
    }

    public Optional<Content> findById(Long id) {
        return contentRepository.findById(id);
    }

    public void deleteById(Long id) {
        contentRepository.deleteById(id);
    }
}
