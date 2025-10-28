package br.com.viniciuspadovam.locatech.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import br.com.viniciuspadovam.locatech.entities.Vehicle;
import br.com.viniciuspadovam.locatech.repositories.VehicleRepository;

@Service
public class VehicleService {

	private final VehicleRepository vehicleRepository;
	
	public VehicleService(VehicleRepository vehicleRepository) {
		this.vehicleRepository = vehicleRepository;
	}
	
	public List<Vehicle> findAll(int page, int size) {
		int offset = (page - 1) * size;
		return this.vehicleRepository.findAll(size, offset);
	}
	
	public Optional<Vehicle> findById(long id) {
		return this.vehicleRepository.findById(id);
	}
	
	public void save(Vehicle vehicle) {
		var savedRow = this.vehicleRepository.save(vehicle);
		Assert.state(savedRow == 1, "Error on saving vehicle " + vehicle.getModel());
	}
	
	public void update(long id, Vehicle vehicle) {
		var updatedRow = this.vehicleRepository.update(id, vehicle);
		if(updatedRow == 0)
			throw new RuntimeException("Vehicle not found.");
	}
	
	public void delete(long id) {
		var deletedRow = this.vehicleRepository.delete(id);
		if(deletedRow == 0)
			throw new RuntimeException("Vehicle not found.");
	}
	
}
