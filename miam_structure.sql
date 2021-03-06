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

INSERT INTO `recipe` (`id`, `name`, `photo`, `persons`, `prep_time`, `cooking_time`, `ingredients`, `steps`) VALUES
(2, 'Crêpes', 'img2/images_recettes/crepes.jpg', 4, 5, 15, '{"fruit":"non","other":"beurre pour la poele","flour":"100","coconut":"0","milk":"0.375","butter":"0","vanilla_sugar":"1","egg":"2","vanilla":"0","sugar":"0","oil":"0"}', '<p>Battez les oeufs dans un plat.</p>\r\n\r\n<p>Incorporez peu &agrave; peu la farine &agrave; la pr&eacute;paration tout en m&eacute;langeant.</p>\r\n\r\n<p>Faites de m&ecirc;me avec le lait.</p>\r\n\r\n<p>Incorporez le sucre vanill&eacute; et m&eacute;langez.</p>\r\n\r\n<p>Faites cuire la p&acirc;te dans une po&ecirc;le beurr&eacute;e bien chaude.</p>\r\n\r\n<p>Ajoutez du sucre, chocolat, glace ou autre directement dans votre assiette.</p>');

INSERT INTO `recipe` (`id`, `name`, `photo`, `persons`, `prep_time`, `cooking_time`, `ingredients`, `steps`) VALUES
(5, 'Churros Espagnols', 'img2/images_recettes/churros.jpg', 4, 10, 4, '{"fruit":"non","other":"25 cl d\\u0027eau, 1 pincée de sel","flour":"250","coconut":"0","milk":"0","butter":"0","vanilla_sugar":"0","egg":"0","vanilla":"0","sugar":"0","oil":"1"}', '<p>Faites bouillir l''eau avec le sel.</p>\r\n\r\n<p>Placez la farine dans un saladier et faites un puits au milieu. Versez alors l''eau bouillante sal&eacute;e et remuez avec </p>\r\n\r\n<p>une cuill&egrave;re en bois jusqu''&agrave; obtenir une p&acirc;te bien homog&egrave;ne et souple.</p>\r\n\r\n<p>Faites chauffer l''huile dans la friteuse et placez la p&acirc;te &agrave; churros dans une poche &agrave; douille cannel&eacute;e. Une fois </p>\r\n\r\n<p>que l''huile est bien chaude, faites alors tomber des filets de p&acirc;te d''environ 10 cm de longueur dans la friteuse, en </p>\r\n\r\n<p>vous aidant de ciseaux pour les couper. Laissez frire les churros ainsi form&eacute;s 2 &agrave; 4 min, jusqu''&agrave; ce qu''ils soient </p>\r\n\r\n<p>bien dor&eacute;s et croustillants. Egouttez-les, laissez-les ti&eacute;dir quelques minutes, saupoudrez-les de sucre et servez- les bien chauds.</p>'),
(6, 'Mousse rapide au chocolat', 'img2/images_recettes/mousseChoco.jpg', 3, 15, 30, '{"fruit":"1/2 tablette de chocolat","other":"de l\\u0027eau","flour":"0","coconut":"0","milk":"0","butter":"0","vanilla_sugar":"0","egg":"3","vanilla":"0","sugar":"0","oil":"0"}', '<p>S&eacute;parez les blancs des oeufs et montez-les en neige. R&eacute;servez &eacute;ventuellement 1 jaune (pas obligatoire).</p>\r\n\r\n<p>Cassez le chocolat en morceaux. Faites-le fondre dans une casserole avec 1 &agrave; 2 c. &agrave; soupe d''eau.</p>\r\n\r\n<p>Quand le chocolat est fondu, retirez la casserole du feu. Vous pouvez m&eacute;langer le jaune au chocolat. M&eacute;langez le </p>\r\n\r\n<p>chocolat au blanc, partagez dans 4 ramequins et mettez 30 min au frigo avant de d&eacute;guster.</p>');

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
