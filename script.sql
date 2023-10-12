-- CREATE DATABASE 20232_usjt_psc_segunda_pessoas;
USE 20232_usjt_psc_segunda_pessoas;

SELECT * FROM tb_pessoas;

INSERT INTO tb_pessoas (nome, fone, email, ativo) VALUES ('Raí', '11977733585', 'raijoiamv@gmail.com', 1);

 CREATE TABLE tb_pessoas(
 	cod_pessoa INT PRIMARY KEY AUTO_INCREMENT,
     nome VARCHAR(200) NOT NULL,
     fone VARCHAR(200) NULL,
     email VARCHAR(200) NOT NULL,
     ativo TINYINT NOT NULL
);

-- USE 20232_usjt_psc_segunda_pessoas;
