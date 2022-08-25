package co.edu.usergioarboleda.alquiler.cabin.app.repository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import co.edu.usergioarboleda.alquiler.cabin.app.models.Client;
import co.edu.usergioarboleda.alquiler.cabin.app.models.Reservation;
import co.edu.usergioarboleda.alquiler.cabin.app.models.custom.CountClient;
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

    public List<CountClient> findTopClients() {
        List<CountClient> respuesta = new ArrayList<>();
        List<Object[]> reporte = repository.countTotalReservationByClient();
        for (Object[] object : reporte) {
            respuesta.add(new CountClient((Long) object[1], (Client) object[0]));
        }
        return respuesta;
    }

    public List<Reservation> findReservationsByStatus(String status) {
        return repository.findAllByStatus(status);
    }

    public List<Reservation> findAllByDates(Date fechaInicial, Date fechaFinal) {
        return repository.findAllByStartDateAfterAndStartDateBefore(fechaInicial, fechaFinal);
    }

}
