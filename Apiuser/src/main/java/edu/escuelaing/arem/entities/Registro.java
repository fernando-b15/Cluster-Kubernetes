package edu.escuelaing.arem.entities;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "registros")
public class Registro {
	private int numero;
	private String message;

	public Registro() {
		// TODO Auto-generated constructor stub
	}

	public Registro(int numero, String message) {
		this.numero = numero;
		this.message = message;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	

}
