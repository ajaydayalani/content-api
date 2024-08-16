package com.ajay.content.example.service;

import java.time.LocalDateTime;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ajay.content.example.model.Content;
import com.ajay.content.example.repository.ContentRepo;
import com.ajay.content.example.repository.ContentRepository;

import jakarta.validation.Valid;

@Service
public class ContentService {
    
    @Autowired
    private ContentRepository contentRepo;

    public Collection<Content> getRecords() {
        return contentRepo.findAll();
    }

    public Collection<Content> getKeyWords(String key) {
        return contentRepo.findAllByTitleContains(key);
    }


    public Content getByID(Integer id){
        return contentRepo.findById(id).orElse(null);
    }


    public void create(@Valid Content content) {

        
        Content c = new Content(
            null, 
            content.title(), 
            content.desc(), 
            content.status(), 
            content.contentType(), 
            LocalDateTime.now(), 
            null, 
            content.url());

        contentRepo.save(c);

    }


    public Content update(Integer id, Content content) {

        
        Content origin =  contentRepo.findById(id).orElse(null);

        if (origin==null){return null;}

        Content c = new Content(
            id, 
            content.title(), 
            content.desc(), 
            content.status(), 
            content.contentType(), 
            origin.dateCreated(), 
            LocalDateTime.now(), 
            content.url());

        contentRepo.save(c);
        return c;

        
    }


    public boolean delete(Integer id) {
        boolean c =contentRepo.existsById(id);
        contentRepo.deleteById(id);
        return c;

    }




  
}
