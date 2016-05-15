CREATE TABLE estado (
    cd_estado int NOT NULL,
    in_estado char(2) NOT NULL,
    nm_estado varchar(50) NOT NULL,
    INDEX (nm_estado),
    PRIMARY KEY (cd_estado)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE cidade (
    cd_cidade int NOT NULL,
    cd_estado int NOT NULL,
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

CREATE TABLE entidade (
	cd_entidade INT(10) NOT NULL AUTO_INCREMENT,  
	tx_razao_social VARCHAR(100) NOT NULL,          
	tx_nome_fantasia VARCHAR(100) NOT NULL,          
	sq_cnpj VARCHAR(14) NOT NULL,          
	sq_cep NUMERIC(8) NOT NULL,
	tx_endereco VARCHAR(100) NOT NULL,
	nr_endereco INT(5) NOT NULL,          
	in_estado char(2) NOT NULL,       
	nm_cidade varchar(50) NOT NULL,       
	tx_email VARCHAR(100) NULL,       
	sq_telefone VARCHAR(11) NOT NULL,       
	tp_entidade CHAR(1) NOT NULL,
	cd_matriz int(10) NULL,
    dt_inclusao datetime NOT NULL,
	dt_alteracao datetime NOT NULL,
	cd_usuario varchar(10) NOT NULL,
	INDEX (tx_nome_fantasia),
	PRIMARY KEY (cd_entidade),
    FOREIGN KEY (cd_matriz) REFERENCES entidade (cd_entidade),
	UNIQUE KEY sq_cnpj (sq_cnpj)
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
    in_estado char(2) NOT NULL,
    nm_cidade varchar(50) NOT NULL,
    sq_telefone VARCHAR(11) NOT NULL,
    sq_celular VARCHAR(11) NULL,
    in_status CHAR(1) NOT NULL,
    tx_motivo VARCHAR(100) NULL,
    in_batizado CHAR(1) NOT NULL,
    dt_batismo DATE NULL,
    nr_registro_batismo INT(10) NULL,
    cd_entidade INT(10) NOT NULL,
    cd_tipo INT(10) NOT NULL,
    dt_inclusao datetime NOT NULL,
    dt_alteracao datetime NOT NULL,
	cd_usuario varchar(10) NOT NULL,
    INDEX (nm_membro),
    PRIMARY KEY (cd_membro),
    FOREIGN KEY (cd_entidade) REFERENCES entidade (cd_entidade),
    FOREIGN KEY (cd_tipo) REFERENCES tipo_membro (cd_tipo),
    UNIQUE KEY uq_membro_rg (sq_rg),
    UNIQUE KEY uq_membro_cpf (sq_cpf),
    UNIQUE KEY uq_membro_nr_registro_batismo (nr_registro_batismo)
)  ENGINE=INNODB DEFAULT CHARSET=UTF8;

/*
CREATE TABLE diretoria (
  cd_diretoria int(10) NOT NULL AUTO_INCREMENT,
  cd_presidente int(10) NOT NULL,
  cd_vice_presidente int(10) NOT NULL,
  cd_entidade int(10) NOT NULL,
  dt_inicio_atividades datetime NOT NULL,
  dt_inclusao datetime NOT NULL,
  dt_alteracao datetime NOT NULL,
  cd_usuario varchar(10) NOT NULL,
  PRIMARY KEY (cd_diretoria),
  FOREIGN KEY (cd_presidente) references membro (cd_membro),
  FOREIGN KEY (cd_entidade) references entidade (cd_entidade),
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
	nm_usuario varchar(10) not null,
	ds_senha varchar(50) not null,
	in_tipo_usuario char(2) not null,
	in_situacao char(1) not null,
	PRIMARY KEY (nm_usuario, ds_senha)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;
*/