package edu.escuelaing.arem.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.escuelaing.arem.entities.Registro;
import edu.escuelaing.arem.persistence.RegistroRepository;



@Service
public class ServicesRegistro {
	
	@Autowired
	private RegistroRepository registroRepository;

	public ServicesRegistro() {
		// TODO Auto-generated constructor stub
	}
	public List<Registro> getAllRegistros(){
		return registroRepository.findAll();
	}
	public Registro getRegistroByNumero(int numero) {
		return registroRepository.findByNumero(numero);
	}
	public void saveRegitro(Registro registro) {
		registroRepository.save(registro);
	}

}
