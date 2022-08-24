package co.edu.usergioarboleda.alquiler.cabin.app.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import co.edu.usergioarboleda.alquiler.cabin.app.models.Client;
import co.edu.usergioarboleda.alquiler.cabin.app.services.ClientService;

@RestController
@RequestMapping("/Client")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ClientController {

    @Autowired
    private ClientService service;

    @RequestMapping("/all")
    public List<Client> getAll() {
        return service.getAll();
    }

    @RequestMapping("/{id}")
    @ResponseStatus(code = HttpStatus.OK)
    public Client getById(@PathVariable("id") Integer id) {
        return service.getById(id);
    }

    @PostMapping(value = "/save")
    @ResponseStatus(code = HttpStatus.CREATED)
    public Client save(@RequestBody Client client) {
        return service.save(client);
    }

    @PutMapping(value = "/update")
    @ResponseStatus(code = HttpStatus.CREATED)
    public Client update(@RequestBody Client client) {
        return service.update(client);
    }

    @DeleteMapping(value = "{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void delete(@PathVariable("id") Integer id) {
        service.deleteById(id);
    }
}
