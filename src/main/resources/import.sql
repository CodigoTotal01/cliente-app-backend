/* -- REGIONES (ERROR SI NO SE COLOCAN RELACIONADAS A LA LLAVE FOARANEA ) --*/

INSERT INTO regiones(id, nombre) VALUES (1, "Sudameríca");
INSERT INTO regiones(id, nombre) VALUES (2, "Centroamérica");
INSERT INTO regiones(id, nombre) VALUES (3, "Norteamérica");
INSERT INTO regiones(id, nombre) VALUES (4, "Europa");
INSERT INTO regiones(id, nombre) VALUES (5, "Asia");
INSERT INTO regiones(id, nombre) VALUES (6, "Africa");
INSERT INTO regiones(id, nombre) VALUES (7, "Oceania");
INSERT INTO regiones(id, nombre) VALUES (8, "Antartida");



/*cLIENTES*/
INSERT INTO clientes (nombre, apellido, email, create_at, region_id) VALUES('Andrés', 'Guzmán', 'profesor@bolsadeideas.com', '2018-01-01',1);
INSERT INTO clientes (nombre, apellido, email, create_at, region_id) VALUES('Mr. John', 'Doe', 'john.doe@gmail.com', '2018-01-02',2);
INSERT INTO clientes (nombre, apellido, email, create_at, region_id) VALUES('Linus', 'Torvalds', 'linus.torvalds@gmail.com', '2018-01-03',3);
INSERT INTO clientes (nombre, apellido, email, create_at, region_id) VALUES('Rasmus', 'Lerdorf', 'rasmus.lerdorf@gmail.com', '2018-01-04',4);
INSERT INTO clientes (nombre, apellido, email, create_at, region_id) VALUES('Erich', 'Gamma', 'erich.gamma@gmail.com', '2018-02-01',5);
INSERT INTO clientes (nombre, apellido, email, create_at, region_id) VALUES('Richard', 'Helm', 'richard.helm@gmail.com', '2018-02-10',6);
INSERT INTO clientes (nombre, apellido, email, create_at, region_id) VALUES('Ralph', 'Johnson', 'ralph.johnson@gmail.com', '2018-02-18',7);
INSERT INTO clientes (nombre, apellido, email, create_at, region_id) VALUES('Andrés', 'Guzmán', 'profesor@bolsadeideas.com', '2018-01-01',8);
INSERT INTO clientes (nombre, apellido, email, create_at, region_id) VALUES('Mr. John', 'Doe', 'john.doe@gmail.com', '2018-01-02',1);
INSERT INTO clientes (nombre, apellido, email, create_at, region_id) VALUES('Linus', 'Torvalds', 'linus.torvalds@gmail.com', '2018-01-03',2);
INSERT INTO clientes (nombre, apellido, email, create_at, region_id) VALUES('Rasmus', 'Lerdorf', 'rasmus.lerdorf@gmail.com', '2018-01-04',3);
INSERT INTO clientes (nombre, apellido, email, create_at, region_id) VALUES('Erich', 'Gamma', 'erich.gamma@gmail.com', '2018-02-01',4);
INSERT INTO clientes (nombre, apellido, email, create_at, region_id) VALUES('Richard', 'Helm', 'richard.helm@gmail.com', '2018-02-10',5);
INSERT INTO clientes (nombre, apellido, email, create_at, region_id) VALUES('Ralph', 'Johnson', 'ralph.johnson@gmail.com', '2018-02-18',6);
INSERT INTO clientes (nombre, apellido, email, create_at, region_id) VALUES('Andrés', 'Guzmán', 'profesor@bolsadeideas.com', '2018-01-01',7);

