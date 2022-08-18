package co.edu.usergioarboleda.alquiler.cabin.app.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import co.edu.usergioarboleda.alquiler.cabin.app.models.Reservation;
import co.edu.usergioarboleda.alquiler.cabin.app.repository.crud.ReservationCrudRepository;

@Repository
public class ReservationRepository {
    @Autowired
    private ReservationCrudRepository repository;

    public List<Reservation> findAll() {
        return (List<Reservation>) repository.findAll();
    }

    public Reservation findById(Integer id) {
        return repository.findById(id).orElse(null);
    }

    public Reservation save(Reservation reservation) {
        return repository.save(reservation);
    }

    public void delete(Reservation reservation) {
        repository.delete(reservation);
    }

    public void deleteById(Integer id) {
        repository.deleteById(id);
    }
}
