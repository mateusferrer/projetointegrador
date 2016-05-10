package testes.visao

import javax.inject.Inject

import org.junit.Assert
import org.junit.Before
import org.junit.Test

import sistema.negocio.aplicacao.LancamentoBean
import sistema.visao.lancamento.LancamentoFrm
import testes.global.AbstractSistema
import testes.sistema.TesteMembroSistema
import testes.unidade.TesteLancamentoUnidade

/**
 * Teste de visão do serviço de  <b>Lancamento</b>.
 * @author Lucas Francisquini
 * @version 1.0 - 30/11/2015
 * @since 30/11/2015
 */
class TesteLancamentoFrm extends AbstractSistema {

    /** Armazena o serviço de negocio. **/
    @Inject
    LancamentoBean bean

    /** Armazena o serviço de negocio. **/
    @Inject
    TesteMembroSistema testeMembro

    /** Armazena o formulario a ser testado. **/
    LancamentoFrm frm

    /** Prepara os testes. **/
    @Before
    void entrar() {
        frm = new LancamentoFrm()
        frm.bean = bean
        frm.entrar()
    }

    /** Deve pesquisar receitas ativas. **/
    @Test
    void devePesquisarReceitasAtivas() {
        frm.filtro.tipoLancamento = "R"
        frm.filtro.status = "A"
        frm.pesquisar()
    }

    /** Deve pesquisar receitas estornadas. **/
    @Test
    void devePesquisarReceitasEstornadas() {
        frm.filtro.tipoLancamento = "R"
        frm.filtro.status = "I"
        frm.pesquisar()
    }

    /** Deve pesquisar despesas ativas. **/
    @Test
    void devePesquisarDespesasAtivas() {
        frm.filtro.tipoLancamento = "D"
        frm.filtro.status = "A"
        frm.pesquisar()
    }

    /** Deve pesquisar despesas estornadas. **/
    @Test
    void devePesquisarDespesasEstornadas() {
        frm.filtro.tipoLancamento = "D"
        frm.filtro.status = "I"
        frm.pesquisar()
    }

    /** Deve pesquisar despesas estornadas. **/
    @Test
    void devePesquisarSaldo() {
        frm.novo()
        frm.dominio = TesteLancamentoUnidade.fabricar()
        frm.dominio.tipoReceita = "O"
        frm.dominio.id = null
        frm.gravar()
        frm.buscarSaldo()
        println frm.saldo
    }

    /** Agrupador de testes: novo, alterar e deletar. **/
    @Test
    void grupoCrud() {
        // inserir
        frm.novo()
        frm.dominio = TesteLancamentoUnidade.fabricar()
        frm.dominio.tipoReceita = "O"
        frm.dominio.id = null
        frm.gravar()
        // Voltar para listagem
        frm.cancelar()
        // Pesquisar
        frm.filtro.tipoLancamento = "R"
        frm.filtro.status = "A"
        frm.pesquisar()
        Assert.assertTrue("Deve ter 1 registro", frm.colecao.size() > 0)
        // Alterar
        frm.alterar(frm.colecao.get(0))
        frm.alterar = true
        frm.dominio.descricao += " alterado"
        frm.gravar()
        // Voltar para listagem
        frm.cancelar()
    }
}