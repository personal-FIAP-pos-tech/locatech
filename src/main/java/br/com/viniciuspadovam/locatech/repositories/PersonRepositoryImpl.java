package br.com.viniciuspadovam.locatech.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.stereotype.Repository;

import br.com.viniciuspadovam.locatech.entities.Person;

@Repository
public class PersonRepositoryImpl implements PersonRepository {

	private final JdbcClient jdbcClient;
	
	public PersonRepositoryImpl(JdbcClient jdbcClient) {
		this.jdbcClient = jdbcClient;
	}

	@Override
	public Optional<Person> findById(long id) {
		return this.jdbcClient
			.sql("SELECT * FROM people WHERE id = :id")
			.param("id", id)
			.query(Person.class)
			.optional();
	}

	@Override
	public List<Person> findAll(int size, int offset) {
		return this.jdbcClient
			.sql("SELECT * FROM people LIMIT :size OFFSET :offset")
			.param("size", size)
			.param("offset", offset)
			.query(Person.class)
			.list();
	}

	@Override
	public Integer save(Person person) {
		return this.jdbcClient
			.sql("INSERT INTO people (name, cpf, phone, email) VALUES (:name, :cpf, :phone, :email)")
			.param("name", person.getName())
			.param("cpf", person.getCpf())
			.param("phone", person.getPhone())
			.param("email", person.getEmail())
			.update();
	}

	@Override
	public Integer update(long id, Person person) {
		return this.jdbcClient
			.sql("UPDATE people SET name = :name, cpf = :cpf, phone = :phone, email = :email WHERE id = :id")
			.param("id", id)
			.param("name", person.getName())
			.param("cpf", person.getCpf())
			.param("phone", person.getPhone())
			.param("email", person.getEmail())
			.update();
	}

	@Override
	public Integer delete(long id) {
		return this.jdbcClient
			.sql("DELETE FROM people WHERE id = :id")
			.param("id", id)
			.update();
	}
	
}
