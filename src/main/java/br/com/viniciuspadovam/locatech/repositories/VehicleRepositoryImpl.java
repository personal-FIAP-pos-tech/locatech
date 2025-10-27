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
		return this.jdbcClient
			.sql("INSERT INTO vehicles (brand, model, license_plate, year, color, daily_price) VALUES (:brand, :model, :licensePlate, :year, :color, :dailyPrice)")
			.param("brand", vehicle.getBrand())
			.param("model", vehicle.getModel())
			.param("licensePlate", vehicle.getLicensePlate())
			.param("year", vehicle.getYear())
			.param("color", vehicle.getColor())
			.param("dailyPrice", vehicle.getDailyPrice())
			.update();
	}

	@Override
	public Integer update(long id, Vehicle vehicle) {
		return this.jdbcClient
			.sql("UPDATE vehicles SET brand = :brand, model = :model, license_plate = :licensePlate, year = :year, color = :color, daily_price = dailyPrice WHERE id = :id")
			.param("id", id)
			.param("brand", vehicle.getBrand())
			.param("model", vehicle.getModel())
			.param("licensePlate", vehicle.getLicensePlate())
			.param("year", vehicle.getYear())
			.param("color", vehicle.getColor())
			.param("dailyPrice", vehicle.getDailyPrice())
			.update();
	}

	@Override
	public Integer delete(long id) {
		return this.jdbcClient
			.sql("DELETE FROM vehicles WHERE id = :id")
			.param("id", id)
			.update();
	}

}
