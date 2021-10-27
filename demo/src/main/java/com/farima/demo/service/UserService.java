package com.farima.demo.service;

import com.farima.demo.entity.Project;
import com.farima.demo.entity.User;
import com.farima.demo.repository.UserRepository;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Data
@Service
public class UserService {
    @Autowired
    private UserRepository repository;

    public Optional<User> getUser(final Long id){
        return repository.findById(id);
    }
    public Iterable<User> getUsers(){
        return repository.findAll();
    }
    public void deleteUser(final Long id){
        repository.deleteById(id);
    }
    public User saveUser(User u){
        User save = repository.save(u);
        return save;
    }
    public Optional<User> updateUser(Long id){
        return repository.findById(id);
    }
}
