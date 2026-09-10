package com.pinwox.tvmaze.repository;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.pinwox.tvmaze.entity.Show;

public interface ShowRepository extends MongoRepository<Show, Long> {

}
