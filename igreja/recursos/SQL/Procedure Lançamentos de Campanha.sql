-- Parâmetros: 1 - Valor da parcela, 2 - Quantidade de Parcelas, 3 - ID do Membro

DELIMITER $$
CREATE PROCEDURE pr_gerar_lancamentos_campanha (IN vl_parcela decimal(10,2), IN cd_membro int(10), IN dt_inicial date, IN dt_final date)
BEGIN
	DECLARE DATA_INI DATE DEFAULT dt_inicial;
    DECLARE DATA_FIM DATE DEFAULT dt_final;
    
END $$
DELIMITER ;


-- Executar Procedures: CALL nome_procedimento(parâmetros);