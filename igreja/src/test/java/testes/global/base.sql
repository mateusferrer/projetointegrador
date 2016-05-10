DROP TABLE IF EXISTS usuario;
DROP TABLE IF EXISTS lancamento_campanha;
DROP TABLE IF EXISTS campanha;
DROP TABLE IF EXISTS lancamento;
DROP TABLE IF EXISTS agenda;
DROP TABLE IF EXISTS membro_administrativo;
DROP TABLE IF EXISTS diretoria;
DROP TABLE IF EXISTS membro;
DROP TABLE IF EXISTS igreja;
DROP TABLE IF EXISTS tipo_evento;
DROP TABLE IF EXISTS funcao;
DROP TABLE IF EXISTS tipo_membro;

#@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@#
#     BASE DE DADOS DO SISTEMA DE GESTÃO DE IGREJA     #
#@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@#
# Criação tem que seguir ordenção logica de dependencias:

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
	ds_estado VARCHAR(50) NOT NULL,       
	ds_cidade VARCHAR(50) NOT NULL,       
	tx_email VARCHAR(100) NULL,       
	sq_telefone VARCHAR(11) NOT NULL,       
	tp_igreja CHAR(1) NOT NULL,       
	cd_igreja_matriz INT(10) NULL,
	dt_alteracao date NOT NULL,
	nm_usuario_alteracao varchar(10) NOT NULL,
	INDEX (tx_nome_fantasia),
	PRIMARY KEY (cd_igreja),
    FOREIGN KEY (cd_igreja_matriz) REFERENCES igreja (cd_igreja),
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
    sq_cep VARCHAR(8) NOT NULL,
    tx_endereco VARCHAR(150) NULL,
    nr_endereco INT(5) NULL,
    ds_estado VARCHAR(50),
    ds_cidade VARCHAR(50),
    sq_telefone VARCHAR(11) NOT NULL,
    sq_celular VARCHAR(11) NULL,
    in_status CHAR(1) NOT NULL,
    tx_motivo VARCHAR(100) NULL,
    dt_alteracao date NOT NULL,
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
  dt_alteracao date NOT NULL,
  nm_usuario_alteracao varchar(10) NOT NULL,
  PRIMARY KEY (cd_diretoria),
  FOREIGN KEY fk_cd_membro_responsavel (cd_responsavel) references membro (cd_membro),
  FOREIGN KEY fk_cd_igreja_responsavel (cd_igreja) references igreja (cd_igreja)
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
  FOREIGN KEY fk_cd_membro_adm (cd_membro) references membro (cd_membro),
  FOREIGN KEY fk_cd_funcao_adm (cd_funcao) references funcao (cd_funcao)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE agenda (
  cd_agenda int(10) NOT NULL AUTO_INCREMENT,
  ds_agendamento varchar(50) NOT NULL,
  ds_tema varchar(30) NOT NULL,
  ds_local varchar(100) NOT NULL,
  in_status char(1) NOT NULL,
  cd_tipo_evento int(10) NULL,
  in_tipo char(1) NOT NULL,
  cd_membro_responsavel int(10) NULL,
  tx_observacao varchar(250) NULL,
  in_categoria char(1) NULL,
  dt_alteracao date NOT NULL,
  nm_usuario_alteracao varchar(10) NOT NULL,
  dt_agenda_unico date NULL,
  hr_inicio time NULL,
  hr_termino time NULL,
  nr_tempo int(2) NULL,
  in_dia_semana char(2) NULL,
  nr_dia_mes int(2) NULL,
  INDEX (ds_agendamento),
  PRIMARY KEY (cd_agenda),
  FOREIGN KEY fk_cd_tipo_evento (cd_tipo_evento) references tipo_evento (cd_tipo)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE lancamento (
  cd_lancamento int(10) NOT NULL AUTO_INCREMENT,
  in_tipo_lancamento char(1) NOT NULL,
  in_rec_des char(2) NOT NULL,
  vl_lancamento decimal(10,2) NOT NULL,
  dt_alteracao date NOT NULL,
  nm_usuario_alteracao varchar(10) NOT NULL,
  cd_membro int(10) NULL,
  tx_observacao varchar(250),
  in_status char(1) NOT NULL,
  cd_igreja int(10) NOT NULL,
  PRIMARY KEY (cd_lancamento),
  FOREIGN KEY fk_cd_membro_lancamento (cd_membro) references membro (cd_membro),
  FOREIGN KEY fk_cd_igreja_lancamento (cd_igreja) references igreja (cd_igreja)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE campanha (
  cd_campanha int(10) NOT NULL AUTO_INCREMENT,
  ds_campanha char(1) NOT NULL,
  vl_total decimal(10,2) NOT NULL,
  nr_parcelas int(2) NOT NULL,
  dt_alteracao date NOT NULL,
  nm_usuario_alteracao varchar(10) NOT NULL,
  dt_inicio date NOT NULL,
  dt_final date NOT NULL,
  in_status char(2) NOT NULL,
  cd_igreja int(10) NOT NULL,
  INDEX (ds_campanha),
  PRIMARY KEY (cd_campanha),
  FOREIGN KEY fk_cd_igreja_campanha (cd_igreja) references igreja (cd_igreja)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE lancamento_campanha (
  cd_lanc_camp int(10) NOT NULL AUTO_INCREMENT,
  cd_campanha int(10) NOT NULL,
  cd_membro int(10) NOT NULL,
  nr_parcela int(2) NOT NULL,
  in_pago char(1) NOT NULL,
  dt_alteracao date NOT NULL,
  nm_usuario_alteracao varchar(10) NOT NULL,
  cd_receita int(10) NULL,
  PRIMARY KEY (cd_lanc_camp),
  FOREIGN KEY fk_cd_campanha_lanc_camp (cd_campanha) references campanha (cd_campanha),
  FOREIGN KEY fk_cd_membro_lanc_camp (cd_membro) references membro (cd_membro),
  FOREIGN KEY fk_cd_receita_lanc_campanha (cd_receita) references lancamento (cd_lancamento)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;
		
CREATE TABLE usuario (
  nm_usuario varchar(10) NOT NULL,
  ds_senha varchar(50) NOT NULL,
  in_tipo_usuario char(2) NOT NULL,
  in_situacao char(1) NOT NULL,
  PRIMARY KEY (nm_usuario, ds_senha)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

insert into usuario values ('LFRANCIS', md5('1234'), 'MS', 'A');

select * from usuario;