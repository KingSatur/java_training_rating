package com.decamplearning.rating.repository;

import com.decamplearning.rating.model.Rating;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Flux;

public interface RatingRepository extends ReactiveMongoRepository<Rating, String> {
    Flux<Rating> findByBookId(Integer bookId);
}
