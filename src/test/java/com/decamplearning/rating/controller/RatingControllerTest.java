package com.decamplearning.rating.controller;

import com.decamplearning.rating.service.RatingService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;


@AutoConfigureMockMvc
@WebMvcTest(controllers = {RatingController.class})
class RatingControllerTest {

    @MockBean
    private RatingService ratingService;

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void shouldCreateRatingForBook(){}

    @Test
    void shouldGetRatingForSpecificBook(){}


}