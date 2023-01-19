package com.decamplearning.rating.service.impl;

import com.decamplearning.rating.dto.CreateRatingRequestDto;
import com.decamplearning.rating.dto.CreateRatingResponseDto;
import com.decamplearning.rating.dto.RatingDto;
import com.decamplearning.rating.model.Rating;
import com.decamplearning.rating.repository.RatingRepository;
import com.decamplearning.rating.service.RatingService;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class RatingServiceImpl implements RatingService {

    private final RatingRepository ratingRepository;

    public RatingServiceImpl(RatingRepository ratingRepository) {
        this.ratingRepository = ratingRepository;
    }

    @Override
    public Mono<CreateRatingResponseDto> createRatingForBook(CreateRatingRequestDto createRatingRequestDto) {
        Rating rating = new Rating();
        rating.setRatingDescription(createRatingRequestDto.getDescription());
        rating.setScore(createRatingRequestDto.getScore());
        return this.ratingRepository.save(rating).map(entity ->  new CreateRatingResponseDto(entity.getId()));
    }

    @Override
    public Flux<RatingDto> getRatingsByBook(Integer bookId) {
        return this.ratingRepository.findByBookId(bookId).map(rating -> RatingDto.builder()
                .bookId(rating.getBookId())
                .description(rating.getRatingDescription())
                .id(rating.getId())
                .score(rating.getScore())
                .build());
    }
}
