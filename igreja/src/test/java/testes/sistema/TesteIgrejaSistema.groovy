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

import sistema.negocio.aplicacao.IgrejaBeanImp
import sistema.negocio.dominio.Congregacao
import testes.global.AbstractSistema
import testes.unidade.TesteIgrejaUnidade

/**
 *  Teste de sistema do serviço de  <b>Cliente</b>.
 * @author Fernando Franzini
 * @version 1.0 - 04/08/2015
 * @since 04/08/2015
 */
@Named
class TesteIgrejaSistema extends AbstractSistema {

    /** Armazena o objeto serviço a ser testado. **/
    @Inject
    IgrejaBeanImp bean

    /**
     * Não deve inserir.
     */
    @Test
    void naoDeveInserir() {
        Congregacao dominio = new Congregacao()
        naoDeveInserir(dominio)
        dominio
    }

    /**
     * Não deve alterar.
     */
    @Test
    void naoDeveAlterar() {
        Congregacao dominio = new Congregacao()
        naoDeveAlterar(dominio)
        dominio
    }

    /**
     * Teste de inserir.
     * @return dominio gravado no banco.
     */
    def inserir() {
        Congregacao dominio = TesteIgrejaUnidade.fabricar();
        dominio.id = null
        deveInserir(dominio)
        dominio
    }

    /**  Agrupador de testes: inserir, alterar e deletar.  */
    @Test
    void grupoCrud() {
        Congregacao dominio = inserir();
        dominio.fantasia += " alterado"
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