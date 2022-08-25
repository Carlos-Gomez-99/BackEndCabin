package co.edu.usergioarboleda.alquiler.cabin.app.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import co.edu.usergioarboleda.alquiler.cabin.app.models.Reservation;
import co.edu.usergioarboleda.alquiler.cabin.app.models.custom.CountClient;
import co.edu.usergioarboleda.alquiler.cabin.app.models.custom.StatusAmount;
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

    @RequestMapping("/{id}")
    @ResponseStatus(code = HttpStatus.OK)
    public Reservation getById(@PathVariable("id") Integer id) {
        return service.getById(id);
    }

    @PostMapping(value = "/save")
    @ResponseStatus(code = HttpStatus.CREATED)
    public Reservation save(@RequestBody Reservation reservation) {
        return service.save(reservation);
    }

    @PutMapping(value = "/update")
    @ResponseStatus(code = HttpStatus.CREATED)
    public Reservation update(@RequestBody Reservation reservation) {
        return service.update(reservation);
    }

    @DeleteMapping(value = "{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void delete(@PathVariable("id") Integer id) {
        service.deleteById(id);
    }

    @GetMapping("/report-dates/{fechaInicial}/{fechaFinal}")
    public List<Reservation> getReportDates(@PathVariable("fechaInicial") String fechaInicial,
            @PathVariable("fechaInicial") String fechaFinal) {
        return service.getReportDates(fechaInicial, fechaFinal);
    }

    @GetMapping("/report-status")
    public StatusAmount getReportStatus() {
        return service.getReservationStatusReport();
    }

    @GetMapping("/report-clients")
    public List<CountClient> getReportClients() {
        return service.getTopClients();
    }

    @GetMapping("/report-dates/amount/{fechaInicial}/{fechaFinal}")
    public Integer getReservationDatesAmount(@PathVariable("fechaInicial") String fechaInicial,
            @PathVariable("fechaInicial") String fechaFinal) {
        return service.getReportDates(fechaInicial, fechaFinal).size();
    }
}
