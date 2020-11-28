package edu.escuelaing.arem.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.escuelaing.arem.entities.User;
import edu.escuelaing.arem.persistence.UserRepository;

@Service
public class ServicesUser {
	
	@Autowired
	private UserRepository userRepository;

	public ServicesUser() {
		// TODO Auto-generated constructor stub
	}
	public List<User> getAllUsuarios(){
		return userRepository.findAll();
	}
	public User getUserByEmail(String mail) {
		return userRepository.findByEmail(mail);
	}

}
