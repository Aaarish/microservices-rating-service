package com.microservices.ratingservice.service.impl;

import com.microservices.ratingservice.dto.RatingDto;
import com.microservices.ratingservice.entity.Rating;
import com.microservices.ratingservice.repository.RatingRepo;
import com.microservices.ratingservice.service.RatingService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class RatingServiceImpl implements RatingService {
    @Autowired
    private RatingRepo ratingRepo;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public RatingDto addRating(RatingDto ratingDto) {
        Rating rating = modelMapper.map(ratingDto, Rating.class);
        rating.setRatingId(UUID.randomUUID().toString());
        Rating savedRating = ratingRepo.save(rating);

        return modelMapper.map(savedRating, RatingDto.class);
    }

    @Override
    public RatingDto getRating(String ratingId) {
        Rating rating = ratingRepo.findById(ratingId).get();

        return modelMapper.map(rating, RatingDto.class);
    }

    @Override
    public List<RatingDto> getRatings() {
        List<Rating> ratings = ratingRepo.findAll();

        List<RatingDto> ratingDtos = ratings.stream()
                .map(r -> modelMapper.map(r, RatingDto.class))
                .collect(Collectors.toList());

        return ratingDtos;
    }

    @Override
    public String deleteRating(String ratingId) {
        ratingRepo.deleteById(ratingId);

        return "Rating successfully deleted";
    }

    @Override
    public List<RatingDto> getRatingsOfUser(String userId) {
        List<Rating> ratingsByUser = ratingRepo.findByUserId(userId);

        List<RatingDto> ratingDtos = ratingsByUser.stream()
                .map(userRating -> modelMapper.map(userRating, RatingDto.class))
                .collect(Collectors.toList());

        return ratingDtos;
    }
}
