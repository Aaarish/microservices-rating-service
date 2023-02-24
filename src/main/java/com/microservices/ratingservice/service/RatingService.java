package com.microservices.ratingservice.service;

import com.microservices.ratingservice.dto.RatingDto;

import java.util.List;

public interface RatingService {
    RatingDto addRating(RatingDto ratingDto);

    RatingDto getRating(String ratingId);

    List<RatingDto> getRatings();

    String deleteRating(String ratingId);

    List<RatingDto> getRatingsOfUser(String userId);
}
