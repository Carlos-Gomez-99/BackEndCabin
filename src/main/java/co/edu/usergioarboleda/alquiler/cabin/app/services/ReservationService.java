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
                return reservation;
            }
        }
    }

    public Reservation update(Reservation reservation) {
        if (reservation.getIdReservation() != null) {
            Reservation newReservation = repository.findById(reservation.getIdReservation());
            if (newReservation != null) {
                if (reservation.getStartDate() != null) {
                    newReservation.setStartDate(reservation.getStartDate());
                }
                if (reservation.getDevolutionDate() != null) {
                    newReservation.setDevolutionDate(reservation.getDevolutionDate());
                }
                if (reservation.getStatus() != null) {
                    newReservation.setStatus(reservation.getStatus());
                }
                return repository.save(newReservation);
            } else {
                return reservation;
            }
        } else {
            return reservation;
        }
    }

    public void delete(Reservation reservation) {
        repository.delete(reservation);
    }

    public void deleteById(Integer id) {
        repository.deleteById(id);
    }
}
