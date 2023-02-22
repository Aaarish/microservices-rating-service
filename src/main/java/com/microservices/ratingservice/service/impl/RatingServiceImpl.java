package com.microservices.ratingservice.service.impl;

import com.microservices.ratingservice.dto.RatingDto;
import com.microservices.ratingservice.repository.RatingRepo;
import com.microservices.ratingservice.service.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RatingServiceImpl implements RatingService {
    @Autowired
    private RatingRepo ratingRepo;

    @Override
    public RatingDto addRating(RatingDto ratingDto) {
        
        return null;
    }

    @Override
    public RatingDto getRating(String ratingId) {
        return null;
    }

    @Override
    public List<RatingDto> getRatings() {
        return null;
    }

    @Override
    public String deleteRating(String ratingId) {
        return null;
    }
}
