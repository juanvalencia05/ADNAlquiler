
CREATE TABLE alquiler (
	id serial PRIMARY KEY,
	fecha_alquiler VARCHAR ( 50 ) UNIQUE NOT NULL,
	fecha_devolucion VARCHAR ( 50 ) NOT NULL,
	fecha_devolucion_real VARCHAR ( 255 ) UNIQUE NOT NULL,
	pago INTEGER NOT NULL
);








