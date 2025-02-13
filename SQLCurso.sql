-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema dbCurso
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema dbCurso
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `dbCurso` DEFAULT CHARACTER SET utf8 ;
USE `dbCurso` ;

-- -----------------------------------------------------
-- Table `dbCurso`.`Curso`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `dbCurso`.`Curso` (
  `idCurso` INT NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(45) NOT NULL,
  `preco` DECIMAL(4,2) NOT NULL,
  `cargaHoraria` INT NOT NULL,
  PRIMARY KEY (`idCurso`),
  UNIQUE INDEX `nome_UNIQUE` (`nome` ASC) VISIBLE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `dbCurso`.`Aluno`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `dbCurso`.`Aluno` (
  `idAluno` INT NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(45) NOT NULL,
  `email` VARCHAR(45) NOT NULL,
  `telefone` VARCHAR(45) NOT NULL,
  `faltas` INT NOT NULL,
  `Curso_idCurso` INT NOT NULL,
  UNIQUE INDEX `email_UNIQUE` (`email` ASC) VISIBLE,
  UNIQUE INDEX `telefone_UNIQUE` (`telefone` ASC) VISIBLE,
  PRIMARY KEY (`idAluno`),
  INDEX `fk_Aluno_Curso_idx` (`Curso_idCurso` ASC) VISIBLE,
  CONSTRAINT `fk_Aluno_Curso`
    FOREIGN KEY (`Curso_idCurso`)
    REFERENCES `dbCurso`.`Curso` (`idCurso`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

SELECT * FROM curso;

INSERT INTO curso (nome, preco, cargaHoraria) VALUES ("Java", 35.90, 60);
INSERT INTO curso (nome, preco, cargaHoraria) VALUES ("Python", 41.90, 35);
INSERT INTO curso (nome, preco, cargaHoraria) VALUES ("C#", 57.50, 80);
INSERT INTO curso (nome, preco, cargaHoraria) VALUES ("JavaScript", 30.00, 50);
INSERT INTO curso (nome, preco, cargaHoraria) VALUES ("PHP", 80.00, 120);
INSERT INTO curso (nome, preco, cargaHoraria) VALUES ("C++", 10.90, 10);

SELECT * FROM aluno;

INSERT INTO aluno (nome, email, telefone, faltas, Curso_idCurso) VALUES ("José Antônio", "josezin@gmail.com", "30256644", 2, 1);
INSERT INTO aluno (nome, email, telefone, faltas, Curso_idCurso) VALUES ("Maria Antonia", "maria@gmail.com", "99885544", 1, 1);
INSERT INTO aluno (nome, email, telefone, faltas, Curso_idCurso) VALUES ("Reinaldo Manzoti", "reinaldo@gmail.com", "99332210", 2, 1);
INSERT INTO aluno (nome, email, telefone, faltas, Curso_idCurso) VALUES ("Enzo Gabriel", "enzo@gmail.com", "30256789", 2, 1);
