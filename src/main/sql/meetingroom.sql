-- phpMyAdmin SQL Dump
-- version 4.7.4
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1:3306
-- Généré le :  mer. 15 jan. 2020 à 08:03
-- Version du serveur :  5.7.19
-- Version de PHP :  7.1.9

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données :  `meetingroom`
--

-- --------------------------------------------------------

--
-- Structure de la table `participant`
--
USE meetingroom;

DROP TABLE IF EXISTS `participant`;
CREATE TABLE IF NOT EXISTS `participant` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `email` varchar(255) NOT NULL,
  `reservation_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `reservation_id` (`reservation_id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `participant`
--

INSERT INTO `participant` (`id`, `email`, `reservation_id`) VALUES
(1, 'tim@tim.fr', 7),
(2, 'aze@ed.fr', 7),
(3, 'frerg@ffdg.com', 7),
(10, 'rzerz', 13);

-- --------------------------------------------------------

--
-- Structure de la table `reservation`
--

DROP TABLE IF EXISTS `reservation`;
CREATE TABLE IF NOT EXISTS `reservation` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `date_debut` datetime NOT NULL,
  `date_fin` datetime NOT NULL,
  `nom` varchar(255) NOT NULL,
  `description` text NOT NULL,
  `salle_id` int(11) NOT NULL,
  `user_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `salle_id` (`salle_id`),
  KEY `user_id` (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `reservation`
--

INSERT INTO `reservation` (`id`, `date_debut`, `date_fin`, `nom`, `description`, `salle_id`, `user_id`) VALUES
(1, '2019-12-03 00:00:00', '2019-12-19 00:00:00', 'resa 1', 'desc', 1, 1),
(2, '2019-12-11 01:00:00', '2019-12-11 04:00:00', 'resa 2', 'desc 2', 2, 2),
(3, '2019-12-11 05:00:00', '2019-12-11 09:00:00', 'resa3', 'desc 3', 1, 2),
(4, '2019-12-21 00:00:00', '2019-12-20 00:00:00', 'fdsgdf', 'fdgdf', 1, 3),
(5, '2019-12-20 00:00:00', '2019-12-26 00:00:00', 'Reservation rÃ©union', 'voila voila', 1, 3),
(6, '2019-12-20 00:00:00', '2019-12-12 00:00:00', 'Nouvelle resa', 'fgdgdfgdf', 1, 3),
(7, '2020-01-17 00:00:00', '2020-01-23 00:00:00', 'Teemooooo', 'ffdhfgh', 1, 3),
(8, '2020-01-04 00:00:00', '2020-01-09 00:00:00', 'fdgfhgj', 'sdf', 1, 3),
(13, '2020-01-26 00:00:00', '2020-01-26 00:00:00', 'Teemo', 'zer', 1, 4);

-- --------------------------------------------------------

--
-- Structure de la table `salle`
--

DROP TABLE IF EXISTS `salle`;
CREATE TABLE IF NOT EXISTS `salle` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `lib` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `salle`
--

INSERT INTO `salle` (`id`, `lib`) VALUES
(1, '201'),
(2, '103');

-- --------------------------------------------------------

--
-- Structure de la table `user`
--

DROP TABLE IF EXISTS `user`;
CREATE TABLE IF NOT EXISTS `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `fullname` varchar(255) NOT NULL,
  `email` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `tel` varchar(50) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `user`
--

INSERT INTO `user` (`id`, `fullname`, `email`, `password`, `tel`) VALUES
(1, 'Jean denis', 'jd@jd.fr', '123', '4355'),
(2, 'Roger', 'dzd@fe.fr', '123', '2345'),
(3, 'admin', 'admin@admin.fr', 'admin', '1324'),
(4, 'Jean Denis', 'user@user.fr', 'user', '4355');

-- --------------------------------------------------------

--
-- Structure de la table `user_roles`
--

DROP TABLE IF EXISTS `user_roles`;
CREATE TABLE IF NOT EXISTS `user_roles` (
  `email` varchar(255) NOT NULL,
  `role_name` varchar(255) NOT NULL,
  PRIMARY KEY (`email`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `user_roles`
--

INSERT INTO `user_roles` (`email`, `role_name`) VALUES
('admin@admin.fr', 'admin'),
('user@user.fr', 'user');

--
-- Contraintes pour les tables déchargées
--

--
-- Contraintes pour la table `participant`
--
ALTER TABLE `participant`
  ADD CONSTRAINT `participant_ibfk_1` FOREIGN KEY (`reservation_id`) REFERENCES `reservation` (`id`);

--
-- Contraintes pour la table `reservation`
--
ALTER TABLE `reservation`
  ADD CONSTRAINT `reservation_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`),
  ADD CONSTRAINT `reservation_ibfk_2` FOREIGN KEY (`salle_id`) REFERENCES `salle` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
