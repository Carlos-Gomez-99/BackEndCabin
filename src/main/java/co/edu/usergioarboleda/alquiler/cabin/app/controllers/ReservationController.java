package co.edu.usergioarboleda.alquiler.cabin.app.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import co.edu.usergioarboleda.alquiler.cabin.app.models.Reservation;
import co.edu.usergioarboleda.alquiler.cabin.app.services.ReservationService;

@RestController
@RequestMapping("/Reservation")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ReservationController {

    @Autowired
    private ReservationService service;

    @RequestMapping("/all")
    public List<Reservation> getAll() {
        return service.getAll();
    }

    @PostMapping(value = "/save")
    @ResponseStatus(code = HttpStatus.CREATED)
    public Reservation save(@RequestBody Reservation reservation) {
        return service.save(reservation);
    }
}
