package br.com.viniciuspadovam.locatech.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import br.com.viniciuspadovam.locatech.entities.Rent;
import br.com.viniciuspadovam.locatech.repositories.RentRepository;

@Service
public class RentService {

private final RentRepository rentRepository;
	
	public RentService(RentRepository rentRepository) {
		this.rentRepository = rentRepository;
	}
	
	public List<Rent> findAll(int page, int size) {
		int offset = (page - 1) * size;
		return this.rentRepository.findAll(size, offset);
	}
	
	public Optional<Rent> findById(long id) {
		return this.rentRepository.findById(id);
	}
	
	public void save(Rent rent) {
		var savedRow = this.rentRepository.save(rent);
		Assert.state(savedRow == 1, "Error on saving rent " + rent.getPersonName());
	}
	
	public void update(long id, Rent rent) {
		var updatedRow = this.rentRepository.update(id, rent);
		if(updatedRow == 0)
			throw new RuntimeException("Rent not found.");
	}
	
	public void delete(long id) {
		var deletedRow = this.rentRepository.delete(id);
		if(deletedRow == 0)
			throw new RuntimeException("Rent not found.");
	}
	
}
