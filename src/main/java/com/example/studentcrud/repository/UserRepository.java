package com.example.studentcrud.repository;

import com.example.studentcrud.entity.User;
import org.springframework.data.repository.CrudRepository;


public interface UserRepository extends CrudRepository<User, Integer> {
    public Long countById(Integer id);
}
