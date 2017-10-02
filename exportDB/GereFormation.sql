-- phpMyAdmin SQL Dump
-- version 4.6.6deb4
-- https://www.phpmyadmin.net/
--
-- Client :  localhost:3306
-- Généré le :  Jeu 28 Septembre 2017 à 14:06
-- Version du serveur :  5.7.19-0ubuntu0.17.04.1
-- Version de PHP :  7.0.22-0ubuntu0.17.04.1

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données :  `GereFormation`
--

-- --------------------------------------------------------

--
-- Structure de la table `ECF`
--

CREATE TABLE `ECF` (
  `id` int(11) NOT NULL,
  `nom` varchar(255) NOT NULL,
  `idModule` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `ECF`
--

INSERT INTO `ECF` (`id`, `nom`, `idModule`) VALUES
(1, 'roulage de clope', NULL);

-- --------------------------------------------------------

--
-- Structure de la table `formation`
--

CREATE TABLE `formation` (
  `id` int(11) NOT NULL,
  `libelle` varchar(500) NOT NULL,
  `description` text NOT NULL,
  `nbHeures` int(11) NOT NULL,
  `lieu` varchar(30000) NOT NULL,
  `dateDebut` date NOT NULL,
  `idFormateur` int(11) DEFAULT NULL,
  `codeFormation` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `formation`
--

INSERT INTO `formation` (`id`, `libelle`, `description`, `nbHeures`, `lieu`, `dateDebut`, `idFormateur`, `codeFormation`) VALUES
(1, 'Developpeur pause cigarette', 'apprendre a faire des pauses cigarettes très souvent', 500, 'Derrière le Self', '2018-03-12', NULL, 1235);

-- --------------------------------------------------------

--
-- Structure de la table `gestionECF`
--

CREATE TABLE `gestionECF` (
  `idStagiaire` int(11) NOT NULL,
  `idECF` int(11) NOT NULL,
  `note` int(2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `gestionFormation`
--

CREATE TABLE `gestionFormation` (
  `idstagiaire` int(11) NOT NULL,
  `idformation` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `gestionModule`
--

CREATE TABLE `gestionModule` (
  `idmodule` int(11) NOT NULL,
  `idformation` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `gestionSequence`
--

CREATE TABLE `gestionSequence` (
  `idmodule` int(11) NOT NULL,
  `idsequence` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `module`
--

CREATE TABLE `module` (
  `id` int(11) NOT NULL,
  `libelle` varchar(500) NOT NULL,
  `description` text NOT NULL,
  `duree` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `module`
--

INSERT INTO `module` (`id`, `libelle`, `description`, `duree`) VALUES
(1, 'le lancer de cendre', 'c\'est un art', 3);

-- --------------------------------------------------------

--
-- Structure de la table `personnel`
--

CREATE TABLE `personnel` (
  `id` int(11) NOT NULL,
  `nom` varchar(255) NOT NULL,
  `prenom` varchar(255) NOT NULL,
  `utilisateur` varchar(255) NOT NULL,
  `motDePasse` varchar(255) NOT NULL,
  `role` char(1) NOT NULL,
  `email` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `personnel`
--

INSERT INTO `personnel` (`id`, `nom`, `prenom`, `utilisateur`, `motDePasse`, `role`, `email`) VALUES
(1, 'Krolikowski', 'Konrad', 'Devrok', 'azerty', 'A', 'marion@gmail.com'),
(3, 'martine', 'martin', 'momomtus', 'boulenoire', 'B', 'momomotus@laboulenoire.paris');

-- --------------------------------------------------------

--
-- Structure de la table `sequence`
--

CREATE TABLE `sequence` (
  `id` int(11) NOT NULL,
  `nom` varchar(255) NOT NULL,
  `description` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `sequence`
--

INSERT INTO `sequence` (`id`, `nom`, `description`) VALUES
(1, 'Konrad', 'est endormi');

-- --------------------------------------------------------

--
-- Structure de la table `stagiaire`
--

CREATE TABLE `stagiaire` (
  `id` int(11) NOT NULL,
  `nom` varchar(255) NOT NULL,
  `prenom` varchar(255) NOT NULL,
  `adresse` text NOT NULL,
  `codePostal` int(5) NOT NULL,
  `ville` varchar(255) NOT NULL,
  `mail` varchar(255) NOT NULL,
  `telephone` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COMMENT='table de Stagiaire';

--
-- Contenu de la table `stagiaire`
--

INSERT INTO `stagiaire` (`id`, `nom`, `prenom`, `adresse`, `codePostal`, `ville`, `mail`, `telephone`) VALUES
(1, 'Le Luron', 'David', '144 rue Robespierre', 29200, 'Brest', '0298680996', 'wowzillah77@gmail.com');

--
-- Index pour les tables exportées
--

--
-- Index pour la table `ECF`
--
ALTER TABLE `ECF`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `idModule` (`idModule`);

--
-- Index pour la table `formation`
--
ALTER TABLE `formation`
  ADD PRIMARY KEY (`id`),
  ADD KEY `idFormateur` (`idFormateur`);

--
-- Index pour la table `gestionECF`
--
ALTER TABLE `gestionECF`
  ADD KEY `idStagiaire` (`idStagiaire`),
  ADD KEY `idECF` (`idECF`);

--
-- Index pour la table `gestionFormation`
--
ALTER TABLE `gestionFormation`
  ADD KEY `idstagiaire` (`idstagiaire`),
  ADD KEY `idformation` (`idformation`);

--
-- Index pour la table `gestionModule`
--
ALTER TABLE `gestionModule`
  ADD KEY `idmodule` (`idmodule`),
  ADD KEY `idformation` (`idformation`);

--
-- Index pour la table `gestionSequence`
--
ALTER TABLE `gestionSequence`
  ADD KEY `idmodule` (`idmodule`),
  ADD KEY `idsequence` (`idsequence`);

--
-- Index pour la table `module`
--
ALTER TABLE `module`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `personnel`
--
ALTER TABLE `personnel`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `sequence`
--
ALTER TABLE `sequence`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `stagiaire`
--
ALTER TABLE `stagiaire`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT pour les tables exportées
--

--
-- AUTO_INCREMENT pour la table `ECF`
--
ALTER TABLE `ECF`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT pour la table `formation`
--
ALTER TABLE `formation`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT pour la table `module`
--
ALTER TABLE `module`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT pour la table `personnel`
--
ALTER TABLE `personnel`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
--
-- AUTO_INCREMENT pour la table `sequence`
--
ALTER TABLE `sequence`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT pour la table `stagiaire`
--
ALTER TABLE `stagiaire`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
--
-- Contraintes pour les tables exportées
--

--
-- Contraintes pour la table `ECF`
--
ALTER TABLE `ECF`
  ADD CONSTRAINT `ECF_ibfk_1` FOREIGN KEY (`idModule`) REFERENCES `module` (`id`);

--
-- Contraintes pour la table `formation`
--
ALTER TABLE `formation`
  ADD CONSTRAINT `formation_ibfk_2` FOREIGN KEY (`idFormateur`) REFERENCES `personnel` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Contraintes pour la table `gestionECF`
--
ALTER TABLE `gestionECF`
  ADD CONSTRAINT `gestionECF_ibfk_1` FOREIGN KEY (`idECF`) REFERENCES `ECF` (`id`),
  ADD CONSTRAINT `gestionECF_ibfk_2` FOREIGN KEY (`idStagiaire`) REFERENCES `stagiaire` (`id`);

--
-- Contraintes pour la table `gestionFormation`
--
ALTER TABLE `gestionFormation`
  ADD CONSTRAINT `gestionFormation_ibfk_1` FOREIGN KEY (`idstagiaire`) REFERENCES `stagiaire` (`id`),
  ADD CONSTRAINT `gestionFormation_ibfk_2` FOREIGN KEY (`idformation`) REFERENCES `formation` (`id`);

--
-- Contraintes pour la table `gestionModule`
--
ALTER TABLE `gestionModule`
  ADD CONSTRAINT `gestionModule_ibfk_1` FOREIGN KEY (`idformation`) REFERENCES `formation` (`id`),
  ADD CONSTRAINT `gestionModule_ibfk_2` FOREIGN KEY (`idmodule`) REFERENCES `module` (`id`);

--
-- Contraintes pour la table `gestionSequence`
--
ALTER TABLE `gestionSequence`
  ADD CONSTRAINT `gestionSequence_ibfk_1` FOREIGN KEY (`idmodule`) REFERENCES `module` (`id`),
  ADD CONSTRAINT `gestionSequence_ibfk_2` FOREIGN KEY (`idsequence`) REFERENCES `sequence` (`id`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
