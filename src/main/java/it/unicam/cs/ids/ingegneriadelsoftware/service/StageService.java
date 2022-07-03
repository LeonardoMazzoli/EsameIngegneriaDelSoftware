package it.unicam.cs.ids.ingegneriadelsoftware.service;

import it.unicam.cs.ids.ingegneriadelsoftware.model.Stage;
import it.unicam.cs.ids.ingegneriadelsoftware.model.Trip;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class StageService {

    private final TripService tripService;

    @Autowired
    public StageService(TripService tripService) {
        this.tripService = tripService;
    }
}

