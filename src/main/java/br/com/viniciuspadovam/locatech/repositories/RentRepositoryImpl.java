package br.com.viniciuspadovam.locatech.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.stereotype.Repository;

import br.com.viniciuspadovam.locatech.entities.Rent;

@Repository
public class RentRepositoryImpl implements RentRepository {
	
	private final JdbcClient jdbcClient;
	
	public RentRepositoryImpl(JdbcClient jdbcClient) {
		this.jdbcClient = jdbcClient;
	}

	@Override
	public Optional<Rent> findById(long id) {
		return this.jdbcClient
			.sql("SELECT r.id, r.person_id, r.vehicle_id, r.begin_rent_date, r.final_rent_date, r.total_price "
				+ "p.name as person_name, p.cpf as person_cpf, "
				+ "v.model as vehicle_model "
				+ "FROM rents r "
				+ "INNER JOIN people p ON r.person_id = p.id"
				+ "INNER JOIN vehicle v ON r.vehicle_id = v.id"
				+ "WHERE r.id = :id")
			.param("id", id)
			.query(Rent.class)
			.optional();
	}

	@Override
	public List<Rent> findAll(int size, int offset) {
		return this.jdbcClient
			.sql("SELECT r.id, r.person_id, r.vehicle_id, r.begin_rent_date, r.final_rent_date, r.total_price "
					+ "p.name as person_name, p.cpf as person_cpf, "
					+ "v.model as vehicle_model "
					+ "FROM rents r "
					+ "INNER JOIN people p ON r.person_id = p.id"
					+ "INNER JOIN vehicle v ON r.vehicle_id = v.id"
					+ "LIMIT :size"
					+ "OFFSET :offset")
			.param("size", size)
			.param("offset", offset)
			.query(Rent.class)
			.list();
	}

	@Override
	public Integer save(Rent rent) {
		return this.jdbcClient
			.sql("INSERT INTO rents (person_id, vehicle_id, begin_date, end_date, total_price) VALUES (:person_id, :vehicle_id, :begin_date, :end_date, :total_price)")
			.param("person_id", rent.getPersonId())
			.param("vehicle_id", rent.getVehicleId())
			.param("begin_date", rent.getBeginRentDate())
			.param("end_date", rent.getFinalRentDate())
			.param("total_price", rent.getTotalPrice())
			.update();
	}

	@Override
	public Integer update(long id, Rent rent) {
		return this.jdbcClient
			.sql("UPDATE rents SET person_id = :person_id, vehicle_id = :vehicle_id, begin_date = :begin_date, end_date = :end_date, total_price = :total_price WHERE id = :id")
			.param("id", id)
			.param("person_id", rent.getPersonId())
			.param("vehicle_id", rent.getVehicleId())
			.param("begin_date", rent.getBeginRentDate())
			.param("end_date", rent.getFinalRentDate())
			.param("total_price", rent.getTotalPrice())
			.update();
	}

	@Override
	public Integer delete(long id) {
		return this.jdbcClient
			.sql("DELETE FROM rents WHERE id = :id")
			.param("id", id)
			.update();
	}

}
