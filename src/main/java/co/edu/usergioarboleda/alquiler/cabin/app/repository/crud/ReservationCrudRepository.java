package co.edu.usergioarboleda.alquiler.cabin.app.repository.crud;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import co.edu.usergioarboleda.alquiler.cabin.app.models.Reservation;

public interface ReservationCrudRepository extends CrudRepository<Reservation, Integer> {

    public List<Reservation> findAllByStartDateAfterAndStartDateBefore(Date startDate, Date endDate);

    @Query(value = "SELECT c.client, count(c.client) as total FROM reservation c GROUP BY c.client ORDER BY total DESC", nativeQuery = true)
    public List<Object[]> countTotalReservationByClient();

    public List<Reservation> findAllByStatus(String status);

    @Query(value = "SELECT c.cabin, count(c.cabin) as total FROM reservation c GROUP BY c.cabin ORDER BY total DESC", nativeQuery = true)
    public List<Object[]> countTotalReservationByCabin();
}
