package testes.sistema;

import javax.inject.Inject;
import javax.inject.Named;

import org.junit.Assert;
import org.junit.Test;

import sistema.negocio.aplicacao.entidade.EntidadeBean;
import sistema.negocio.dominio.entidade.Entidade;
import testes.global.AbstractSistema;
import testes.unidade.TesteEntidadeUnidade;

import com.forj.cirrus.infra.exceptions.NegocioException;

/**
 * Teste de sistema do servi�o de <b>Entidade</b>.
 * @version 1.0 - 15/05/2016
 * @since 15/05/2016
 */
@Named
public class TesteEntidadeSistema extends AbstractSistema {

    /** Armazena o objeto servi�o a ser testado. **/
    @Inject
    private EntidadeBean bean;

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
            bean.inserir(null);
            Assert.fail("N�o deve inserir com objeto nulo");
        } catch (NegocioException e) {
            System.out.println(e.getErrosString());
        }
    }

    /** N�o deve inserir objeto vazio. */
    @Test
    public void naoDeveInserirVazio() {
        try {
            bean.inserir(new Entidade());
            Assert.fail("N�o deve inserir com objeto vazio");
        } catch (NegocioException e) {
            System.out.println(e.getErrosString());
        }
    }

    /** N�o deve alterar objeto nulo. */
    @Test
    public void naoDeveAlterarNulo() {
        try {
            Entidade entidade = null;
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
            bean.alterar(new Entidade());
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
            bean.excluir(new Entidade());
            Assert.fail("N�o deve excluir com objeto vazio");
        } catch (NegocioException e) {
            System.out.println(e.getErrosString());
        }
    }

    /** Deve executar os testes em quest�o com sucesso. */
    @Test
    public void grupoCrudEntidade() {
        Entidade entidade = TesteEntidadeUnidade.fabricar();
        entidade.setId(null);
        deveInserirSucesso(entidade);
        devePesquisarPorCodigoSucesso(entidade.getId());
        devePesquisarPorNomeSucesso(entidade.getNome());
        devePesquisarTodosSucesso();
        entidade.setNome(entidade.getNome() + " Alterado");
        deveAlterarSucesso(entidade);
        deveExcluirSucesso(entidade);
    }

    /** Deve inserir com sucesso. */
    private void deveInserirSucesso(Entidade entidade) {
        try {
            bean.inserir(entidade);
        } catch (NegocioException e) {
            Assert.fail("Deveria ter inserido com sucesso - " + e.getErrosString());
        }
    }

    /** Deve alterar com sucesso. */
    private void deveAlterarSucesso(Entidade entidade) {
        try {
            bean.alterar(entidade);
        } catch (NegocioException e) {
            Assert.fail("Deveria ter alterado com sucesso - " + e.getErrosString());
        }
    }

    /** Deve excluir com sucesso. */
    private void deveExcluirSucesso(Entidade entidade) {
        try {
            bean.excluir(entidade);
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
    private void devePesquisarPorNomeSucesso(String nome) {
        try {
            bean.get(nome);
        } catch (NegocioException e) {
            Assert.fail("Deveria pesquisar por c�digo: " + e.getErrosString());
        }
    }
}