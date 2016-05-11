-- TIPO MEMBRO
insert into tipo_membro (ds_tipo_membro) 
	values ('Pastor');
insert into tipo_membro (ds_tipo_membro) 
	values ('Presbítero');
insert into tipo_membro (ds_tipo_membro) 
	values ('Diácono');
insert into tipo_membro (ds_tipo_membro) 
	values ('Bispo');

-- FUNÇÃO
insert into funcao (ds_funcao) 
	values ('Tesoureiro(a)');
insert into funcao (ds_funcao) 
	values ('Secretário(a)');

-- TIPO EVENTO
insert into tipo_evento (ds_tipo_evento) 
	values ('Culto');

-- IGREJA
insert into igreja (tx_razao_social, tx_nome_fantasia, sq_cnpj, sq_cep, tx_endereco, nr_endereco, cd_estado, cd_cidade, sq_telefone, tp_igreja, dt_cadastro, dt_alteracao, nm_usuario_alteracao) 
	values ('Lucas Costa Francisquini', 'Igreja Evangélica Batista', '86212661000104', '86010150', 'Av. Rio de Janeiro', 1558, 16, 2951, '4332941866', 'M', '11052016', '11052016', 'LFRANCISQU');

-- MEMBRO
insert into membro (nm_membro, sq_cpf, dt_nascimento, in_sexo, tx_endereco, nr_endereco, sq_cep, cd_estado, cd_cidade, sq_telefone, in_status, dt_cadastro, dt_alteracao, nm_usuario_alteracao, in_batizado, cd_igreja, cd_tipo) 
	values ('Lucas Costa Francisquini', '06459478902', '25051994', 'M', 'R. Capitão Ferreira Gomes', 87, '86070030', 16, 2951, '4333510548', 'A', '11052016', '11052016', 'LFRANCISQU', 'N', 1, 1);
insert into membro (nm_membro, sq_cpf, dt_nascimento, in_sexo, tx_endereco, nr_endereco, sq_cep, cd_estado, cd_cidade, sq_telefone, in_status, dt_cadastro, dt_alteracao, nm_usuario_alteracao, in_batizado, cd_igreja, cd_tipo) 
	values ('Rosely Macedo Francisquini', '44981012861', '25051994', 'F', 'R. Capitão Ferreira Gomes', 87, '86070030', 16, 2951, '4333510548', 'A', '11052016', '11052016', 'LFRANCISQU', 'N', 1, 1);
insert into membro (nm_membro, sq_cpf, dt_nascimento, in_sexo, tx_endereco, nr_endereco, sq_cep, cd_estado, cd_cidade, sq_telefone, in_status, dt_cadastro, dt_alteracao, nm_usuario_alteracao, in_batizado, cd_igreja, cd_tipo) 
	values ('Luiz Marcos Francisquini', '28933974849', '25051994', 'M', 'R. Capitão Ferreira Gomes', 87, '86070030', 16, 2951, '4333510548', 'A', '11052016', '11052016', 'LFRANCISQU', 'N', 1, 1);
insert into membro (nm_membro, sq_cpf, dt_nascimento, in_sexo, tx_endereco, nr_endereco, sq_cep, cd_estado, cd_cidade, sq_telefone, in_status, dt_cadastro, dt_alteracao, nm_usuario_alteracao, in_batizado, cd_igreja, cd_tipo) 
	values ('Matheus Costa Francisquini', '42449735593', '25051994', 'M', 'R. Capitão Ferreira Gomes', 87, '86070030', 16, 2951, '4333510548', 'A', '11052016', '11052016', 'LFRANCISQU', 'N', 1, 1);
insert into membro (nm_membro, sq_cpf, dt_nascimento, in_sexo, tx_endereco, nr_endereco, sq_cep, cd_estado, cd_cidade, sq_telefone, in_status, dt_cadastro, dt_alteracao, nm_usuario_alteracao, in_batizado, cd_igreja, cd_tipo) 
	values ('Ana Carolina dos Santos Lopes', '68771195416', '25051994', 'M', 'R. Capitão Ferreira Gomes', 87, '86070030', 16, 2951, '4333510548', 'A', '11052016', '11052016', 'LFRANCISQU', 'N', 1, 1);
insert into membro (nm_membro, sq_cpf, dt_nascimento, in_sexo, tx_endereco, nr_endereco, sq_cep, cd_estado, cd_cidade, sq_telefone, in_status, dt_cadastro, dt_alteracao, nm_usuario_alteracao, in_batizado, cd_igreja, cd_tipo) 
	values ('Wagner Soares', '06459478902', '80739102761', 'M', 'R. Capitão Ferreira Gomes', 87, '86070030', 16, 2951, '4333510548', 'A', '11052016', '11052016', 'LFRANCISQU', 'N', 1, 1);
insert into membro (nm_membro, sq_cpf, dt_nascimento, in_sexo, tx_endereco, nr_endereco, sq_cep, cd_estado, cd_cidade, sq_telefone, in_status, dt_cadastro, dt_alteracao, nm_usuario_alteracao, in_batizado, cd_igreja, cd_tipo) 
	values ('Thiago dos Santos de Jesus', '76941895926', '25051994', 'M', 'R. Capitão Ferreira Gomes', 87, '86070030', 16, 2951, '4333510548', 'A', '11052016', '11052016', 'LFRANCISQU', 'N', 1, 1);
insert into membro (nm_membro, sq_cpf, dt_nascimento, in_sexo, tx_endereco, nr_endereco, sq_cep, cd_estado, cd_cidade, sq_telefone, in_status, dt_cadastro, dt_alteracao, nm_usuario_alteracao, in_batizado, cd_igreja, cd_tipo) 
	values ('Marina dos Santos Rocha', '35536160168', '25051994', 'M', 'R. Capitão Ferreira Gomes', 87, '86070030', 16, 2951, '4333510548', 'A', '11052016', '11052016', 'LFRANCISQU', 'N', 1, 1);
insert into membro (nm_membro, sq_cpf, dt_nascimento, in_sexo, tx_endereco, nr_endereco, sq_cep, cd_estado, cd_cidade, sq_telefone, in_status, dt_cadastro, dt_alteracao, nm_usuario_alteracao, in_batizado, cd_igreja, cd_tipo) 
	values ('Mateus Ferrer Corso', '89675112727', '25051994', 'M', 'R. Capitão Ferreira Gomes', 87, '86070030', 16, 2951, '4333510548', 'A', '11052016', '11052016', 'LFRANCISQU', 'N', 1, 1);
insert into membro (nm_membro, sq_cpf, dt_nascimento, in_sexo, tx_endereco, nr_endereco, sq_cep, cd_estado, cd_cidade, sq_telefone, in_status, dt_cadastro, dt_alteracao, nm_usuario_alteracao, in_batizado, cd_igreja, cd_tipo) 
	values ('Thiago Constante de Souza', '84453590709', '25051994', 'M', 'R. Capitão Ferreira Gomes', 87, '86070030', 16, 2951, '4333510548', 'A', '11052016', '11052016', 'LFRANCISQU', 'N', 1, 1);

-- DIRETORIA
insert into diretoria (cd_responsavel, cd_igreja, dt_inicio, dt_cadastro, dt_alteracao, nm_usuario_alteracao) 
	values (1, 1, '11052016', '11052016', '11052016', 'LFRANCISQU');

-- USUARIO
insert into usuario 
	values ('LFRANCIS', md5('1234'), 'MS', 'A', 1);

-- MEMBRO ADMINISTRATIVO
insert into membro_administrativo (cd_membro, cd_funcao, cd_diretoria, dt_ocupacao, dt_alteracao, nm_usuario_alteracao, dt_desocupacao) 
	values (1, 1, 1, '11052016', '11052016', 'LFRANCISQU', '11052016');

-- AGENDA
insert into agenda (ds_agendamento, ds_tema, ds_local, in_status, cd_tipo_evento, cd_membro_responsavel, in_categoria, dt_cadastro, dt_alteracao, nm_usuario_alteracao)
	values ('Aniversário Igreja', 'Black and Withe', 'Igreja Evangélica Batista', 'C', 1, 1, 'U', '11052016', '11052016', 'LFRANCISQU');

-- CAMPANHA
insert into campanha (ds_campanha, vl_total, nr_parcelas, dt_cadastro, dt_alteracao, nm_usuario_alteracao, dt_inicial, dt_final, in_status, cd_igreja)
	values ('Aquisição Ar Condicionado', 1400.00, 10, '11052016', '11052016', 'LFRANCISQU', '11052016', '11032017', 'EA', 1);

-- LANÇAMENTO    
insert into lancamento (in_tipo_lancamento, in_rec_des, vl_lancamento, dt_cadastro, dt_alteracao, nm_usuario_alteracao, cd_membro, in_status, cd_igreja)
	values ('', '', 0.0, '', '', '', 0, '', 0);
