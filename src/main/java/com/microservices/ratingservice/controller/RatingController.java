package com.microservices.ratingservice.controller;

import com.microservices.ratingservice.dto.RatingDto;
import com.microservices.ratingservice.entity.Rating;
import com.microservices.ratingservice.service.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ratings")
public class RatingController {
    @Autowired
    private RatingService ratingService;

    @PostMapping
    public ResponseEntity<RatingDto> addRating(@RequestBody RatingDto ratingDto){
        return ResponseEntity.status(HttpStatus.CREATED).body(ratingService.addRating(ratingDto));
    }

    @GetMapping("/{ratingId}")
    public ResponseEntity<RatingDto> getRating(@PathVariable String ratingId){
        return ResponseEntity.ok(ratingService.getRating(ratingId));
    }

    @GetMapping
    public ResponseEntity<List<RatingDto>> getRatings(){
        return ResponseEntity.ok(ratingService.getRatings());
    }

    @DeleteMapping("/{ratingId}")
    public ResponseEntity<String> deleteRating(@PathVariable String ratingId){
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(ratingService.deleteRating(ratingId));
    }

    @GetMapping("/users/{userId}")
    public ResponseEntity<List<RatingDto>> getRatingsOfUser(@PathVariable String userId){
        return ResponseEntity.ok(ratingService.getRatingsOfUser(userId));
    }
}
