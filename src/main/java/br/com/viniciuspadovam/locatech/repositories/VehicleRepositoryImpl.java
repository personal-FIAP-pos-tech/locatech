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
		return this.jdbcClient
			.sql("SELECT * FROM vehicles WHERE id = :id")
			.param("id", id)
			.query(Vehicle.class)
			.optional();
	}

	@Override
	public List<Vehicle> findAll(int size, int offset) {
		return this.jdbcClient
			.sql("SELECT * FROM vehicles LIMIT :size OFFSET :offset")
			.param("size", size)
			.param("offset", offset)
			.query(Vehicle.class)
			.list();
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
