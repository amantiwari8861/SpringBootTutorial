package com.amazon.inventory.service;

import java.util.List;

import com.amazon.inventory.model.Comments;

public interface CommentsService {
    public Comments writeComment(Comments comment);
    public List<Comments> getAllComments();
    public List<Comments> getAllCommentsByProductId(long id);
}
