package com.pinwox.tvmaze.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.pinwox.tvmaze.entity.Comment;

public interface CommentRepository extends MongoRepository<Comment, Long> {

}
