package co.edu.usergioarboleda.alquiler.cabin.app.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.usergioarboleda.alquiler.cabin.app.models.Admin;
import co.edu.usergioarboleda.alquiler.cabin.app.repository.AdminRepository;

@Service
public class AdminService {
    
    @Autowired
    private AdminRepository repository;

    public List<Admin> getAll() {
        return repository.findAll();
    }

    public Admin getById(Integer id) {
        return repository.findById(id);
    }

    public Admin save(Admin admin) {
        if (admin.getIdAdmin() == null) {
            return repository.save(admin);
        } else {
            if (repository.findById(admin.getIdAdmin()) == null) {
                return repository.save(admin);
            } else {
                return null;
            }
        }
    }
}
