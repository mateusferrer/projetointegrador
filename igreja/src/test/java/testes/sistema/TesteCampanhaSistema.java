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
 * Teste de sistema do serviço de <b>Campanha</b>.
 * @version 1.0 - 15/05/2016
 * @since 15/05/2016
 */
@Named
public class TesteCampanhaSistema extends AbstractSistema {

    /** Armazena o objeto serviço a ser testado. **/
    @Inject
    private CampanhaBean bean;

    /** Armazena o objeto serviço a ser testado. **/
    @Inject
    private EntidadeBean entidadeBean;

    /** Armazena uma entidade. **/
    private Entidade entidade;

    /** {Descrita resumida do método}. */
    @Before
    public void inicializarTeste() {
        try {
            entidade = entidadeBean.get(null).get(0);
        } catch (NegocioException e) {
            System.out.println(e.getErrosString());
        }
    }

    /** Não deve pesquisar com código nulo. */
    @Test
    public void naoDevePesquisarComCodigoNulo() {
        try {
            bean.getPorCodigo(null);
            Assert.fail("Não deve pesquisar com código nulo");
        } catch (NegocioException e) {
            System.out.println(e.getErrosString());
        }
    }

    /** Não deve inserir objeto nulo. */
    @Test
    public void naoDeveInserirNulo() {
        try {
            Campanha campanha = null;
            bean.inserir(campanha);
            Assert.fail("Não deve inserir com objeto nulo");
        } catch (NegocioException e) {
            System.out.println(e.getErrosString());
        }
    }

    /** Não deve inserir objeto vazio. */
    @Test
    public void naoDeveInserirVazio() {
        try {
            Campanha campanha = new Campanha();
            bean.inserir(campanha);
            Assert.fail("Não deve inserir com objeto vazio");
        } catch (NegocioException e) {
            System.out.println(e.getErrosString());
        }
    }

    /** Não deve alterar objeto nulo. */
    @Test
    public void naoDeveAlterarNulo() {
        try {
            Campanha entidade = null;
            bean.alterar(entidade);
            Assert.fail("Não deve alterar com objeto nulo");
        } catch (NegocioException e) {
            System.out.println(e.getErrosString());
        }
    }

    /** Não deve alterar objeto vazio. */
    @Test
    public void naoDeveAlterarVazio() {
        try {
            bean.alterar(new Campanha());
            Assert.fail("Não deve alterar com objeto vazio");
        } catch (NegocioException e) {
            System.out.println(e.getErrosString());
        }
    }

    /** Não deve excluir objeto nulo. */
    @Test
    public void naoDeveExcluirNulo() {
        try {
            bean.excluir(null);
            Assert.fail("Não deve excluir com objeto nulo");
        } catch (NegocioException e) {
            System.out.println(e.getErrosString());
        }
    }

    /** Não deve excluir objeto vazio. */
    @Test
    public void naoDeveExcluirVazio() {
        try {
            bean.excluir(new Campanha());
            Assert.fail("Não deve excluir com objeto vazio");
        } catch (NegocioException e) {
            System.out.println(e.getErrosString());
        }
    }

    /** Deve executar os testes em questão com sucesso. */
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
            Assert.fail("Deveria pesquisar por código: " + e.getErrosString());
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

    /** Deve pesquisar por código. */
    private void devePesquisarPorDescricaoSucesso(String descricao) {
        try {
            bean.get(descricao);
        } catch (NegocioException e) {
            Assert.fail("Deveria pesquisar por código: " + e.getErrosString());
        }
    }
}