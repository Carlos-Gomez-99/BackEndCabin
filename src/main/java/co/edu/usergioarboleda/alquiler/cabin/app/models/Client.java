package co.edu.usergioarboleda.alquiler.cabin.app.models;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "client")
public class Client implements Serializable {

    private static final long serialVersionUID = 3L;

    @Id
    @GeneratedValue(strategy = javax.persistence.GenerationType.IDENTITY)
    private Integer idClient;
    private String email;
    private String password;
    private String name;
    private Integer age;

    @OneToMany(cascade = { CascadeType.PERSIST }, mappedBy = "client")
    @JsonIgnoreProperties(value = { "client" })
    private List<Message> messages;

    @OneToMany(cascade = { CascadeType.PERSIST }, mappedBy = "client")
    @JsonIgnoreProperties(value = { "client" })
    private List<Reservation> reservations;
}
