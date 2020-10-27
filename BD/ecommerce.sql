-- phpMyAdmin SQL Dump
-- version 4.8.5
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1:3306
-- Généré le :  jeu. 16 jan. 2020 à 17:46
-- Version du serveur :  5.7.26
-- Version de PHP :  7.2.18

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données :  `ecommerce`
--

-- --------------------------------------------------------

--
-- Structure de la table `admin`
--

DROP TABLE IF EXISTS `admin`;
CREATE TABLE IF NOT EXISTS `admin` (
  `id` int(20) NOT NULL AUTO_INCREMENT,
  `nomAdmin` varchar(15) NOT NULL,
  `emailAdmin` varchar(20) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `admin`
--

INSERT INTO `admin` (`id`, `nomAdmin`, `emailAdmin`) VALUES
(1, 'hajar', 'hajar@123');

-- --------------------------------------------------------

--
-- Structure de la table `article`
--

DROP TABLE IF EXISTS `article`;
CREATE TABLE IF NOT EXISTS `article` (
  `id` int(20) NOT NULL,
  `des` varchar(15) NOT NULL,
  `prix` float NOT NULL,
  `qte` int(15) NOT NULL,
  `img` varchar(20) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `article`
--

INSERT INTO `article` (`id`, `des`, `prix`, `qte`, `img`) VALUES
(1, 'Dow to Be', 150.32, 80, 'image.jpg'),
(2, 'Wendy', 160.32, 60, 'image1.jpg');

-- --------------------------------------------------------

--
-- Structure de la table `comm`
--

DROP TABLE IF EXISTS `comm`;
CREATE TABLE IF NOT EXISTS `comm` (
  `idc` int(12) NOT NULL,
  `nomc` varchar(12) NOT NULL,
  `prixc` double NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `panier`
--

DROP TABLE IF EXISTS `panier`;
CREATE TABLE IF NOT EXISTS `panier` (
  `id` int(14) NOT NULL,
  `nomlivre` varchar(14) NOT NULL,
  `prixlivre` int(20) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `user`
--

DROP TABLE IF EXISTS `user`;
CREATE TABLE IF NOT EXISTS `user` (
  `id` int(20) NOT NULL AUTO_INCREMENT,
  `nom` varchar(15) NOT NULL,
  `login` varchar(15) NOT NULL,
  `password` varchar(20) NOT NULL,
  `email` varchar(20) NOT NULL,
  UNIQUE KEY `id` (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=8 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `user`
--

INSERT INTO `user` (`id`, `nom`, `login`, `password`, `email`) VALUES
(7, 'aicha', 'ifkirn', '123', 'aicha@ifkirn'),
(2, 'hajar', 'kkk', 'ha12', 'null'),
(3, 'hhh', 'llll', 'mm44j', 'jaja@mm'),
(4, 'fghjjjjj', 'ggh', 'tftftfg', 'gtf@gg'),
(5, 'hajj', 'lllmm', 'jhh45', 'hajar@123'),
(6, 'hajar', 'jkajjhf', 'hgjg', 'hajar@123');
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
