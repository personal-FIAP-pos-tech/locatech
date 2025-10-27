package br.com.viniciuspadovam.locatech.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.stereotype.Repository;

import br.com.viniciuspadovam.locatech.entities.Vehicle;

@Repository
public class VehicleRepositoryImpl implements VehicleRepository {

	private final JdbcClient jdbcClient;
	
	public VehicleRepositoryImpl(JdbcClient jdbcClient) {
		this.jdbcClient = jdbcClient;
	}

	@Override
	public Optional<Vehicle> findById(long id) {
		// TODO Auto-generated method stub
		return Optional.empty();
	}

	@Override
	public List<Vehicle> findAll(int size, int offset) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer save(Vehicle vehicle) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer update(long id, Vehicle vehicle) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer delete(long id) {
		// TODO Auto-generated method stub
		return null;
	}

}
