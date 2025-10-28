CREATE TABLE IF NOT EXISTS vehicles (
	id BIGINT AUTO_INCREMENT PRIMARY KEY,
	brand VARCHAR(255),
	model VARCHAR(255),
	license_plate VARCHAR(255),
	"year" INT,
	color VARCHAR(255),
	daily_price DECIMAL(10,2)
);

INSERT INTO vehicles (brand, model, license_plate, "year", color, daily_price) 
VALUES ('Chevrolet', 'Celta', 'ABC-1234', 2010, 'preto', 100.00);
