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

import co.edu.usergioarboleda.alquiler.cabin.app.models.Admin;
import co.edu.usergioarboleda.alquiler.cabin.app.services.AdminService;

@RestController
@RequestMapping("/Admin")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class AdminController {

    @Autowired
    private AdminService service;

    @RequestMapping("/all")
    public List<Admin> getAll() {
        return service.getAll();
    }

    @RequestMapping("/{id}")
    @ResponseStatus(code = HttpStatus.OK)
    public Admin getById(@PathVariable("id") Integer id) {
        return service.getById(id);
    }

    @PostMapping(value = "/save")
    @ResponseStatus(code = HttpStatus.CREATED)
    public Admin save(@RequestBody Admin admin) {
        return service.save(admin);
    }

    @PutMapping(value = "/update")
    @ResponseStatus(code = HttpStatus.CREATED)
    public Admin update(@RequestBody Admin admin) {
        return service.update(admin);
    }

    @DeleteMapping(value = "/{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void delete(@PathVariable("id") Integer id) {
        service.deleteById(id);
    }
}
