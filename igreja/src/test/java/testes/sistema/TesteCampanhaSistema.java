package testes.sistema;

import javax.inject.Inject;
import javax.inject.Named;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import sistema.negocio.aplicacao.campanha.CampanhaBean;
import sistema.negocio.aplicacao.entidade.EntidadeBean;
import sistema.negocio.dominio.Campanha;
import sistema.negocio.dominio.entidade.Entidade;
import testes.global.AbstractSistema;
import testes.unidade.TesteCampanhaUnidade;

import com.forj.cirrus.infra.exceptions.NegocioException;

/**
 * Teste de sistema do servi�o de <b>Campanha</b>.
 * @version 1.0 - 15/05/2016
 * @since 15/05/2016
 */
@Named
public class TesteCampanhaSistema extends AbstractSistema {

    /** Armazena o objeto servi�o a ser testado. **/
    @Inject
    private CampanhaBean bean;

    /** Armazena o objeto servi�o a ser testado. **/
    @Inject
    private EntidadeBean entidadeBean;

    /** Armazena uma entidade. **/
    private Entidade entidade;

    /** {Descrita resumida do m�todo}. */
    @Before
    public void inicializarTeste() {
        try {
            entidade = entidadeBean.get(null).get(0);
        } catch (NegocioException e) {
            System.out.println(e.getErrosString());
        }
    }

    /** N�o deve pesquisar com c�digo nulo. */
    @Test
    public void naoDevePesquisarComCodigoNulo() {
        try {
            bean.getPorCodigo(null);
            Assert.fail("N�o deve pesquisar com c�digo nulo");
        } catch (NegocioException e) {
            System.out.println(e.getErrosString());
        }
    }

    /** N�o deve inserir objeto nulo. */
    @Test
    public void naoDeveInserirNulo() {
        try {
            Campanha campanha = null;
            bean.inserir(campanha);
            Assert.fail("N�o deve inserir com objeto nulo");
        } catch (NegocioException e) {
            System.out.println(e.getErrosString());
        }
    }

    /** N�o deve inserir objeto vazio. */
    @Test
    public void naoDeveInserirVazio() {
        try {
            Campanha campanha = new Campanha();
            bean.inserir(campanha);
            Assert.fail("N�o deve inserir com objeto vazio");
        } catch (NegocioException e) {
            System.out.println(e.getErrosString());
        }
    }

    /** N�o deve alterar objeto nulo. */
    @Test
    public void naoDeveAlterarNulo() {
        try {
            Campanha entidade = null;
            bean.alterar(entidade);
            Assert.fail("N�o deve alterar com objeto nulo");
        } catch (NegocioException e) {
            System.out.println(e.getErrosString());
        }
    }

    /** N�o deve alterar objeto vazio. */
    @Test
    public void naoDeveAlterarVazio() {
        try {
            bean.alterar(new Campanha());
            Assert.fail("N�o deve alterar com objeto vazio");
        } catch (NegocioException e) {
            System.out.println(e.getErrosString());
        }
    }

    /** N�o deve excluir objeto nulo. */
    @Test
    public void naoDeveExcluirNulo() {
        try {
            bean.excluir(null);
            Assert.fail("N�o deve excluir com objeto nulo");
        } catch (NegocioException e) {
            System.out.println(e.getErrosString());
        }
    }

    /** N�o deve excluir objeto vazio. */
    @Test
    public void naoDeveExcluirVazio() {
        try {
            bean.excluir(new Campanha());
            Assert.fail("N�o deve excluir com objeto vazio");
        } catch (NegocioException e) {
            System.out.println(e.getErrosString());
        }
    }

    /** Deve executar os testes em quest�o com sucesso. */
    @Test
    public void grupoCrudCampanha() {
        Campanha campanha = TesteCampanhaUnidade.fabricar();
        campanha.setId(null);
        campanha.setEntidade(entidade);
        deveInserirSucesso(campanha);
        devePesquisarPorCodigoSucesso(campanha.getId());
        devePesquisarPorDescricaoSucesso(campanha.getDescricao());
        devePesquisarTodosSucesso();
        campanha.setDescricao(campanha.getDescricao() + " Alterado");
        deveAlterarSucesso(campanha);
        deveExcluirSucesso(campanha);
    }

    /** Deve inserir com sucesso. */
    private void deveInserirSucesso(Campanha entidade) {
        try {
            bean.inserir(entidade);
        } catch (NegocioException e) {
            Assert.fail("Deveria ter inserido com sucesso - " + e.getErrosString());
        }
    }

    /** Deve alterar com sucesso. */
    private void deveAlterarSucesso(Campanha campanha) {
        try {
            bean.alterar(campanha);
        } catch (NegocioException e) {
            Assert.fail("Deveria ter alterado com sucesso - " + e.getErrosString());
        }
    }

    /** Deve excluir com sucesso. */
    private void deveExcluirSucesso(Campanha campanha) {
        try {
            bean.excluir(campanha);
        } catch (NegocioException e) {
            Assert.fail("Deveria ter excluido com sucesso - " + e.getErrosString());
        }
    }

    /** Pesquisa todos os registros. */
    private void devePesquisarPorCodigoSucesso(Long codigo) {
        try {
            bean.getPorCodigo(codigo);
        } catch (NegocioException e) {
            Assert.fail("Deveria pesquisar por c�digo: " + e.getErrosString());
        }
    }

    /** Pesquisa todos os registros. */
    private void devePesquisarTodosSucesso() {
        try {
            bean.get(null);
        } catch (NegocioException e) {
            Assert.fail("Deveria pesquisar todos: " + e.getErrosString());
        }
    }

    /** Deve pesquisar por c�digo. */
    private void devePesquisarPorDescricaoSucesso(String descricao) {
        try {
            bean.get(descricao);
        } catch (NegocioException e) {
            Assert.fail("Deveria pesquisar por c�digo: " + e.getErrosString());
        }
    }
}