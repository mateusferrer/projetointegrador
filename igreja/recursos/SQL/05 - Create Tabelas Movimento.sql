CREATE TABLE movimento (
	cd_movimento int(10) not null auto_increment,
	in_tipo_movimento char(1) not null, -- R - Receita / D - Despesa
	vl_movimento decimal(10,2) not null,
	dt_movimento date not null,
	in_estorno char(1) not null, -- S - Sim / N - Não
	cd_igreja int(10) not null,
	dt_inclusao datetime not null,
	dt_alteracao datetime not null,
	nm_usuario_inc_alt varchar(10) not null,
	PRIMARY KEY (cd_movimento),
	FOREIGN KEY (cd_igreja) references igreja (cd_igreja)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE movimento_receita (
	cd_movimento int(10) not null,
	in_tipo_receita char(1) not null, -- C - Campanha / Etc.
	cd_membro int(10) null,
	tx_observacao varchar(250) null,
	cd_contribuinte int null,
    PRIMARY KEY (cd_movimento),
	FOREIGN KEY (cd_movimento) references movimento (cd_movimento),
    FOREIGN KEY (cd_membro) references membro (cd_membro),
    FOREIGN KEY (cd_contribuinte) references contribuinte (cd_contribuinte)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE movimento_despesa (
	cd_movimento int(10) not null,
	in_tipo_despesa char(1) not null,
	tx_observacao varchar(250),
    PRIMARY KEY (cd_movimento),
	FOREIGN KEY (cd_movimento) references movimento (cd_movimento)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;