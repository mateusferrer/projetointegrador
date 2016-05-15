package testes.sistema

import javax.annotation.Resource
import javax.inject.Inject

import org.junit.Assert
import org.junit.Test

import sistema.negocio.dominio.MembroAdministrativo
import sistema.negocio.dominio.Secretaria
import testes.global.AbstractSistema
import testes.unidade.TesteSecretariaUnidade

import com.forj.cirrus.negocio.aplicativo.DominioBean
import com.forj.cirrus.util.Cirrus;

/**
 * Teste de sistema do serviço de <b>Secretaria</b>.
 * @author Lucas Francisquini
 * @version 1.0 - 27/11/2015
 * @since 27/11/2015
 */
class TesteSecretariaSistema extends AbstractSistema {

    /** Armazena o objeto serviço a ser testado. **/
    @Resource(name = Cirrus.FACADE)
    DominioBean<Secretaria> bean

    /** Armazena o teste de cargo administrativo. **/
    @Inject
    TesteMembroSistema testeMembro;

    /** Armazena o teste de membro. **/
    @Inject
    TesteEntidadeSistema testeIgreja;

    /**
     * Não deve inserir.
     */
    @Test
    void naoDeveInserir() {
        Secretaria dominio = new Secretaria()
        naoDeveInserir(dominio)
        dominio
    }

    /**
     * Não deve alterar.
     */
    @Test
    void naoDeveAlterar() {
        Secretaria dominio = new Secretaria()
        naoDeveAlterar(dominio)
        dominio
    }

    /**
     * Teste de inserir.
     * @return dominio gravado no banco.
     */
    def inserir() {
        Secretaria dominio = TesteSecretariaUnidade.fabricar();
        dominio.igrejaResponsavel = testeIgreja.inserir();
        dominio.pastorResponsavel = testeMembro.inserir()
        dominio.id = null
        deveInserir(dominio)
        dominio
    }

    /**  Agrupador de testes: inserir, alterar e deletar.  */
    @Test
    void grupoCrud() {
        Secretaria dominio = inserir();
        dominio.dataInicio += 1
        deveAlterar(dominio)
        deveExcluir(dominio)
    }

    /** Pesquisa todos os registros.  */
    @Test
    void devePesquisarTodos() {
        try {
            println bean.get(Secretaria.TODOS);
        } catch (e) {
            Assert.fail("Deveria pesquisar todos: " + e.message)
        }
    }
}