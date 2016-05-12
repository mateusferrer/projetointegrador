/**
 * Copyright (c) Uniprime Norte do Paran�. Av Rio de Janeiro 1758 Londrina-PR
 * Brazil. Todos os direitos reservados. Este software cont�m informa��es
 * confidenciais e de propriedade exclusiva da Uniprime Norte do Paran� e n�o
 * deve ser utilizado fora da corpora��o.
 */
package testes.sistema

import javax.inject.Inject
import javax.inject.Named

import org.junit.Assert
import org.junit.Test

import sistema.negocio.aplicacao.CargoEclesiasticoBean;
import sistema.negocio.aplicacao.IgrejaBeanImp
import sistema.negocio.dominio.CargoEclesiastico;
import sistema.negocio.dominio.Congregacao
import testes.global.AbstractSistema
import testes.unidade.TesteCargoEclesiasticoUnidade;
import testes.unidade.TesteIgrejaUnidade

/**
 * Teste de sistema do servi�o de <b>CargoEclesiastico</b>.
 * @author Lucas Francisquini
 * @version 1.0 - 26/11/2015
 * @since 26/11/2015
 */
@Named
class TesteCargoEclesiasticoSistema extends AbstractSistema {

    /** Armazena o objeto servi�o a ser testado. **/
    @Inject
    CargoEclesiasticoBean bean

    /**
     * N�o deve inserir.
     */
    @Test
    void naoDeveInserir() {
        CargoEclesiastico dominio = new CargoEclesiastico()
        naoDeveInserir(dominio)
        dominio
    }

    /**
     * N�o deve alterar.
     */
    @Test
    void naoDeveAlterar() {
        CargoEclesiastico dominio = new CargoEclesiastico()
        naoDeveAlterar(dominio)
        dominio
    }

    /**
     * Teste de inserir.
     * @return dominio gravado no banco.
     */
    def inserir() {
        CargoEclesiastico dominio = TesteCargoEclesiasticoUnidade.fabricar();
        dominio.id = null
        deveInserir(dominio)
        dominio
    }

    /**  Agrupador de testes: inserir, alterar e deletar.  */
    @Test
    void grupoCrud() {
        CargoEclesiastico dominio = inserir();
        dominio.descricao += " alterado"
        deveAlterar(dominio)
        deveExcluir(dominio)
    }

    /** Pesquisa todos os registros.  */
    @Test
    void devePesquisarTodos() {
        try {
            println bean.get();
        } catch (e) {
            Assert.fail("Deveria pesquisar todos: " + e.message)
        }
    }
}