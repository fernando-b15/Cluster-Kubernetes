package edu.escuelaing.arem.controller;

import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import edu.escuelaing.arem.config.PasswordEncryptorConfiguration;
import edu.escuelaing.arem.config.Token;
import edu.escuelaing.arem.entities.User;
import edu.escuelaing.arem.services.ServicesUser;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;



@RestController
@CrossOrigin
@RequestMapping("users")
public class UserController {
	
	@Autowired
	private ServicesUser Service;

	public UserController() {
		// TODO Auto-generated constructor stub
	}
	
	@RequestMapping (method = RequestMethod.GET )
	public ResponseEntity<?>  getAllUsers(){
		try{
			List<User> usuarios = Service.getAllUsuarios();
			return new ResponseEntity<>(usuarios, HttpStatus.ACCEPTED);
		}catch (Exception e){
			return new ResponseEntity<>(e.getMessage(),HttpStatus.NOT_FOUND);
	   }
	}
	@PostMapping("/login")
	 public ResponseEntity<?> login(@RequestBody User userLogin) throws ServletException {
		String jwtToken = "";
		System.out.println("llegoooooooooooooo a controlleeeeeeeeeeeeeeeer");
		if (userLogin.getEmail() == null || userLogin.getPassword() == null) {
			throw new ServletException("Please fill in username and password");
		}
		String email = userLogin.getEmail();
		String password = userLogin.getPassword();
		User user = Service.getUserByEmail(email);
		String pwd = user.getPassword();
		if (!pwd.equals(password)) {
			throw new ServletException("Invalid login. Please check your name and password.");
		}
		jwtToken = Jwts.builder().setSubject(email).claim("roles", "user").setIssuedAt(new Date(System.currentTimeMillis() + 600000)).signWith(
				SignatureAlgorithm.HS256, PasswordEncryptorConfiguration.passwordEncryptor().encryptPassword(pwd)).compact();
		return new ResponseEntity<>(new Token(jwtToken, user), HttpStatus.OK);
	}


}
