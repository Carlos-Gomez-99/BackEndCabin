package co.edu.usergioarboleda.alquiler.cabin.app.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.usergioarboleda.alquiler.cabin.app.models.Reservation;
import co.edu.usergioarboleda.alquiler.cabin.app.repository.ReservationRepository;

@Service
public class ReservationService {

    @Autowired
    private ReservationRepository repository;

    public List<Reservation> getAll() {
        return repository.findAll();
    }

    public Reservation getById(Integer id) {
        return repository.findById(id);
    }

    public Reservation save(Reservation reservation) {
        if (reservation.getIdReservation() == null) {
            return repository.save(reservation);
        } else {
            if (repository.findById(reservation.getIdReservation()) == null) {
                return repository.save(reservation);
            } else {
                return null;
            }
        }
    }
}
