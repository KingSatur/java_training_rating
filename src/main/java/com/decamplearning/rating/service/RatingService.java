package com.decamplearning.rating.service;

import com.decamplearning.rating.dto.CreateRatingRequestDto;
import com.decamplearning.rating.dto.CreateRatingResponseDto;
import com.decamplearning.rating.dto.RatingDto;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface RatingService {

    Mono<CreateRatingResponseDto> createRatingForBook(CreateRatingRequestDto createRatingRequestDto,
                                                      String correlationId);
    Flux<RatingDto> getRatingsByBook(Integer bookId, String correlationId);

}
