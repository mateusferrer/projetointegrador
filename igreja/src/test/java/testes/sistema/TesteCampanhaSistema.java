package testes.sistema;

import java.util.List;

import javax.inject.Inject;

import org.junit.Assert;
import org.junit.Test;

import sistema.negocio.aplicacao.campanha.CampanhaBean;
import sistema.negocio.dominio.campanha.Campanha;
import sistema.negocio.dominio.membro.Membro;
import testes.global.AbstractSistema;
import testes.unidade.TesteCampanhaUnidade;

import com.forj.cirrus.infra.exceptions.NegocioException;

/**
 * Teste de sistema do serviço de <b>Campanha</b>.
 * @version 1.0 - 29/05/2016
 * @since 15/05/2016
 */
public class TesteCampanhaSistema extends AbstractSistema {

    /** Armazena o gerenciador dos processos de negócio. **/
    @Inject
    private CampanhaBean campanhaBean;

    /** Armazena o gerenciador dos processos de teste. **/
    @Inject
    private TesteMembroSistema testeMembro;

    /** Não deve pesquisar com código nulo. */
    @Test
    public void naoDevePesquisarComCodigoNulo() {
        try {
            campanhaBean.getPorCodigo(null);
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
            campanhaBean.inserir(campanha);
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
            campanhaBean.inserir(campanha);
            Assert.fail("Não deve inserir com objeto vazio");
        } catch (NegocioException e) {
            System.out.println(e.getErrosString());
        }
    }

    /** Não deve alterar objeto nulo. */
    @Test
    public void naoDeveAlterarNulo() {
        try {
            Campanha campanha = null;
            campanhaBean.alterar(campanha);
            Assert.fail("Não deve alterar com objeto nulo");
        } catch (NegocioException e) {
            System.out.println(e.getErrosString());
        }
    }

    /** Não deve alterar objeto vazio. */
    @Test
    public void naoDeveAlterarVazio() {
        Campanha campanha = new Campanha();
        try {
            campanhaBean.alterar(campanha);
            Assert.fail("Não deve alterar com objeto vazio");
        } catch (NegocioException e) {
            System.out.println(e.getErrosString());
        }
    }

    /** Não deve excluir objeto nulo. */
    @Test
    public void naoDeveExcluirNulo() {
        Campanha campanha = new Campanha();
        try {
            campanhaBean.excluir(campanha);
            Assert.fail("Não deve excluir com objeto nulo");
        } catch (NegocioException e) {
            System.out.println(e.getErrosString());
        }
    }

    /** Não deve excluir objeto vazio. */
    @Test
    public void naoDeveExcluirVazio() {
        Campanha campanha = new Campanha();
        try {
            campanhaBean.excluir(campanha);
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
        deveInserirSucesso(campanha);
        devePesquisarPorCodigoSucesso(campanha.getId());
        devePesquisarPorDescricaoSucesso(campanha.getDescricao());
        devePesquisarTodosSucesso();
        campanha.setDescricao(campanha.getDescricao() + " Alterado");
        deveAlterarSucesso(campanha);
        deveExcluirSucesso(campanha);
        // Campanha com contribuintes
        List<Membro> membros = testeMembro.devePesquisarTodosSucesso();
        Campanha campContrib = TesteCampanhaUnidade.fabricarComContribuintes();
        for (int i = 0; i < campContrib.getContribuintes().size(); i++) {
            campContrib.getContribuintes().get(i).setMembro(membros.get(i));
        }
        campContrib.setId(null);
        campContrib.getContribuintes().stream().forEach(c -> c.setId(null));
        deveInserirSucesso(campContrib);
        deveAlterarSucesso(campContrib);
        deveExcluirSucesso(campContrib);
    }

    /** Deve inserir com sucesso. */
    private void deveInserirSucesso(Campanha entidade) {
        try {
            campanhaBean.inserir(entidade);
        } catch (NegocioException e) {
            Assert.fail("Deveria ter inserido com sucesso - " + e.getErrosString());
        }
    }

    /** Deve alterar com sucesso. */
    private void deveAlterarSucesso(Campanha campanha) {
        try {
            campanhaBean.alterar(campanha);
        } catch (NegocioException e) {
            Assert.fail("Deveria ter alterado com sucesso - " + e.getErrosString());
        }
    }

    /** Deve excluir com sucesso. */
    private void deveExcluirSucesso(Campanha campanha) {
        try {
            campanhaBean.excluir(campanha);
        } catch (NegocioException e) {
            Assert.fail("Deveria ter excluido com sucesso - " + e.getErrosString());
        }
    }

    /** Pesquisa todos os registros. */
    private void devePesquisarPorCodigoSucesso(Long codigo) {
        try {
            campanhaBean.getPorCodigo(codigo);
        } catch (NegocioException e) {
            Assert.fail("Deveria pesquisar por código: " + e.getErrosString());
        }
    }

    /** Pesquisa todos os registros. */
    private void devePesquisarTodosSucesso() {
        try {
            campanhaBean.get("");
        } catch (NegocioException e) {
            Assert.fail("Deveria pesquisar todos: " + e.getErrosString());
        }
    }

    /** Deve pesquisar por código. */
    private void devePesquisarPorDescricaoSucesso(String descricao) {
        try {
            campanhaBean.get(descricao);
        } catch (NegocioException e) {
            Assert.fail("Deveria pesquisar por código: " + e.getErrosString());
        }
    }
}