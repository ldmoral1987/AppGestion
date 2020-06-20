-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Servidor: localhost
-- Tiempo de generación: 19-06-2020 a las 17:14:06
-- Versión del servidor: 10.4.11-MariaDB
-- Versión de PHP: 7.4.6

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `AppGestion`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `employee`
--

CREATE TABLE `employee` (
  `id` int(11) NOT NULL,
  `name` varchar(64) NOT NULL,
  `email` varchar(64) NOT NULL,
  `telephone` varchar(64) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `employee`
--

INSERT INTO `employee` (`id`, `name`, `email`, `telephone`) VALUES
(1, 'José María Sánchez', 'jmsanchez@empresa.com', '957-111111'),
(2, 'Alberto García', 'agarcia@empresa.com', '957-111112'),
(3, 'Silvia Torres', 'storres@empresa.com', '957-111113'),
(4, 'Ana Fuentes', 'afuentes@empresa.com', '957-111114'),
(5, 'Virginia Gutiérrez', 'vgutierrez@empresa.com', '957-111115'),
(6, 'Máximo Iriarte', 'miriarte@empresa.com', '957-111116'),
(7, 'María del Moral', 'mdmoral@empresa.com', '1');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `product`
--

CREATE TABLE `product` (
  `id` int(11) NOT NULL,
  `reference` varchar(32) NOT NULL,
  `name` varchar(64) NOT NULL,
  `category` varchar(64) NOT NULL,
  `price` double(6,2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `product`
--

INSERT INTO `product` (`id`, `reference`, `name`, `category`, `price`) VALUES
(1, 'x42dgc4', 'SSD-240-Seagate', 'Hardware', 75.99),
(2, 'x42dgc4', 'SSD-240G-WD', 'Hardware', 69.99),
(3, 't67xgt3', 'SSD-480G-WD', 'Hardware', 99.99),
(4, 'r02nrf7', 'SSD-1T-Seagate', 'Hardware', 149.99),
(5, 'm55grl3', 'HP-1747-Pro', 'Portátiles', 899.99),
(6, 'l52hwl7', 'HP-1256-Pro', 'Portátiles', 699.99),
(7, 'm35gql8', 'HP-2467q', 'Portátiles', 499.99),
(8, 'p63vks4', 'Cal. IBM-564', 'Mat. oficina', 99.99),
(9, 'q92dev9', 'Paquete folios A4', 'Mat. oficina', 3.50),
(10, 'v18cje4', 'Grapadora', 'Mat. oficina', 5.99);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `user`
--

CREATE TABLE `user` (
  `user_id` int(11) NOT NULL,
  `username` varchar(45) NOT NULL,
  `password` varchar(64) NOT NULL,
  `role` varchar(45) NOT NULL,
  `enabled` tinyint(4) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `user`
--

INSERT INTO `user` (`user_id`, `username`, `password`, `role`, `enabled`) VALUES
(1, 'admin', '$2a$10$engL0F8JsCe2lfuHGZAy2e.AlL0MVKAcEZo9MlOTZTHiQtO2DSTby', 'ROLE_ADMIN', 1),
(2, 'usuario', '$2a$10$iiQidLIMUa3YK.dn4O0NOO724ahdyH5jSjHtKXnlNHbjG9xQhXrHW', 'ROLE_USER', 1);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `employee`
--
ALTER TABLE `employee`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `product`
--
ALTER TABLE `product`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`user_id`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `user`
--
ALTER TABLE `user`
  MODIFY `user_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
