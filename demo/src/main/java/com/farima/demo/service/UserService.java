package com.farima.demo.service;

import com.farima.demo.dto.UserDto;
import com.farima.demo.entity.Project;
import com.farima.demo.entity.User;
import com.farima.demo.repository.UserRepository;
import lombok.Data;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Data
@Service
public class UserService {
    @Autowired
    private UserRepository repository;
    private final ModelMapper modelMapper = new ModelMapper();

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

    public User updateUser(UserDto projectDto){
        User project = modelMapper.map(projectDto, User.class);
        return repository.save(project);
    }


    /*
    public User updateUserDto(Long id, String username){//nouvelle que je test
        User currentUser = userRepository.getById(id);
        currentUser.setUsername(username);
        return userRepository.save(currentUser);
    }*/
}
