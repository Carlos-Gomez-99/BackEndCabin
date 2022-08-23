package co.edu.usergioarboleda.alquiler.cabin.app.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import co.edu.usergioarboleda.alquiler.cabin.app.models.Category;
import co.edu.usergioarboleda.alquiler.cabin.app.repository.crud.CategoryCrudRepository;

@Repository
public class CategoryRepository {
    @Autowired
    private CategoryCrudRepository repository;

    public List<Category> findAll() {
        return (List<Category>) repository.findAll();
    }

    public Category findById(Integer id) {
        return repository.findById(id).orElse(null);
    }

    public Category save(Category category) {
        return repository.save(category);
    }

    public void delete(Category category) {
        repository.delete(category);
    }

    public void deleteById(Integer id) {
        repository.deleteById(id);
    }
}
