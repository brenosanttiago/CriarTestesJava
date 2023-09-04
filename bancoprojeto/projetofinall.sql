-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Tempo de geração: 28-Mar-2023 às 19:23
-- Versão do servidor: 10.4.25-MariaDB
-- versão do PHP: 8.1.10

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Banco de dados: `projetofinal`
--

-- --------------------------------------------------------

--
-- Estrutura da tabela `disciplina`
--

CREATE TABLE `disciplina` (
  `disciplinaID` int(11) NOT NULL,
  `nome` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estrutura da tabela `materia`
--

CREATE TABLE `materia` (
  `materiaID` int(11) NOT NULL,
  `nome` varchar(255) DEFAULT NULL,
  `descricao` varchar(255) DEFAULT NULL,
  `serie` int(11) DEFAULT NULL,
  `disciplinaID` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estrutura da tabela `questao`
--

CREATE TABLE `questao` (
  `questaoID` int(11) NOT NULL,
  `enunciado` varchar(255) DEFAULT NULL,
  `gabarito` varchar(255) DEFAULT NULL,
  `bimestre` int(11) DEFAULT NULL,
  `materiaID` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Extraindo dados da tabela `questao`
--

INSERT INTO `questao` (`questaoID`, `enunciado`, `gabarito`, `bimestre`, `materiaID`) VALUES
(1, 'Oi', '123', 2, 2);

-- --------------------------------------------------------

--
-- Estrutura da tabela `teste`
--

CREATE TABLE `teste` (
  `testeID` int(11) NOT NULL,
  `datagerao` date DEFAULT NULL,
  `questaoID` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estrutura da tabela `testequestoes`
--

CREATE TABLE `testequestoes` (
  `testeID` int(11) DEFAULT NULL,
  `questaoID` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Índices para tabelas despejadas
--

--
-- Índices para tabela `disciplina`
--
ALTER TABLE `disciplina`
  ADD PRIMARY KEY (`disciplinaID`);

--
-- Índices para tabela `materia`
--
ALTER TABLE `materia`
  ADD PRIMARY KEY (`materiaID`);

--
-- Índices para tabela `questao`
--
ALTER TABLE `questao`
  ADD PRIMARY KEY (`questaoID`);

--
-- Índices para tabela `teste`
--
ALTER TABLE `teste`
  ADD PRIMARY KEY (`testeID`);

--
-- AUTO_INCREMENT de tabelas despejadas
--

--
-- AUTO_INCREMENT de tabela `disciplina`
--
ALTER TABLE `disciplina`
  MODIFY `disciplinaID` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de tabela `materia`
--
ALTER TABLE `materia`
  MODIFY `materiaID` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de tabela `questao`
--
ALTER TABLE `questao`
  MODIFY `questaoID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT de tabela `teste`
--
ALTER TABLE `teste`
  MODIFY `testeID` int(11) NOT NULL AUTO_INCREMENT;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
