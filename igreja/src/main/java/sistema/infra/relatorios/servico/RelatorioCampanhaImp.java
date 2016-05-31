/**
 * Copyright (c) Uniprime Norte do Paraná. Av Rio de Janeiro 1758 Londrina-PR Brazil. Todos os direitos
 * reservados. Este software contém informações confidenciais e de propriedade exclusiva da Uniprime Norte do
 * Paraná e não deve ser utilizado fora da corporação.
 */
package sistema.infra.relatorios.servico;

import javax.inject.Named;

import sistema.infra.relatorios.AbstractRelatorioBase;
import sistema.infra.relatorios.PathRelatorio;

/**
 * Gerenciador de relatorios de darf utilizando framework ireport com jasper studio.
 * @author Allan Moreli
 * @version 1.0 - 26/03/2015
 * @since 26/03/2015
 */
@Named
public class RelatorioCampanhaImp extends AbstractRelatorioBase {

    /** Armazena o path do relatorio jasper. **/
    private static final String PATH_RELATORIO = PathRelatorio.PADRAO + "demonstrativoCampanha.jasper";

    // /** {@inheritDoc} */
    // @Override
    // public File getExtrato(List<Darf> colecao) throws NegocioException {
    // Param.validar(colecao, "Dados.");
    // try {
    // Map<String, Object> map = RelatorioUtils.getMapPadraoComCabecalho();
    // map.put("total", getValorTotal(colecao));
    // return RelatorioUtils.gerarPdf(sistemaBean.getPathPadraoSrc() + PATH_EXTRATO, map,
    // new JRBeanCollectionDataSource(gerarDados(colecao)));
    // } catch (RelatorioException e) {
    // throw new NegocioException(e);
    // }
    // }
    //
    // /** {@inheritDoc} */
    // @Override
    // public File getComprovante1PorPagina(Darf darf) throws NegocioException {
    // Param.validar(darf, "Dados Comprovante");
    // darf.validar();
    // List<Darf> colecao = new ArrayList<>(1);
    // colecao.add(darf);
    // return getComprovante1PorPagina(colecao);
    // }
    //
    // /** {@inheritDoc} */
    // @Override
    // public File getComprovante1PorPagina(List<Darf> darfs) throws NegocioException {
    // Param.validar(darfs, "Dados");
    // try {
    // Map<String, Object> map = gerarCabecalho(gerarDados(), PathRelatorio.DARF_AUTENTICADO);
    // return RelatorioUtils.gerarPdf(sistemaBean.getPathPadraoSrc() + PathRelatorio.DARF_AUTENTICADO,
    // map, new JRBeanCollectionDataSource(darfParaComprovantes(darfs)));
    // } catch (RelatorioException e) {
    // throw new NegocioException(e);
    // }
    // }
    //
    // // metodos privados de apoio.
    //
    // /**
    // * Gerar os dados do gps para impressão.
    // * @param colecao a ser convertida.
    // * @return dados do boleto para impressão.
    // */
    // private List<ExtratoGpsDarf> gerarDados(List<Darf> colecao) {
    // List<ExtratoGpsDarf> lista = new ArrayList<ExtratoGpsDarf>();
    // for (Darf gps : colecao) {
    // ExtratoGpsDarf dados = new ExtratoGpsDarf();
    // dados.setDataPagamento(gps.getDataPagamento());
    // dados.setContribuinte(gps.getContribuinte());
    // dados.setValor(gps.getValorTotal());
    // //dados.setStatus(gps.get);
    // lista.add(dados);
    // }
    // return lista;
    // }
    //
    // /**
    // * Efetua o calculo do valor total dos lançamentos.
    // * @param colecao de lançamentos para calculo.
    // * @return valor total dos lançamentos visualizados.
    // */
    // private BigDecimal getValorTotal(List<Darf> colecao) {
    // BigDecimal total = BigDecimal.ZERO;
    // for (Darf lf : colecao) {
    // total = total.add(lf.getValorPrincipal());
    // }
    // return total;
    // }
    //
    // /**
    // * Carrega os dados do darf no comprovante.
    // * @param lista utilizado para mineiracao de dados.
    // * @return dados do relatório.
    // * @throws NegocioException caso ocorram erros.
    // */
    // private List<ComprovanteDarf> darfParaComprovantes(List<Darf> lista) throws NegocioException {
    // Param.validar(lista, MsgErro.obrigatorio("DARF"));
    // List<ComprovanteDarf> comprovantes = new ArrayList<ComprovanteDarf>();
    // for (Darf darf : lista) {
    // ComprovanteDarf comprovante = new ComprovanteDarf();
    // comprovante.setNome(darf.getContribuinte());
    // comprovante.setDataVencimento(darf.getDataVencimento());
    // comprovante.setDataPagamento(darf.getDataPagamento());
    // comprovante.setPeriodoApuracao(darf.getDataApuracao());
    // comprovante.setVlJuros(darf.getValorJuros());
    // comprovante.setVlMulta(darf.getValorMulta());
    // comprovante.setVlPrincipal(darf.getValorPrincipal());
    // comprovante.setVlTotal(darf.getValorTotal());
    // comprovante.setCpfCnpj(darf.getPk().getCpfCnpj());
    // comprovante.setCodigoReceita(darf.getReceita());
    // comprovante.setNumeroReferencia(darf.getReferencia());
    // comprovante.setStatus(darf.getMensagem());
    // comprovante.setBanco("Banco do Brasil");
    // comprovante.setConta(darf.getConta());
    // comprovante.setAutenticacao(darf.getAutenticacao());
    // comprovante.setValorReceita(darf.getValorReceitaBruta());
    // comprovante.setPercentualReceita(darf.getPercentualcReceitaBruta());
    // comprovantes.add(comprovante);
    // }
    // return comprovantes;
    // }

}