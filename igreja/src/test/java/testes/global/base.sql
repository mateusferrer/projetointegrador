DROP TABLE IF EXISTS usuario;
DROP TABLE IF EXISTS movimento_receita;
DROP TABLE IF EXISTS movimento_despesa;
DROP TABLE IF EXISTS movimento;
DROP TABLE IF EXISTS lancamento_campanha;
DROP TABLE IF EXISTS contribuinte;
DROP TABLE IF EXISTS campanha;
DROP TABLE IF EXISTS agendamento_evento;
DROP TABLE IF EXISTS agendamento_reuniao;
DROP TABLE IF EXISTS agendamento;
DROP TABLE IF EXISTS membro_administrativo;
DROP TABLE IF EXISTS diretoria;
DROP TABLE IF EXISTS membro;
DROP TABLE IF EXISTS congregacao;
DROP TABLE IF EXISTS tipo_evento;
DROP TABLE IF EXISTS funcao;
DROP TABLE IF EXISTS tipo_membro;
DROP TABLE IF EXISTS cidade;
DROP TABLE IF EXISTS estado;

CREATE TABLE estado (
    cd_estado int(10) NOT NULL,
    in_estado char(2) NOT NULL,
    nm_estado varchar(50) NOT NULL,
    INDEX (nm_estado),
    PRIMARY KEY (cd_estado)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE cidade (
    cd_cidade int(10) NOT NULL,
    cd_estado int(10) NOT NULL,
    nm_cidade varchar(50) NOT NULL,
    INDEX (nm_cidade),
    PRIMARY KEY (cd_cidade),
    FOREIGN KEY (cd_estado) REFERENCES estado (cd_estado)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE tipo_membro (
	cd_tipo int(10) not null auto_increment,
	ds_tipo_membro varchar(50) NOT NULL,
	dt_inclusao datetime NOT NULL,
	dt_alteracao datetime NOT NULL,
	cd_usuario varchar(10) NOT NULL,
	INDEX (ds_tipo_membro),
	PRIMARY KEY (cd_tipo),
	UNIQUE KEY uq_descricao_tipo_membro (ds_tipo_membro)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE funcao (
	cd_funcao int(10) not null auto_increment,
	ds_funcao varchar(50) NOT NULL,
	dt_inclusao datetime NOT NULL,
	dt_alteracao datetime NOT NULL,
	cd_usuario varchar(10) NOT NULL,
	INDEX (ds_funcao),
	PRIMARY KEY (cd_funcao),
	UNIQUE KEY uq_descricao_cargo_administrativo (ds_funcao)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE tipo_evento (
	cd_tipo int(10) not null auto_increment,
	ds_tipo_evento varchar(50) NOT NULL,
	dt_inclusao datetime NOT NULL,
	dt_alteracao datetime NOT NULL,
	cd_usuario varchar(10) NOT NULL,
    INDEX (ds_tipo_evento),
	PRIMARY KEY (cd_tipo),
	UNIQUE KEY uq_descricao_tipo_evento (ds_tipo_evento)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE congregacao (
	cd_congregacao INT(10) NOT NULL AUTO_INCREMENT,  
	tx_razao_social VARCHAR(100) NOT NULL,          
	tx_nome_fantasia VARCHAR(100) NOT NULL,          
	sq_cnpj VARCHAR(14) NOT NULL,          
	sq_cep NUMERIC(8) NOT NULL,
	tx_endereco VARCHAR(150) NOT NULL,          
	nr_endereco INT(5) NOT NULL,          
	cd_estado int(10) NOT NULL,       
	cd_cidade int(10) NOT NULL,       
	tx_email VARCHAR(100) NULL,       
	sq_telefone VARCHAR(11) NOT NULL,       
	tp_congregacao CHAR(1) NOT NULL,       
	cd_sede int(10) NULL,
    dt_inclusao datetime NOT NULL,
	dt_alteracao datetime NOT NULL,
	cd_usuario varchar(10) NOT NULL,
	INDEX (tx_nome_fantasia),
	PRIMARY KEY (cd_congregacao),
    FOREIGN KEY (cd_sede) REFERENCES congregacao (cd_congregacao),
    FOREIGN KEY (cd_estado) REFERENCES estado (cd_estado),
    FOREIGN KEY (cd_cidade) REFERENCES cidade (cd_cidade),
	UNIQUE KEY cd_congregacao (cd_congregacao)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE membro (
    cd_membro INT(10) NOT NULL AUTO_INCREMENT,
    nm_membro VARCHAR(100) NOT NULL,
    sq_rg VARCHAR(10) NULL,
    sq_cpf VARCHAR(11) NOT NULL,
    dt_nascimento DATE NOT NULL,
    sq_cep VARCHAR(8) NOT NULL,
    tx_endereco VARCHAR(150) NOT NULL,
    nr_endereco INT(5) NOT NULL,
    in_sexo CHAR(1) NOT NULL,
    tx_email VARCHAR(100) NULL,
    cd_estado int(10) NOT NULL,
    cd_cidade int(10) NOT NULL,
    sq_telefone VARCHAR(11) NOT NULL,
    sq_celular VARCHAR(11) NULL,
    in_status CHAR(1) NOT NULL,
    tx_motivo VARCHAR(100) NULL,
    in_batizado CHAR(1) NOT NULL,
    dt_batismo DATE NULL,
    nr_registro_batismo INT(10) NULL,
    cd_congregacao INT(10) NOT NULL,
    cd_tipo INT(10) NOT NULL,
    dt_inclusao datetime NOT NULL,
    dt_alteracao datetime NOT NULL,
	cd_usuario varchar(10) NOT NULL,
    INDEX (nm_membro),
    PRIMARY KEY (cd_membro),
    FOREIGN KEY (cd_congregacao) REFERENCES congregacao (cd_congregacao),
    FOREIGN KEY (cd_tipo) REFERENCES tipo_membro (cd_tipo),
    UNIQUE KEY uq_membro_rg (sq_rg),
    UNIQUE KEY uq_membro_cpf (sq_cpf),
    UNIQUE KEY uq_membro_nr_registro_batismo (nr_registro_batismo)
)  ENGINE=INNODB DEFAULT CHARSET=UTF8;

CREATE TABLE diretoria (
  cd_diretoria int(10) NOT NULL AUTO_INCREMENT,
  cd_presidente int(10) NOT NULL,
  cd_vice_presidente int(10) NOT NULL,
  dt_inicio_atividades datetime NOT NULL,
  dt_inclusao datetime NOT NULL,
  dt_alteracao datetime NOT NULL,
  cd_usuario varchar(10) NOT NULL,
  PRIMARY KEY (cd_diretoria),
  FOREIGN KEY (cd_presidente) references membro (cd_membro),
  FOREIGN KEY (cd_vice_presidente) references membro (cd_membro)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE membro_administrativo (
	cd_membro_administrativo int(10) NOT NULL AUTO_INCREMENT,
	cd_membro int(10) NOT NULL,
	cd_funcao int(10) NOT NULL,
	cd_diretoria int(10),
	dt_ocupacao date NOT NULL,
	dt_desocupacao date NULL,
	PRIMARY KEY (cd_membro_administrativo),
	FOREIGN KEY (cd_membro) references membro (cd_membro),
	FOREIGN KEY (cd_funcao) references funcao (cd_funcao)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE usuario (
	cd_usuario varchar(10) not null,
	ds_senha varchar(50) not null,
	in_tipo_usuario char(2) not null,
	in_situacao char(1) not null,
	PRIMARY KEY (cd_usuario)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE campanha (
	cd_campanha int(10) NOT NULL AUTO_INCREMENT,
	ds_campanha char(50) NOT NULL,
	vl_campanha decimal(10,2) NOT NULL,
	nr_parcelas int(10) NOT NULL,
	dt_inicial date NOT NULL,
	dt_final date NOT NULL,
	in_status char(2) NOT NULL,
	cd_congregacao int(10) NOT NULL,
	dt_inclusao datetime NOT NULL,
	dt_alteracao datetime NOT NULL,
	cd_usuario varchar(10) NOT NULL,
	INDEX (ds_campanha),
	PRIMARY KEY (cd_campanha),
	FOREIGN KEY (cd_congregacao) references congregacao (cd_congregacao)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE contribuinte (
	cd_contribuinte int(10) not null auto_increment,
	cd_campanha int(10) not null,
	cd_membro int(10) not null,
	vl_contribuido decimal(10,2) not null, -- Valor total a ser contribuido pelo contribuinte.
	dt_inicial date not null,
	dt_final date not null,
	dt_inclusao datetime not null,
	dt_alteracao datetime not null,
	cd_usuario varchar(10) not null,
	PRIMARY KEY (cd_contribuinte),
	FOREIGN KEY (cd_campanha) references campanha (cd_campanha),
	FOREIGN KEY (cd_membro) references membro (cd_membro)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE lancamento_campanha (
	cd_lancamento int(10) not null auto_increment,
	vl_lancamento decimal(10,2) not null,
	dt_pagamento date null,
	in_pago char(1) not null,
	cd_contribuinte int null,
	PRIMARY KEY (cd_lancamento),
	FOREIGN KEY (cd_contribuinte) references contribuinte (cd_contribuinte)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;