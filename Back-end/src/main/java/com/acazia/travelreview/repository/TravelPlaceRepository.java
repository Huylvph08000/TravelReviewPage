package com.acazia.travelreview.repository;

import com.acazia.travelreview.models.TravelPlace;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;



@Repository
public interface TravelPlaceRepository extends JpaRepository<TravelPlace, Long> {
    @Query("select travelplace from TravelPlace travelplace where travelplace.name = ?1")
    TravelPlace findByName(String travelPlaceName);
//    TravelPlace createPost(TravelPlace travelPlace);


}
