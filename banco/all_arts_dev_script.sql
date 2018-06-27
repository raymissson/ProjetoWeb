DROP DATABASE all_arts_dev;
-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema all_arts_dev
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema all_arts_dev
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `all_arts_dev` DEFAULT CHARACTER SET utf8 ;
USE `all_arts_dev` ;

-- -----------------------------------------------------
-- Table `all_arts_dev`.`categoria`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `all_arts_dev`.`categoria` (
  `cod_categoria` INT(11) NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(45) NOT NULL,
  `descricao` VARCHAR(255) NOT NULL,
  PRIMARY KEY (`cod_categoria`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `all_arts_dev`.`unidade_federativa`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `all_arts_dev`.`unidade_federativa` (
  `uf_sigla` CHAR(2) NOT NULL,
  `uf_nome` VARCHAR(45) NULL DEFAULT NULL,
  PRIMARY KEY (`uf_sigla`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `all_arts_dev`.`cidade`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `all_arts_dev`.`cidade` (
  `cod_cidade` INT(11) NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(45) NOT NULL,
  `unidade_federativa_uf_sigla` CHAR(2) NOT NULL,
  PRIMARY KEY (`cod_cidade`),
  INDEX `fk_cidade_unidade_federativa1_idx` (`unidade_federativa_uf_sigla` ASC),
  CONSTRAINT `fk_cidade_unidade_federativa1`
    FOREIGN KEY (`unidade_federativa_uf_sigla`)
    REFERENCES `all_arts_dev`.`unidade_federativa` (`uf_sigla`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `all_arts_dev`.`usuario`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `all_arts_dev`.`usuario` (
  `usucodigo` INT NOT NULL,
  `usulogin` VARCHAR(45) NOT NULL,
  `ususenha` VARCHAR(45) NOT NULL,
  `usutipousuario` INT NOT NULL,
  PRIMARY KEY (`usucodigo`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `all_arts_dev`.`cliente`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `all_arts_dev`.`cliente` (
  `cpf` VARCHAR(11) NOT NULL,
  `nome` VARCHAR(45) NOT NULL,
  `email` VARCHAR(45) NOT NULL,
  `telefone` VARCHAR(45) NULL DEFAULT NULL,
  `data_nascimento` DATE NULL DEFAULT NULL,
  `data_cadastro` DATE NOT NULL,
  `usuario_usucodigo` INT NOT NULL,
  PRIMARY KEY (`cpf`),
  INDEX `fk_cliente_usuario1_idx` (`usuario_usucodigo` ASC),
  CONSTRAINT `fk_cliente_usuario1`
    FOREIGN KEY (`usuario_usucodigo`)
    REFERENCES `all_arts_dev`.`usuario` (`usucodigo`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `all_arts_dev`.`status`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `all_arts_dev`.`status` (
  `cod_status` INT(11) NOT NULL,
  `descricao` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`cod_status`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `all_arts_dev`.`tipo_pagto`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `all_arts_dev`.`tipo_pagto` (
  `cod_tipo_pagto` INT(11) NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(45) NULL DEFAULT NULL,
  PRIMARY KEY (`cod_tipo_pagto`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `all_arts_dev`.`compra`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `all_arts_dev`.`compra` (
  `cod_compra` INT(11) NOT NULL AUTO_INCREMENT,
  `data_compra` DATE NOT NULL,
  `status_cod_status` INT(11) NOT NULL,
  `tipo_pagto_cod_tipo_pagto` INT(11) NOT NULL,
  `cliente_cpf` VARCHAR(11) NOT NULL,
  PRIMARY KEY (`cod_compra`),
  INDEX `fk_compra_status1_idx` (`status_cod_status` ASC),
  INDEX `fk_compra_tipo_pagto1_idx` (`tipo_pagto_cod_tipo_pagto` ASC),
  INDEX `fk_compra_cliente1_idx` (`cliente_cpf` ASC),
  CONSTRAINT `fk_compra_status1`
    FOREIGN KEY (`status_cod_status`)
    REFERENCES `all_arts_dev`.`status` (`cod_status`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_compra_tipo_pagto1`
    FOREIGN KEY (`tipo_pagto_cod_tipo_pagto`)
    REFERENCES `all_arts_dev`.`tipo_pagto` (`cod_tipo_pagto`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_compra_cliente1`
    FOREIGN KEY (`cliente_cpf`)
    REFERENCES `all_arts_dev`.`cliente` (`cpf`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `all_arts_dev`.`curriculo`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `all_arts_dev`.`curriculo` (
  `id_curriculo` INT(11) NOT NULL AUTO_INCREMENT,
  `curriculo_arquivo` VARCHAR(45) NOT NULL,
  `candidato_nome` VARCHAR(45) NOT NULL,
  `candidato_email` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id_curriculo`))
ENGINE = InnoDB
AUTO_INCREMENT = 2
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `all_arts_dev`.`endereco`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `all_arts_dev`.`endereco` (
  `cep` INT(11) NOT NULL,
  `logradouro` VARCHAR(45) NOT NULL,
  `referencias` VARCHAR(45) NULL DEFAULT NULL,
  `numero` INT(11) NOT NULL,
  `bairro` VARCHAR(45) NOT NULL,
  `data_alteracao` DATE NOT NULL,
  `cidade_cod_cidade` INT(11) NOT NULL,
  `cliente_cod_cliente` INT(11) NOT NULL,
  PRIMARY KEY (`cep`),
  INDEX `fk_endereco_cidade1_idx` (`cidade_cod_cidade` ASC),
  CONSTRAINT `fk_endereco_cidade1`
    FOREIGN KEY (`cidade_cod_cidade`)
    REFERENCES `all_arts_dev`.`cidade` (`cod_cidade`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `all_arts_dev`.`administrador`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `all_arts_dev`.`administrador` (
  `codigo` INT(11) NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(45) NOT NULL,
  `login` VARCHAR(45) NOT NULL,
  `senha` VARCHAR(45) NOT NULL,
  `tipo_usuario` INT NOT NULL,
  `usuario_usucodigo` INT NOT NULL,
  PRIMARY KEY (`codigo`),
  INDEX `fk_administrador_usuario1_idx` (`usuario_usucodigo` ASC),
  CONSTRAINT `fk_administrador_usuario1`
    FOREIGN KEY (`usuario_usucodigo`)
    REFERENCES `all_arts_dev`.`usuario` (`usucodigo`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `all_arts_dev`.`produto`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `all_arts_dev`.`produto` (
  `cod_produto` INT(11) NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(145) NOT NULL,
  `descricao` VARCHAR(245) NOT NULL,
  `imagem` VARCHAR(150) NOT NULL,
  `preco_venda` DOUBLE(7,2) NULL DEFAULT NULL,
  `categoria_cod_categoria` INT(11) NULL DEFAULT NULL,
  `usuario_codigo` INT(11) NULL DEFAULT NULL,
  PRIMARY KEY (`cod_produto`),
  INDEX `fk_produto_categoria1_idx` (`categoria_cod_categoria` ASC),
  INDEX `fk_produto_usuario1_idx` (`usuario_codigo` ASC),
  CONSTRAINT `fk_produto_categoria1`
    FOREIGN KEY (`categoria_cod_categoria`)
    REFERENCES `all_arts_dev`.`categoria` (`cod_categoria`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_produto_usuario1`
    FOREIGN KEY (`usuario_codigo`)
    REFERENCES `all_arts_dev`.`administrador` (`codigo`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `all_arts_dev`.`item_compra`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `all_arts_dev`.`item_compra` (
  `compra_cod_compra` INT(11) NOT NULL,
  `produto_cod_produto` INT(11) NOT NULL,
  PRIMARY KEY (`compra_cod_compra`, `produto_cod_produto`),
  INDEX `fk_compra_has_produto_produto1_idx` (`produto_cod_produto` ASC),
  INDEX `fk_compra_has_produto_compra1_idx` (`compra_cod_compra` ASC),
  CONSTRAINT `fk_compra_has_produto_compra1`
    FOREIGN KEY (`compra_cod_compra`)
    REFERENCES `all_arts_dev`.`compra` (`cod_compra`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_compra_has_produto_produto1`
    FOREIGN KEY (`produto_cod_produto`)
    REFERENCES `all_arts_dev`.`produto` (`cod_produto`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `all_arts_dev`.`mensagem`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `all_arts_dev`.`mensagem` (
  `id_mensagem` INT(11) NOT NULL AUTO_INCREMENT,
  `conteudo` VARCHAR(150) NOT NULL,
  `tipo` VARCHAR(75) NOT NULL,
  `nome_usuario` VARCHAR(45) NOT NULL,
  `email_usuario` VARCHAR(45) NOT NULL,
  `status_resposta` INT(11) NOT NULL,
  PRIMARY KEY (`id_mensagem`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
