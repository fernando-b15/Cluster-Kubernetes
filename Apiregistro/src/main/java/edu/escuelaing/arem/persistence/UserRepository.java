package edu.escuelaing.arem.persistence;

import org.springframework.data.mongodb.repository.MongoRepository;

import edu.escuelaing.arem.entities.User;

public interface UserRepository extends MongoRepository<User, String> {
	User findByEmail(String email);
}