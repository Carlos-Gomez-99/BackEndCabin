package co.edu.usergioarboleda.alquiler.cabin.app.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.usergioarboleda.alquiler.cabin.app.models.Score;
import co.edu.usergioarboleda.alquiler.cabin.app.repository.ScoreRepository;

@Service
public class ScoreService {

    @Autowired
    private ScoreRepository repository;

    public List<Score> getAll() {
        return repository.findAll();
    }

    public Score getById(Integer id) {
        return repository.findById(id);
    }

    public void delete(Score score) {
        repository.delete(score);
    }

    public void deleteById(Integer id) {
        repository.deleteById(id);
    }

    public Score save(Score score) {
        return repository.save(score);
    }
}
