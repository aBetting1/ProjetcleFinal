-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Hôte : localhost
-- Généré le : mar. 30 mai 2023 à 14:42
-- Version du serveur :  10.5.6-MariaDB-1:10.5.6+maria~stretch
-- Version de PHP : 7.3.19-1~deb10u1

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données : `ProjetCle`
--

-- --------------------------------------------------------

--
-- Structure de la table `Cle`
--

CREATE TABLE `Cle` (
  `Numero` int(11) NOT NULL,
  `couleur` varchar(500) NOT NULL,
  `Ouverture` varchar(500) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `Cle`
--

INSERT INTO `Cle` (`Numero`, `couleur`, `Ouverture`) VALUES
(3, 'ghgggggggggggg', 'gggggggggggg'),
(4, 'violet', 'Maison de Killina'),
(5, 'bleu', 'E204'),
(6, 'her', 'her'),
(9, 'jy', 'jty'),
(9999, 'rouge', 'maison de Remy');

-- --------------------------------------------------------

--
-- Structure de la table `Utilisateur`
--

CREATE TABLE `Utilisateur` (
  `id` int(11) NOT NULL,
  `Pseudo` varchar(500) NOT NULL,
  `Mdp` varchar(500) NOT NULL,
  `Droit` varchar(500) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `Utilisateur`
--

INSERT INTO `Utilisateur` (`id`, `Pseudo`, `Mdp`, `Droit`) VALUES
(3, 'anthony', '8d969eef6ecad3c29a3a629280e686cf0c3f5d5a86aff3ca12020c923adc6c92', 'admin'),
(5, 'bonjour', '29257bd3717cae65acc4e06f107728d9822aa2bdb3e287425b7e429784b480b5', 'utilisateur'),
(6, 'salut', 'ca978112ca1bbdcafac231b39a23dc4da786eff8147c4e72b9807785afee48bb', 'utilisateur'),
(7, 'Kevin', '29257bd3717cae65acc4e06f107728d9822aa2bdb3e287425b7e429784b480b5', 'utilisateur'),
(8, 'z', '6B86B273FF34FCE19D6B804EFF5A3F5747ADA4EAA22F1D49C01E52DDB7875B4B', 'admin'),
(10, 'Rémy', '3000caca5b94c7e5fc0f9e2f187bb589f925597778832ad59485280ac32be4c1', 'admin'),
(11, 'a', 'ca978112ca1bbdcafac231b39a23dc4da786eff8147c4e72b9807785afee48bb', 'admin');

--
-- Index pour les tables déchargées
--

--
-- Index pour la table `Cle`
--
ALTER TABLE `Cle`
  ADD PRIMARY KEY (`Numero`);

--
-- Index pour la table `Utilisateur`
--
ALTER TABLE `Utilisateur`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT pour les tables déchargées
--

--
-- AUTO_INCREMENT pour la table `Utilisateur`
--
ALTER TABLE `Utilisateur`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
