package co.edu.usergioarboleda.alquiler.cabin.app.models;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "reservation")
public class Reservation implements Serializable {

    private static final long serialVersionUID = 5L;

    @Id
    @GeneratedValue(strategy = javax.persistence.GenerationType.IDENTITY)
    private Integer idReservation;
    private Date startDate;
    private String reservationTime;
    private Date devolutionDate;

    @ManyToOne
    @JoinColumn(name = "clientId")
    @JsonIgnoreProperties(value = { "reservations" })
    private Client client;

    @ManyToOne
    @JoinColumn(name = "cabinId")
    @JsonIgnoreProperties(value = { "reservations" })
    private Cabin cabin;
}
