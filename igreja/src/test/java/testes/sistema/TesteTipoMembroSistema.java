package testes.sistema;

import javax.inject.Inject;

import org.junit.Assert;
import org.junit.Test;

import sistema.negocio.aplicacao.membro.TipoMembroBean;
import sistema.negocio.dominio.membro.TipoMembro;
import testes.global.AbstractSistema;
import testes.unidade.TesteTipoMembroUnidade;

import com.forj.cirrus.infra.exceptions.NegocioException;

/**
 * Teste de sistema do serviço de <b>TipoMembro</b>.
 * 
 * @version 1.0 - 15/05/2016
 * @since 15/05/2016
 */
public class TesteTipoMembroSistema extends AbstractSistema {

	/** Armazena o objeto serviço a ser testado. **/
	@Inject
	private TipoMembroBean bean;

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
			bean.inserir(null);
			Assert.fail("Não deve inserir com objeto nulo");
		} catch (NegocioException e) {
			System.out.println(e.getErrosString());
		}
	}

	/** Não deve inserir objeto vazio. */
	@Test
	public void naoDeveInserirVazio() {
		try {
			bean.inserir(new TipoMembro());
			Assert.fail("Não deve inserir com objeto vazio");
		} catch (NegocioException e) {
			System.out.println(e.getErrosString());
		}
	}

	/** Não deve alterar objeto nulo. */
	@Test
	public void naoDeveAlterarNulo() {
		try {
			TipoMembro tipoMembro = null;
			bean.alterar(tipoMembro);
			Assert.fail("Não deve alterar com objeto nulo");
		} catch (NegocioException e) {
			System.out.println(e.getErrosString());
		}
	}

	/** Não deve alterar objeto vazio. */
	@Test
	public void naoDeveAlterarVazio() {
		try {
			bean.alterar(new TipoMembro());
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
			bean.excluir(new TipoMembro());
			Assert.fail("Não deve excluir com objeto vazio");
		} catch (NegocioException e) {
			System.out.println(e.getErrosString());
		}
	}

	/** Deve executar os testes em questão com sucesso. */
	@Test
	public void grupoCrudEntidade() {
		TipoMembro tipoMembro = TesteTipoMembroUnidade.fabricar();
		tipoMembro.setId(null);
		deveInserirSucesso(tipoMembro);
		devePesquisarPorCodigoSucesso(tipoMembro.getId());
		devePesquisarPorDescricaoSucesso(tipoMembro.getDescricao());
		devePesquisarTodosSucesso();
		tipoMembro.setDescricao(tipoMembro.getDescricao() + " Alterado");
		deveAlterarSucesso(tipoMembro);
		deveExcluirSucesso(tipoMembro);
	}

	/** Deve inserir com sucesso. */
	private void deveInserirSucesso(TipoMembro tipoMembro) {
		try {
			bean.inserir(tipoMembro);
		} catch (NegocioException e) {
			Assert.fail("Deveria ter inserido com sucesso - "
					+ e.getErrosString());
		}
	}

	/** Deve alterar com sucesso. */
	private void deveAlterarSucesso(TipoMembro tipoMembro) {
		try {
			bean.alterar(tipoMembro);
		} catch (NegocioException e) {
			Assert.fail("Deveria ter alterado com sucesso - "
					+ e.getErrosString());
		}
	}

	/** Deve excluir com sucesso. */
	private void deveExcluirSucesso(TipoMembro tipoMembro) {
		try {
			bean.excluir(tipoMembro);
		} catch (NegocioException e) {
			Assert.fail("Deveria ter excluido com sucesso - "
					+ e.getErrosString());
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