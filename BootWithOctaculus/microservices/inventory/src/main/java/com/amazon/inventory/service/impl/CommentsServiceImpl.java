package com.amazon.inventory.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amazon.inventory.model.Comments;
import com.amazon.inventory.repository.CommentsRepository;
import com.amazon.inventory.service.CommentsService;

@Service
public class CommentsServiceImpl implements CommentsService{

    @Autowired
    CommentsRepository commentsRepository;

    @Override
    public List<Comments> getAllComments() {
        return commentsRepository.findAll();
    }

    @Override
    public List<Comments> getAllCommentsByProductId(long id) {
        return commentsRepository.getAllCommentsByProductId(id);
    }

    @Override
    public Comments writeComment(Comments comment) {
        return commentsRepository.save(comment);
    }
}
