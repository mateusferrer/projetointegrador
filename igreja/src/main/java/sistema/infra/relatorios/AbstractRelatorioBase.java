/**
 * Copyright (c) Uniprime Norte do Paran� Av Rio de Janeiro 1758 Londrina-PR Brazil. Todos os direitos
 * reservados. Este software cont�m informa��es confidenciais e de propriedade exclusiva da Uniprime Norte do
 * Paran� e n�o deve ser utilizado fora da corpora��o.
 */
package sistema.infra.relatorios;

import java.io.Serializable;

/**
 * Centralizador de comportamentos de processo de gera��o de relatorios.
 * @author Fernando Franzini
 * @version 1.0 - 26/03/2015
 * @since 26/03/2015
 */
public abstract class AbstractRelatorioBase implements Serializable {

    /**
     * Utilizado para gerar o cabe�alho dos comprovantes.
     * @param dados dados do cabe�alho.
     * @param tipo tipo do relat�rio.
     * @return cabe�alho dos comprovantes.
     * @throws RelatorioException caso ocorrer erros.
     */
    // protected Map<String, Object> gerarCabecalho(DadosContaDebito dados, PathRelatorio tipo)
    // throws RelatorioException {
    // Map<String, Object> map = RelatorioUtils.getMapPadrao();
    // if (PathRelatorio.GPS_AUTENTICADO == tipo) {
    // map.put("logogps", "LOGO");
    // }
    // if (PathRelatorio.DARF_AUTENTICADO == tipo) {
    // map.put("logodarf", sistemaBean.getPathPadraoSrc() + RelatorioUtils.LOGO_DARF);
    // }
    // map.put("nomeEntidade", dados.getNome());
    // map.put("codBancoDeb", dados.getCodBanco());
    // map.put("nomeBancoDeb", dados.getBanco());
    // map.put("codAgenciaDeb", dados.getCodAgencia());
    // map.put("nomeAgenciaDeb", dados.getAgencia());
    // map.put("contaDeb", dados.getConta());
    // return map;
    // }
}
