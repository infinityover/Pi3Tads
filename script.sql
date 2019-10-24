create database Pi3Tads;

use Pi3Tads;

create table produto(
    id varchar(30),
    nome varchar(100),
    valor float(15,2),
    CONSTRAINT produtoPk PRIMARY KEY (id)

);

create table filial(
    id varchar(30),
    apelido varchar(100),
    estado varchar(2),
    cidade varchar(70),
    CONSTRAINT filialPk PRIMARY KEY (id)

);

create table produtoFilial(
    id int,
    idProduto varchar(30),
    idFilial varchar(30),
    CONSTRAINT produtoFilialPk PRIMARY KEY (id)

);

create table venda(
    id int NOT NULL AUTO_INCREMENT,
    idFilial varchar(30),
    dataOp timestamp,
    valor float(15,2),
    CONSTRAINT vendaPk PRIMARY KEY (id)

);

create table vendaProduto(
    id int AUTO_INCREMENT,
    idVenda int, 
    idProduto varchar(30),
    valor float(15,2),
    quantidade int,
    desconto float(4,2),
    CONSTRAINT vendaProdutoPk PRIMARY KEY (id)
);
