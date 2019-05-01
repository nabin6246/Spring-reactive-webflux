package com.example.spring.reactivewebflux.repository;

import com.example.spring.reactivewebflux.model.Comment;
import reactor.core.publisher.Flux;

public interface CommentRepository{
    Flux<Comment> findAll();
}