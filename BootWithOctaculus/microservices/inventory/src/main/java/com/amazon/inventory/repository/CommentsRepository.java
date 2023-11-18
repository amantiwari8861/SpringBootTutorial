package com.amazon.inventory.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.amazon.inventory.model.Comments;

@Repository
public interface CommentsRepository extends JpaRepository<Comments,Long>{
    @Query("from Comments where productId=?1")
    public List<Comments> getAllCommentsByProductId(long id);
}
