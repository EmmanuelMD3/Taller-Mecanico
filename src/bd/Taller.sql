CREATE DATABASE Taller;

USE Taller;

SELECT * FROM Administrador;

CREATE TABLE Administrador(
	id_administrador INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(50) NOT NULL,
    correo VARCHAR(100) UNIQUE NOT NULL,
    contrasena VARCHAR(255) NOT NULL
);

CREATE TABLE Empleado(
	id_empleado INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(50) NOT NULL,
    apellido VARCHAR(50) NOT NULL,
    correo VARCHAR(100) UNIQUE NOT NULL,
    contrasena VARCHAR(255) NOT NULL
);

CREATE TABLE Mantenimiento (
    id_mantenimiento INT AUTO_INCREMENT PRIMARY KEY,
    descripcion TEXT NOT NULL,
    fecha DATE NOT NULL,
    id_vehiculo INT NOT NULL,
    id_empleado INT NOT NULL,
    FOREIGN KEY (id_vehiculo) REFERENCES Vehiculo(id_vehiculo) ON DELETE CASCADE,
    FOREIGN KEY (id_empleado) REFERENCES Empleado(id_empleado) ON DELETE CASCADE
) ENGINE=InnoDB;

CREATE TABLE Propietario (
    id_propietario INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(50) NOT NULL,
    telefono VARCHAR(15)
);

CREATE TABLE Vehiculo (
    id_vehiculo INT AUTO_INCREMENT PRIMARY KEY,
    placa VARCHAR(20) UNIQUE NOT NULL,
    marca VARCHAR(50) NOT NULL,
    modelo VARCHAR(50) NOT NULL,
    anio YEAR NOT NULL,
    id_propietario INT NOT NULL,
    FOREIGN KEY (id_propietario) REFERENCES Propietario(id_propietario) ON DELETE CASCADE
);

CREATE TABLE Mantenimiento (
    id_mantenimiento INT AUTO_INCREMENT PRIMARY KEY,
    descripcion TEXT NOT NULL,
    fecha DATE NOT NULL,
    id_vehiculo INT NOT NULL,
    id_empleado INT NOT NULL,
    FOREIGN KEY (id_vehiculo) REFERENCES Vehiculo(id_vehiculo) ON DELETE CASCADE,
    FOREIGN KEY (id_empleado) REFERENCES Empleado(id_empleado) ON DELETE SET NULL
);

CREATE TABLE Asistencia (
    id_registro INT AUTO_INCREMENT PRIMARY KEY,
    id_empleado INT NOT NULL,
    fecha_entrada DATETIME NOT NULL,
    fecha_salida DATETIME,
    FOREIGN KEY (id_empleado) REFERENCES Empleado(id_empleado) ON DELETE CASCADE
);