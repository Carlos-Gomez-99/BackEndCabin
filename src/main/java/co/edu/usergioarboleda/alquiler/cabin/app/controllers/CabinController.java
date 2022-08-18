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

import co.edu.usergioarboleda.alquiler.cabin.app.models.Cabin;
import co.edu.usergioarboleda.alquiler.cabin.app.services.CabinService;

@RestController
@RequestMapping("/Cabin")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class CabinController {
    @Autowired
    private CabinService service;

    @RequestMapping("/all")
    public List<Cabin> getAll() {
        return service.getAll();
    }

    @PostMapping(value = "/save")
    @ResponseStatus(code = HttpStatus.CREATED)
    public Cabin save(@RequestBody Cabin cabin) {
        return service.save(cabin);
    }
}
