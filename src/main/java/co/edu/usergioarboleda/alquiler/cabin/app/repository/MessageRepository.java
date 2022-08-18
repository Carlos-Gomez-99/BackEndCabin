package co.edu.usergioarboleda.alquiler.cabin.app.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import co.edu.usergioarboleda.alquiler.cabin.app.models.Message;
import co.edu.usergioarboleda.alquiler.cabin.app.repository.crud.MessageCrudRepository;

@Repository
public class MessageRepository {
    @Autowired
    private MessageCrudRepository repository;

    public List<Message> findAll() {
        return (List<Message>) repository.findAll();
    }

    public Message findById(Integer id) {
        return repository.findById(id).orElse(null);
    }

    public Message save(Message message) {
        return repository.save(message);
    }

    public void delete(Message message) {
        repository.delete(message);
    }

    public void deleteById(Integer id) {
        repository.deleteById(id);
    }
}
