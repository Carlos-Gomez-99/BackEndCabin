package co.edu.usergioarboleda.alquiler.cabin.app.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.usergioarboleda.alquiler.cabin.app.models.Message;
import co.edu.usergioarboleda.alquiler.cabin.app.repository.MessageRepository;

@Service
public class MessageService {
    
    @Autowired
    private MessageRepository repository;

    public List<Message> getAll() {
        return repository.findAll();
    }

    public Message getById(Integer id) {
        return repository.findById(id);
    }

    public Message save(Message message) {
        if (message.getIdMessage() == null) {
            return repository.save(message);
        } else {
            if (repository.findById(message.getIdMessage()) == null) {
                return repository.save(message);
            } else {
                return null;
            }
        }
    }
}
