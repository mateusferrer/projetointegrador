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
DROP TABLE IF EXISTS entidade;
DROP TABLE IF EXISTS tipo_evento;
DROP TABLE IF EXISTS funcao;
DROP TABLE IF EXISTS tipo_membro;
DROP TABLE IF EXISTS usuario;

CREATE TABLE usuario (
	cd_usuario varchar(10) not null,
	ds_senha varchar(50) not null,
	in_tipo_usuario char(2) not null,
	in_situacao char(1) not null,
	PRIMARY KEY (cd_usuario),
    UNIQUE (cd_usuario)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE entidade (
	cd_entidade INT(10) NOT NULL AUTO_INCREMENT,  
	nm_entidade VARCHAR(100) NOT NULL,          
	sq_cnpj VARCHAR(14) NOT NULL,          
	sq_cep NUMERIC(8) NOT NULL,
	ds_rua VARCHAR(100) NOT NULL,
	nr_rua INT(5) NOT NULL,      
    ds_bairro VARCHAR(50) NOT NULL,
	in_estado char(2) NOT NULL,       
	nm_cidade varchar(50) NOT NULL,       
	tx_email VARCHAR(100) NULL,       
	sq_telefone VARCHAR(11) NOT NULL,       
	tp_entidade CHAR(1) NOT NULL,
	cd_matriz int(10) NULL,
    dt_inclusao datetime NOT NULL DEFAULT NOW(),
	dt_alteracao datetime NOT NULL DEFAULT NOW(),
	cd_usuario varchar(10) NOT NULL,
	INDEX (nm_entidade),
	PRIMARY KEY (cd_entidade),
    FOREIGN KEY (cd_usuario) REFERENCES usuario (cd_usuario),
    FOREIGN KEY (cd_matriz) REFERENCES entidade (cd_entidade),
	UNIQUE KEY sq_cnpj (sq_cnpj)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE tipo_membro (
	cd_tipo int(10) not null auto_increment,
	ds_tipo_membro varchar(50) NOT NULL,
	dt_inclusao datetime NOT NULL DEFAULT NOW(),
	dt_alteracao datetime NOT NULL DEFAULT NOW(),
	cd_usuario varchar(10) NOT NULL,
	INDEX (ds_tipo_membro),
	PRIMARY KEY (cd_tipo),
    FOREIGN KEY (cd_usuario) REFERENCES usuario (cd_usuario),
	UNIQUE KEY uq_descricao_tipo_membro (ds_tipo_membro)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE membro (
    cd_membro INT(10) NOT NULL AUTO_INCREMENT,
    nm_membro VARCHAR(100) NOT NULL,
    sq_rg VARCHAR(10) NULL,
    sq_cpf VARCHAR(11) NOT NULL,
    dt_nascimento DATE NOT NULL,
	sq_cep NUMERIC(8) NOT NULL,
	ds_rua VARCHAR(100) NOT NULL,
	nr_rua INT(5) NOT NULL,      
    ds_bairro VARCHAR(50) NOT NULL,
	in_estado char(2) NOT NULL,       
	nm_cidade varchar(50) NOT NULL,       
    in_sexo CHAR(1) NOT NULL,
    tx_email VARCHAR(100) NULL,
    sq_telefone VARCHAR(11) NOT NULL,
    sq_celular VARCHAR(11) NULL,
    in_status CHAR(1) NOT NULL,
    tx_motivo VARCHAR(100) NULL,
    in_batizado CHAR(1) NOT NULL,
    dt_batismo DATE NULL,
    cd_entidade INT(10) NOT NULL,
    cd_tipo INT(10) NOT NULL,
    dt_inclusao datetime NOT NULL DEFAULT NOW(),
    dt_alteracao datetime NOT NULL DEFAULT NOW(),
	cd_usuario varchar(10) NOT NULL,
    INDEX (nm_membro),
    PRIMARY KEY (cd_membro),
    FOREIGN KEY (cd_entidade) REFERENCES entidade (cd_entidade),
    FOREIGN KEY (cd_tipo) REFERENCES tipo_membro (cd_tipo),
    FOREIGN KEY (cd_usuario) REFERENCES usuario (cd_usuario),
    UNIQUE KEY uq_membro_rg (sq_rg),
    UNIQUE KEY uq_membro_cpf (sq_cpf)
)  ENGINE=INNODB DEFAULT CHARSET=UTF8;

CREATE TABLE campanha (
	cd_campanha int(10) NOT NULL AUTO_INCREMENT,
	ds_campanha char(50) NOT NULL,
	vl_campanha decimal(10,2) NOT NULL,
	nr_parcelas int(10) NOT NULL,
	dt_inicial date NOT NULL,
	dt_final date NOT NULL,
	in_status char(2) NOT NULL,
	cd_entidade int(10) NOT NULL,
	dt_inclusao datetime NOT NULL default NOW(),
	dt_alteracao datetime NOT NULL default NOW(),
	cd_usuario varchar(10) NOT NULL,
	INDEX (ds_campanha),
	PRIMARY KEY (cd_campanha),
    FOREIGN KEY (cd_usuario) REFERENCES usuario (cd_usuario),
	FOREIGN KEY (cd_entidade) references entidade (cd_entidade)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE contribuinte (
	cd_contribuinte int(10) not null auto_increment,
	cd_campanha int(10) not null,
	cd_membro int(10) not null,
	vl_contribuido decimal(10,2) not null, -- Valor total a ser contribuido pelo contribuinte.
	dt_inicial date not null,
	dt_final date not null,
	PRIMARY KEY (cd_contribuinte),
	FOREIGN KEY (cd_campanha) references campanha (cd_campanha) on delete cascade,
	FOREIGN KEY (cd_membro) references membro (cd_membro)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE lancamento_campanha (
	cd_lancamento int(10) not null auto_increment,
    cd_contribuinte int not null,
	vl_lancamento decimal(10,2) not null,
	dt_pagamento date null,
	in_pago char(1) not null,
	PRIMARY KEY (cd_lancamento),
	FOREIGN KEY (cd_contribuinte) references contribuinte (cd_contribuinte) on delete cascade
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE funcao (
	cd_funcao int(10) not null auto_increment,
	ds_funcao varchar(50) NOT NULL,
	dt_inclusao datetime NOT NULL DEFAULT NOW(),
	dt_alteracao datetime NOT NULL DEFAULT NOW(),
	cd_usuario varchar(10) NOT NULL,
	INDEX (ds_funcao),
	PRIMARY KEY (cd_funcao),
    FOREIGN KEY (cd_usuario) REFERENCES usuario (cd_usuario),
	UNIQUE KEY uq_descricao_cargo_administrativo (ds_funcao)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE tipo_evento (
	cd_tipo int(10) not null auto_increment,
	ds_tipo_evento varchar(50) NOT NULL,
	dt_inclusao datetime NOT NULL DEFAULT NOW(),
	dt_alteracao datetime NOT NULL DEFAULT NOW(),
	cd_usuario varchar(10) NOT NULL,
    INDEX (ds_tipo_evento),
	PRIMARY KEY (cd_tipo),
    FOREIGN KEY (cd_usuario) REFERENCES usuario (cd_usuario),
	UNIQUE KEY uq_descricao_tipo_evento (ds_tipo_evento)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

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

*/

-- USUARIO
insert into usuario (cd_usuario, ds_senha, in_tipo_usuario, in_situacao)
	VALUES ('LFRANCISQU', '123', 'M', 'A');
    insert into usuario (cd_usuario, ds_senha, in_tipo_usuario, in_situacao)
	VALUES ('WSOARES', '1234', 'M', 'T');
    insert into usuario (cd_usuario, ds_senha, in_tipo_usuario, in_situacao)
	VALUES ('SDIAS', '1123', 'M', 'S');

-- TIPO MEMBRO
insert into tipo_membro (ds_tipo_membro, cd_usuario) 
	values ('Pastor', 'LFRANCISQU');
insert into tipo_membro (ds_tipo_membro, cd_usuario) 
	values ('Presbitero', 'WSOARES');
    insert into tipo_membro (ds_tipo_membro, cd_usuario) 
	values ('COPERADOR', 'SDIAS');

-- FUNÇÃO
insert into funcao (ds_funcao, cd_usuario) 
	values ('Tesoureiro(a)', 'LFRANCISQU');
insert into funcao (ds_funcao, cd_usuario) 
	values ('Secretário(a)', 'LFRANCISQU');

-- TIPO EVENTO
insert into tipo_evento (ds_tipo_evento , cd_usuario) 
	values ('Culto', 'LFRANCISQU');
    insert into tipo_evento (ds_tipo_evento , cd_usuario) 
	values ('Reuniao', 'SDIAS');
    insert into tipo_evento (ds_tipo_evento , cd_usuario) 
	values ('Palestra', 'WSOARES');

-- IGREJA
insert into entidade (nm_entidade, sq_cnpj, sq_cep, ds_rua, nr_rua, ds_bairro, in_estado, nm_cidade, sq_telefone, tp_entidade, dt_alteracao, cd_usuario) 
	values ('Igreja Evangélica Batista', '86212661000104', '86010150', 'Av. Rio de Janeiro', 1558, 'Vila Ipiranga', 'PR', 'Londrina', '4332941866', 'M', '20160518', 'LFRANCISQU');
    insert into entidade (nm_entidade, sq_cnpj, sq_cep, ds_rua, nr_rua, ds_bairro, in_estado, nm_cidade, sq_telefone, tp_entidade, dt_alteracao, cd_usuario) 
	values ('Igreja Evangélica Luz do Mundo', '86212661000105', '86010149', 'Av. Santos', 1544, 'Vila Rual', 'PR', 'Londrina', '4332941844', 'F', '20160518', 'LFRANCISQU');
    insert into entidade (nm_entidade, sq_cnpj, sq_cep, ds_rua, nr_rua, ds_bairro, in_estado, nm_cidade, sq_telefone, tp_entidade, dt_alteracao, cd_usuario) 
	values ('Igreja Evangélica Assembleia de Deus', '86212661000103', '86010166', 'Av. Sao Paulo', 65, 'acapuco', 'PR', 'Londrina', '4332946666', 'F', '20160518', 'LFRANCISQU');
    insert into entidade (nm_entidade, sq_cnpj, sq_cep, ds_rua, nr_rua, ds_bairro, in_estado, nm_cidade, sq_telefone, tp_entidade, dt_alteracao, cd_usuario) 
	values ('Igreja Evangélica Batista Peniel', '86212661000102', '86010178', 'Av. Santos', 7866, 'Cafezao', 'PR', 'Londrina', '433292345', 'F', '20160518', 'LFRANCISQU');
    insert into entidade (nm_entidade, sq_cnpj, sq_cep, ds_rua, nr_rua, ds_bairro, in_estado, nm_cidade, sq_telefone, tp_entidade, dt_alteracao, cd_usuario) 
	values ('Igreja Evangélica Batista Renovada', '86212661000101', '86010155', 'Av. Bahia', 5433, 'Brasil', 'PR', 'Londrina', '433294432', 'F', '20160518', 'LFRANCISQU');
    insert into entidade (nm_entidade, sq_cnpj, sq_cep, ds_rua, nr_rua, ds_bairro, in_estado, nm_cidade, sq_telefone, tp_entidade, dt_alteracao, cd_usuario) 
	values ('Igreja Evangélica Brasil Para Cristo', '86212661000100', '86010122', 'Av. Rio Grande Do Norte', 5544, 'Taroba', 'PR', 'Londrina', '433294878', 'F', '20160518', 'LFRANCISQU');
    insert into entidade (nm_entidade, sq_cnpj, sq_cep, ds_rua, nr_rua, ds_bairro, in_estado, nm_cidade, sq_telefone, tp_entidade, dt_alteracao, cd_usuario) 
	values ('Igreja Evangélica Renovada', '86212661000114', '86010121', 'Av. Rio de Janeiro', 789, 'Campus Elizios', 'PR', 'Londrina', '4332941876', 'F', '20160518', 'LFRANCISQU');
    insert into entidade (nm_entidade, sq_cnpj, sq_cep, ds_rua, nr_rua, ds_bairro, in_estado, nm_cidade, sq_telefone, tp_entidade, dt_alteracao, cd_usuario) 
	values ('Igreja Evangélica Deus é Amor', '86212661000124', '86010165', 'Av. Tiradentes', 22, 'Romana', 'PR', 'Londrina', '4332941543', 'F', '20160518', 'LFRANCISQU');
    insert into entidade (nm_entidade, sq_cnpj, sq_cep, ds_rua, nr_rua, ds_bairro, in_estado, nm_cidade, sq_telefone, tp_entidade, dt_alteracao, cd_usuario) 
	values ('Igreja Evangélica Mundial', '86212661000134', '86010888', 'Av. Jk', 345, 'Sao Lourenço', 'PR', 'Londrina', '4332941567', 'F', '20160518', 'LFRANCISQU');
    insert into entidade (nm_entidade, sq_cnpj, sq_cep, ds_rua, nr_rua, ds_bairro, in_estado, nm_cidade, sq_telefone, tp_entidade, dt_alteracao, cd_usuario) 
	values ('Igreja Evangélica Só o Senhor è Deus', '86212661000144', '86010132', 'Av. Brasil', 1058, 'Maria Celina', 'PR', 'Londrina', '4332941865', 'F', '20160518', 'LFRANCISQU');

-- MEMBRO
insert into membro (nm_membro, sq_cpf, dt_nascimento, in_sexo, sq_cep, ds_rua, nr_rua, ds_bairro, in_estado, nm_cidade, sq_telefone, in_status, dt_alteracao, cd_usuario, in_batizado, cd_entidade, cd_tipo) 
	values ('Lucas Costa Francisquini', '06459478902', '19940525', 'M', '86070030', 'R. Capitão Ferreira Gomes', 87, 'Shangrilá', 'PR', 'Londrina', '4333510548', 'A', '20160518', 'LFRANCISQU', 'N', 1, 1);
insert into membro (nm_membro, sq_cpf, dt_nascimento, in_sexo, sq_cep, ds_rua, nr_rua, ds_bairro, in_estado, nm_cidade, sq_telefone, in_status, dt_alteracao, cd_usuario, in_batizado, cd_entidade, cd_tipo) 
	values ('Rosely Macedo Francisquini', '44981012861', '19940525', 'F', '86070030', 'R. Capitão Ferreira Gomes', 87, 'Shangrilá', 'PR', 'Londrina', '4333510548', 'A', '20160518', 'LFRANCISQU', 'N', 1, 1);
insert into membro (nm_membro, sq_cpf, dt_nascimento, in_sexo, sq_cep, ds_rua, nr_rua, ds_bairro, in_estado, nm_cidade, sq_telefone, in_status, dt_alteracao, cd_usuario, in_batizado, cd_entidade, cd_tipo) 
	values ('Luiz Marcos Francisquini', '28933974849', '19940525', 'M', '86070030', 'R. Capitão Ferreira Gomes', 87, 'Shangrilá', 'PR', 'Londrina', '4333510548', 'A', '20160518', 'LFRANCISQU', 'N', 1, 1);
insert into membro (nm_membro, sq_cpf, dt_nascimento, in_sexo, sq_cep, ds_rua, nr_rua, ds_bairro, in_estado, nm_cidade, sq_telefone, in_status, dt_alteracao, cd_usuario, in_batizado, cd_entidade, cd_tipo) 
	values ('Matheus Costa Francisquini', '42449735593', '19940525', 'M', '86070030', 'R. Capitão Ferreira Gomes', 87, 'Shangrilá', 'PR', 'Londrina', '4333510548', 'A', '20160518', 'LFRANCISQU', 'N', 1, 1);
insert into membro (nm_membro, sq_cpf, dt_nascimento, in_sexo, sq_cep, ds_rua, nr_rua, ds_bairro, in_estado, nm_cidade, sq_telefone, in_status, dt_alteracao, cd_usuario, in_batizado, cd_entidade, cd_tipo) 
	values ('Ana Carolina dos Santos Lopes', '68771195416', '19940525', 'M', '86070030', 'R. Capitão Ferreira Gomes', 87, 'Shangrilá', 'PR', 'Londrina', '4333510548', 'A', '20160518', 'LFRANCISQU', 'N', 1, 2);
insert into membro (nm_membro, sq_cpf, dt_nascimento, in_sexo, sq_cep, ds_rua, nr_rua, ds_bairro, in_estado, nm_cidade, sq_telefone, in_status, dt_alteracao, cd_usuario, in_batizado, cd_entidade, cd_tipo) 
	values ('Wagner Soares', '80739102761', '19940525', 'M', '86070030', 'R. Capitão Ferreira Gomes', 87, 'Shangrilá', 'PR', 'Londrina', '4333510548', 'A', '20160518', 'LFRANCISQU', 'N', 1, 2);
insert into membro (nm_membro, sq_cpf, dt_nascimento, in_sexo, sq_cep, ds_rua, nr_rua, ds_bairro, in_estado, nm_cidade, sq_telefone, in_status, dt_alteracao, cd_usuario, in_batizado, cd_entidade, cd_tipo) 
	values ('Thiago dos Santos de Jesus', '76941895926', '19940525', 'M', '86070030', 'R. Capitão Ferreira Gomes', 87, 'Shangrilá', 'PR', 'Londrina', '4333510548', 'A', '20160518', 'LFRANCISQU', 'N', 1, 2);
insert into membro (nm_membro, sq_cpf, dt_nascimento, in_sexo, sq_cep, ds_rua, nr_rua, ds_bairro, in_estado, nm_cidade, sq_telefone, in_status, dt_alteracao, cd_usuario, in_batizado, cd_entidade, cd_tipo) 
	values ('Marina dos Santos Rocha', '35536160168', '19940525', 'M', '86070030', 'R. Capitão Ferreira Gomes', 87, 'Shangrilá', 'PR', 'Londrina', '4333510548', 'A', '20160518', 'LFRANCISQU', 'N', 1, 2);
insert into membro (nm_membro, sq_cpf, dt_nascimento, in_sexo, sq_cep, ds_rua, nr_rua, ds_bairro, in_estado, nm_cidade, sq_telefone, in_status, dt_alteracao, cd_usuario, in_batizado, cd_entidade, cd_tipo) 
	values ('Mateus Ferrer Corso', '8967511545', '19940525', 'M', '86070030', 'R. Capitão Ferreira Gomes', 87, 'Shangrilá', 'PR', 'Londrina', '4333510548', 'A', '20160518', 'LFRANCISQU', 'N', 1, 2);
insert into membro (nm_membro, sq_cpf, dt_nascimento, in_sexo, sq_cep, ds_rua, nr_rua, ds_bairro, in_estado, nm_cidade, sq_telefone, in_status, dt_alteracao, cd_usuario, in_batizado, cd_entidade, cd_tipo) 
	values ('Thiago Constante de Souza', '84453590009', '19940525', 'M', '86070030', 'R. Capitão Ferreira Gomes', 87, 'Shangrilá', 'PR', 'Londrina', '4333510548', 'A', '20160518', 'LFRANCISQU', 'N', 1, 2);
insert into membro (nm_membro, sq_cpf, dt_nascimento, in_sexo, sq_cep, ds_rua, nr_rua, ds_bairro, in_estado, nm_cidade, sq_telefone, in_status, dt_alteracao, cd_usuario, in_batizado, cd_entidade, cd_tipo) 
	values ('Leandro Costa Francisquini', '82265238937', '19920525', 'M', '86070030', 'R. Capitão Ferreira Gomes', 87, 'Shangrilá', 'PR', 'Londrina', '4333510548', 'A', '20160518', 'LFRANCISQU', 'N', 2, 1);
insert into membro (nm_membro, sq_cpf, dt_nascimento, in_sexo, sq_cep, ds_rua, nr_rua, ds_bairro, in_estado, nm_cidade, sq_telefone, in_status, dt_alteracao, cd_usuario, in_batizado, cd_entidade, cd_tipo) 
	values ('Rosana Macedo Francisquini', '32460922817', '19940125', 'F', '86070030', 'R. Capitão Ferreira Gomes', 87, 'Shangrilá', 'PR', 'Londrina', '4333510548', 'A', '20160518', 'LFRANCISQU', 'N', 2, 1);
insert into membro (nm_membro, sq_cpf, dt_nascimento, in_sexo, sq_cep, ds_rua, nr_rua, ds_bairro, in_estado, nm_cidade, sq_telefone, in_status, dt_alteracao, cd_usuario, in_batizado, cd_entidade, cd_tipo) 
	values ('Léo Marcos Francisquini', '28933974987', '19920525', 'M', '86070030', 'R. Capitão Ferreira Gomes', 87, 'Shangrilá', 'PR', 'Londrina', '4333510548', 'A', '20160518', 'LFRANCISQU', 'N', 2, 2);
insert into membro (nm_membro, sq_cpf, dt_nascimento, in_sexo, sq_cep, ds_rua, nr_rua, ds_bairro, in_estado, nm_cidade, sq_telefone, in_status, dt_alteracao, cd_usuario, in_batizado, cd_entidade, cd_tipo) 
	values ('Marcelo Costa Francisquini', '42485735566', '19970525', 'M', '86070030', 'R. Capitão Ferreira Gomes', 87, 'Shangrilá', 'PR', 'Londrina', '4333510548', 'A', '20160518', 'LFRANCISQU', 'N', 2, 2);
insert into membro (nm_membro, sq_cpf, dt_nascimento, in_sexo, sq_cep, ds_rua, nr_rua, ds_bairro, in_estado, nm_cidade, sq_telefone, in_status, dt_alteracao, cd_usuario, in_batizado, cd_entidade, cd_tipo) 
	values ('Carolina dos Santos Lopes', '68571195487', '19990525', 'M', '86070030', 'R. Capitão Ferreira Gomes', 87, 'Shangrilá', 'PR', 'Londrina', '4333510548', 'A', '20160518', 'LFRANCISQU', 'N', 2, 2);
insert into membro (nm_membro, sq_cpf, dt_nascimento, in_sexo, sq_cep, ds_rua, nr_rua, ds_bairro, in_estado, nm_cidade, sq_telefone, in_status, dt_alteracao, cd_usuario, in_batizado, cd_entidade, cd_tipo) 
	values ('Wander Soares', '80739582888', '19970507', 'M', '86070030', 'R. Capitão Ferreira Gomes', 87, 'Shangrilá', 'PR', 'Londrina', '4333510548', 'A', '20160518', 'LFRANCISQU', 'N', 2, 2);
insert into membro (nm_membro, sq_cpf, dt_nascimento, in_sexo, sq_cep, ds_rua, nr_rua, ds_bairro, in_estado, nm_cidade, sq_telefone, in_status, dt_alteracao, cd_usuario, in_batizado, cd_entidade, cd_tipo) 
	values ('Tagori dos Santos de Jesus', '76945495989', '19840525', 'M', '86070030', 'R. Capitão Ferreira Gomes', 87, 'Shangrilá', 'PR', 'Londrina', '4333510548', 'A', '20160518', 'LFRANCISQU', 'N', 2, 2);
insert into membro (nm_membro, sq_cpf, dt_nascimento, in_sexo, sq_cep, ds_rua, nr_rua, ds_bairro, in_estado, nm_cidade, sq_telefone, in_status, dt_alteracao, cd_usuario, in_batizado, cd_entidade, cd_tipo) 
	values ('Mariana dos Santos Rocha', '35535560100', '19980525', 'M', '86070030', 'R. Capitão Ferreira Gomes', 87, 'Shangrilá', 'PR', 'Londrina', '4333510548', 'A', '20160518', 'LFRANCISQU', 'N', 2, 2);
insert into membro (nm_membro, sq_cpf, dt_nascimento, in_sexo, sq_cep, ds_rua, nr_rua, ds_bairro, in_estado, nm_cidade, sq_telefone, in_status, dt_alteracao, cd_usuario, in_batizado, cd_entidade, cd_tipo) 
	values ('Marcos Ferrer Corso', '89675112079', '19940525', 'M', '86070030', 'R. Capitão Ferreira Gomes', 87, 'Shangrilá', 'PR', 'Londrina', '4333510548', 'A', '20160518', 'LFRANCISQU', 'N', 2, 2);
insert into membro (nm_membro, sq_cpf, dt_nascimento, in_sexo, sq_cep, ds_rua, nr_rua, ds_bairro, in_estado, nm_cidade, sq_telefone, in_status, dt_alteracao, cd_usuario, in_batizado, cd_entidade, cd_tipo) 
	values ('Tadeu Constante de Souza', '84458590799', '19980512','M', '86070030', 'R. Capitão Ferreira Gomes', 87, 'Shangrilá', 'PR', 'Londrina', '4333510548', 'A', '20160518', 'LFRANCISQU', 'N', 2, 2);
insert into membro (nm_membro, sq_cpf, dt_nascimento, in_sexo, sq_cep, ds_rua, nr_rua, ds_bairro, in_estado, nm_cidade, sq_telefone, in_status, dt_alteracao, cd_usuario, in_batizado, cd_entidade, cd_tipo) 
	values ('Lucas Costa Cardoso', '06450078772', '19940205', 'M', '86070030', 'R. Arthur Lopes', 99, 'Shangrilá', 'PR', 'Londrina', '4333510548', 'A', '20160518', 'LFRANCISQU', 'N',3, 1);
insert into membro (nm_membro, sq_cpf, dt_nascimento, in_sexo, sq_cep, ds_rua, nr_rua, ds_bairro, in_estado, nm_cidade, sq_telefone, in_status, dt_alteracao, cd_usuario, in_batizado, cd_entidade, cd_tipo) 
	values ('Rosely Macedo Cardoso', '44980412881', '19930508', 'F', '86070030', 'R. Capitão Ferreira Gomes', 87, 'Shangrilá', 'PR', 'Londrina', '4333510548', 'A', '20160518', 'LFRANCISQU', 'N', 3, 1);
insert into membro (nm_membro, sq_cpf, dt_nascimento, in_sexo, sq_cep, ds_rua, nr_rua, ds_bairro, in_estado, nm_cidade, sq_telefone, in_status, dt_alteracao, cd_usuario, in_batizado, cd_entidade, cd_tipo) 
	values ('Luiz Marcos Cardoso', '28933975589', '19911201', 'M', '86070030', 'R. Capitão Ferreira Gomes', 87, 'Shangrilá', 'PR', 'Londrina', '4333510548', 'A', '20160518', 'LFRANCISQU', 'N', 3, 2);
insert into membro (nm_membro, sq_cpf, dt_nascimento, in_sexo, sq_cep, ds_rua, nr_rua, ds_bairro, in_estado, nm_cidade, sq_telefone, in_status, dt_alteracao, cd_usuario, in_batizado, cd_entidade, cd_tipo) 
	values ('Matheus Costa Cardoso', '42449735883', '19870812', 'M', '86070030', 'R. Capitão Ferreira Gomes', 87, 'Shangrilá', 'PR', 'Londrina', '4333510548', 'A', '20160518', 'LFRANCISQU', 'N', 3, 2);
insert into membro (nm_membro, sq_cpf, dt_nascimento, in_sexo, sq_cep, ds_rua, nr_rua, ds_bairro, in_estado, nm_cidade, sq_telefone, in_status, dt_alteracao, cd_usuario, in_batizado, cd_entidade, cd_tipo) 
	values ('Ana Carolina Santos', '68771005836', '19851204', 'M', '86070030', 'R. Capitão Ferreira Gomes', 87, 'Shangrilá', 'PR', 'Londrina', '4333510548', 'A', '20160518', 'LFRANCISQU', 'N', 3, 2);
insert into membro (nm_membro, sq_cpf, dt_nascimento, in_sexo, sq_cep, ds_rua, nr_rua, ds_bairro, in_estado, nm_cidade, sq_telefone, in_status, dt_alteracao, cd_usuario, in_batizado, cd_entidade, cd_tipo) 
	values ('Wagner Souza', '80739107771', '19930224', 'M', '86070030', 'R. Capitão Ferreira Gomes', 87, 'Shangrilá', 'PR', 'Londrina', '4333510548', 'A', '20160518', 'LFRANCISQU', 'N', 3, 2);
insert into membro (nm_membro, sq_cpf, dt_nascimento, in_sexo, sq_cep, ds_rua, nr_rua, ds_bairro, in_estado, nm_cidade, sq_telefone, in_status, dt_alteracao, cd_usuario, in_batizado, cd_entidade, cd_tipo) 
	values ('Thiago dos Santos', '15568702055', '19980401', 'M', '86070030', 'R. Capitão Ferreira Gomes', 87, 'Shangrilá', 'PR', 'Londrina', '4333510548', 'A', '20160518', 'LFRANCISQU', 'N', 3, 2);
insert into membro (nm_membro, sq_cpf, dt_nascimento, in_sexo, sq_cep, ds_rua, nr_rua, ds_bairro, in_estado, nm_cidade, sq_telefone, in_status, dt_alteracao, cd_usuario, in_batizado, cd_entidade, cd_tipo) 
	values ('Marina dos Santos', '77063112015', '19880806', 'M', '86070030', 'R. Capitão Ferreira Gomes', 87, 'Shangrilá', 'PR', 'Londrina', '4333510548', 'A', '20160518', 'LFRANCISQU', 'N', 3, 2);
insert into membro (nm_membro, sq_cpf, dt_nascimento, in_sexo, sq_cep, ds_rua, nr_rua, ds_bairro, in_estado, nm_cidade, sq_telefone, in_status, dt_alteracao, cd_usuario, in_batizado, cd_entidade, cd_tipo) 
	values ('Mateus Ferrer', '00238890988', '19910810', 'M', '86070030', 'R. Capitão Ferreira Gomes', 87, 'Shangrilá', 'PR', 'Londrina', '4333510548', 'A', '20160518', 'LFRANCISQU', 'N', 3, 2);
insert into membro (nm_membro, sq_cpf, dt_nascimento, in_sexo, sq_cep, ds_rua, nr_rua, ds_bairro, in_estado, nm_cidade, sq_telefone, in_status, dt_alteracao, cd_usuario, in_batizado, cd_entidade, cd_tipo) 
	values ('Thiago Constante', '10126583684', '19941229', 'M', '86070030', 'R. Capitão Ferreira Gomes', 87, 'Shangrilá', 'PR', 'Londrina', '4333510548', 'A', '20160518', 'LFRANCISQU', 'N', 3, 2);
insert into membro (nm_membro, sq_cpf, dt_nascimento, in_sexo, sq_cep, ds_rua, nr_rua, ds_bairro, in_estado, nm_cidade, sq_telefone, in_status, dt_alteracao, cd_usuario, in_batizado, cd_entidade, cd_tipo) 
	values ('Lucas Pereira Francisquini', '06459478758', '19940227', 'M', '86070030', 'R. Capitão Ferreira Gomes', 87, 'Shangrilá', 'PR', 'Londrina', '4333510548', 'A', '20160518', 'LFRANCISQU', 'N', 4, 1);
insert into membro (nm_membro, sq_cpf, dt_nascimento, in_sexo, sq_cep, ds_rua, nr_rua, ds_bairro, in_estado, nm_cidade, sq_telefone, in_status, dt_alteracao, cd_usuario, in_batizado, cd_entidade, cd_tipo) 
	values ('Rosely Santos Francisquini', '44981012987', '19870730', 'F', '86070030', 'R. Capitão Ferreira Gomes', 87, 'Shangrilá', 'PR', 'Londrina', '4333510548', 'A', '20160518', 'LFRANCISQU', 'N', 4, 1);
insert into membro (nm_membro, sq_cpf, dt_nascimento, in_sexo, sq_cep, ds_rua, nr_rua, ds_bairro, in_estado, nm_cidade, sq_telefone, in_status, dt_alteracao, cd_usuario, in_batizado, cd_entidade, cd_tipo) 
	values ('Luiz Matheus Francisquini', '28933974986', '19910125', 'M', '86070030', 'R. Capitão Ferreira Gomes', 87, 'Shangrilá', 'PR', 'Londrina', '4333510548', 'A', '20160518', 'LFRANCISQU', 'N', 4, 2);
insert into membro (nm_membro, sq_cpf, dt_nascimento, in_sexo, sq_cep, ds_rua, nr_rua, ds_bairro, in_estado, nm_cidade, sq_telefone, in_status, dt_alteracao, cd_usuario, in_batizado, cd_entidade, cd_tipo) 
	values ('Matheus Santos Francisquini', '42449735632', '19980102', 'M', '86070030', 'R. Capitão Ferreira Gomes', 87, 'Shangrilá', 'PR', 'Londrina', '4333510548', 'A', '20160518', 'LFRANCISQU', 'N', 4, 2);
insert into membro (nm_membro, sq_cpf, dt_nascimento, in_sexo, sq_cep, ds_rua, nr_rua, ds_bairro, in_estado, nm_cidade, sq_telefone, in_status, dt_alteracao, cd_usuario, in_batizado, cd_entidade, cd_tipo) 
	values ('Ana Clacra dos Santos', '68771195687', '19940514', 'M', '86070030', 'R. Capitão Ferreira Gomes', 87, 'Shangrilá', 'PR', 'Londrina', '4333510548', 'A', '20160518', 'LFRANCISQU', 'N', 4, 2);
insert into membro (nm_membro, sq_cpf, dt_nascimento, in_sexo, sq_cep, ds_rua, nr_rua, ds_bairro, in_estado, nm_cidade, sq_telefone, in_status, dt_alteracao, cd_usuario, in_batizado, cd_entidade, cd_tipo) 
	values ('Wagner Dias', '80739102871', '19940510', 'M', '86070030', 'R. Capitão Ferreira Gomes', 87, 'Shangrilá', 'PR', 'Londrina', '4333510548', 'A', '20160518', 'LFRANCISQU', 'N', 4, 2);
insert into membro (nm_membro, sq_cpf, dt_nascimento, in_sexo, sq_cep, ds_rua, nr_rua, ds_bairro, in_estado, nm_cidade, sq_telefone, in_status, dt_alteracao, cd_usuario, in_batizado, cd_entidade, cd_tipo) 
	values ('Thiago Macedo', '76941895652', '19940501', 'M', '86070030', 'R. Capitão Ferreira Gomes', 87, 'Shangrilá', 'PR', 'Londrina', '4333510548', 'A', '20160518', 'LFRANCISQU', 'N', 4, 2);
insert into membro (nm_membro, sq_cpf, dt_nascimento, in_sexo, sq_cep, ds_rua, nr_rua, ds_bairro, in_estado, nm_cidade, sq_telefone, in_status, dt_alteracao, cd_usuario, in_batizado, cd_entidade, cd_tipo) 
	values ('Marina dos Santos Rocha', '35536160247', '19940725', 'M', '86070030', 'R. Capitão Ferreira Gomes', 87, 'Shangrilá', 'PR', 'Londrina', '4333510548', 'A', '20160518', 'LFRANCISQU', 'N', 4, 2);
insert into membro (nm_membro, sq_cpf, dt_nascimento, in_sexo, sq_cep, ds_rua, nr_rua, ds_bairro, in_estado, nm_cidade, sq_telefone, in_status, dt_alteracao, cd_usuario, in_batizado, cd_entidade, cd_tipo) 
	values ('Mateus Pereira', '89675112000', '19940925', 'M', '86070030', 'R. Capitão Ferreira Gomes', 87, 'Shangrilá', 'PR', 'Londrina', '4333510548', 'A', '20160518', 'LFRANCISQU', 'N', 4, 2);
insert into membro (nm_membro, sq_cpf, dt_nascimento, in_sexo, sq_cep, ds_rua, nr_rua, ds_bairro, in_estado, nm_cidade, sq_telefone, in_status, dt_alteracao, cd_usuario, in_batizado, cd_entidade, cd_tipo) 
	values ('Thiago Dias Macedo', '84453590887', '19941025', 'M', '86070030', 'R. Capitão Ferreira Gomes', 87, 'Shangrilá', 'PR', 'Londrina', '4333510548', 'A', '20160518', 'LFRANCISQU', 'N', 4, 2);

-- CAMPANHA
insert into campanha (ds_campanha, vl_campanha, nr_parcelas, cd_usuario, dt_inicial, dt_final, in_status, cd_entidade)
	values ('Aquisição Ar Condicionado', 1400.00, 10, 'LFRANCISQU', '20160520', '20170220', 'AB', 1);
    insert into campanha (ds_campanha, vl_campanha, nr_parcelas, cd_usuario, dt_inicial, dt_final, in_status, cd_entidade)
	values ('Aquisição troca do forro', 2000.00, 10, 'LFRANCISQU', '20160520', '20170220', 'AB', 2);
insert into campanha (ds_campanha, vl_campanha, nr_parcelas, cd_usuario, dt_inicial, dt_final, in_status, cd_entidade)
	values ('Aquisição compara Contra Baixo', 1000.00, 5, 'LFRANCISQU', '20160520', '20170220', 'AB', 3);
    insert into campanha (ds_campanha, vl_campanha, nr_parcelas, cd_usuario, dt_inicial, dt_final, in_status, cd_entidade)
	values ('Aquario Bateria', 500.00, 5, 'LFRANCISQU', '20160520', '20170220', 'AB', 4);
    
-- CONTRIBUINTE
insert into contribuinte (cd_campanha, cd_membro, vl_contribuido, dt_inicial, dt_final) VALUES (1, 1, 140.00, '20160520', '20170220');
insert into contribuinte (cd_campanha, cd_membro, vl_contribuido, dt_inicial, dt_final) VALUES (1, 2, 140.00, '20160520', '20170220');
insert into contribuinte (cd_campanha, cd_membro, vl_contribuido, dt_inicial, dt_final) VALUES (1, 3, 140.00, '20160520', '20170220');
insert into contribuinte (cd_campanha, cd_membro, vl_contribuido, dt_inicial, dt_final) VALUES (1, 4, 140.00, '20160520', '20170220');
insert into contribuinte (cd_campanha, cd_membro, vl_contribuido, dt_inicial, dt_final) VALUES (1, 5, 140.00, '20160520', '20170220');
insert into contribuinte (cd_campanha, cd_membro, vl_contribuido, dt_inicial, dt_final) VALUES (1, 6, 140.00, '20160520', '20170220');
insert into contribuinte (cd_campanha, cd_membro, vl_contribuido, dt_inicial, dt_final) VALUES (1, 7, 140.00, '20160520', '20170220');
insert into contribuinte (cd_campanha, cd_membro, vl_contribuido, dt_inicial, dt_final) VALUES (1, 8, 140.00, '20160520', '20170220');
insert into contribuinte (cd_campanha, cd_membro, vl_contribuido, dt_inicial, dt_final) VALUES (1, 9, 140.00, '20160520', '20170220');
insert into contribuinte (cd_campanha, cd_membro, vl_contribuido, dt_inicial, dt_final) VALUES (1, 10, 140.00, '20160520', '20170220');

insert into contribuinte (cd_campanha, cd_membro, vl_contribuido, dt_inicial, dt_final) VALUES (2, 11, 200.00, '20160520', '20170220');
insert into contribuinte (cd_campanha, cd_membro, vl_contribuido, dt_inicial, dt_final) VALUES (2, 12, 200.00, '20160520', '20170220');
insert into contribuinte (cd_campanha, cd_membro, vl_contribuido, dt_inicial, dt_final) VALUES (2, 13, 200.00, '20160520', '20170220');
insert into contribuinte (cd_campanha, cd_membro, vl_contribuido, dt_inicial, dt_final) VALUES (2, 14, 200.00, '20160520', '20170220');
insert into contribuinte (cd_campanha, cd_membro, vl_contribuido, dt_inicial, dt_final) VALUES (2, 15, 200.00, '20160520', '20170220');
insert into contribuinte (cd_campanha, cd_membro, vl_contribuido, dt_inicial, dt_final) VALUES (2, 16, 200.00, '20160520', '20170220');
insert into contribuinte (cd_campanha, cd_membro, vl_contribuido, dt_inicial, dt_final) VALUES (2, 17, 200.00, '20160520', '20170220');
insert into contribuinte (cd_campanha, cd_membro, vl_contribuido, dt_inicial, dt_final) VALUES (2, 18, 200.00, '20160520', '20170220');
insert into contribuinte (cd_campanha, cd_membro, vl_contribuido, dt_inicial, dt_final) VALUES (2, 19, 200.00, '20160520', '20170220');

insert into contribuinte (cd_campanha, cd_membro, vl_contribuido, dt_inicial, dt_final) VALUES (3, 20, 100.00, '20160520', '20170220');
insert into contribuinte (cd_campanha, cd_membro, vl_contribuido, dt_inicial, dt_final) VALUES (3, 10, 140.00, '20160520', '20170220');
insert into contribuinte (cd_campanha, cd_membro, vl_contribuido, dt_inicial, dt_final) VALUES (3, 21, 100.00, '20160520', '20170220');
insert into contribuinte (cd_campanha, cd_membro, vl_contribuido, dt_inicial, dt_final) VALUES (3, 22, 100.00, '20160520', '20170220');
insert into contribuinte (cd_campanha, cd_membro, vl_contribuido, dt_inicial, dt_final) VALUES (3, 23, 100.00, '20160520', '20170220');
insert into contribuinte (cd_campanha, cd_membro, vl_contribuido, dt_inicial, dt_final) VALUES (3, 24, 100.00, '20160520', '20170220');
insert into contribuinte (cd_campanha, cd_membro, vl_contribuido, dt_inicial, dt_final) VALUES (3, 25, 100.00, '20160520', '20170220');
insert into contribuinte (cd_campanha, cd_membro, vl_contribuido, dt_inicial, dt_final) VALUES (3, 26, 100.00, '20160520', '20170220');
insert into contribuinte (cd_campanha, cd_membro, vl_contribuido, dt_inicial, dt_final) VALUES (3, 27, 100.00, '20160520', '20170220');
insert into contribuinte (cd_campanha, cd_membro, vl_contribuido, dt_inicial, dt_final) VALUES (3, 28, 100.00, '20160520', '20170220');
insert into contribuinte (cd_campanha, cd_membro, vl_contribuido, dt_inicial, dt_final) VALUES (3, 29, 100.00, '20160520', '20170220');
insert into contribuinte (cd_campanha, cd_membro, vl_contribuido, dt_inicial, dt_final) VALUES (3, 30, 100.00, '20160520', '20170220');

insert into contribuinte (cd_campanha, cd_membro, vl_contribuido, dt_inicial, dt_final) VALUES (3, 31, 100.00, '20160520', '20170220');
insert into contribuinte (cd_campanha, cd_membro, vl_contribuido, dt_inicial, dt_final) VALUES (3, 32, 100.00, '20160520', '20170220');
insert into contribuinte (cd_campanha, cd_membro, vl_contribuido, dt_inicial, dt_final) VALUES (3, 33, 100.00, '20160520', '20170220');
insert into contribuinte (cd_campanha, cd_membro, vl_contribuido, dt_inicial, dt_final) VALUES (3, 34, 100.00, '20160520', '20170220');
insert into contribuinte (cd_campanha, cd_membro, vl_contribuido, dt_inicial, dt_final) VALUES (3, 35, 100.00, '20160520', '20170220');

/* LANCAMENTOS CAMPANHA PARA CADA CONTRIBUINTE */

	-- CONTRIBUINTE 1
	insert into lancamento_campanha (cd_contribuinte, vl_lancamento, dt_pagamento, in_pago)
		VALUES (1, 14.00, '20160520', 'N');
	insert into lancamento_campanha (cd_contribuinte, vl_lancamento, dt_pagamento, in_pago)
		VALUES (1, 14.00, '20160620', 'N');
	insert into lancamento_campanha (cd_contribuinte, vl_lancamento, dt_pagamento, in_pago)
		VALUES (1, 14.00, '20160720', 'N');
	insert into lancamento_campanha (cd_contribuinte, vl_lancamento, dt_pagamento, in_pago)
		VALUES (1, 14.00, '20160820', 'N');
	insert into lancamento_campanha (cd_contribuinte, vl_lancamento, dt_pagamento, in_pago)
		VALUES (1, 14.00, '20160920', 'N');
	insert into lancamento_campanha (cd_contribuinte, vl_lancamento, dt_pagamento, in_pago)
		VALUES (1, 14.00, '20161020', 'N');
	insert into lancamento_campanha (cd_contribuinte, vl_lancamento, dt_pagamento, in_pago)
		VALUES (1, 14.00, '20161120', 'N');
	insert into lancamento_campanha (cd_contribuinte, vl_lancamento, dt_pagamento, in_pago)
		VALUES (1, 14.00, '20161220', 'N');
	insert into lancamento_campanha (cd_contribuinte, vl_lancamento, dt_pagamento, in_pago)
		VALUES (1, 14.00, '20170120', 'N');
	insert into lancamento_campanha (cd_contribuinte, vl_lancamento, dt_pagamento, in_pago)
		VALUES (1, 14.00, '20170220', 'N');

	-- CONTRIBUINTE 2
	insert into lancamento_campanha (cd_contribuinte, vl_lancamento, dt_pagamento, in_pago)
		VALUES (2, 14.00, '20160520', 'N');
	insert into lancamento_campanha (cd_contribuinte, vl_lancamento, dt_pagamento, in_pago)
		VALUES (2, 14.00, '20160620', 'N');
	insert into lancamento_campanha (cd_contribuinte, vl_lancamento, dt_pagamento, in_pago)
		VALUES (2, 14.00, '20160720', 'N');
	insert into lancamento_campanha (cd_contribuinte, vl_lancamento, dt_pagamento, in_pago)
		VALUES (2, 14.00, '20160820', 'N');
	insert into lancamento_campanha (cd_contribuinte, vl_lancamento, dt_pagamento, in_pago)
		VALUES (2, 14.00, '20160920', 'N');
	insert into lancamento_campanha (cd_contribuinte, vl_lancamento, dt_pagamento, in_pago)
		VALUES (2, 14.00, '20161020', 'N');
	insert into lancamento_campanha (cd_contribuinte, vl_lancamento, dt_pagamento, in_pago)
		VALUES (2, 14.00, '20161120', 'N');
	insert into lancamento_campanha (cd_contribuinte, vl_lancamento, dt_pagamento, in_pago)
		VALUES (2, 14.00, '20161220', 'N');
	insert into lancamento_campanha (cd_contribuinte, vl_lancamento, dt_pagamento, in_pago)
		VALUES (2, 14.00, '20170120', 'N');
	insert into lancamento_campanha (cd_contribuinte, vl_lancamento, dt_pagamento, in_pago)
		VALUES (2, 14.00, '20170220', 'N');

	-- CONTRIBUINTE 3
	insert into lancamento_campanha (cd_contribuinte, vl_lancamento, dt_pagamento, in_pago)
		VALUES (3, 14.00, '20160520', 'N');
	insert into lancamento_campanha (cd_contribuinte, vl_lancamento, dt_pagamento, in_pago)
		VALUES (3, 14.00, '20160620', 'N');
	insert into lancamento_campanha (cd_contribuinte, vl_lancamento, dt_pagamento, in_pago)
		VALUES (3, 14.00, '20160720', 'N');
	insert into lancamento_campanha (cd_contribuinte, vl_lancamento, dt_pagamento, in_pago)
		VALUES (3, 14.00, '20160820', 'N');
	insert into lancamento_campanha (cd_contribuinte, vl_lancamento, dt_pagamento, in_pago)
		VALUES (3, 14.00, '20160920', 'N');
	insert into lancamento_campanha (cd_contribuinte, vl_lancamento, dt_pagamento, in_pago)
		VALUES (3, 14.00, '20161020', 'N');
	insert into lancamento_campanha (cd_contribuinte, vl_lancamento, dt_pagamento, in_pago)
		VALUES (3, 14.00, '20161120', 'N');
	insert into lancamento_campanha (cd_contribuinte, vl_lancamento, dt_pagamento, in_pago)
		VALUES (3, 14.00, '20161220', 'N');
	insert into lancamento_campanha (cd_contribuinte, vl_lancamento, dt_pagamento, in_pago)
		VALUES (3, 14.00, '20170120', 'N');
	insert into lancamento_campanha (cd_contribuinte, vl_lancamento, dt_pagamento, in_pago)
		VALUES (3, 14.00, '20170220', 'N');

	-- CONTRIBUINTE 4
	insert into lancamento_campanha (cd_contribuinte, vl_lancamento, dt_pagamento, in_pago)
		VALUES (4, 14.00, '20160520', 'N');
	insert into lancamento_campanha (cd_contribuinte, vl_lancamento, dt_pagamento, in_pago)
		VALUES (4, 14.00, '20160620', 'N');
	insert into lancamento_campanha (cd_contribuinte, vl_lancamento, dt_pagamento, in_pago)
		VALUES (4, 14.00, '20160720', 'N');
	insert into lancamento_campanha (cd_contribuinte, vl_lancamento, dt_pagamento, in_pago)
		VALUES (4, 14.00, '20160820', 'N');
	insert into lancamento_campanha (cd_contribuinte, vl_lancamento, dt_pagamento, in_pago)
		VALUES (4, 14.00, '20160920', 'N');
	insert into lancamento_campanha (cd_contribuinte, vl_lancamento, dt_pagamento, in_pago)
		VALUES (4, 14.00, '20161020', 'N');
	insert into lancamento_campanha (cd_contribuinte, vl_lancamento, dt_pagamento, in_pago)
		VALUES (4, 14.00, '20161120', 'N');
	insert into lancamento_campanha (cd_contribuinte, vl_lancamento, dt_pagamento, in_pago)
		VALUES (4, 14.00, '20161220', 'N');
	insert into lancamento_campanha (cd_contribuinte, vl_lancamento, dt_pagamento, in_pago)
		VALUES (4, 14.00, '20170120', 'N');
	insert into lancamento_campanha (cd_contribuinte, vl_lancamento, dt_pagamento, in_pago)
		VALUES (4, 14.00, '20170220', 'N');

	-- CONTRIBUINTE 5
	insert into lancamento_campanha (cd_contribuinte, vl_lancamento, dt_pagamento, in_pago)
		VALUES (5, 14.00, '20160520', 'N');
	insert into lancamento_campanha (cd_contribuinte, vl_lancamento, dt_pagamento, in_pago)
		VALUES (5, 14.00, '20160620', 'N');
	insert into lancamento_campanha (cd_contribuinte, vl_lancamento, dt_pagamento, in_pago)
		VALUES (5, 14.00, '20160720', 'N');
	insert into lancamento_campanha (cd_contribuinte, vl_lancamento, dt_pagamento, in_pago)
		VALUES (5, 14.00, '20160820', 'N');
	insert into lancamento_campanha (cd_contribuinte, vl_lancamento, dt_pagamento, in_pago)
		VALUES (5, 14.00, '20160920', 'N');
	insert into lancamento_campanha (cd_contribuinte, vl_lancamento, dt_pagamento, in_pago)
		VALUES (5, 14.00, '20161020', 'N');
	insert into lancamento_campanha (cd_contribuinte, vl_lancamento, dt_pagamento, in_pago)
		VALUES (5, 14.00, '20161120', 'N');
	insert into lancamento_campanha (cd_contribuinte, vl_lancamento, dt_pagamento, in_pago)
		VALUES (5, 14.00, '20161220', 'N');
	insert into lancamento_campanha (cd_contribuinte, vl_lancamento, dt_pagamento, in_pago)
		VALUES (5, 14.00, '20170120', 'N');
	insert into lancamento_campanha (cd_contribuinte, vl_lancamento, dt_pagamento, in_pago)
		VALUES (5, 14.00, '20170220', 'N');

	-- CONTRIBUINTE 6
	insert into lancamento_campanha (cd_contribuinte, vl_lancamento, dt_pagamento, in_pago)
		VALUES (6, 14.00, '20160520', 'N');
	insert into lancamento_campanha (cd_contribuinte, vl_lancamento, dt_pagamento, in_pago)
		VALUES (6, 14.00, '20160620', 'N');
	insert into lancamento_campanha (cd_contribuinte, vl_lancamento, dt_pagamento, in_pago)
		VALUES (6, 14.00, '20160720', 'N');
	insert into lancamento_campanha (cd_contribuinte, vl_lancamento, dt_pagamento, in_pago)
		VALUES (6, 14.00, '20160820', 'N');
	insert into lancamento_campanha (cd_contribuinte, vl_lancamento, dt_pagamento, in_pago)
		VALUES (6, 14.00, '20160920', 'N');
	insert into lancamento_campanha (cd_contribuinte, vl_lancamento, dt_pagamento, in_pago)
		VALUES (6, 14.00, '20161020', 'N');
	insert into lancamento_campanha (cd_contribuinte, vl_lancamento, dt_pagamento, in_pago)
		VALUES (6, 14.00, '20161120', 'N');
	insert into lancamento_campanha (cd_contribuinte, vl_lancamento, dt_pagamento, in_pago)
		VALUES (6, 14.00, '20161220', 'N');
	insert into lancamento_campanha (cd_contribuinte, vl_lancamento, dt_pagamento, in_pago)
		VALUES (6, 14.00, '20170120', 'N');
	insert into lancamento_campanha (cd_contribuinte, vl_lancamento, dt_pagamento, in_pago)
		VALUES (6, 14.00, '20170220', 'N');

	-- CONTRIBUINTE 7
	insert into lancamento_campanha (cd_contribuinte, vl_lancamento, dt_pagamento, in_pago)
		VALUES (7, 14.00, '20160520', 'N');
	insert into lancamento_campanha (cd_contribuinte, vl_lancamento, dt_pagamento, in_pago)
		VALUES (7, 14.00, '20160620', 'N');
	insert into lancamento_campanha (cd_contribuinte, vl_lancamento, dt_pagamento, in_pago)
		VALUES (7, 14.00, '20160720', 'N');
	insert into lancamento_campanha (cd_contribuinte, vl_lancamento, dt_pagamento, in_pago)
		VALUES (7, 14.00, '20160820', 'N');
	insert into lancamento_campanha (cd_contribuinte, vl_lancamento, dt_pagamento, in_pago)
		VALUES (7, 14.00, '20160920', 'N');
	insert into lancamento_campanha (cd_contribuinte, vl_lancamento, dt_pagamento, in_pago)
		VALUES (7, 14.00, '20161020', 'N');
	insert into lancamento_campanha (cd_contribuinte, vl_lancamento, dt_pagamento, in_pago)
		VALUES (7, 14.00, '20161120', 'N');
	insert into lancamento_campanha (cd_contribuinte, vl_lancamento, dt_pagamento, in_pago)
		VALUES (7, 14.00, '20161220', 'N');
	insert into lancamento_campanha (cd_contribuinte, vl_lancamento, dt_pagamento, in_pago)
		VALUES (7, 14.00, '20170120', 'N');
	insert into lancamento_campanha (cd_contribuinte, vl_lancamento, dt_pagamento, in_pago)
		VALUES (7, 14.00, '20170220', 'N');

	-- CONTRIBUINTE 8
	insert into lancamento_campanha (cd_contribuinte, vl_lancamento, dt_pagamento, in_pago)
		VALUES (8, 14.00, '20160520', 'N');
	insert into lancamento_campanha (cd_contribuinte, vl_lancamento, dt_pagamento, in_pago)
		VALUES (8, 14.00, '20160620', 'N');
	insert into lancamento_campanha (cd_contribuinte, vl_lancamento, dt_pagamento, in_pago)
		VALUES (8, 14.00, '20160720', 'N');
	insert into lancamento_campanha (cd_contribuinte, vl_lancamento, dt_pagamento, in_pago)
		VALUES (8, 14.00, '20160820', 'N');
	insert into lancamento_campanha (cd_contribuinte, vl_lancamento, dt_pagamento, in_pago)
		VALUES (8, 14.00, '20160920', 'N');
	insert into lancamento_campanha (cd_contribuinte, vl_lancamento, dt_pagamento, in_pago)
		VALUES (8, 14.00, '20161020', 'N');
	insert into lancamento_campanha (cd_contribuinte, vl_lancamento, dt_pagamento, in_pago)
		VALUES (8, 14.00, '20161120', 'N');
	insert into lancamento_campanha (cd_contribuinte, vl_lancamento, dt_pagamento, in_pago)
		VALUES (8, 14.00, '20161220', 'N');
	insert into lancamento_campanha (cd_contribuinte, vl_lancamento, dt_pagamento, in_pago)
		VALUES (8, 14.00, '20170120', 'N');
	insert into lancamento_campanha (cd_contribuinte, vl_lancamento, dt_pagamento, in_pago)
		VALUES (8, 14.00, '20170220', 'N');

	-- CONTRIBUINTE 9
	insert into lancamento_campanha (cd_contribuinte, vl_lancamento, dt_pagamento, in_pago)
		VALUES (9, 14.00, '20160520', 'N');
	insert into lancamento_campanha (cd_contribuinte, vl_lancamento, dt_pagamento, in_pago)
		VALUES (9, 14.00, '20160620', 'N');
	insert into lancamento_campanha (cd_contribuinte, vl_lancamento, dt_pagamento, in_pago)
		VALUES (9, 14.00, '20160720', 'N');
	insert into lancamento_campanha (cd_contribuinte, vl_lancamento, dt_pagamento, in_pago)
		VALUES (9, 14.00, '20160820', 'N');
	insert into lancamento_campanha (cd_contribuinte, vl_lancamento, dt_pagamento, in_pago)
		VALUES (9, 14.00, '20160920', 'N');
	insert into lancamento_campanha (cd_contribuinte, vl_lancamento, dt_pagamento, in_pago)
		VALUES (9, 14.00, '20161020', 'N');
	insert into lancamento_campanha (cd_contribuinte, vl_lancamento, dt_pagamento, in_pago)
		VALUES (9, 14.00, '20161120', 'N');
	insert into lancamento_campanha (cd_contribuinte, vl_lancamento, dt_pagamento, in_pago)
		VALUES (9, 14.00, '20161220', 'N');
	insert into lancamento_campanha (cd_contribuinte, vl_lancamento, dt_pagamento, in_pago)
		VALUES (9, 14.00, '20170120', 'N');
	insert into lancamento_campanha (cd_contribuinte, vl_lancamento, dt_pagamento, in_pago)
		VALUES (9, 14.00, '20170220', 'N');

	-- CONTRIBUINTE 10
	insert into lancamento_campanha (cd_contribuinte, vl_lancamento, dt_pagamento, in_pago)
		VALUES (10, 14.00, '20160520', 'N');
	insert into lancamento_campanha (cd_contribuinte, vl_lancamento, dt_pagamento, in_pago)
		VALUES (10, 14.00, '20160620', 'N');
	insert into lancamento_campanha (cd_contribuinte, vl_lancamento, dt_pagamento, in_pago)
		VALUES (10, 14.00, '20160720', 'N');
	insert into lancamento_campanha (cd_contribuinte, vl_lancamento, dt_pagamento, in_pago)
		VALUES (10, 14.00, '20160820', 'N');
	insert into lancamento_campanha (cd_contribuinte, vl_lancamento, dt_pagamento, in_pago)
		VALUES (10, 14.00, '20160920', 'N');
	insert into lancamento_campanha (cd_contribuinte, vl_lancamento, dt_pagamento, in_pago)
		VALUES (10, 14.00, '20161020', 'N');
	insert into lancamento_campanha (cd_contribuinte, vl_lancamento, dt_pagamento, in_pago)
		VALUES (10, 14.00, '20161120', 'N');
	insert into lancamento_campanha (cd_contribuinte, vl_lancamento, dt_pagamento, in_pago)
		VALUES (10, 14.00, '20161220', 'N');
	insert into lancamento_campanha (cd_contribuinte, vl_lancamento, dt_pagamento, in_pago)
		VALUES (10, 14.00, '20170120', 'N');
	insert into lancamento_campanha (cd_contribuinte, vl_lancamento, dt_pagamento, in_pago)
		VALUES (10, 14.00, '20170220', 'N');
        
        -- CONTRIBUINTE 11
	insert into lancamento_campanha (cd_contribuinte, vl_lancamento, dt_pagamento, in_pago)
		VALUES (11, 20.00, '20160520', 'N');
	insert into lancamento_campanha (cd_contribuinte, vl_lancamento, dt_pagamento, in_pago)
		VALUES (11, 20.00, '20160620', 'N');
	insert into lancamento_campanha (cd_contribuinte, vl_lancamento, dt_pagamento, in_pago)
		VALUES (11, 20.00, '20160720', 'N');
	insert into lancamento_campanha (cd_contribuinte, vl_lancamento, dt_pagamento, in_pago)
		VALUES (11, 20.00, '20160820', 'N');
	insert into lancamento_campanha (cd_contribuinte, vl_lancamento, dt_pagamento, in_pago)
		VALUES (11, 20.00, '20160920', 'N');
	insert into lancamento_campanha (cd_contribuinte, vl_lancamento, dt_pagamento, in_pago)
		VALUES (11, 20.00, '20161020', 'N');
	insert into lancamento_campanha (cd_contribuinte, vl_lancamento, dt_pagamento, in_pago)
		VALUES (11, 20.00, '20161120', 'N');
	insert into lancamento_campanha (cd_contribuinte, vl_lancamento, dt_pagamento, in_pago)
		VALUES (11, 20.00, '20161220', 'N');
	insert into lancamento_campanha (cd_contribuinte, vl_lancamento, dt_pagamento, in_pago)
		VALUES (11, 20.00, '20170120', 'N');
	insert into lancamento_campanha (cd_contribuinte, vl_lancamento, dt_pagamento, in_pago)
		VALUES (11, 20.00, '20170220', 'N');

	-- CONTRIBUINTE 12
	insert into lancamento_campanha (cd_contribuinte, vl_lancamento, dt_pagamento, in_pago)
		VALUES (12, 20.00, '20160520', 'N');
	insert into lancamento_campanha (cd_contribuinte, vl_lancamento, dt_pagamento, in_pago)
		VALUES (12, 20.00, '20160620', 'N');
	insert into lancamento_campanha (cd_contribuinte, vl_lancamento, dt_pagamento, in_pago)
		VALUES (12, 20.00, '20160720', 'N');
	insert into lancamento_campanha (cd_contribuinte, vl_lancamento, dt_pagamento, in_pago)
		VALUES (12, 20.00, '20160820', 'N');
	insert into lancamento_campanha (cd_contribuinte, vl_lancamento, dt_pagamento, in_pago)
		VALUES (12, 20.00, '20160920', 'N');
	insert into lancamento_campanha (cd_contribuinte, vl_lancamento, dt_pagamento, in_pago)
		VALUES (12, 20.00, '20161020', 'N');
	insert into lancamento_campanha (cd_contribuinte, vl_lancamento, dt_pagamento, in_pago)
		VALUES (2, 14.00, '20161120', 'N');
	insert into lancamento_campanha (cd_contribuinte, vl_lancamento, dt_pagamento, in_pago)
		VALUES (12, 20.00, '20161220', 'N');
	insert into lancamento_campanha (cd_contribuinte, vl_lancamento, dt_pagamento, in_pago)
		VALUES (12, 20.00, '20170120', 'N');
	insert into lancamento_campanha (cd_contribuinte, vl_lancamento, dt_pagamento, in_pago)
		VALUES (12, 20.00, '20170220', 'N');

	-- CONTRIBUINTE 13
	insert into lancamento_campanha (cd_contribuinte, vl_lancamento, dt_pagamento, in_pago)
		VALUES (13, 20.00, '20160520', 'N');
	insert into lancamento_campanha (cd_contribuinte, vl_lancamento, dt_pagamento, in_pago)
		VALUES (13, 20.00, '20160620', 'N');
	insert into lancamento_campanha (cd_contribuinte, vl_lancamento, dt_pagamento, in_pago)
		VALUES (13, 20.00, '20160720', 'N');
	insert into lancamento_campanha (cd_contribuinte, vl_lancamento, dt_pagamento, in_pago)
		VALUES (13, 20.00, '20160820', 'N');
	insert into lancamento_campanha (cd_contribuinte, vl_lancamento, dt_pagamento, in_pago)
		VALUES (13, 20.00, '20160920', 'N');
	insert into lancamento_campanha (cd_contribuinte, vl_lancamento, dt_pagamento, in_pago)
		VALUES (13, 20.00, '20161020', 'N');
	insert into lancamento_campanha (cd_contribuinte, vl_lancamento, dt_pagamento, in_pago)
		VALUES (13, 20.00, '20161120', 'N');
	insert into lancamento_campanha (cd_contribuinte, vl_lancamento, dt_pagamento, in_pago)
		VALUES (13, 20.00, '20161220', 'N');
	insert into lancamento_campanha (cd_contribuinte, vl_lancamento, dt_pagamento, in_pago)
		VALUES (13, 20.00, '20170120', 'N');
	insert into lancamento_campanha (cd_contribuinte, vl_lancamento, dt_pagamento, in_pago)
		VALUES (13, 20.00, '20170220', 'N');

	-- CONTRIBUINTE 14
	insert into lancamento_campanha (cd_contribuinte, vl_lancamento, dt_pagamento, in_pago)
		VALUES (14, 20.00, '20160520', 'N');
	insert into lancamento_campanha (cd_contribuinte, vl_lancamento, dt_pagamento, in_pago)
		VALUES (14, 20.00, '20160620', 'N');
	insert into lancamento_campanha (cd_contribuinte, vl_lancamento, dt_pagamento, in_pago)
		VALUES (14, 20.00, '20160720', 'N');
	insert into lancamento_campanha (cd_contribuinte, vl_lancamento, dt_pagamento, in_pago)
		VALUES (14, 20.00, '20160820', 'N');
	insert into lancamento_campanha (cd_contribuinte, vl_lancamento, dt_pagamento, in_pago)
		VALUES (14, 20.00, '20160920', 'N');
	insert into lancamento_campanha (cd_contribuinte, vl_lancamento, dt_pagamento, in_pago)
		VALUES (14, 20.00, '20161020', 'N');
	insert into lancamento_campanha (cd_contribuinte, vl_lancamento, dt_pagamento, in_pago)
		VALUES (14, 20.00, '20161120', 'N');
	insert into lancamento_campanha (cd_contribuinte, vl_lancamento, dt_pagamento, in_pago)
		VALUES (14, 20.00, '20161220', 'N');
	insert into lancamento_campanha (cd_contribuinte, vl_lancamento, dt_pagamento, in_pago)
		VALUES (14, 20.00, '20170120', 'N');
	insert into lancamento_campanha (cd_contribuinte, vl_lancamento, dt_pagamento, in_pago)
		VALUES (14, 20.00, '20170220', 'N');

	-- CONTRIBUINTE 15
	insert into lancamento_campanha (cd_contribuinte, vl_lancamento, dt_pagamento, in_pago)
		VALUES (15, 20.00, '20160520', 'N');
	insert into lancamento_campanha (cd_contribuinte, vl_lancamento, dt_pagamento, in_pago)
		VALUES (15, 20.00, '20160620', 'N');
	insert into lancamento_campanha (cd_contribuinte, vl_lancamento, dt_pagamento, in_pago)
		VALUES (15, 20.00, '20160720', 'N');
	insert into lancamento_campanha (cd_contribuinte, vl_lancamento, dt_pagamento, in_pago)
		VALUES (15, 20.00, '20160820', 'N');
	insert into lancamento_campanha (cd_contribuinte, vl_lancamento, dt_pagamento, in_pago)
		VALUES (15, 20.00, '20160920', 'N');
	insert into lancamento_campanha (cd_contribuinte, vl_lancamento, dt_pagamento, in_pago)
		VALUES (15, 20.00, '20161020', 'N');
	insert into lancamento_campanha (cd_contribuinte, vl_lancamento, dt_pagamento, in_pago)
		VALUES (15, 20.00, '20161120', 'N');
	insert into lancamento_campanha (cd_contribuinte, vl_lancamento, dt_pagamento, in_pago)
		VALUES (15, 20.00, '20161220', 'N');
	insert into lancamento_campanha (cd_contribuinte, vl_lancamento, dt_pagamento, in_pago)
		VALUES (15, 20.00, '20170120', 'N');
	insert into lancamento_campanha (cd_contribuinte, vl_lancamento, dt_pagamento, in_pago)
		VALUES (15, 20.00, '20170220', 'N');

	-- CONTRIBUINTE 16
	insert into lancamento_campanha (cd_contribuinte, vl_lancamento, dt_pagamento, in_pago)
		VALUES (16, 20.00, '20160520', 'N');
	insert into lancamento_campanha (cd_contribuinte, vl_lancamento, dt_pagamento, in_pago)
		VALUES (16, 20.00, '20160620', 'N');
	insert into lancamento_campanha (cd_contribuinte, vl_lancamento, dt_pagamento, in_pago)
		VALUES (16, 20.00, '20160720', 'N');
	insert into lancamento_campanha (cd_contribuinte, vl_lancamento, dt_pagamento, in_pago)
		VALUES (16, 20.00, '20160820', 'N');
	insert into lancamento_campanha (cd_contribuinte, vl_lancamento, dt_pagamento, in_pago)
		VALUES (16, 20.00, '20160920', 'N');
	insert into lancamento_campanha (cd_contribuinte, vl_lancamento, dt_pagamento, in_pago)
		VALUES (16, 20.00, '20161020', 'N');
	insert into lancamento_campanha (cd_contribuinte, vl_lancamento, dt_pagamento, in_pago)
		VALUES (16, 20.00, '20161120', 'N');
	insert into lancamento_campanha (cd_contribuinte, vl_lancamento, dt_pagamento, in_pago)
		VALUES (16, 20.00, '20161220', 'N');
	insert into lancamento_campanha (cd_contribuinte, vl_lancamento, dt_pagamento, in_pago)
		VALUES (16, 20.00, '20170120', 'N');
	insert into lancamento_campanha (cd_contribuinte, vl_lancamento, dt_pagamento, in_pago)
		VALUES (16, 20.00, '20170220', 'N');

	-- CONTRIBUINTE 17
	insert into lancamento_campanha (cd_contribuinte, vl_lancamento, dt_pagamento, in_pago)
		VALUES (17, 20.00, '20160520', 'N');
	insert into lancamento_campanha (cd_contribuinte, vl_lancamento, dt_pagamento, in_pago)
		VALUES (17, 20.00, '20160620', 'N');
	insert into lancamento_campanha (cd_contribuinte, vl_lancamento, dt_pagamento, in_pago)
		VALUES (17, 20.00, '20160720', 'N');
	insert into lancamento_campanha (cd_contribuinte, vl_lancamento, dt_pagamento, in_pago)
		VALUES (17, 20.00, '20160820', 'N');
	insert into lancamento_campanha (cd_contribuinte, vl_lancamento, dt_pagamento, in_pago)
		VALUES (17, 20.00, '20160920', 'N');
	insert into lancamento_campanha (cd_contribuinte, vl_lancamento, dt_pagamento, in_pago)
		VALUES (17, 20.00, '20161020', 'N');
	insert into lancamento_campanha (cd_contribuinte, vl_lancamento, dt_pagamento, in_pago)
		VALUES (17, 14.00, '20161120', 'N');
	insert into lancamento_campanha (cd_contribuinte, vl_lancamento, dt_pagamento, in_pago)
		VALUES (17, 20.00, '20161220', 'N');
	insert into lancamento_campanha (cd_contribuinte, vl_lancamento, dt_pagamento, in_pago)
		VALUES (17, 20.00, '20170120', 'N');
	insert into lancamento_campanha (cd_contribuinte, vl_lancamento, dt_pagamento, in_pago)
		VALUES (17, 20.00, '20170220', 'N');

	-- CONTRIBUINTE 18
	insert into lancamento_campanha (cd_contribuinte, vl_lancamento, dt_pagamento, in_pago)
		VALUES (18, 20.00, '20160520', 'N');
	insert into lancamento_campanha (cd_contribuinte, vl_lancamento, dt_pagamento, in_pago)
		VALUES (18, 20.00, '20160620', 'N');
	insert into lancamento_campanha (cd_contribuinte, vl_lancamento, dt_pagamento, in_pago)
		VALUES (18, 20.00, '20160720', 'N');
	insert into lancamento_campanha (cd_contribuinte, vl_lancamento, dt_pagamento, in_pago)
		VALUES (18, 20.00, '20160820', 'N');
	insert into lancamento_campanha (cd_contribuinte, vl_lancamento, dt_pagamento, in_pago)
		VALUES (18, 20.00, '20160920', 'N');
	insert into lancamento_campanha (cd_contribuinte, vl_lancamento, dt_pagamento, in_pago)
		VALUES (18, 20.00, '20161020', 'N');
	insert into lancamento_campanha (cd_contribuinte, vl_lancamento, dt_pagamento, in_pago)
		VALUES (18, 20.00, '20161120', 'N');
	insert into lancamento_campanha (cd_contribuinte, vl_lancamento, dt_pagamento, in_pago)
		VALUES (18, 20.00, '20161220', 'N');
	insert into lancamento_campanha (cd_contribuinte, vl_lancamento, dt_pagamento, in_pago)
		VALUES (18, 20.00, '20170120', 'N');
	insert into lancamento_campanha (cd_contribuinte, vl_lancamento, dt_pagamento, in_pago)
		VALUES (18, 20.00, '20170220', 'N');

	-- CONTRIBUINTE 19
	insert into lancamento_campanha (cd_contribuinte, vl_lancamento, dt_pagamento, in_pago)
		VALUES (19, 20.00, '20160520', 'N');
	insert into lancamento_campanha (cd_contribuinte, vl_lancamento, dt_pagamento, in_pago)
		VALUES (19, 20.00, '20160620', 'N');
	insert into lancamento_campanha (cd_contribuinte, vl_lancamento, dt_pagamento, in_pago)
		VALUES (19, 20.00, '20160720', 'N');
	insert into lancamento_campanha (cd_contribuinte, vl_lancamento, dt_pagamento, in_pago)
		VALUES (19, 20.00, '20160820', 'N');
	insert into lancamento_campanha (cd_contribuinte, vl_lancamento, dt_pagamento, in_pago)
		VALUES (19, 20.00, '20160920', 'N');
	insert into lancamento_campanha (cd_contribuinte, vl_lancamento, dt_pagamento, in_pago)
		VALUES (19, 20.00, '20161020', 'N');
	insert into lancamento_campanha (cd_contribuinte, vl_lancamento, dt_pagamento, in_pago)
		VALUES (19, 14.00, '20161120', 'N');
	insert into lancamento_campanha (cd_contribuinte, vl_lancamento, dt_pagamento, in_pago)
		VALUES (19, 20.00, '20161220', 'N');
	insert into lancamento_campanha (cd_contribuinte, vl_lancamento, dt_pagamento, in_pago)
		VALUES (19, 20.00, '20170120', 'N');
	insert into lancamento_campanha (cd_contribuinte, vl_lancamento, dt_pagamento, in_pago)
		VALUES (19, 20.00, '20170220', 'N');

	-- CONTRIBUINTE 20
	insert into lancamento_campanha (cd_contribuinte, vl_lancamento, dt_pagamento, in_pago)
		VALUES (20, 20.00, '20160520', 'N');
	insert into lancamento_campanha (cd_contribuinte, vl_lancamento, dt_pagamento, in_pago)
		VALUES (20, 20.00, '20160620', 'N');
	insert into lancamento_campanha (cd_contribuinte, vl_lancamento, dt_pagamento, in_pago)
		VALUES (20, 20.00, '20160720', 'N');
	insert into lancamento_campanha (cd_contribuinte, vl_lancamento, dt_pagamento, in_pago)
		VALUES (20, 20.00, '20160820', 'N');
	insert into lancamento_campanha (cd_contribuinte, vl_lancamento, dt_pagamento, in_pago)
		VALUES (20, 20.00, '20160920', 'N');
	insert into lancamento_campanha (cd_contribuinte, vl_lancamento, dt_pagamento, in_pago)
		VALUES (20, 20.00, '20161020', 'N');
	insert into lancamento_campanha (cd_contribuinte, vl_lancamento, dt_pagamento, in_pago)
		VALUES (20, 20.00, '20161120', 'N');
	insert into lancamento_campanha (cd_contribuinte, vl_lancamento, dt_pagamento, in_pago)
		VALUES (20, 20.00, '20161220', 'N');
	insert into lancamento_campanha (cd_contribuinte, vl_lancamento, dt_pagamento, in_pago)
		VALUES (20, 20.00, '20170120', 'N');
	insert into lancamento_campanha (cd_contribuinte, vl_lancamento, dt_pagamento, in_pago)
		VALUES (20, 20.00, '20170220', 'N');
         -- CONTRIBUINTE 21
	insert into lancamento_campanha (cd_contribuinte, vl_lancamento, dt_pagamento, in_pago)
		VALUES (21, 20.00, '20160520', 'N');
	insert into lancamento_campanha (cd_contribuinte, vl_lancamento, dt_pagamento, in_pago)
		VALUES (21, 20.00, '20160620', 'N');
	insert into lancamento_campanha (cd_contribuinte, vl_lancamento, dt_pagamento, in_pago)
		VALUES (21, 20.00, '20160720', 'N');
	insert into lancamento_campanha (cd_contribuinte, vl_lancamento, dt_pagamento, in_pago)
		VALUES (21, 20.00, '20160820', 'N');
	insert into lancamento_campanha (cd_contribuinte, vl_lancamento, dt_pagamento, in_pago)
		VALUES (21, 20.00, '20160920', 'N');
	

	-- CONTRIBUINTE 22
	insert into lancamento_campanha (cd_contribuinte, vl_lancamento, dt_pagamento, in_pago)
		VALUES (22, 20.00, '20160520', 'N');
	insert into lancamento_campanha (cd_contribuinte, vl_lancamento, dt_pagamento, in_pago)
		VALUES (22, 20.00, '20160620', 'N');
	insert into lancamento_campanha (cd_contribuinte, vl_lancamento, dt_pagamento, in_pago)
		VALUES (22, 20.00, '20160720', 'N');
	insert into lancamento_campanha (cd_contribuinte, vl_lancamento, dt_pagamento, in_pago)
		VALUES (22, 20.00, '20160820', 'N');
	insert into lancamento_campanha (cd_contribuinte, vl_lancamento, dt_pagamento, in_pago)
		VALUES (22, 20.00, '20160920', 'N');
	
	-- CONTRIBUINTE 23
	insert into lancamento_campanha (cd_contribuinte, vl_lancamento, dt_pagamento, in_pago)
		VALUES (23, 20.00, '20160520', 'N');
	insert into lancamento_campanha (cd_contribuinte, vl_lancamento, dt_pagamento, in_pago)
		VALUES (23, 20.00, '20160620', 'N');
	insert into lancamento_campanha (cd_contribuinte, vl_lancamento, dt_pagamento, in_pago)
		VALUES (23, 20.00, '20160720', 'N');
	insert into lancamento_campanha (cd_contribuinte, vl_lancamento, dt_pagamento, in_pago)
		VALUES (23, 20.00, '20160820', 'N');
	insert into lancamento_campanha (cd_contribuinte, vl_lancamento, dt_pagamento, in_pago)
		VALUES (23, 20.00, '20160920', 'N');
	
	-- CONTRIBUINTE 24
	insert into lancamento_campanha (cd_contribuinte, vl_lancamento, dt_pagamento, in_pago)
		VALUES (24, 20.00, '20160520', 'N');
	insert into lancamento_campanha (cd_contribuinte, vl_lancamento, dt_pagamento, in_pago)
		VALUES (24, 20.00, '20160620', 'N');
	insert into lancamento_campanha (cd_contribuinte, vl_lancamento, dt_pagamento, in_pago)
		VALUES (24, 20.00, '20160720', 'N');
	insert into lancamento_campanha (cd_contribuinte, vl_lancamento, dt_pagamento, in_pago)
		VALUES (24, 20.00, '20160820', 'N');
	insert into lancamento_campanha (cd_contribuinte, vl_lancamento, dt_pagamento, in_pago)
		VALUES (24, 20.00, '20160920', 'N');
	

	-- CONTRIBUINTE 25
	insert into lancamento_campanha (cd_contribuinte, vl_lancamento, dt_pagamento, in_pago)
		VALUES (25, 20.00, '20160520', 'N');
	insert into lancamento_campanha (cd_contribuinte, vl_lancamento, dt_pagamento, in_pago)
		VALUES (25, 20.00, '20160620', 'N');
	insert into lancamento_campanha (cd_contribuinte, vl_lancamento, dt_pagamento, in_pago)
		VALUES (25, 20.00, '20160720', 'N');
	insert into lancamento_campanha (cd_contribuinte, vl_lancamento, dt_pagamento, in_pago)
		VALUES (25, 20.00, '20160820', 'N');
	insert into lancamento_campanha (cd_contribuinte, vl_lancamento, dt_pagamento, in_pago)
		VALUES (25, 20.00, '20160920', 'N');
	
	-- CONTRIBUINTE 26
	insert into lancamento_campanha (cd_contribuinte, vl_lancamento, dt_pagamento, in_pago)
		VALUES (26, 20.00, '20160520', 'N');
	insert into lancamento_campanha (cd_contribuinte, vl_lancamento, dt_pagamento, in_pago)
		VALUES (26, 20.00, '20160620', 'N');
	insert into lancamento_campanha (cd_contribuinte, vl_lancamento, dt_pagamento, in_pago)
		VALUES (26, 20.00, '20160720', 'N');
	insert into lancamento_campanha (cd_contribuinte, vl_lancamento, dt_pagamento, in_pago)
		VALUES (26, 20.00, '20160820', 'N');
	insert into lancamento_campanha (cd_contribuinte, vl_lancamento, dt_pagamento, in_pago)
		VALUES (26, 20.00, '20160920', 'N');
	

	-- CONTRIBUINTE 27
	insert into lancamento_campanha (cd_contribuinte, vl_lancamento, dt_pagamento, in_pago)
		VALUES (27, 20.00, '20160520', 'N');
	insert into lancamento_campanha (cd_contribuinte, vl_lancamento, dt_pagamento, in_pago)
		VALUES (27, 20.00, '20160620', 'N');
	insert into lancamento_campanha (cd_contribuinte, vl_lancamento, dt_pagamento, in_pago)
		VALUES (27, 20.00, '20160720', 'N');
	insert into lancamento_campanha (cd_contribuinte, vl_lancamento, dt_pagamento, in_pago)
		VALUES (27, 20.00, '20160820', 'N');
	insert into lancamento_campanha (cd_contribuinte, vl_lancamento, dt_pagamento, in_pago)
		VALUES (27, 20.00, '20160920', 'N');
	

	-- CONTRIBUINTE 28
	insert into lancamento_campanha (cd_contribuinte, vl_lancamento, dt_pagamento, in_pago)
		VALUES (28, 20.00, '20160520', 'N');
	insert into lancamento_campanha (cd_contribuinte, vl_lancamento, dt_pagamento, in_pago)
		VALUES (28, 20.00, '20160620', 'N');
	insert into lancamento_campanha (cd_contribuinte, vl_lancamento, dt_pagamento, in_pago)
		VALUES (28, 20.00, '20160720', 'N');
	insert into lancamento_campanha (cd_contribuinte, vl_lancamento, dt_pagamento, in_pago)
		VALUES (28, 20.00, '20160820', 'N');
	insert into lancamento_campanha (cd_contribuinte, vl_lancamento, dt_pagamento, in_pago)
		VALUES (28, 20.00, '20160920', 'N');
	

	-- CONTRIBUINTE 29
	insert into lancamento_campanha (cd_contribuinte, vl_lancamento, dt_pagamento, in_pago)
		VALUES (29, 20.00, '20160520', 'N');
	insert into lancamento_campanha (cd_contribuinte, vl_lancamento, dt_pagamento, in_pago)
		VALUES (29, 20.00, '20160620', 'N');
	insert into lancamento_campanha (cd_contribuinte, vl_lancamento, dt_pagamento, in_pago)
		VALUES (29, 20.00, '20160720', 'N');
	insert into lancamento_campanha (cd_contribuinte, vl_lancamento, dt_pagamento, in_pago)
		VALUES (29, 20.00, '20160820', 'N');
	insert into lancamento_campanha (cd_contribuinte, vl_lancamento, dt_pagamento, in_pago)
		VALUES (29, 20.00, '20160920', 'N');
	
	-- CONTRIBUINTE 30
	insert into lancamento_campanha (cd_contribuinte, vl_lancamento, dt_pagamento, in_pago)
		VALUES (30, 20.00, '20160520', 'N');
	insert into lancamento_campanha (cd_contribuinte, vl_lancamento, dt_pagamento, in_pago)
		VALUES (30, 20.00, '20160620', 'N');
	insert into lancamento_campanha (cd_contribuinte, vl_lancamento, dt_pagamento, in_pago)
		VALUES (30, 20.00, '20160720', 'N');
	insert into lancamento_campanha (cd_contribuinte, vl_lancamento, dt_pagamento, in_pago)
		VALUES (30, 20.00, '20160820', 'N');
	insert into lancamento_campanha (cd_contribuinte, vl_lancamento, dt_pagamento, in_pago)
		VALUES (30, 20.00, '20160920', 'N');
	
    -- CONTRIBUINTE 31
	insert into lancamento_campanha (cd_contribuinte, vl_lancamento, dt_pagamento, in_pago)
		VALUES (31, 20.00, '20160520', 'N');
	insert into lancamento_campanha (cd_contribuinte, vl_lancamento, dt_pagamento, in_pago)
		VALUES (31, 20.00, '20160620', 'N');
	insert into lancamento_campanha (cd_contribuinte, vl_lancamento, dt_pagamento, in_pago)
		VALUES (31, 20.00, '20160720', 'N');
	insert into lancamento_campanha (cd_contribuinte, vl_lancamento, dt_pagamento, in_pago)
		VALUES (31, 20.00, '20160820', 'N');
	insert into lancamento_campanha (cd_contribuinte, vl_lancamento, dt_pagamento, in_pago)
		VALUES (31, 20.00, '20160920', 'N');
	

	-- CONTRIBUINTE 32
	insert into lancamento_campanha (cd_contribuinte, vl_lancamento, dt_pagamento, in_pago)
		VALUES (32, 20.00, '20160520', 'N');
	insert into lancamento_campanha (cd_contribuinte, vl_lancamento, dt_pagamento, in_pago)
		VALUES (32, 20.00, '20160620', 'N');
	insert into lancamento_campanha (cd_contribuinte, vl_lancamento, dt_pagamento, in_pago)
		VALUES (32, 20.00, '20160720', 'N');
	insert into lancamento_campanha (cd_contribuinte, vl_lancamento, dt_pagamento, in_pago)
		VALUES (32, 20.00, '20160820', 'N');
	insert into lancamento_campanha (cd_contribuinte, vl_lancamento, dt_pagamento, in_pago)
		VALUES (32, 20.00, '20160920', 'N');
	
	-- CONTRIBUINTE 33
	insert into lancamento_campanha (cd_contribuinte, vl_lancamento, dt_pagamento, in_pago)
		VALUES (33, 20.00, '20160520', 'N');
	insert into lancamento_campanha (cd_contribuinte, vl_lancamento, dt_pagamento, in_pago)
		VALUES (33, 20.00, '20160620', 'N');
	insert into lancamento_campanha (cd_contribuinte, vl_lancamento, dt_pagamento, in_pago)
		VALUES (33, 20.00, '20160720', 'N');
	insert into lancamento_campanha (cd_contribuinte, vl_lancamento, dt_pagamento, in_pago)
		VALUES (33, 20.00, '20160820', 'N');
	insert into lancamento_campanha (cd_contribuinte, vl_lancamento, dt_pagamento, in_pago)
		VALUES (23, 20.00, '20160920', 'N');
	
	-- CONTRIBUINTE 34
	insert into lancamento_campanha (cd_contribuinte, vl_lancamento, dt_pagamento, in_pago)
		VALUES (34, 20.00, '20160520', 'N');
	insert into lancamento_campanha (cd_contribuinte, vl_lancamento, dt_pagamento, in_pago)
		VALUES (34, 20.00, '20160620', 'N');
	insert into lancamento_campanha (cd_contribuinte, vl_lancamento, dt_pagamento, in_pago)
		VALUES (34, 20.00, '20160720', 'N');
	insert into lancamento_campanha (cd_contribuinte, vl_lancamento, dt_pagamento, in_pago)
		VALUES (34, 20.00, '20160820', 'N');
	insert into lancamento_campanha (cd_contribuinte, vl_lancamento, dt_pagamento, in_pago)
		VALUES (34, 20.00, '20160920', 'N');

	-- CONTRIBUINTE 35
	insert into lancamento_campanha (cd_contribuinte, vl_lancamento, dt_pagamento, in_pago)
		VALUES (35, 20.00, '20160520', 'N');
	insert into lancamento_campanha (cd_contribuinte, vl_lancamento, dt_pagamento, in_pago)
		VALUES (35, 20.00, '20160620', 'N');
	insert into lancamento_campanha (cd_contribuinte, vl_lancamento, dt_pagamento, in_pago)
		VALUES (35, 20.00, '20160720', 'N');
	insert into lancamento_campanha (cd_contribuinte, vl_lancamento, dt_pagamento, in_pago)
		VALUES (35, 20.00, '20160820', 'N');
	insert into lancamento_campanha (cd_contribuinte, vl_lancamento, dt_pagamento, in_pago)
		VALUES (35, 20.00, '20160920', 'N');

/*
-- LANÇAMENTO    
insert into lancamento (in_tipo_lancamento, in_rec_des, vl_lancamento, dt_alteracao, cd_usuario, cd_membro, in_status, cd_entidade)
	values ('', '', 0.0, '', '', '', 0, '', 0);

/*
-- DIRETORIA
insert into diretoria (cd_responsavel, cd_entidade, dt_inicio, dt_alteracao, cd_usuario) 
	values (1, 1, '11052016', '11052016', '11052016', 'LFRANCISQU');

-- MEMBRO ADMINISTRATIVO
insert into membro_administrativo (cd_membro, cd_funcao, cd_diretoria, dt_ocupacao, dt_alteracao, cd_usuario, dt_desocupacao) 
	values (1, 1, 1, '11052016', '11052016', 'LFRANCISQU', '11052016');

-- AGENDA
insert into agenda (ds_agendamento, ds_tema, ds_local, in_status, cd_tipo_evento, cd_membro_responsavel, in_categoria, dt_alteracao, cd_usuario)
	values ('Aniversário Igreja', 'Black and Withe', 'Igreja Evangélica Batista', 'C', 1, 1, 'U', '11052016', '11052016', 'LFRANCISQU');
*/