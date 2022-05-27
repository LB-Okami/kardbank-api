package com.kardbanktest.kardbank.repository;

import java.util.List;
import java.util.Optional;

import com.kardbanktest.kardbank.model.User;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long>{
    
    List<User> findAll();

    Optional<User> findById(Long id);

    List<User> findByName(String name);

    List<User> findByEmail(String email);

    List<User> findByCpf(String cpf);

    List<User> findByNumber(String number);


}
