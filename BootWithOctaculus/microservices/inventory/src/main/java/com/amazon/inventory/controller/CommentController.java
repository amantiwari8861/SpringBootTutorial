package com.amazon.inventory.controller;

import java.util.Date;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.amazon.inventory.model.Comments;
import com.amazon.inventory.service.CommentsService;
import com.amazon.inventory.service.ProductService;

@Controller
public class CommentController {

    @Autowired
    CommentsService commentsService;

    @Autowired
    ProductService productService;
    
    @PostMapping("/writeComment")
    public String writeComment(@ModelAttribute("Comments")Comments comment,HttpSession session){
        comment.setRecordCreated(new Date().toString());
        commentsService.writeComment(comment);
        session.setAttribute("product", productService.getProductById(comment.getProductId()));
        session.setAttribute("comments", commentsService.getAllCommentsByProductId(comment.getProductId()));
        return "view-product";
    }
}
