package com.example.spring.reactivewebflux.repository;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

import com.example.spring.reactivewebflux.model.Comment;
import com.example.spring.reactivewebflux.utils.CommentGenerator;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

@Repository
public class ReactiveCommentRepository implements CommentRepository{

    @Override
    public Flux<Comment> findAll(){
        return Flux.interval(Duration.ofSeconds(1))
        .onBackpressureDrop()
        .map(this::generateComment)
        .flatMapIterable(x->x);
    }

    private List<Comment> generateComment(long interval){
        Comment obj=new Comment(
            CommentGenerator.randomAuthor(),
            CommentGenerator.randomMessage(),
            CommentGenerator.getCurrentTimeStamp()
        );
        return Arrays.asList(obj);
    }
}