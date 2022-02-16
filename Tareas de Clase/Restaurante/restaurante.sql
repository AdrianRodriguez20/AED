CREATE DATABASE restaurante;
CREATE TABLE platos
(
  idplato INT AUTO_INCREMENT NOT NULL,
  preciounidad DOUBLE NOT NULL,
  disponible INT NOT NULL,
  descripcion VARCHAR(100) NOT NULL,
  nombre VARCHAR(50) NOT NULL,
  PRIMARY KEY (idplato)
);

CREATE TABLE Operario
(
  idoperario INT AUTO_INCREMENT NOT NULL,
  nombre VARCHAR(50) NOT NULL,
  password VARCHAR(100) NOT NULL,
  rol VARCHAR(100) NOT NULL,
  PRIMARY KEY (idoperario),
  UNIQUE (nombre)
);

CREATE TABLE mesas
(
  nummesa INT NOT NULL,
  ocupantesmax INT NOT NULL,
  PRIMARY KEY (nummesa)
);

CREATE TABLE servicios
(
  idservicio INT AUTO_INCREMENT NOT NULL,
  fechacomienzo BIGINT NOT NULL,
  fechafin BIGINT NOT NULL,
  reservada INT NOT NULL,
  pagada BIT NOT NULL,
  fk_nummesa INT NOT NULL,
  PRIMARY KEY (idservicio),
  FOREIGN KEY (fk_nummesa) REFERENCES mesas(nummesa)
);

CREATE TABLE detallefactura
(
  iddetallefactura INT AUTO_INCREMENT NOT NULL,
  cantidad INT NOT NULL,
  preciounidad DOUBLE NOT NULL,
  fk_idplato INT NOT NULL,
  fk_idservicio INT NOT NULL,
  PRIMARY KEY (iddetallefactura),
  FOREIGN KEY (fk_idplato) REFERENCES platos(idplato),
  FOREIGN KEY (fk_idservicio) REFERENCES servicios(idservicio)
);
