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

INSERT INTO aluno (nome, email, telefone, faltas, Curso_idCurso) VALUES ("Hélio Roberto", "helio@gmail.com", "932502315", 0, 2);
INSERT INTO aluno (nome, email, telefone, faltas, Curso_idCurso) VALUES ("Amanda Nunes", "mandy@gmail.com", "98765430", 3, 2);
INSERT INTO aluno (nome, email, telefone, faltas, Curso_idCurso) VALUES ("Clara Maria", "clara@gmail.com", "80764312", 1, 2);
INSERT INTO aluno (nome, email, telefone, faltas, Curso_idCurso) VALUES ("Patrick Almeida", "patrick@gmail.com", "30257898", 2, 2);

INSERT INTO aluno (nome, email, telefone, faltas, Curso_idCurso) VALUES ("Julio Carlos", "julio@gmail.com", "91224750", 0, 3);
INSERT INTO aluno (nome, email, telefone, faltas, Curso_idCurso) VALUES ("Claudinei Garcia", "claudinei@gmail.com", "90765530", 1, 3);
INSERT INTO aluno (nome, email, telefone, faltas, Curso_idCurso) VALUES ("Eduarda Santos", "eduarda@gmail.com", "99097621", 4, 3);
INSERT INTO aluno (nome, email, telefone, faltas, Curso_idCurso) VALUES ("Daniel Silva", "daniel@gmail.com", "97675540", 2, 3);

INSERT INTO aluno (nome, email, telefone, faltas, Curso_idCurso) VALUES ("Adria Almeida", "adria@gmail.com", "90908865", 0, 4);
INSERT INTO aluno (nome, email, telefone, faltas, Curso_idCurso) VALUES ("Jandira Costa", "jandira@gmail.com", "93451233", 1, 4);
INSERT INTO aluno (nome, email, telefone, faltas, Curso_idCurso) VALUES ("Clara Nunes", "claranunes@gmail.com", "95678540", 1, 4);
INSERT INTO aluno (nome, email, telefone, faltas, Curso_idCurso) VALUES ("Madalena Santos", "madalena@gmail.com", "30256654", 2, 4);

INSERT INTO aluno (nome, email, telefone, faltas, Curso_idCurso) VALUES ("Denise Costa", "denise@gmail.com", "99421678", 4, 5);
INSERT INTO aluno (nome, email, telefone, faltas, Curso_idCurso) VALUES ("Carlos Eduardo", "edu@gmail.com", "30256894", 1, 5);
INSERT INTO aluno (nome, email, telefone, faltas, Curso_idCurso) VALUES ("Victor Manzoti", "victor@gmail.com", "87653748", 2, 5);
INSERT INTO aluno (nome, email, telefone, faltas, Curso_idCurso) VALUES ("Bruno Silva", "bruno@gmail.com", "98761234", 0, 5);

INSERT INTO aluno (nome, email, telefone, faltas, Curso_idCurso) VALUES ("Luan Garcia", "luan@gmail.com", "95642090", 0, 6);
INSERT INTO aluno (nome, email, telefone, faltas, Curso_idCurso) VALUES ("Keler Santos", "keler@gmail.com", "87406644", 1, 6);
INSERT INTO aluno (nome, email, telefone, faltas, Curso_idCurso) VALUES ("Taiara Abelardo", "tainara@gmail.com", "21764083", 2, 6);
INSERT INTO aluno (nome, email, telefone, faltas, Curso_idCurso) VALUES ("Gabriel Silva", "gabriel@gmail.com", "65908721", 3, 6);
