package com.farima.demo.repository;

import com.farima.demo.entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

@Repository
@CrossOrigin("*")
public interface UserRepository extends CrudRepository<User,Long> {
}
