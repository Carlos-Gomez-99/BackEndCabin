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
                return message;
            }
        }
    }

    public Message update(Message message) {
        if (message.getIdMessage() != null) {
            Message newMessage = repository.findById(message.getIdMessage());
            if (newMessage != null) {
                if (message.getMessageText() != null) {
                    newMessage.setMessageText(message.getMessageText());
                }
                return repository.save(newMessage);
            } else {
                return message;
            }
        } else {
            return message;
        }
    }

    public void delete(Message message) {
        repository.delete(message);
    }

    public void deleteById(Integer id) {
        repository.deleteById(id);
    }
}
