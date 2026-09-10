package com.pinwox.tvmaze.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.pinwox.tvmaze.entity.Comment;

public interface CommentRepository extends MongoRepository<Comment, String> {

      List<Comment> findByShowId(Long showId);

}
