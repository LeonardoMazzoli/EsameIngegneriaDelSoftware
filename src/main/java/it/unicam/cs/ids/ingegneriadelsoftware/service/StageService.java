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

    @Transactional
    public void save(Stage stage, Long tripId) {
        if (stage == null) throw new NullPointerException("Tappa Nulla");
        if (tripId == null || tripId < 0) throw new IllegalArgumentException("Id del viaggio non valido");
        Trip trip = this.tripService.findByID(tripId);
        trip.getTripStages().add(stage);
        this.tripService.save(trip);
    }
}


