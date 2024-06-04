package com.makes.apibusinesscontroll.services;

import com.makes.apibusinesscontroll.models.User;
import com.makes.apibusinesscontroll.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    public List<User> getAll() {
        return repository.findAll();
    }

    public User getById(Integer id) {
        return repository.findById(id).orElse(null);
    }

    public User save(User user) {
        return repository.save(user);
    }

    public void delete(Integer id) {
        repository.deleteById(id);
    }
}
