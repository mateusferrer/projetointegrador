DROP TABLE IF EXISTS contribuinte_campanha;
DROP TABLE IF EXISTS campanha;
DROP TABLE IF EXISTS lancamento;
DROP TABLE IF EXISTS agenda;
DROP TABLE IF EXISTS membro_administrativo;
DROP TABLE IF EXISTS diretoria;
DROP TABLE IF EXISTS membro;
DROP TABLE IF EXISTS usuario;
DROP TABLE IF EXISTS igreja;
DROP TABLE IF EXISTS tipo_evento;
DROP TABLE IF EXISTS funcao;
DROP TABLE IF EXISTS tipo_membro;
DROP TABLE IF EXISTS cidade;
DROP TABLE IF EXISTS estado;

#@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@#
#     BASE DE DADOS DO SISTEMA DE GESTÃO DE IGREJA     #
#@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@#
# Criação tem que seguir ordenção logica de dependencias:

CREATE TABLE estado (
    cd_estado int NOT NULL,
    in_estado char(2) NOT NULL,
    nm_estado varchar(50) NOT NULL,
    PRIMARY KEY (cd_estado)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE cidade (
    cd_cidade int NOT NULL,
    cd_estado int NOT NULL,
    nm_cidade varchar(50) NOT NULL,
    PRIMARY KEY (cd_cidade),
    FOREIGN KEY (cd_estado) REFERENCES estado (cd_estado)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE tipo_membro (
  cd_tipo int(10) not null auto_increment,
  ds_tipo_membro varchar(50) NOT NULL,
  INDEX (ds_tipo_membro),
  PRIMARY KEY (cd_tipo),
  UNIQUE KEY uq_descricao_tipo_membro (ds_tipo_membro)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE funcao (
  cd_funcao int(10) not null auto_increment,
  ds_funcao varchar(50) NOT NULL,
  INDEX (ds_funcao),
  PRIMARY KEY (cd_funcao),
  UNIQUE KEY uq_descricao_cargo_administrativo (ds_funcao)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE tipo_evento (
  cd_tipo int(10) not null auto_increment,
  ds_tipo_evento varchar(50) NOT NULL,
  INDEX (ds_tipo_evento),
  PRIMARY KEY (cd_tipo),
  UNIQUE KEY uq_descricao_tipo_evento (ds_tipo_evento)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE igreja (
	cd_igreja INT(10) NOT NULL AUTO_INCREMENT,  
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
	tp_igreja CHAR(1) NOT NULL,       
	cd_igreja_matriz int(10) NULL,
    dt_cadastro datetime NOT NULL,
	dt_alteracao datetime NOT NULL,
	nm_usuario_alteracao varchar(10) NOT NULL,
	INDEX (tx_nome_fantasia),
	PRIMARY KEY (cd_igreja),
    FOREIGN KEY (cd_igreja_matriz) REFERENCES igreja (cd_igreja),
    FOREIGN KEY (cd_estado) REFERENCES estado (cd_estado),
    FOREIGN KEY (cd_cidade) REFERENCES cidade (cd_cidade),
	UNIQUE KEY cd_igreja (cd_igreja)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE membro (
    cd_membro INT(10) NOT NULL AUTO_INCREMENT,
    nm_membro VARCHAR(100) NOT NULL,
    sq_rg VARCHAR(10) NULL,
    sq_cpf VARCHAR(11) NOT NULL,
    dt_nascimento DATE NOT NULL,
    in_sexo CHAR(1) NOT NULL,
    tx_email VARCHAR(100) NULL,
    tx_endereco VARCHAR(150) NOT NULL,
    nr_endereco INT(5) NOT NULL,
    sq_cep VARCHAR(8) NOT NULL,
    cd_estado int(10) NOT NULL,
    cd_cidade int(10) NOT NULL,
    sq_telefone VARCHAR(11) NOT NULL,
    sq_celular VARCHAR(11) NULL,
    in_status CHAR(1) NOT NULL,
    tx_motivo VARCHAR(100) NULL,
    dt_cadastro datetime NOT NULL,
    dt_alteracao datetime NOT NULL,
	nm_usuario_alteracao varchar(10) NOT NULL,
    in_batizado CHAR(1) NOT NULL,
    dt_batismo DATE NULL,
    nr_registro_batismo INT(10) NULL,
    cd_igreja INT(10) NOT NULL,
    cd_tipo INT(10) NOT NULL,
    INDEX (nm_membro),
    PRIMARY KEY (cd_membro),
    FOREIGN KEY (cd_igreja) REFERENCES igreja (cd_igreja),
    FOREIGN KEY (cd_tipo) REFERENCES tipo_membro (cd_tipo),
    UNIQUE KEY uq_membro_rg (sq_rg),
    UNIQUE KEY uq_membro_cpf (sq_cpf),
    UNIQUE KEY uq_membro_nr_registro_batismo (nr_registro_batismo)
)  ENGINE=INNODB DEFAULT CHARSET=UTF8;

CREATE TABLE diretoria (
  cd_diretoria int(10) NOT NULL AUTO_INCREMENT,
  cd_responsavel int(10) NOT NULL,
  cd_igreja int(10) NOT NULL,
  dt_inicio datetime NOT NULL,
  dt_cadastro datetime NOT NULL,
  dt_alteracao datetime NOT NULL,
  nm_usuario_alteracao varchar(10) NOT NULL,
  PRIMARY KEY (cd_diretoria),
  FOREIGN KEY (cd_responsavel) references membro (cd_membro),
  FOREIGN KEY (cd_igreja) references igreja (cd_igreja)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE membro_administrativo (
  cd_membro_adm int(10) NOT NULL AUTO_INCREMENT,
  cd_membro int(10) NOT NULL,
  cd_funcao int(10) NOT NULL,
  cd_diretoria int(10),
  dt_ocupacao date NOT NULL,
  dt_alteracao date NOT NULL,
  nm_usuario_alteracao varchar(10) NOT NULL,
  dt_desocupacao date NULL,
  PRIMARY KEY (cd_membro_adm),
  FOREIGN KEY (cd_membro) references membro (cd_membro),
  FOREIGN KEY (cd_funcao) references funcao (cd_funcao)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE agenda (
  cd_agenda int(10) NOT NULL AUTO_INCREMENT,
  ds_agendamento varchar(50) NOT NULL,
  ds_tema varchar(30) NOT NULL,
  ds_local varchar(100) NOT NULL,
  in_status char(1) NOT NULL,
  cd_tipo_evento int(10) NULL,
  in_categoria char(1) NOT NULL,
  cd_membro_responsavel int(10) NULL,
  tx_observacao varchar(250) NULL,
  dt_cadastro datetime NOT NULL,
  dt_alteracao datetime NOT NULL,
  nm_usuario_alteracao varchar(10) NOT NULL,
  dt_agenda_unico date NULL,
  hr_inicio time NULL,
  hr_termino time NULL,
  nr_tempo int(2) NULL,
  in_dia_semana char(2) NULL,
  nr_dia_mes int(2) NULL,
  INDEX (ds_agendamento),
  PRIMARY KEY (cd_agenda),
  FOREIGN KEY (cd_tipo_evento) references tipo_evento (cd_tipo)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE campanha (
  cd_campanha int(10) NOT NULL AUTO_INCREMENT,
  ds_campanha char(50) NOT NULL,
  vl_total decimal(10,2) NOT NULL,
  nr_parcelas int(10) NOT NULL,
  dt_inicial date NOT NULL,
  dt_final date NOT NULL,
  in_status char(2) NOT NULL,
  cd_igreja int(10) NOT NULL,
  dt_cadastro datetime NOT NULL,
  dt_alteracao datetime NOT NULL,
  nm_usuario_alteracao varchar(10) NOT NULL,
  INDEX (ds_campanha),
  PRIMARY KEY (cd_campanha),
  FOREIGN KEY (cd_igreja) references igreja (cd_igreja)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE contribuinte (
  cd_contribuinte int(10) NOT NULL AUTO_INCREMENT,
  cd_campanha int(10) NOT NULL,
  cd_membro int(10) NOT NULL,
  vl_contribuido decimal(10,2) NOT NULL, -- Valor total a ser contribuido pelo contribuinte.
  dt_inicial date NOT NULL,
  dt_final date NOT NULL,
  dt_cadastro datetime NOT NULL,
  dt_alteracao datetime NOT NULL,
  nm_usuario_alteracao varchar(10) NOT NULL,
  PRIMARY KEY (cd_contribuinte),
  FOREIGN KEY (cd_campanha) references campanha (cd_campanha),
  FOREIGN KEY (cd_membro) references membro (cd_membro)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE lancamento (
  cd_lancamento int(10) NOT NULL AUTO_INCREMENT,
  in_tipo_lancamento char(1) NOT NULL, -- Se lançamento = Campanha, então cd_membro obrigatório.
  in_rec_des char(2) NOT NULL,
  vl_lancamento decimal(10,2) NOT NULL,
  dt_cadastro datetime NOT NULL,
  dt_alteracao datetime NOT NULL,
  dt_pgto_campanha date NULL, -- Se lançamento = campanha, então dt_pgto_campanha obrigatório.
  nm_usuario_alteracao varchar(10) NOT NULL,
  cd_membro int(10) NULL,
  tx_observacao varchar(250),
  in_status char(1) NOT NULL,
  in_pago char(1) NOT NULL, -- Será sempre 'S', exceto quando o tipo for campanha, que dessa forma, poderá ser alterado.
  cd_igreja int(10) NOT NULL,
  PRIMARY KEY (cd_lancamento),
  FOREIGN KEY (cd_membro) references membro (cd_membro),
  FOREIGN KEY (cd_igreja) references igreja (cd_igreja)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE usuario (
  nm_usuario varchar(10) NOT NULL,
  ds_senha varchar(50) NOT NULL,
  in_tipo_usuario char(2) NOT NULL,
  in_situacao char(1) NOT NULL,
  cd_diretoria int(10) NOT NULL,
  PRIMARY KEY (nm_usuario, ds_senha),
  FOREIGN KEY (cd_diretoria) references diretoria (cd_diretoria)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;