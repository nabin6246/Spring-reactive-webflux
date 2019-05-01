package com.example.spring.reactivewebflux.controller;

import com.example.spring.reactivewebflux.model.Comment;
import com.example.spring.reactivewebflux.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController
public class CommentController{
    @Autowired
    private CommentRepository commentRepository;

    @GetMapping(path="/comment/stream",
    produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<Comment> feed(){
        return this.commentRepository.findAll();
    }
    

}