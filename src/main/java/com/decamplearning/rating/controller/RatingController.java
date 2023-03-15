package com.decamplearning.rating.controller;

import com.decamplearning.rating.dto.CreateRatingRequestDto;
import com.decamplearning.rating.dto.CreateRatingResponseDto;
import com.decamplearning.rating.dto.RatingDto;
import com.decamplearning.rating.service.RatingService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/rating")
public class RatingController {

    private final RatingService ratingService;

    public RatingController(RatingService ratingService) {
        this.ratingService = ratingService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Flux<RatingDto>> getRatingsByBook(
            @PathVariable("id") int bookId,
            @RequestHeader("java-training-correlation-id") String correlationId
    ) {
        return ResponseEntity.ok(this.ratingService.getRatingsByBook(bookId,correlationId));
    }

    @PostMapping
    public ResponseEntity<Mono<CreateRatingResponseDto>> createRating(
            @RequestBody CreateRatingRequestDto createRatingRequestDto,
            @RequestHeader("java-training-correlation-id") String correlationId
            ){
       return ResponseEntity.ok(this.ratingService.createRatingForBook(createRatingRequestDto,correlationId));
    }

}
