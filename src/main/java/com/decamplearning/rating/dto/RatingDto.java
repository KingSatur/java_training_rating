package com.decamplearning.rating.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RatingDto {

    private String id;
    @JsonIgnore
    private Integer bookId;
    private String description;

    private Date creationDate;

    private Integer score;

}
