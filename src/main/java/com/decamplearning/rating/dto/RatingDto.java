package com.decamplearning.rating.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RatingDto {

    private String id;
    @JsonIgnore
    private Integer bookId;
    private String description;
    private Integer score;

}
