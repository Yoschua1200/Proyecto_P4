-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1:3306
-- Tiempo de generación: 04-05-2021 a las 06:41:01
-- Versión del servidor: 5.7.31
-- Versión de PHP: 7.3.21

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `cursoslibres`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `administradores`
--

DROP TABLE IF EXISTS `administradores`;
CREATE TABLE IF NOT EXISTS `administradores` (
  `cedula` int(11) NOT NULL,
  `nombre` varchar(50) COLLATE utf8_spanish2_ci NOT NULL,
  `correo` varchar(50) COLLATE utf8_spanish2_ci NOT NULL,
  `telefono` varchar(50) COLLATE utf8_spanish2_ci NOT NULL,
  PRIMARY KEY (`cedula`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish2_ci;

--
-- Volcado de datos para la tabla `administradores`
--

INSERT INTO `administradores` (`cedula`, `nombre`, `correo`, `telefono`) VALUES
(1111, 'Admin', 'admin@una.ac.cr', '88989889');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `cursos`
--

DROP TABLE IF EXISTS `cursos`;
CREATE TABLE IF NOT EXISTS `cursos` (
  `codigo` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(40) COLLATE utf8_spanish2_ci NOT NULL,
  `tematica` varchar(40) COLLATE utf8_spanish2_ci NOT NULL,
  `costo` varchar(40) COLLATE utf8_spanish2_ci NOT NULL,
  `status` varchar(40) COLLATE utf8_spanish2_ci NOT NULL,
  `logo` varchar(40) COLLATE utf8_spanish2_ci NOT NULL,
  PRIMARY KEY (`codigo`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8 COLLATE=utf8_spanish2_ci;

--
-- Volcado de datos para la tabla `cursos`
--

INSERT INTO `cursos` (`codigo`, `nombre`, `tematica`, `costo`, `status`, `logo`) VALUES
(1, 'Virtual box', 'Virtualizacion', '10000', 'Oferta', '3.jpg'),
(2, 'VMWare', 'Virtualizacion', '2000', 'Oferta', '2.jpg'),
(3, 'Shodan', 'Internet of Things', '2000', 'Activo', '3.png'),
(4, 'Photoshop', 'Diseño', '3400', 'Oferta', '4.jpg'),
(5, 'Pentesting', 'Seguridad Informatica', '1200', 'Oferta', '1.jpeg'),
(6, 'Arduino', 'Electronica', '1200', 'Activo', '6.jpg'),
(7, 'Puruin', 'Pururin', 'gg', 'gg', 'pururin.jpg'),
(8, 'Cisco', 'Networking', '1200', 'Oferta', 'cisco.jpg');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `estudiantes`
--

DROP TABLE IF EXISTS `estudiantes`;
CREATE TABLE IF NOT EXISTS `estudiantes` (
  `cedula` int(11) NOT NULL,
  `nombre` varchar(40) COLLATE utf8_spanish2_ci NOT NULL,
  `correo` varchar(40) COLLATE utf8_spanish2_ci NOT NULL,
  `telefono` varchar(40) COLLATE utf8_spanish2_ci NOT NULL,
  PRIMARY KEY (`cedula`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish2_ci;

--
-- Volcado de datos para la tabla `estudiantes`
--

INSERT INTO `estudiantes` (`cedula`, `nombre`, `correo`, `telefono`) VALUES
(5050, 'Qwerty', 'qwerty@est.una.ac.cr', '898934'),
(60427, 'Danny', 'danny@est.una.ac.cr', '88989889');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `grupos`
--

DROP TABLE IF EXISTS `grupos`;
CREATE TABLE IF NOT EXISTS `grupos` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `cedula_profesor` int(11) NOT NULL,
  `codigo_curso` int(11) NOT NULL,
  `horario` varchar(40) COLLATE utf8_spanish2_ci NOT NULL,
  PRIMARY KEY (`id`),
  KEY `grupo_fk_curso` (`codigo_curso`),
  KEY `grupo_fk_estudiante` (`cedula_profesor`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8 COLLATE=utf8_spanish2_ci;

--
-- Volcado de datos para la tabla `grupos`
--

INSERT INTO `grupos` (`id`, `cedula_profesor`, `codigo_curso`, `horario`) VALUES
(7, 2222, 6, 'Lunes - Viernes 3pm - 5pm'),
(8, 3426, 5, 'Jueves - SÃ¡bado 1pm - 4pm');

-- --------------------------------------------------------

--
-- Estructura Stand-in para la vista `historial_est`
-- (Véase abajo para la vista actual)
--
DROP VIEW IF EXISTS `historial_est`;
CREATE TABLE IF NOT EXISTS `historial_est` (
`ced_est` int(11)
,`nombre_curso` varchar(40)
,`nombre_prof` varchar(50)
,`horario` varchar(40)
);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `matriculas`
--

DROP TABLE IF EXISTS `matriculas`;
CREATE TABLE IF NOT EXISTS `matriculas` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `id_grupo` int(11) NOT NULL,
  `id_estudiante` int(11) NOT NULL,
  `nota_estudiante` int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id_grupo`,`id_estudiante`),
  UNIQUE KEY `id` (`id`),
  KEY `id_estudiante_fk` (`id_estudiante`),
  KEY `id_grupo_fk` (`id_grupo`)
) ENGINE=InnoDB AUTO_INCREMENT=38 DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla `matriculas`
--

INSERT INTO `matriculas` (`id`, `id_grupo`, `id_estudiante`, `nota_estudiante`) VALUES
(37, 7, 5050, 90);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `profesores`
--

DROP TABLE IF EXISTS `profesores`;
CREATE TABLE IF NOT EXISTS `profesores` (
  `cedula` int(11) NOT NULL,
  `nombre` varchar(50) COLLATE utf8_spanish2_ci NOT NULL,
  `correo` varchar(50) COLLATE utf8_spanish2_ci NOT NULL,
  `telefono` varchar(50) COLLATE utf8_spanish2_ci NOT NULL,
  `especialidad1` varchar(50) COLLATE utf8_spanish2_ci DEFAULT NULL,
  `especialidad2` varchar(50) COLLATE utf8_spanish2_ci DEFAULT NULL,
  `especialidad3` varchar(50) COLLATE utf8_spanish2_ci DEFAULT NULL,
  PRIMARY KEY (`cedula`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish2_ci;

--
-- Volcado de datos para la tabla `profesores`
--

INSERT INTO `profesores` (`cedula`, `nombre`, `correo`, `telefono`, `especialidad1`, `especialidad2`, `especialidad3`) VALUES
(2222, 'Majid', 'majid@una.ac.cr', '89508209', 'Redes', 'IoT', 'Arqui'),
(3426, 'Henry Guevara', 'henry@una.ac.cr', '3232332', 'Seguridad', 'Soporte técnico', 'Arqui');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuarios`
--

DROP TABLE IF EXISTS `usuarios`;
CREATE TABLE IF NOT EXISTS `usuarios` (
  `cedula` int(11) NOT NULL,
  `contrasena` varchar(40) COLLATE utf8mb4_spanish_ci DEFAULT NULL,
  `tipo` int(11) DEFAULT NULL,
  PRIMARY KEY (`cedula`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_spanish_ci;

--
-- Volcado de datos para la tabla `usuarios`
--

INSERT INTO `usuarios` (`cedula`, `contrasena`, `tipo`) VALUES
(1111, '1234', 3),
(2222, '8954', 2),
(5050, '5249 ', 1);

-- --------------------------------------------------------

--
-- Estructura para la vista `historial_est`
--
DROP TABLE IF EXISTS `historial_est`;

DROP VIEW IF EXISTS `historial_est`;
CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `historial_est`  AS  select `e`.`cedula` AS `ced_est`,`c`.`nombre` AS `nombre_curso`,`p`.`nombre` AS `nombre_prof`,`g`.`horario` AS `horario` from ((((`estudiantes` `e` join `cursos` `c`) join `profesores` `p`) join `grupos` `g`) join `matriculas` `m`) where ((`g`.`cedula_profesor` = `p`.`cedula`) and (`g`.`codigo_curso` = `c`.`codigo`) and (`m`.`id_estudiante` = `e`.`cedula`) and (`m`.`id_grupo` = `g`.`id`)) ;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `grupos`
--
ALTER TABLE `grupos`
  ADD CONSTRAINT `grupo_fk_curso` FOREIGN KEY (`codigo_curso`) REFERENCES `cursos` (`codigo`),
  ADD CONSTRAINT `grupo_fk_estudiante` FOREIGN KEY (`cedula_profesor`) REFERENCES `profesores` (`cedula`);

--
-- Filtros para la tabla `matriculas`
--
ALTER TABLE `matriculas`
  ADD CONSTRAINT `id_estudiante_fk` FOREIGN KEY (`id_estudiante`) REFERENCES `estudiantes` (`cedula`),
  ADD CONSTRAINT `id_grupo_fk` FOREIGN KEY (`id_grupo`) REFERENCES `grupos` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
