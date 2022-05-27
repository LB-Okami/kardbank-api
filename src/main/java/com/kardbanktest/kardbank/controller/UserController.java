package com.kardbanktest.kardbank.controller;

import java.util.List;

import com.kardbanktest.kardbank.model.User;
import com.kardbanktest.kardbank.repository.UserRepository;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class UserController {
    
    private UserRepository repository;

    UserController(UserRepository userRepository) {
        this.repository = userRepository;
    }

    @GetMapping
    public ResponseEntity<List<User>> findAll() {
        return ResponseEntity.ok( repository.findAll());
    }

    @GetMapping(path = {"/{id}"})
    public ResponseEntity findById(@PathVariable long id){
        return repository.findById(id).map(resp -> ResponseEntity.ok(resp)).orElse(ResponseEntity.notFound().build());
    }

    @GetMapping(path = {"/name/{name}"})
    public ResponseEntity<List<User>> findByName(@PathVariable String name) {
        return ResponseEntity.ok(repository.findByName(name));
    }

    @GetMapping(path = {"/email/{email}"})
    public ResponseEntity<List<User>> findByEmail(@PathVariable String email) {
        return ResponseEntity.ok(repository.findByEmail(email));
    }

    @GetMapping(path = {"/cpf/{cpf}"})
    public ResponseEntity<List<User>> findByCpf (@PathVariable String cpf) {
        return ResponseEntity.ok(repository.findByCpf(cpf));
    }

    @PostMapping
    public ResponseEntity<User> save(@RequestBody User user) {
        return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(user));
    }

    @PutMapping(path = {"/{id}"})
	public ResponseEntity<User> put(@RequestBody User user, @PathVariable Long id) {
		return ResponseEntity.status(HttpStatus.OK).body(repository.save(user));
	}

    @DeleteMapping("/{id}")
	public void delete(@PathVariable Long id) {
		repository.deleteById(id);
	}
}
