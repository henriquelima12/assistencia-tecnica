-- phpMyAdmin SQL Dump
-- version 4.6.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: 25-Jun-2018 às 00:37
-- Versão do servidor: 5.7.14
-- PHP Version: 5.6.25

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `assistencia`
--

-- --------------------------------------------------------

--
-- Estrutura da tabela `clientes`
--

CREATE TABLE `clientes` (
  `idcli` int(11) NOT NULL,
  `nomecli` varchar(50) NOT NULL,
  `endcli` varchar(50) DEFAULT NULL,
  `cpf` varchar(100) NOT NULL,
  `emailcli` varchar(50) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `clientes`
--

INSERT INTO `clientes` (`idcli`, `nomecli`, `endcli`, `cpf`, `emailcli`) VALUES
(2, 'Henrique Lima', 'Cidade Leste', '444-444-444-44', 'henrique@henrique.com'),
(7, 'Teste', 'Tauá', '111-111-111-11', 'teste@teste'),
(8, 'Luis henrique', 'Teresópolis', '098-765-432-10', 'luispoca@luis.com'),
(13, 'Leivison Imundo', 'São Geraldo', '123-456-789-15', 'cobra@cobra'),
(10, 'Carlos', 'Lustal', '111-222-333-44', 'carlos@carlos.com'),
(12, 'Henrique Araújo', 'Cidade Leste', '111-222-333-45', 'henrique@araujo'),
(17, 'Gisele', 'Cidade Leste', '111-222-555-77', 'gisele@gisele.com');

-- --------------------------------------------------------

--
-- Estrutura da tabela `os`
--

CREATE TABLE `os` (
  `ordem_servico` int(11) NOT NULL,
  `data_os` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `tipo` varchar(25) NOT NULL,
  `situacao` varchar(25) NOT NULL,
  `equipamento` varchar(150) NOT NULL,
  `defeito` varchar(150) NOT NULL,
  `servico` varchar(150) DEFAULT NULL,
  `tecnico` varchar(30) DEFAULT NULL,
  `valor` decimal(10,2) DEFAULT NULL,
  `nomecli` varchar(25) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `os`
--

INSERT INTO `os` (`ordem_servico`, `data_os`, `tipo`, `situacao`, `equipamento`, `defeito`, `servico`, `tecnico`, `valor`, `nomecli`) VALUES
(33, '2018-06-11 17:04:56', 'Ordem de Serviço', 'Entrega OK', 'Notebook', 'Não liga', 'troca da fonte', 'Carlos', '150.00', 'Henrique Lima'),
(32, '2018-06-11 17:04:07', 'Ordem de Serviço', 'Entrega OK', 'Celular', 'Display Queimado', 'Troca de display', 'Eu', '100.00', 'Teste'),
(34, '2018-06-11 17:05:20', 'Ordem de Serviço', 'Entrega OK', 'Notebook', 'Não liga', 'troca da fonte', 'Carlos', '150.00', 'Henrique Lima'),
(35, '2018-06-11 17:05:41', 'Ordem de Serviço', 'Entrega OK', 'Notebook', 'Não liga', 'troca da fonte', 'Eu', '170.00', 'Henrique Lima');

-- --------------------------------------------------------

--
-- Estrutura da tabela `usuarios`
--

CREATE TABLE `usuarios` (
  `iduser` int(15) NOT NULL,
  `nome` varchar(60) NOT NULL,
  `fone` varchar(60) NOT NULL,
  `login` varchar(15) NOT NULL,
  `senha` varchar(15) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `usuarios`
--

INSERT INTO `usuarios` (`iduser`, `nome`, `fone`, `login`, `senha`) VALUES
(25, 'Henrique Araújo', '(99) 98987-6764', 'henrique lima', '123456'),
(23, 'Teste3', '(88) 98888-8888', 'teste3', '12345'),
(24, 'Carlos', '(88) 98989-8989', 'carlos', 'carlos'),
(28, 'Teste', '(88) 99994-4444', 'teste', 'teste'),
(27, 'Teste 2 ', '(88) 88888-8888', 'teste', '123');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `clientes`
--
ALTER TABLE `clientes`
  ADD PRIMARY KEY (`idcli`);

--
-- Indexes for table `os`
--
ALTER TABLE `os`
  ADD PRIMARY KEY (`ordem_servico`);

--
-- Indexes for table `usuarios`
--
ALTER TABLE `usuarios`
  ADD PRIMARY KEY (`iduser`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `clientes`
--
ALTER TABLE `clientes`
  MODIFY `idcli` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=18;
--
-- AUTO_INCREMENT for table `os`
--
ALTER TABLE `os`
  MODIFY `ordem_servico` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=36;
--
-- AUTO_INCREMENT for table `usuarios`
--
ALTER TABLE `usuarios`
  MODIFY `iduser` int(15) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=29;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
