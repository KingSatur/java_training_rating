package com.decamplearning.rating.service.impl;

import com.decamplearning.rating.dto.CreateRatingRequestDto;
import com.decamplearning.rating.dto.CreateRatingResponseDto;
import com.decamplearning.rating.dto.RatingDto;
import com.decamplearning.rating.model.Rating;
import com.decamplearning.rating.repository.RatingRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import java.util.Date;


@ExtendWith(SpringExtension.class)
class RatingServiceImplTest {

    @InjectMocks
    private RatingServiceImpl ratingService;

    @Mock
    private RatingRepository ratingRepository;


    @Test
    void shouldCreateRatingForBook(){
        CreateRatingRequestDto createRatingRequestDto = new CreateRatingRequestDto(
                20,
                "Descritpion",
                300
        );
        Rating rating = new Rating();
        rating.setId("3415f4ce-62e7-46a8-8f77-728d6d8fbd3e");
        Mockito.when(this.ratingRepository.save(Mockito.any(Rating.class))).thenReturn(
                Mono.just(rating)
        );
        Mono<CreateRatingResponseDto> createRatingResponseDto = this.ratingService.createRatingForBook(createRatingRequestDto);
        Mockito.verify(this.ratingRepository, Mockito.atLeastOnce() ).save(Mockito.any(Rating.class));
        Assertions.assertNotNull(createRatingResponseDto);
        CreateRatingResponseDto createRatingResponseDto1 = createRatingResponseDto.block();
        Assertions.assertEquals("3415f4ce-62e7-46a8-8f77-728d6d8fbd3e",createRatingResponseDto1.getId());
    }

    @Test
    void shouldGetRatingForSpecificBook(){
        Rating rating = new Rating();
        rating.setId("3415f4ce-62e7-46a8-8f77-728d6d8fbd3e");
        rating.setRatingDescription("Description");
        rating.setScore(200);
        rating.setCreationDate(new Date());
        Mockito.when(this.ratingRepository.findByBookId(Mockito.anyInt())).thenReturn(
                Flux.just(rating)
        );
        Flux<RatingDto> ratings = this.ratingService.getRatingsByBook(10);
        Mockito.verify(this.ratingRepository, Mockito.atLeastOnce() ).findByBookId(Mockito.anyInt());
        Assertions.assertNotNull(ratings);
        StepVerifier.create(ratings)
                .expectNextMatches(ratingDto ->
                        ratingDto.getDescription().equals("Description")
                        && ratingDto.getId().equals("3415f4ce-62e7-46a8-8f77-728d6d8fbd3e")
                        && ratingDto.getScore().equals(200)
                        && ratingDto.getCreationDate() != null
                )
                .expectComplete().verify();

    }

}