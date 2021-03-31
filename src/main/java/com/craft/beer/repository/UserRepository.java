package com.craft.beer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.craft.beer.model.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, String>{

}
