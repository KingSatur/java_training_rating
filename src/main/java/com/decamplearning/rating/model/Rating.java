package com.decamplearning.rating.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document(collection = "rating")
@Getter
@Setter
public class Rating {
    @Id
    private String id;
    private Integer bookId;
    private String ratingDescription;
    @CreatedDate
    private Date creationDate = new Date();
    private Integer score;
    private RatingUtility[] ratingUtilities;

    public Rating() {
    }

    public Rating(String id, Integer bookId, String ratingDescription, Integer score, RatingUtility[] ratingUtilities,
                  Date creationDate) {
        this.id = id;
        this.bookId = bookId;
        this.ratingDescription = ratingDescription;
        this.score = score;
        this.ratingUtilities = ratingUtilities;
        this.creationDate = creationDate;
    }
}
