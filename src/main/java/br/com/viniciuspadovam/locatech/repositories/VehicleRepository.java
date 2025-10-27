package br.com.viniciuspadovam.locatech.repositories;

import java.util.List;
import java.util.Optional;

import br.com.viniciuspadovam.locatech.entities.Vehicle;

public interface VehicleRepository {
	
	Optional<Vehicle> findById(long id);
	List<Vehicle> findAll(int size, int offset);
	Integer save(Vehicle vehicle);
	Integer update(long id, Vehicle vehicle);
	Integer delete(long id);

}
