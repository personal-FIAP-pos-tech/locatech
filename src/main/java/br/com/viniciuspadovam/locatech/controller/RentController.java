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

import br.com.viniciuspadovam.locatech.entities.Rent;
import br.com.viniciuspadovam.locatech.services.RentService;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/api/v1/rents")
@Slf4j
public class RentController {
	
	private final RentService rentService;
	
	public RentController(RentService rentService) {
		this.rentService = rentService;
	}

	@GetMapping
	public ResponseEntity<List<Rent>> findAll(@RequestParam int page, @RequestParam int size) {
		log.info("GET => /api/v1/rents");
		var rents = this.rentService.findAll(page, size);
		return ResponseEntity.ok(rents);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Optional<Rent>> findById(@PathVariable int id) {
		log.info("GET => /api/v1/rents" + id);
		var vehicles = this.rentService.findById(id);
		return ResponseEntity.ok(vehicles);
	}
	
	@PostMapping
	public ResponseEntity<Void> save(@RequestBody Rent rent) {
		log.info("POST => /api/v1/rents");
		this.rentService.save(rent);
		return ResponseEntity.status(HttpStatus.CREATED).build();
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Void> update(@PathVariable long id, @RequestBody Rent rent) {
		log.info("PUT => /api/v1/rents/" + id);
		this.rentService.update(id, rent);
		return ResponseEntity.ok().build();
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable long id) {
		log.info("DELETE => /api/v1/rents/" + id);
		this.rentService.delete(id);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}

}
