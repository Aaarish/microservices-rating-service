package com.microservices.ratingservice.repository;

import com.microservices.ratingservice.entity.Rating;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RatingRepo extends JpaRepository<Rating, String> {

    @Query(value = "select * from ratings where ratings.user_id = :userId", nativeQuery = true)
    List<Rating> findByUserId(@Param("userId") String userId);
}
