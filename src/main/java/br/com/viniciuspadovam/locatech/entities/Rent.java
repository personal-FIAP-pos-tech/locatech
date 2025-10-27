package br.com.viniciuspadovam.locatech.entities;

import java.math.BigDecimal;
import java.time.LocalDate;

import lombok.Data;

@Data
public class Rent {

	private long id;
	private long personId;
	private long vehicleId;
	private String vehicle;
	private String personCpf;
	private String personName;
	private LocalDate beginRentDate;
	private LocalDate finalRentDate;
	private BigDecimal totalPrice;
	
}
