package com.acazia.travelreview.security.services;

import com.acazia.travelreview.models.TravelPlace;
import com.acazia.travelreview.repository.TravelPlaceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

public class TravelPlaceServiceImpl implements TravelPlaceService{
    @Autowired
    private TravelPlaceRepository travelPlaceRepository;
    @Override
    public TravelPlace createTravelPlace(TravelPlace travelPlace) {
        return travelPlaceRepository.save(travelPlace);
    }
}
