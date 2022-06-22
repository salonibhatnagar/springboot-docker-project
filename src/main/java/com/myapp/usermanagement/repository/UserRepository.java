package com.myapp.usermanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.myapp.usermanagement.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

}
