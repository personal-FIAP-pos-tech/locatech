CREATE TABLE IF NOT EXISTS vehicles (
	id BIGINT AUTO_INCREMENT PRIMARY KEY,
	brand VARCHAR(255),
	model VARCHAR(255),
	license_plate VARCHAR(255),
	"year" INT,
	color VARCHAR(255),
	daily_price DECIMAL(10,2)
);

CREATE TABLE IF NOT EXISTS people (
	id BIGINT AUTO_INCREMENT PRIMARY KEY,
	"name" VARCHAR(255),
	cpf VARCHAR(255),
	phone VARCHAR(255),
	email VARCHAR(255)
);

CREATE TABLE IF NOT EXISTS rents (
	id BIGINT AUTO_INCREMENT PRIMARY KEY,
	person_id BIGINT NOT NULL,
	vehicle_id BIGINT NOT NULL,
	begin_date DATE,
	end_date DATE,
	total_price DECIMAL(10,2),
	FOREIGN KEY (person_id) REFERENCES people(id),
	FOREIGN KEY (vehicle_id) REFERENCES vehicles(id)
);

INSERT INTO vehicles (brand, model, license_plate, "year", color, daily_price) 
VALUES ('Chevrolet', 'Celta', 'ABC-1234', 2010, 'preto', 100.00);

INSERT INTO people ("name", cpf, phone, email) 
VALUES ('José', '00000000000', '119999-99', 'ze@gmail.com');

INSERT INTO rents (person_id, vehicle_id, begin_date, end_date, total_price) 
VALUES (1, 1, '2025-11-20', '2025-12-05', 1500.00);
