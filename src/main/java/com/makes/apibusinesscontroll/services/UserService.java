package com.makes.apibusinesscontroll.services;

import com.makes.apibusinesscontroll.models.User;
import com.makes.apibusinesscontroll.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    public List<User> findAllL() {
        return repository.findAll();
    }

    public Optional<User> findById(Integer id){
        return  repository.findById(id);
    }

    @Transactional
    public User save(User user) {
        return repository.save(user);
    }

    @Transactional
    public void delete(User user) {
        repository.delete(user);
    }

    public boolean existsByEmail(String email) {
        return repository.existsByEmail(email);
    }
}
