package com.farima.demo.service;

import com.farima.demo.entity.Project;
import com.farima.demo.repository.ProjectRepository;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Data
@Service
public class ProjetService {
    //permet d'avoir acces au repository'
    @Autowired
    private ProjectRepository repository;

    public Optional<Project> getProjet(final Long id){
        return repository.findById(id);
    }

    public Iterable<Project> getProjets(){
        return repository.findAll();
    }
    public void deleteProject(final Long id){
        repository.deleteById(id);
    }
    public Project saveProjet(Project p){
        Project save = repository.save(p);
        return save;
    }
}

