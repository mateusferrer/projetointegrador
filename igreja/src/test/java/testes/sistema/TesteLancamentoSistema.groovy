/**
 * Copyright (c) Uniprime Norte do Paranï¿½. Av Rio de Janeiro 1758 Londrina-PR
 * Brazil. Todos os direitos reservados. Este software contï¿½m informaï¿½ï¿½es
 * confidenciais e de propriedade exclusiva da Uniprime Norte do Paranï¿½ e nï¿½o
 * deve ser utilizado fora da corporaï¿½ï¿½o.
 */
package testes.sistema

import javax.inject.Inject
import javax.inject.Named

import org.junit.Assert
import org.junit.Test

import sistema.negocio.aplicacao.LancamentoBean
import sistema.negocio.dominio.FiltroLancamento
import sistema.negocio.dominio.Lancamento
import testes.global.AbstractSistema
import testes.unidade.TesteLancamentoUnidade

/**
 * Teste de sistema do serviço de <b>Lancamento</b>.
 * @author Lucas Francisquini
 * @version 1.0 - 30/11/2015
 * @since 30/11/2015
 */
@Named
class TesteLancamentoSistema extends AbstractSistema {

    /** Armazena o objeto serviço a ser testado. **/
    @Inject
    LancamentoBean bean

    /**
     * Não deve inserir lançamento vazio.
     */
    @Test
    void naoDeveInserir() {
        naoDeveInserir(new Lancamento())
    }

    /**
     * Não deve alterar lançamento vazio.
     */
    @Test
    void naoDeveAlterar() {
        naoDeveAlterar(new Lancamento())
    }

    /** Não deve pesquisar com parâmetro nulo.  */
    @Test
    void naoDevePesquisarComParametroNulo() {
        try {
            bean.get(null)
            Assert.fail("Não deve pesquisar com parâmetro nulo.")
        } catch (e) {
            e.getMessage()
        }
    }

    /** Não deve pesquisar com parâmetro vazio.  */
    @Test
    void naoDevePesquisarComParametroVazio() {
        try {
            bean.get(new FiltroLancamento())
            Assert.fail("Não deve pesquisar com parâmetro vazio.")
        } catch (e) {
            e.getMessage()
        }
    }

    /** Deve pesquisar receitas ativas.  */
    @Test
    void devePesquisarAtivos() {
        try {
            inserir(Lancamento.ATIVO)
            bean.get(new FiltroLancamento(status: Lancamento.ATIVO, tipoLancamento: Lancamento.LANC_RECEITA))
        } catch (e) {
            Assert.fail("Deveria pesquisar ativos - " + e.getMessage())
        }
    }

    /** Deve pesquisar receitas ativas.  */
    @Test
    void devePesquisarInativos() {
        try {
            inserir(Lancamento.ATIVO)
            bean.get(new FiltroLancamento(status: Lancamento.INATIVO, tipoLancamento: Lancamento.LANC_RECEITA))
        } catch (e) {
            Assert.fail("Deveria pesquisar receitas inativos - " + e.getMessage())
        }
    }

    /** Deve pesquisar o saldo.  */
    @Test
    void devePesquisarSaldo() {
        try {
            inserir(Lancamento.ATIVO)
            inserir(Lancamento.INATIVO)
            println "Saldo: " + bean.getSaldo()
        } catch (e) {
            Assert.fail("Deveria pesquisar as despesas ativas: " + e.message)
        }
    }

    /**
     * Teste de inserir.
     * @return dominio gravado no banco.
     */
    def inserir(status) {
        Lancamento dominio = TesteLancamentoUnidade.fabricar();
        dominio.id = null
        dominio.status = status
        deveInserir(dominio)
        dominio
    }

    /**  Agrupador de testes: inserir, alterar e deletar.  */
    @Test
    void grupoCrud() {
        Lancamento dominio = inserir(Lancamento.ATIVO);
        dominio.descricao += " alterado"
        deveAlterar(dominio)
        deveExcluir(dominio)
    }
}