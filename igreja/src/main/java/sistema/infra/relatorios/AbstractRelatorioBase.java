/**
 * Copyright (c) Uniprime Norte do Paraná Av Rio de Janeiro 1758 Londrina-PR Brazil. Todos os direitos
 * reservados. Este software contém informações confidenciais e de propriedade exclusiva da Uniprime Norte do
 * Paraná e não deve ser utilizado fora da corporação.
 */
package sistema.infra.relatorios;

import java.io.Serializable;

/**
 * Centralizador de comportamentos de processo de geração de relatorios.
 * @author Fernando Franzini
 * @version 1.0 - 26/03/2015
 * @since 26/03/2015
 */
public abstract class AbstractRelatorioBase implements Serializable {

    /**
     * Utilizado para gerar o cabeçalho dos comprovantes.
     * @param dados dados do cabeçalho.
     * @param tipo tipo do relatório.
     * @return cabeçalho dos comprovantes.
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
