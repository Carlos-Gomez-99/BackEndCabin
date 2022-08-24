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

import co.edu.usergioarboleda.alquiler.cabin.app.models.Category;
import co.edu.usergioarboleda.alquiler.cabin.app.services.CategoryService;

@RestController
@RequestMapping("/Category")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class CategoryController {
    @Autowired
    private CategoryService service;

    @RequestMapping("/all")
    public List<Category> getAll() {
        return service.getAll();
    }

    @RequestMapping("/{id}")
    @ResponseStatus(code = HttpStatus.OK)
    public Category getById(@PathVariable("id") Integer id) {
        return service.getById(id);
    }

    @PostMapping(value = "/save")
    @ResponseStatus(code = HttpStatus.CREATED)
    public Category save(@RequestBody Category category) {
        return service.save(category);
    }

    @PutMapping(value = "/update")
    @ResponseStatus(code = HttpStatus.CREATED)
    public Category update(@RequestBody Category category) {
        return service.update(category);
    }

    @DeleteMapping(value = "/{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void delete(@PathVariable("id") Integer id) {
        service.deleteById(id);
    }
}
