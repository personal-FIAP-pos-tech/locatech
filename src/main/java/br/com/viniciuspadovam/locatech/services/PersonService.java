package br.com.viniciuspadovam.locatech.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import br.com.viniciuspadovam.locatech.entities.Person;
import br.com.viniciuspadovam.locatech.repositories.PersonRepository;

@Service
public class PersonService {
	
	private final PersonRepository personRepository;
	
	public PersonService(PersonRepository personRepository) {
		this.personRepository = personRepository;
	}
	
	public List<Person> findAll(int page, int size) {
		int offset = (page - 1) * size;
		return this.personRepository.findAll(size, offset);
	}
	
	public Optional<Person> findById(long id) {
		return this.personRepository.findById(id);
	}
	
	public void save(Person person) {
		var savedRow = this.personRepository.save(person);
		Assert.state(savedRow == 1, "Error on saving person " + person.getName());
	}
	
	public void update(long id, Person person) {
		var updatedRow = this.personRepository.update(id, person);
		if(updatedRow == 0)
			throw new RuntimeException("Person not found.");
	}
	
	public void delete(long id) {
		var deletedRow = this.personRepository.delete(id);
		if(deletedRow == 0)
			throw new RuntimeException("Person not found.");
	}

}
