package br.com.viniciuspadovam.locatech.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/vehicles")
public class VehicleController {
	
	@GetMapping
	public ResponseEntity<String> getVehicles() {
		return ResponseEntity.ok("Vehicle");
	}

}
