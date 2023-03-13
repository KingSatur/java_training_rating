package com.decamplearning.rating.service.impl;

import com.decamplearning.rating.repository.RatingRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;


@ExtendWith(SpringExtension.class)
class RatingServiceImplTest {

    @InjectMocks
    private RatingServiceImpl ratingService;

    @Mock
    private RatingRepository ratingRepository;


    @Test
    void shouldCreateRatingForBook(){}

    @Test
    void shouldGetRatingForSpecificBook(){}

}