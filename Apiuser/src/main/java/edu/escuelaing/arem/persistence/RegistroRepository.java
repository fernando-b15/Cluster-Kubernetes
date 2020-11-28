package edu.escuelaing.arem.persistence;

import org.springframework.data.mongodb.repository.MongoRepository;

import edu.escuelaing.arem.entities.Registro;


public interface RegistroRepository extends MongoRepository<Registro, String> {
	Registro findByNumero(int numero);
}