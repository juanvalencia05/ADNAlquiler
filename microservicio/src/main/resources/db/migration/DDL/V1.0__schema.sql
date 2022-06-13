
CREATE TABLE alquiler (
	id serial PRIMARY KEY,
	tiempo_alquiler INTEGER NOT NULL,
	fecha_alquiler VARCHAR ( 50 ) NOT NULL,
	fecha_devolucion VARCHAR ( 50 ) NOT NULL,
	fecha_devolucion_real VARCHAR ( 50 ) NOT NULL,
	pago INTEGER NOT NULL
);








