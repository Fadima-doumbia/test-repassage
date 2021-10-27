package com.farima.demo.repository;

import com.farima.demo.entity.Project;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

@Repository
@CrossOrigin("*")
public interface ProjectRepository extends CrudRepository<Project,Long> {
}
