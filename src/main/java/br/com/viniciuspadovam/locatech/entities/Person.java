package br.com.viniciuspadovam.locatech.entities;

import lombok.Data;

@Data
public class Person {

	private long id;
	private String name;
	private String cpf;
	private String phone;
	private String email;
	
}
