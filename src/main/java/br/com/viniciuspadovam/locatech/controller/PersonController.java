package br.com.viniciuspadovam.locatech.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.viniciuspadovam.locatech.entities.Person;
import br.com.viniciuspadovam.locatech.services.PersonService;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/api/v1/people")
@Slf4j
public class PersonController {

	private final PersonService personService;
	
	public PersonController(PersonService personService) {
		this.personService = personService;
	}

	@GetMapping
	public ResponseEntity<List<Person>> findAll(@RequestParam int page, @RequestParam int size) {
		log.info("GET => /api/v1/people");
		var vehicles = this.personService.findAll(page, size);
		return ResponseEntity.ok(vehicles);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Optional<Person>> findById(@PathVariable int id) {
		log.info("GET => /api/v1/people" + id);
		var people = this.personService.findById(id);
		return ResponseEntity.ok(people);
	}
	
	@PostMapping
	public ResponseEntity<Void> save(@RequestBody Person person) {
		log.info("POST => /api/v1/people");
		this.personService.save(person);
		return ResponseEntity.status(HttpStatus.CREATED).build();
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Void> update(@PathVariable long id, @RequestBody Person person) {
		log.info("PUT => /api/v1/people/" + id);
		this.personService.update(id, person);
		return ResponseEntity.ok().build();
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable long id) {
		log.info("DELETE => /api/v1/people/" + id);
		this.personService.delete(id);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}

}
