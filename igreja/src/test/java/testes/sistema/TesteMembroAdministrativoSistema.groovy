package testes.sistema

import javax.annotation.Resource
import javax.inject.Inject

import org.junit.Assert
import org.junit.Test

import sistema.negocio.dominio.MembroAdministrativo
import testes.global.AbstractSistema
import testes.unidade.TesteMembroAdministrativoUnidade

import com.forj.cirrus.negocio.aplicativo.DominioBean
import com.forj.cirrus.util.Cirrus

/**
 * Teste de sistema do serviço de <b>Membro Administrativo</b>.
 * @author Lucas Francisquini
 * @version 1.0 - 27/11/2015
 * @since 27/11/2015
 */
class TesteMembroAdministrativoSistema extends AbstractSistema {

    /** Armazena o objeto serviço a ser testado. **/
    @Resource(name = Cirrus.FACADE)
    DominioBean<MembroAdministrativo> bean

    /** Armazena o teste de cargo administrativo. **/
    @Inject
    TesteCargoAdministrativoSistema testeCargo;

    /** Armazena o teste de membro. **/
    @Inject
    TesteMembroSistema testeMembro;

    /**
     * Não deve inserir.
     */
    @Test
    void naoDeveInserir() {
        MembroAdministrativo dominio = new MembroAdministrativo()
        naoDeveInserir(dominio)
        dominio
    }

    /**
     * Não deve alterar.
     */
    @Test
    void naoDeveAlterar() {
        MembroAdministrativo dominio = new MembroAdministrativo()
        naoDeveAlterar(dominio)
        dominio
    }

    /**
     * Teste de inserir.
     * @return dominio gravado no banco.
     */
    def inserir() {
        MembroAdministrativo dominio = TesteMembroAdministrativoUnidade.fabricar();
        dominio.cargo = testeCargo.inserir();
        dominio.membro = testeMembro.inserir()
        dominio.id = null
        deveInserir(dominio)
        dominio
    }

    /**  Agrupador de testes: inserir, alterar e deletar.  */
    @Test
    void grupoCrud() {
        MembroAdministrativo dominio = inserir();
        dominio.posicao += " alterado"
        deveAlterar(dominio)
        deveExcluir(dominio)
    }

    /** Pesquisa todos os registros.  */
    @Test
    void devePesquisarTodos() {
        try {
            println bean.get(MembroAdministrativo.TODOS);
        } catch (e) {
            Assert.fail("Deveria pesquisar todos: " + e.message)
        }
    }
}