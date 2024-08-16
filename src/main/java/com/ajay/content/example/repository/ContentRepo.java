package com.ajay.content.example.repository;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.HashMap;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.ajay.content.example.model.Content;
import com.ajay.content.example.model.Status;
import com.ajay.content.example.model.Type;

import jakarta.annotation.PostConstruct;

@Repository
public class ContentRepo {

    private HashMap<Integer, Content> db = new HashMap<>();

    @PostConstruct
    private void initDB(){
        Content c= new Content(
            1, 
            "First Video", 
            "Spring Demo", 
            Status.IN_PROGRESS, 
            Type.VIDEO, 
            LocalDateTime.now(), 
            null, 
            "");


            db.put(c.id(),c);
    }

    public Collection<Content> findAll() {
        return db.values();
    }

    public Content findById(Integer id){
        return db.get(id);
    }


    public void save (Content content){
        db.put(content.id(), content);
    }

    public Content remove(Integer id) {
        return db.remove(id);
    }

    
}
