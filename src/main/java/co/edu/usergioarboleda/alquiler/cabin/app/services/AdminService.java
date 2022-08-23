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
                return admin;
            }
        }
    }

    public Admin update(Admin admin) {
        if (admin.getIdAdmin() != null) {
            Admin newAdmin = repository.findById(admin.getIdAdmin());
            if (newAdmin != null) {
                if (admin.getNombre() != null) {
                    newAdmin.setNombre(admin.getNombre());
                }
                if (admin.getCorreo() != null) {
                    newAdmin.setCorreo(admin.getCorreo());
                }
                if (admin.getContrasena() != null) {
                    newAdmin.setContrasena(admin.getContrasena());
                }
                return repository.save(newAdmin);
            } else {
                return admin;
            }
        } else {
            return admin;
        }
    }

    public void delete(Admin admin) {
        repository.delete(admin);
    }

    public void deleteById(Integer id) {
        repository.deleteById(id);
    }
}
