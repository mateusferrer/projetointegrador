-- Parâmetros: 1 - Valor da parcela, 2 - Quantidade de Parcelas, 3 - ID do Membro

DELIMITER $$
CREATE PROCEDURE pr_gerar_lanc_contrib(IN vl_parcela decimal(10,2), IN cd_membro int(10), IN dt_inicial date, IN dt_final date)
BEGIN

		DECLARE dia INT DEFAULT day(ini);
		DECLARE mes INT DEFAULT month(ini);
		DECLARE ano INT DEFAULT year(ini);
        DECLARE dt_pagamento DATE DEFAULT dt_inicial;
		loop_teste: LOOP
			INSERT INTO lancamento_campanha (vl_lancamento, dt_pagamento, in_pago, cd_contribuinte)
				VALUES (<{vl_lancamento: }>, dt_pagamento, <{in_pago: }>, <{cd_contribuinte: }>);
			SET contador = contador + 1;
			SET soma = soma + contador;
			IF contador >= limite THEN
				LEAVE loop_teste;
			END IF;
		END LOOP loop_teste;

    -- Calcular Meses
    -- Processo para gerar os lançamentos de acordo com os meses estimados (Tabela: lancamento)
END $$
DELIMITER ;


-- Executar Procedures: CALL nome_procedimento(parâmetros);