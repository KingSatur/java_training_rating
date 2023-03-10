package com.decamplearning.rating.controller;

import com.decamplearning.rating.dto.CreateRatingResponseDto;
import com.decamplearning.rating.dto.RatingDto;
import com.decamplearning.rating.service.RatingService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.reactive.server.WebTestClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;
import java.util.Date;

@WebFluxTest(controllers = {RatingController.class})
class RatingControllerTest {

    @MockBean
    private RatingService ratingService;

    @Autowired
    private WebTestClient webClient;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void shouldCreateRatingForBook() throws Exception {
        CreateRatingResponseDto createRatingResponseDto =
                new CreateRatingResponseDto("3415f4ce-62e7-46a8-8f77-728d6d8fbd3e");
        Mockito.when(this.ratingService.createRatingForBook(Mockito.any())).thenReturn(
                Mono.just(createRatingResponseDto)
        );
        this.webClient
                .post()
                .uri("/rating")
                .contentType(MediaType.APPLICATION_JSON)
                .bodyValue(createRatingResponseDto)
                .exchange()
                .expectStatus()
                .isOk()
                .expectBody()
                .jsonPath("$.id").isEqualTo("3415f4ce-62e7-46a8-8f77-728d6d8fbd3e");

    }

    @Test
    void shouldGetRatingForSpecificBook(){
        RatingDto ratingDto = new RatingDto("3415f4ce-62e7-46a8-8f77-728d6d8fbd9e",
                20, "Description", new Date(), 300);
        Mockito.when(this.ratingService.getRatingsByBook(Mockito.any())).thenReturn(
                Flux.just(ratingDto)
        );
        Flux<RatingDto> ratings = this.webClient
                .get()
                .uri("/rating/20")
                .exchange().returnResult(RatingDto.class).getResponseBody();

        StepVerifier.create(ratings)
                .expectNextMatches(retrievedRating ->
                        retrievedRating.getDescription().equals("Description")
                                && retrievedRating.getId().equals(
                                        "3415f4ce-62e7-46a8-8f77-728d6d8fbd9e")
                                && retrievedRating.getCreationDate() != null)
                .verifyComplete();
    }



}