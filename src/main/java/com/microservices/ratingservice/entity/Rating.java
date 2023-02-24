package com.microservices.ratingservice.entity;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ratings")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Rating {
    @Id
    @Column(name = "rating_id")
    private String ratingId;
    private String userId;
    private String hotelId;
    private int rating;
    private String remark;
}
