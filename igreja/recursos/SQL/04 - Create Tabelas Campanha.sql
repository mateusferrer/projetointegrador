CREATE TABLE campanha (
	cd_campanha int(10) NOT NULL AUTO_INCREMENT,
	ds_campanha char(50) NOT NULL,
	vl_campanha decimal(10,2) NOT NULL,
	nr_parcelas int(10) NOT NULL,
	dt_inicial date NOT NULL,
	dt_final date NOT NULL,
	in_status char(2) NOT NULL,
	cd_igreja int(10) NOT NULL,
	dt_inclusao datetime NOT NULL,
	dt_alteracao datetime NOT NULL,
	nm_usuario_inc_alt varchar(10) NOT NULL,
	INDEX (ds_campanha),
	PRIMARY KEY (cd_campanha),
	FOREIGN KEY (cd_igreja) references igreja (cd_igreja)
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
	nm_usuario_inc_alt varchar(10) not null,
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