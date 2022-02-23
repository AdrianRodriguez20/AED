-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 23-02-2022 a las 13:14:55
-- Versión del servidor: 10.4.21-MariaDB
-- Versión de PHP: 8.0.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `restaurante`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `detallefactura`
--

CREATE TABLE `detallefactura` (
  `iddetallefactura` int(11) NOT NULL,
  `cantidad` int(11) NOT NULL,
  `preciounidad` double NOT NULL,
  `fk_idplato` int(11) NOT NULL,
  `fk_idservicio` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `detallefactura`
--

INSERT INTO `detallefactura` (`iddetallefactura`, `cantidad`, `preciounidad`, `fk_idplato`, `fk_idservicio`) VALUES
(55, 1, 8, 4, 1),
(56, 1, 10, 5, 1),
(57, 1, 4, 6, 1),
(58, 1, 6, 12, 2),
(59, 2, 5, 13, 2),
(60, 1, 12, 17, 2),
(61, 3, 10, 5, 15),
(62, 4, 4, 6, 15),
(63, 2, 3, 35, 25),
(64, 2, 1, 19, 25);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `mesas`
--

CREATE TABLE `mesas` (
  `nummesa` int(11) NOT NULL,
  `ocupantesmax` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `mesas`
--

INSERT INTO `mesas` (`nummesa`, `ocupantesmax`) VALUES
(1, 5),
(2, 4),
(3, 2),
(6, 5),
(7, 4),
(21, 4),
(25, 6),
(28, 2),
(29, 3),
(101, 7),
(1000, 7);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `operario`
--

CREATE TABLE `operario` (
  `idoperario` int(11) NOT NULL,
  `nombre` varchar(50) NOT NULL,
  `password` varchar(100) NOT NULL,
  `rol` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `operario`
--

INSERT INTO `operario` (`idoperario`, `nombre`, `password`, `rol`) VALUES
(1, 'admin', '$2a$10$52LG2AqZiGjyXTRFWR8S1upiKxMANaQVfGu8PIXKQP785B298eaVq', 'ROLE_USER'),
(3, 'adrian', '$2a$10$IfteafF9b8ceHp7RdbHRp.X8usYKWi8jdwAyBzaQuDw1qKPJ/q1uu', 'ROLE_USER'),
(5, 'root', '$2a$10$580ek8vsh5tmiiOw1SQuy.X0lb2JDJFBxqfbIuKaSY0hG8Ax0BTg.', 'ROLE_USER');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `platos`
--

CREATE TABLE `platos` (
  `idplato` int(11) NOT NULL,
  `preciounidad` double NOT NULL,
  `disponible` int(11) NOT NULL,
  `descripcion` varchar(100) NOT NULL,
  `nombre` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `platos`
--

INSERT INTO `platos` (`idplato`, `preciounidad`, `disponible`, `descripcion`, `nombre`) VALUES
(3, 24, 0, 'Tortillas de trigo rellenas de pollo a la plancha. ', 'Enchilada'),
(4, 8, 1, '6 palitos fritos rellenos de queso derretido', 'Tequeños'),
(5, 10, 1, 'Dos carnes de 100g estilo smash, bacon, queso americano.', 'Smash'),
(6, 4, 1, 'Ración de Patatas Gajo con cuenco Mayo.', 'Ración Patatas Gajo'),
(7, 10, 1, 'Pollo empanado, queso Grana Padano, mézclum, canónigos, picatostes.', 'Ensalada César'),
(8, 3, 0, 'Tarta de zanahoriaz', 'Mini Carrot'),
(9, 3, 0, 'Tarta de queso con vainilla.', 'Tarta de queso'),
(10, 10, 1, 'Nachos bañados en chili con carne, queso fundido.', 'Nachos'),
(11, 6, 1, '6 tiras de pollo empanadas con salsa Barbacoa', 'Chicken Tenders'),
(12, 6, 1, '7 Alitas de pollo rebozadas crujientes.', 'Crispy Chicken Wings'),
(13, 5, 1, 'Dos tortillas de harina de trigo, jamón cocido, queso cheddar fundido.', 'Quesadilla de Jamón y Queso'),
(15, 10, 1, 'Cachopo a la plancha con salsa de setas.', 'Cachopo'),
(16, 7, 1, 'Pan integral tostado a la plancha, jamón cocido y queso fundido', 'Sándwich Jamón Cocido y Queso Integral'),
(17, 12, 1, 'Queso mozzarella y orégano sobre una base de pan focaccia.', 'Pizza Margarita'),
(18, 12, 1, 'Hamburguesa de queso, tomate y lechuga.', 'Hamburguesa de queso'),
(19, 1, 1, 'Chocolate con leche y nata', 'Batido de chocolate'),
(35, 3, 1, 'Esponjoso bizcocho con chocolate, dulce de leche y mousse bombón.', 'Tarta Chocolate ');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `servicios`
--

CREATE TABLE `servicios` (
  `idservicio` int(11) NOT NULL,
  `fechacomienzo` bigint(20) NOT NULL,
  `fechafin` bigint(20) NOT NULL,
  `reservada` varchar(100) NOT NULL,
  `pagada` bit(1) NOT NULL,
  `fk_nummesa` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `servicios`
--

INSERT INTO `servicios` (`idservicio`, `fechacomienzo`, `fechafin`, `reservada`, `pagada`, `fk_nummesa`) VALUES
(1, 1645891200000, 1645898400000, 'Reserva Jose María', b'0', 7),
(2, 1645970220000, 1645977420000, 'Reserva Adrian', b'0', 1000),
(15, 1646075100000, 1646082300000, 'Cena Terraza Javier', b'0', 6),
(25, 1645869600000, 1645876800000, 'Brunch Andrés', b'0', 28);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `detallefactura`
--
ALTER TABLE `detallefactura`
  ADD PRIMARY KEY (`iddetallefactura`),
  ADD KEY `fk_idplato` (`fk_idplato`),
  ADD KEY `fk_idservicio` (`fk_idservicio`);

--
-- Indices de la tabla `mesas`
--
ALTER TABLE `mesas`
  ADD PRIMARY KEY (`nummesa`);

--
-- Indices de la tabla `operario`
--
ALTER TABLE `operario`
  ADD PRIMARY KEY (`idoperario`),
  ADD UNIQUE KEY `nombre` (`nombre`);

--
-- Indices de la tabla `platos`
--
ALTER TABLE `platos`
  ADD PRIMARY KEY (`idplato`);

--
-- Indices de la tabla `servicios`
--
ALTER TABLE `servicios`
  ADD PRIMARY KEY (`idservicio`),
  ADD KEY `fk_nummesa` (`fk_nummesa`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `detallefactura`
--
ALTER TABLE `detallefactura`
  MODIFY `iddetallefactura` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=65;

--
-- AUTO_INCREMENT de la tabla `operario`
--
ALTER TABLE `operario`
  MODIFY `idoperario` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT de la tabla `platos`
--
ALTER TABLE `platos`
  MODIFY `idplato` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=36;

--
-- AUTO_INCREMENT de la tabla `servicios`
--
ALTER TABLE `servicios`
  MODIFY `idservicio` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=26;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `detallefactura`
--
ALTER TABLE `detallefactura`
  ADD CONSTRAINT `detallefactura_ibfk_1` FOREIGN KEY (`fk_idplato`) REFERENCES `platos` (`idplato`),
  ADD CONSTRAINT `detallefactura_ibfk_2` FOREIGN KEY (`fk_idservicio`) REFERENCES `servicios` (`idservicio`);

--
-- Filtros para la tabla `servicios`
--
ALTER TABLE `servicios`
  ADD CONSTRAINT `servicios_ibfk_1` FOREIGN KEY (`fk_nummesa`) REFERENCES `mesas` (`nummesa`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
