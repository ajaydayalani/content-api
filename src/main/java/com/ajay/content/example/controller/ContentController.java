package com.ajay.content.example.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.ajay.content.example.model.Content;
import com.ajay.content.example.service.ContentService;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;




@RestController
public class ContentController {
    
    @Autowired
    private ContentService contentService;



    @GetMapping("/content")
    public Collection<Content> getAllRecords() {
        return contentService.getRecords();
    }

    @GetMapping("/content/filter/{key}")
    public Collection<Content> getAllRecords(@PathVariable String key) {
        return contentService.getKeyWords(key);
    }

    @GetMapping("/content/{id}")
    public Content retrieve(@PathVariable Integer id) {

        Content c= contentService.getByID(id);
        if(c==null){throw new ResponseStatusException(HttpStatus.NOT_FOUND);}
        return c;
        
    }

    @PostMapping("/content")
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@Valid @RequestBody Content content) {
        
         contentService.create(content);
    }


    @PutMapping("/content/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void update(@PathVariable  Integer id , @Valid @RequestBody  Content content) {
        
        Content c = contentService.update(id, content);
        if(c==null){throw new ResponseStatusException(HttpStatus.NOT_FOUND);}
    
    }

    @DeleteMapping("/content/{id}")
    public void delete(@PathVariable Integer id){
        boolean c = contentService.delete(id);
        if(!c){throw new ResponseStatusException(HttpStatus.NOT_FOUND);}

    }
    
    
    
}
