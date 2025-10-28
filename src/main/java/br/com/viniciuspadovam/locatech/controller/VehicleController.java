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

import br.com.viniciuspadovam.locatech.entities.Vehicle;
import br.com.viniciuspadovam.locatech.services.VehicleService;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/api/v1/vehicles")
@Slf4j
public class VehicleController {
	
	private final VehicleService vehicleService;
	
	public VehicleController(VehicleService vehicleService) {
		this.vehicleService = vehicleService;
	}

	@GetMapping
	public ResponseEntity<List<Vehicle>> findAll(@RequestParam int page, @RequestParam int size) {
		log.info("GET => /vehicles");
		var vehicles = this.vehicleService.findAll(page, size);
		return ResponseEntity.ok(vehicles);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Optional<Vehicle>> findById(@PathVariable int id) {
		log.info("GET => /vehicles/" + id);
		var vehicles = this.vehicleService.findById(id);
		return ResponseEntity.ok(vehicles);
	}
	
	@PostMapping
	public ResponseEntity<Void> save(@RequestBody Vehicle vehicle) {
		log.info("POST => /vehicles");
		this.vehicleService.save(vehicle);
		return ResponseEntity.status(HttpStatus.CREATED).build();
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Void> update(@PathVariable long id, @RequestBody Vehicle vehicle) {
		log.info("PUT => /vehicles/" + id);
		this.vehicleService.update(id, vehicle);
		return ResponseEntity.ok().build();
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable long id) {
		log.info("DELETE => /vehicles/" + id);
		this.vehicleService.delete(id);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}

}
