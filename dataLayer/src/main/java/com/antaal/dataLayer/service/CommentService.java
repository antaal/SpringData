package com.antaal.dataLayer.service;

import com.antaal.dataLayer.model.Comment;
import com.antaal.dataLayer.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CommentService {
    @Autowired
    private CommentRepository commentRepository;

    public Iterable<Comment> getComments(){
        return commentRepository.findAll();
    }
    public Optional<Comment> getCommentById(Integer id){
        return commentRepository.findById(id);
    }
    public Iterable<Comment> getCommentContaining(String expression) {
        return commentRepository.findByContentContaining(expression);
    }
    public Comment saveComment(Comment comment){
        return commentRepository.save(comment);
    }
    public void deleteComment(Integer id){
        commentRepository.deleteById(id);
    }
}
