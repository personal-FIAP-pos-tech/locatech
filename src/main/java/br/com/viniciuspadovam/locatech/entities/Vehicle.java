package br.com.viniciuspadovam.locatech.entities;

import java.math.BigDecimal;

import lombok.Data;

@Data
public class Vehicle {

	private long id;
	private String brand;
	private String model;
	private String licensePlate;
	private int year;
	private String color;
	private BigDecimal dailyPrice;
	
}
