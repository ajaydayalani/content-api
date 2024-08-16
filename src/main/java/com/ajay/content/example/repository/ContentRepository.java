package com.ajay.content.example.repository;

import java.util.List;

import org.springframework.data.repository.ListCrudRepository;

import com.ajay.content.example.model.Content;

public interface ContentRepository extends ListCrudRepository<Content,Integer> {

    List<Content> findAllByTitleContains(String keyword);
    
}
