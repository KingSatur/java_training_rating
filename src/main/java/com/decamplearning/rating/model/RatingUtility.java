package com.decamplearning.rating.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;

@Getter
@Setter
public class RatingUtility {

    @Id
    private String id;
    private boolean wasUtil;
    private Integer user;

    public RatingUtility() {
    }

    public RatingUtility(String id, boolean wasUtil, Integer user) {
        this.id = id;
        this.wasUtil = wasUtil;
        this.user = user;
    }
}
