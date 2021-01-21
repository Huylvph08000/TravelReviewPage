package com.acazia.travelreview.repository;

import com.acazia.travelreview.models.TravelPlace;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface TravelPlaceRepository extends JpaRepository<TravelPlace, Long> {
    @Query("select travelplace from TravelPlace travelplace where travelplace.id = ?1")
    Optional<TravelPlace> findById(Long id);


    TravelPlace findAllByNameContaining(String name);
}
