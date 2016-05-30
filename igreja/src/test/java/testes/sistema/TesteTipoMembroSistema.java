package testes.sistema;

import javax.inject.Inject;
import javax.inject.Named;

import org.junit.Assert;
import org.junit.Test;

import sistema.negocio.aplicacao.membro.TipoMembroBean;
import sistema.negocio.dominio.membro.TipoMembro;
import testes.global.AbstractSistema;
import testes.unidade.TesteTipoMembroUnidade;

import com.forj.cirrus.infra.exceptions.NegocioException;

/**
 * Teste de sistema do servi�o de <b>TipoMembro</b>.
 * 
 * @version 1.0 - 15/05/2016
 * @since 15/05/2016
 */
@Named
public class TesteTipoMembroSistema extends AbstractSistema {

	/** Armazena o objeto servi�o a ser testado. **/
	@Inject
	private TipoMembroBean tipoMembroBean;

	/** N�o deve pesquisar com c�digo nulo. */
	@Test
	public void naoDevePesquisarComCodigoNulo() {
		try {
			tipoMembroBean.getPorCodigo(null);
			Assert.fail("N�o deve pesquisar com c�digo nulo");
		} catch (NegocioException e) {
			System.out.println(e.getErrosString());
		}
	}

	/** N�o deve inserir objeto nulo. */
	@Test
	public void naoDeveInserirNulo() {
		try {
			TipoMembro tipoMembro = null;
			tipoMembroBean.inserir(tipoMembro);
			Assert.fail("N�o deve inserir com objeto nulo");
		} catch (NegocioException e) {
			System.out.println(e.getErrosString());
		}
	}

	/** N�o deve inserir objeto vazio. */
	@Test
	public void naoDeveInserirVazio() {
		try {
			TipoMembro tipoMembro = new TipoMembro();
			tipoMembroBean.inserir(tipoMembro);
			Assert.fail("N�o deve inserir com objeto vazio");
		} catch (NegocioException e) {
			System.out.println(e.getErrosString());
		}
	}

	/** N�o deve alterar objeto nulo. */
	@Test
	public void naoDeveAlterarNulo() {
		try {
			TipoMembro tipoMembro = null;
			tipoMembroBean.alterar(tipoMembro);
			Assert.fail("N�o deve alterar com objeto nulo");
		} catch (NegocioException e) {
			System.out.println(e.getErrosString());
		}
	}

	/** N�o deve alterar objeto vazio. */
	@Test
	public void naoDeveAlterarVazio() {
		try {
			TipoMembro tipoMembro = new TipoMembro();
			tipoMembroBean.alterar(tipoMembro);
			Assert.fail("N�o deve alterar com objeto vazio");
		} catch (NegocioException e) {
			System.out.println(e.getErrosString());
		}
	}

	/** N�o deve excluir objeto nulo. */
	@Test
	public void naoDeveExcluirNulo() {
		try {
			TipoMembro tipoMembro = new TipoMembro();
			tipoMembroBean.excluir(tipoMembro);
			Assert.fail("N�o deve excluir com objeto nulo");
		} catch (NegocioException e) {
			System.out.println(e.getErrosString());
		}
	}

	/** N�o deve excluir objeto vazio. */
	@Test
	public void naoDeveExcluirVazio() {
		try {
			TipoMembro tipoMembro = new TipoMembro();
			tipoMembroBean.excluir(tipoMembro);
			Assert.fail("N�o deve excluir com objeto vazio");
		} catch (NegocioException e) {
			System.out.println(e.getErrosString());
		}
	}

	/** Deve executar os testes em quest�o com sucesso. */
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
	public TipoMembro deveInserirSucesso(TipoMembro tipoMembro) {
		try {
			tipoMembroBean.inserir(tipoMembro);
		} catch (NegocioException e) {
			Assert.fail("Deveria ter inserido com sucesso - "
					+ e.getErrosString());
		}
		return tipoMembro;
	}

	/** Deve alterar com sucesso. */
	private void deveAlterarSucesso(TipoMembro tipoMembro) {
		try {
			tipoMembroBean.alterar(tipoMembro);
		} catch (NegocioException e) {
			Assert.fail("Deveria ter alterado com sucesso - "
					+ e.getErrosString());
		}
	}

	/** Deve excluir com sucesso. */
	private void deveExcluirSucesso(TipoMembro tipoMembro) {
		try {
			tipoMembroBean.excluir(tipoMembro);
		} catch (NegocioException e) {
			Assert.fail("Deveria ter excluido com sucesso - "
					+ e.getErrosString());
		}
	}

	/** Pesquisa todos os registros. */
	private void devePesquisarPorCodigoSucesso(Long codigo) {
		try {
			tipoMembroBean.getPorCodigo(codigo);
		} catch (NegocioException e) {
			Assert.fail("Deveria pesquisar por c�digo: " + e.getErrosString());
		}
	}

	/** Pesquisa todos os registros. */
	private void devePesquisarTodosSucesso() {
		try {
			tipoMembroBean.get(null);
		} catch (NegocioException e) {
			Assert.fail("Deveria pesquisar todos: " + e.getErrosString());
		}
	}

	/** Deve pesquisar por c�digo. */
	private void devePesquisarPorDescricaoSucesso(String descricao) {
		try {
			tipoMembroBean.get(descricao);
		} catch (NegocioException e) {
			Assert.fail("Deveria pesquisar por c�digo: " + e.getErrosString());
		}
	}

}