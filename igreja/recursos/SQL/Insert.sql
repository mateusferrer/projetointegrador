-- USUARIO
insert into usuario (cd_usuario, ds_senha, in_tipo_usuario, in_situacao)
	VALUES ('LFRANCISQU', '123', 'M', 'A');

-- TIPO MEMBRO
insert into tipo_membro (ds_tipo_membro, cd_usuario) 
	values ('Pastor', 'LFRANCISQU');
insert into tipo_membro (ds_tipo_membro, cd_usuario) 
	values ('Comum', 'LFRANCISQU');

-- FUNÇÃO
insert into funcao (ds_funcao, cd_usuario) 
	values ('Tesoureiro(a)', 'LFRANCISQU');
insert into funcao (ds_funcao, cd_usuario) 
	values ('Secretário(a)', 'LFRANCISQU');

-- TIPO EVENTO
insert into tipo_evento (ds_tipo_evento , cd_usuario) 
	values ('Culto', 'LFRANCISQU');

-- IGREJA
insert into entidade (tx_razao_social, tx_nome_fantasia, sq_cnpj, sq_cep, tx_endereco, nr_endereco, in_estado, nm_cidade, sq_telefone, tp_entidade, dt_alteracao, cd_usuario) 
	values ('Lucas Costa Francisquini', 'Igreja Evangélica Batista', '86212661000104', '86010150', 'Av. Rio de Janeiro', 1558, 'PR', 'Londrina', '4332941866', 'M', '20160518', 'LFRANCISQU');

-- MEMBRO
insert into membro (nm_membro, sq_cpf, dt_nascimento, in_sexo, tx_endereco, nr_endereco, sq_cep, in_estado, nm_cidade, sq_telefone, in_status, dt_alteracao, cd_usuario, in_batizado, cd_entidade, cd_tipo) 
	values ('Lucas Costa Francisquini', '06459478902', '19940525', 'M', 'R. Capitão Ferreira Gomes', 87, '86070030', 'PR', 'Londrina', '4333510548', 'A', '20160518', 'LFRANCISQU', 'N', 1, 1);
insert into membro (nm_membro, sq_cpf, dt_nascimento, in_sexo, tx_endereco, nr_endereco, sq_cep, in_estado, nm_cidade, sq_telefone, in_status, dt_alteracao, cd_usuario, in_batizado, cd_entidade, cd_tipo) 
	values ('Rosely Macedo Francisquini', '44981012861', '19940525', 'F', 'R. Capitão Ferreira Gomes', 87, '86070030', 'PR', 'Londrina', '4333510548', 'A', '20160518', 'LFRANCISQU', 'N', 1, 1);
insert into membro (nm_membro, sq_cpf, dt_nascimento, in_sexo, tx_endereco, nr_endereco, sq_cep, in_estado, nm_cidade, sq_telefone, in_status, dt_alteracao, cd_usuario, in_batizado, cd_entidade, cd_tipo) 
	values ('Luiz Marcos Francisquini', '28933974849', '19940525', 'M', 'R. Capitão Ferreira Gomes', 87, '86070030', 'PR', 'Londrina', '4333510548', 'A', '20160518', 'LFRANCISQU', 'N', 1, 2);
insert into membro (nm_membro, sq_cpf, dt_nascimento, in_sexo, tx_endereco, nr_endereco, sq_cep, in_estado, nm_cidade, sq_telefone, in_status, dt_alteracao, cd_usuario, in_batizado, cd_entidade, cd_tipo) 
	values ('Matheus Costa Francisquini', '42449735593', '19940525', 'M', 'R. Capitão Ferreira Gomes', 87, '86070030', 'PR', 'Londrina', '4333510548', 'A', '20160518', 'LFRANCISQU', 'N', 1, 2);
insert into membro (nm_membro, sq_cpf, dt_nascimento, in_sexo, tx_endereco, nr_endereco, sq_cep, in_estado, nm_cidade, sq_telefone, in_status, dt_alteracao, cd_usuario, in_batizado, cd_entidade, cd_tipo) 
	values ('Ana Carolina dos Santos Lopes', '68771195416', '19940525', 'M', 'R. Capitão Ferreira Gomes', 87, '86070030', 'PR', 'Londrina', '4333510548', 'A', '20160518', 'LFRANCISQU', 'N', 1, 2);
insert into membro (nm_membro, sq_cpf, dt_nascimento, in_sexo, tx_endereco, nr_endereco, sq_cep, in_estado, nm_cidade, sq_telefone, in_status, dt_alteracao, cd_usuario, in_batizado, cd_entidade, cd_tipo) 
	values ('Wagner Soares', '80739102761', '19940525', 'M', 'R. Capitão Ferreira Gomes', 87, '86070030', 'PR', 'Londrina', '4333510548', 'A', '20160518', 'LFRANCISQU', 'N', 1, 2);
insert into membro (nm_membro, sq_cpf, dt_nascimento, in_sexo, tx_endereco, nr_endereco, sq_cep, in_estado, nm_cidade, sq_telefone, in_status, dt_alteracao, cd_usuario, in_batizado, cd_entidade, cd_tipo) 
	values ('Thiago dos Santos de Jesus', '76941895926', '19940525', 'M', 'R. Capitão Ferreira Gomes', 87, '86070030', 'PR', 'Londrina', '4333510548', 'A', '20160518', 'LFRANCISQU', 'N', 1, 2);
insert into membro (nm_membro, sq_cpf, dt_nascimento, in_sexo, tx_endereco, nr_endereco, sq_cep, in_estado, nm_cidade, sq_telefone, in_status, dt_alteracao, cd_usuario, in_batizado, cd_entidade, cd_tipo) 
	values ('Marina dos Santos Rocha', '35536160168', '19940525', 'M', 'R. Capitão Ferreira Gomes', 87, '86070030', 'PR', 'Londrina', '4333510548', 'A', '20160518', 'LFRANCISQU', 'N', 1, 2);
insert into membro (nm_membro, sq_cpf, dt_nascimento, in_sexo, tx_endereco, nr_endereco, sq_cep, in_estado, nm_cidade, sq_telefone, in_status, dt_alteracao, cd_usuario, in_batizado, cd_entidade, cd_tipo) 
	values ('Mateus Ferrer Corso', '89675112727', '19940525', 'M', 'R. Capitão Ferreira Gomes', 87, '86070030', 'PR', 'Londrina', '4333510548', 'A', '20160518', 'LFRANCISQU', 'N', 1, 2);
insert into membro (nm_membro, sq_cpf, dt_nascimento, in_sexo, tx_endereco, nr_endereco, sq_cep, in_estado, nm_cidade, sq_telefone, in_status, dt_alteracao, cd_usuario, in_batizado, cd_entidade, cd_tipo) 
	values ('Thiago Constante de Souza', '84453590709', '19940525', 'M', 'R. Capitão Ferreira Gomes', 87, '86070030', 'PR', 'Londrina', '4333510548', 'A', '20160518', 'LFRANCISQU', 'N', 1, 2);

-- CAMPANHA
insert into campanha (ds_campanha, vl_campanha, nr_parcelas, cd_usuario, dt_inicial, dt_final, in_status, cd_entidade)
	values ('Aquisição Ar Condicionado', 1400.00, 10, 'LFRANCISQU', '20160520', '20160220', 'AB', 1);

-- CONTRIBUINTE
insert into contribuinte (cd_campanha, cd_membro, vl_contribuido, dt_inicial, dt_final) VALUES (1, 1, 140.00, '20160520', '20160220');
insert into contribuinte (cd_campanha, cd_membro, vl_contribuido, dt_inicial, dt_final) VALUES (1, 2, 140.00, '20160520', '20160220');
insert into contribuinte (cd_campanha, cd_membro, vl_contribuido, dt_inicial, dt_final) VALUES (1, 3, 140.00, '20160520', '20160220');
insert into contribuinte (cd_campanha, cd_membro, vl_contribuido, dt_inicial, dt_final) VALUES (1, 4, 140.00, '20160520', '20160220');
insert into contribuinte (cd_campanha, cd_membro, vl_contribuido, dt_inicial, dt_final) VALUES (1, 5, 140.00, '20160520', '20160220');
insert into contribuinte (cd_campanha, cd_membro, vl_contribuido, dt_inicial, dt_final) VALUES (1, 6, 140.00, '20160520', '20160220');
insert into contribuinte (cd_campanha, cd_membro, vl_contribuido, dt_inicial, dt_final) VALUES (1, 7, 140.00, '20160520', '20160220');
insert into contribuinte (cd_campanha, cd_membro, vl_contribuido, dt_inicial, dt_final) VALUES (1, 8, 140.00, '20160520', '20160220');
insert into contribuinte (cd_campanha, cd_membro, vl_contribuido, dt_inicial, dt_final) VALUES (1, 9, 140.00, '20160520', '20160220');
insert into contribuinte (cd_campanha, cd_membro, vl_contribuido, dt_inicial, dt_final) VALUES (1, 10, 140.00, '20160520', '20160220');

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