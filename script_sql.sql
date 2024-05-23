create database if not exists hotel;

use hotel;


CREATE table if not exists hotel_info (
	id INT UNSIGNED auto_increment NOT NULL,
	nome varchar(100) NOT NULL,
	localizacao varchar(100) NOT NULL,
	contato varchar(100) NOT NULL,
	descricao text NOT NULL,
	classificacao varchar(100) NULL,
	CONSTRAINT hotel_info_pk PRIMARY KEY (id)
);

CREATE TABLE if not exists Clientes (
	id INT UNSIGNED auto_increment NOT NULL,
	nome varchar(100) NOT NULL,
	sobrenome varchar(100) NOT NULL,
	email varchar(100) NOT NULL,
	senha varchar(100) NOT NULL,
	telefone varchar(20) NOT NULL,
	preferancia varchar(100) NULL,
	CONSTRAINT Clientes_pk PRIMARY KEY (id),
	CONSTRAINT Clientes_unique UNIQUE KEY (email)
);

CREATE table if not exists funcionarios (
	id INT unsigned auto_increment NOT NULL,
	nome varchar(50) NOT NULL,
	sobrenome varchar(50) NOT NULL,
	nome_usuario varchar(50) NOT NULL,
	email varchar(100) NOT NULL,
	senha varchar(30) NOT NULL,
	telefone varchar(15) NULL,
	endereco varchar(100) NULL,
	cargo varchar(100) NOT NULL,
	nivel_acesso varchar(50) NOT NULL,
	CONSTRAINT funcionarios_pk PRIMARY KEY (id),
	CONSTRAINT funcionarios_unique UNIQUE KEY (nome_usuario,email));

CREATE table if not exists acomodacoes (
	id INT UNSIGNED auto_increment NOT NULL,
	numero INT NOT null,
	tipo varchar(100) NOT NULL,
	quantidade_leitos INT NOT NULL,
	preco_base DOUBLE NOT NULL,
	tamanho varchar(100) NOT null,
	estado TINYINT DEFAULT 0 NOT null,
	CONSTRAINT acomodacoes_pk PRIMARY KEY (id),
	CONSTRAINT acomodacoes_unique UNIQUE KEY (numero)
);


CREATE TABLE if not exists reservas (
    id INT UNSIGNED AUTO_INCREMENT NOT NULL,
    dataCheckin DATE NOT NULL,
    dataCheckout DATE NOT NULL,
    valorTotal DOUBLE NOT NULL,
    estado TINYINT DEFAULT 0 NOT NULL,
    id_cliente INT UNSIGNED NULL,
    id_acomodacao INT UNSIGNED NULL,
    CONSTRAINT reservas_pk PRIMARY KEY (id),
    CONSTRAINT reservas_clientes_FK FOREIGN KEY (id_cliente) REFERENCES Clientes(id) ON DELETE CASCADE ON UPDATE CASCADE,
    CONSTRAINT reservas_acomodacoes_FK FOREIGN KEY (id_acomodacao) REFERENCES acomodacoes(id) ON DELETE SET NULL ON UPDATE SET NULL
);

INSERT INTO hotel_info (nome, localizacao, contato, descricao, classificacao)
VALUES
('Hotel Paraíso', 'Rua das Flores, 123', 'contato@hotelparaiso.com', 'Um hotel aconchegante no centro da cidade', '5 estrelas');

INSERT INTO Clientes (nome, sobrenome, email, senha, telefone, preferancia)
VALUES
('João', 'Silva', 'joao.silva@example.com', 'senha123', '1234567890', 'Quarto com vista para o mar'),
('Maria', 'Oliveira', 'maria.oliveira@example.com', 'senha456', '0987654321', 'Cama king size'),
('Pedro', 'Souza', 'pedro.souza@example.com', 'senha789', '1122334455', 'Andar alto'),
('Ana', 'Costa', 'ana.costa@example.com', 'senha101', '5566778899', 'Café da manhã incluído'),
('Lucas', 'Pereira', 'lucas.pereira@example.com', 'senha202', '6677889900', 'Quarto silencioso');

INSERT INTO funcionarios (nome, sobrenome, nome_usuario, email, senha, telefone, endereco, cargo, nivel_acesso)
VALUES
('Carlos', 'Lima', 'carlos.lima', 'carlos.lima@example.com', 'senha123', '11987654321', 'Rua A, 123', 'Recepcionista', 'normal'),
('Fernanda', 'Alves', 'fernanda.alves', 'fernanda.alves@example.com', 'senha456', '11912345678', 'Avenida B, 456', 'Gerente', 'admin'),
('Juliana', 'Melo', 'juliana.melo', 'juliana.melo@example.com', 'senha789', '21987654321', 'Praça C, 789', 'Camareira', 'normal'),
('Rafael', 'Gomes', 'rafael.gomes', 'rafael.gomes@example.com', 'senha101', '21912345678', 'Travessa D, 101', 'Segurança', 'normal'),
('Mariana', 'Ferreira', 'mariana.ferreira', 'mariana.ferreira@example.com', 'senha202', '31987654321', 'Alameda E, 202', 'Cozinheira', 'normal');

INSERT INTO acomodacoes (numero, tipo, quantidade_leitos, preco_base, tamanho, estado)
VALUES
(101, 'Standard', 2, 2150.00, '20m²', 0),
(102, 'Deluxe', 3, 2250.00, '30m²', 0),
(103, 'Suite', 4, 2350.00, '40m²', 0),
(104, 'Standard', 2, 2150.00, '20m²', 0),
(105, 'Deluxe', 3, 2250.00, '30m²', 0);

INSERT INTO reservas (dataCheckin, dataCheckout, valorTotal, estado, id_cliente, id_acomodacao)
VALUES ('2024-06-01', '2024-06-10', 2500.00, 1, 3, 5);
