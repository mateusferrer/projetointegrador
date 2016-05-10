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

import sistema.negocio.aplicacao.CargoAdministrativoBean
import sistema.negocio.dominio.CargoAdministrativo
import sistema.negocio.dominio.CargoEclesiastico
import testes.global.AbstractSistema
import testes.unidade.TesteCargoAdministrativoUnidade

/**
 * Teste de sistema do serviço de <b>CargoAdministrativo</b>.
 * @author Lucas Francisquini
 * @version 1.0 - 27/11/2015
 * @since 27/11/2015
 */
@Named
class TesteCargoAdministrativoSistema extends AbstractSistema {

    /** Armazena o objeto serviço a ser testado. **/
    @Inject
    CargoAdministrativoBean bean

    /**
     * Não deve inserir.
     */
    @Test
    void naoDeveInserir() {
        CargoAdministrativo dominio = new CargoAdministrativo()
        naoDeveInserir(dominio)
        dominio
    }

    /**
     * Não deve alterar.
     */
    @Test
    void naoDeveAlterar() {
        CargoAdministrativo dominio = new CargoAdministrativo()
        naoDeveAlterar(dominio)
        dominio
    }

    /**
     * Teste de inserir.
     * @return dominio gravado no banco.
     */
    def inserir() {
        CargoAdministrativo dominio = TesteCargoAdministrativoUnidade.fabricar();
        dominio.id = null
        deveInserir(dominio)
        dominio
    }

    /**  Agrupador de testes: inserir, alterar e deletar.  */
    @Test
    void grupoCrud() {
        CargoAdministrativo dominio = inserir();
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