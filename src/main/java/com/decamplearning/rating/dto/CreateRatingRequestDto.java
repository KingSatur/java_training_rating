package com.decamplearning.rating.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateRatingRequestDto {

    private Integer bookId;
    private String description;
    private Integer score;

}
