package testes.sistema

import javax.annotation.Resource
import javax.inject.Inject
import javax.inject.Named

import org.junit.Assert
import org.junit.Test

import sistema.negocio.dominio.Membro
import testes.global.AbstractSistema
import testes.unidade.TesteMembroUnidade

import com.forj.cirrus.negocio.aplicativo.DominioBean
import com.forj.cirrus.util.Cirrus

/**
 * Teste de sistema do serviço de <b>Membro</b>.
 * @author Lucas Francisquini
 * @version 1.0 - 26/11/2015
 * @since 26/11/2015
 */
@Named
class TesteMembroSistema extends AbstractSistema {

    /** Armazena o objeto serviço a ser testado. **/
    @Resource(name = Cirrus.FACADE)
    DominioBean<Membro> bean

    /** Armazena o teste de cargo eclesiástico. **/
    @Inject
    TesteCargoEclesiasticoSistema testeCargo;

    /** Armazena o teste de cargo eclesiástico. **/
    @Inject
    TesteIgrejaSistema testeIgreja;

    /**
     * Não deve inserir.
     */
    @Test
    void naoDeveInserir() {
        Membro dominio = new Membro()
        naoDeveInserir(dominio)
        dominio
    }

    /**
     * Não deve alterar.
     */
    @Test
    void naoDeveAlterar() {
        Membro dominio = new Membro()
        naoDeveAlterar(dominio)
        dominio
    }

    /**
     * Teste de inserir.
     * @return dominio gravado no banco.
     */
    def inserir() {
        Membro dominio = TesteMembroUnidade.fabricar();
        dominio.cargo = testeCargo.inserir();
        dominio.igreja = testeIgreja.inserir()
        dominio.id = null
        deveInserir(dominio)
        dominio
    }

    /**  Agrupador de testes: inserir, alterar e deletar.  */
    @Test
    void grupoCrud() {
        Membro dominio = inserir();
        dominio.nome += " alterado"
        deveAlterar(dominio)
        deveExcluir(dominio)
    }

    /** Pesquisa todos os registros.  */
    @Test
    void devePesquisarTodos() {
        try {
            println bean.get(Membro.TODOS);
        } catch (e) {
            Assert.fail("Deveria pesquisar todos: " + e.message)
        }
    }
}