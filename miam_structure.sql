-- phpMyAdmin SQL Dump
-- version 3.4.10.1deb1
-- http://www.phpmyadmin.net
--
-- Client: localhost
-- Généré le : Sam 26 Octobre 2013 à 14:43
-- Version du serveur: 5.5.34
-- Version de PHP: 5.3.10-1ubuntu3.8

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Base de données: `miam`
--
CREATE DATABASE `miam` DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci;
USE `miam`;

-- --------------------------------------------------------

--
-- Structure de la table `recipe`
--

DROP TABLE IF EXISTS `recipe`;
CREATE TABLE IF NOT EXISTS `recipe` (
  `id` int(11) NOT NULL,
  `name` varchar(255) NOT NULL,
  `photo` varchar(255) NOT NULL,
  `persons` int(11) NOT NULL,
  `prep_time` int(11) NOT NULL,
  `cooking_time` int(11) NOT NULL,
  `ingredients` text NOT NULL,
  `steps` text NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `recipe_history`
--

DROP TABLE IF EXISTS `recipe_history`;
CREATE TABLE IF NOT EXISTS `recipe_history` (
  `user` int(11) NOT NULL,
  `recipe` int(11) NOT NULL,
  `date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `session`
--

DROP TABLE IF EXISTS `session`;
CREATE TABLE IF NOT EXISTS `session` (
  `uid` varchar(32) NOT NULL,
  `user` int(11) NOT NULL,
  `expiration` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`uid`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `user`
--

DROP TABLE IF EXISTS `user`;
CREATE TABLE IF NOT EXISTS `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `mail` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `admin` int(1) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=4 ;

ALTER TABLE  `recipe_history` ADD  `id` INT NOT NULL AUTO_INCREMENT FIRST ,
ADD PRIMARY KEY (  `id` );

ALTER TABLE  `recipe` CHANGE  `id`  `id` INT( 11 ) NOT NULL AUTO_INCREMENT;

INSERT INTO `recipe` (`id`, `name`, `photo`, `persons`, `prep_time`, `cooking_time`, `ingredients`, `steps`) VALUES
(1, 'Clafoutis aux cerises', 'img2/images_recettes/clafoutis.jpg', 6, 10, 10, '{"fruit":"oui","other":"Beurre pour le moule","flour":"50","coconut":"0","milk":"0.5","butter":"0","vanilla_sugar":"0","egg":"3","vanilla":"0","sugar":"50","oil":"4"}', '				<p>Préchauffez le four th.6 (180°C).</p>\r\n				<p>Mélangez la farine, le sucre, l''huile et les oeufs dans une terrine, mélangez bien afin d''obtenir une pate homogène.</p>\r\n				<p>Ajoutez le lait pour obtenir une pate un peu plus épaisse que la pate à crèpes.</p>\r\n				<p>Beurrez un moule.</p>\r\n				<p>Ajoutez les fruits choisis.</p>\r\n				<p>Versez la pate et enfournez pendant 40 min.</p>');

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
