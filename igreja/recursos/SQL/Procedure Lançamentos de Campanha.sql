-- Parâmetros: 1 - Valor da parcela, 2 - Quantidade de Parcelas, 3 - ID do Membro

DELIMITER $$
CREATE PROCEDURE pr_gerar_lanc_contrib(IN vl_parcela decimal(10,2), IN cd_membro int(10), IN dt_inicial date, IN dt_final date)
BEGIN
    -- Calcular Meses
    -- Processo para gerar os lançamentos de acordo com os meses estimados (Tabela: lancamento)
END $$
DELIMITER ;


-- Executar Procedures: CALL nome_procedimento(parâmetros);