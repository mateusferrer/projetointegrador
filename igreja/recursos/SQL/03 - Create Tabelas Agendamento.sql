CREATE TABLE agendamento (
	cd_agendamento int(10) NOT NULL AUTO_INCREMENT,
	ds_agendamento varchar(50) NOT NULL,
	ds_tema varchar(30) NOT NULL,
	ds_local varchar(100) NOT NULL,
	in_status char(1) NOT NULL,
	cd_tipo_evento int(10) NULL,
	in_categoria char(1) NOT NULL,
	cd_membro_responsavel int(10) NULL,
	tx_observacao varchar(250) NULL,
	dt_agenda_unico date NULL,
	hr_inicio time NULL,
	hr_termino time NULL,
	nr_tempo int(2) NULL,
	in_dia_semana char(2) NULL,
	nr_dia_mes int(2) NULL,
	dt_inclusao datetime NOT NULL,
	dt_alteracao datetime NOT NULL,
	nm_usuario_inc_alt varchar(10) NOT NULL,
	INDEX (ds_agendamento),
	PRIMARY KEY (cd_agendamento),
	FOREIGN KEY (cd_tipo_evento) references tipo_evento (cd_tipo)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE agenda_evento (
	cd_agenda int(10) NOT NULL AUTO_INCREMENT
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE agenda_reuniao (
	cd_agenda int(10) NOT NULL AUTO_INCREMENT
)ENGINE=InnoDB DEFAULT CHARSET=utf8;