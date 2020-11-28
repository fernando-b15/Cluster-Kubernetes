package edu.escuelaing.arem.controller;

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
import edu.escuelaing.arem.entities.Registro;
import edu.escuelaing.arem.services.ServicesRegistro;


@RestController
@CrossOrigin
@RequestMapping("registros")
public class RegistroController {
	
	@Autowired
	private ServicesRegistro Service;

	public RegistroController() {
		// TODO Auto-generated constructor stub
	}
	
	@RequestMapping (method = RequestMethod.GET )
	public ResponseEntity<?>  getAllRegistros(){
		try{
			List<Registro> usuarios = Service.getAllRegistros();
			return new ResponseEntity<>(usuarios, HttpStatus.ACCEPTED);
		}catch (Exception e){
			return new ResponseEntity<>(e.getMessage(),HttpStatus.NOT_FOUND);
	   }
	}
	@PostMapping("/save")
	 public ResponseEntity<?> saveRegistro(@RequestBody Registro registro) throws ServletException {
		Service.saveRegitro(registro);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}


}
