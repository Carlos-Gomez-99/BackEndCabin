package co.edu.usergioarboleda.alquiler.cabin.app.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import co.edu.usergioarboleda.alquiler.cabin.app.models.Client;
import co.edu.usergioarboleda.alquiler.cabin.app.repository.crud.ClientCrudRepository;

@Repository
public class ClientRepository {
    @Autowired
    private ClientCrudRepository repository;

    public List<Client> findAll() {
        return (List<Client>) repository.findAll();
    }

    public Client findById(Integer id) {
        return repository.findById(id).orElse(null);
    }

    public Client save(Client client) {
        return repository.save(client);
    }

    public void delete(Client client) {
        repository.delete(client);
    }

    public void deleteById(Integer id) {
        repository.deleteById(id);
    }
}
