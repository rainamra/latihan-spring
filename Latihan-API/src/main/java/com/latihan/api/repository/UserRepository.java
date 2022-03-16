package com.latihan.api.repository;

import com.latihan.api.model.User;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    public User findByidUser(Integer idUser);
    public User findByuserName(String userName);

    // public User findByidUserAndusername(Integer idUser, String username);
}
