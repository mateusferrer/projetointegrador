package testes.sistema;

import javax.inject.Inject;
import javax.inject.Named;

import org.junit.Assert;
import org.junit.Test;

import sistema.negocio.aplicacao.membro.MembroBean;
import sistema.negocio.dominio.membro.Membro;
import testes.global.AbstractSistema;
import testes.unidade.TesteMembroUnidade;

import com.forj.cirrus.infra.exceptions.NegocioException;

/**
 * Teste de sistema do serviço de <b>Membro</b>.
 * @version 1.0 - 16/05/2016
 * @since 16/05/2016
 */
@Named
public class TesteMembroSistema extends AbstractSistema {

	/** Armazena o gerenciador dos processos de negócio. **/
	@Inject
	private MembroBean membroBean;

	/** Armazena o gerenciador de teste de Entidade. **/
	@Inject
	private TesteEntidadeSistema testeEntidade;

	/** Armazena o gerenciador de teste do Tipo de Membro. **/
	@Inject
	private TesteTipoMembroSistema testeTipoMembro;

	/** Não deve pesquisar com código nulo. */
	@Test
	public void naoDevePesquisarComCodigoNulo() {
		try {
			membroBean.getPorCodigo(null);
			Assert.fail("Não deve pesquisar com código nulo");
		} catch (NegocioException e) {
			System.out.println(e.getErrosString());
		}
	}

	/** Não deve inserir objeto nulo. */
	@Test
	public void naoDeveInserirNulo() {
		try {
			Membro membro = new Membro();
			membroBean.inserir(membro);
			Assert.fail("Não deve inserir com objeto nulo");
		} catch (NegocioException e) {
			System.out.println(e.getErrosString());
		}
	}

	/** Não deve inserir objeto vazio. */
	@Test
	public void naoDeveInserirVazio() {
		try {
			Membro membro = new Membro();
			membroBean.inserir(membro);
			Assert.fail("Não deve inserir com objeto vazio");
		} catch (NegocioException e) {
			System.out.println(e.getErrosString());
		}
	}

	/** Não deve alterar objeto nulo. */
	@Test
	public void naoDeveAlterarNulo() {
		try {
			Membro membro = null;
			membroBean.alterar(membro);
			Assert.fail("Não deve alterar com objeto nulo");
		} catch (NegocioException e) {
			System.out.println(e.getErrosString());
		}
	}

	/** Não deve alterar objeto vazio. */
	@Test
	public void naoDeveAlterarVazio() {
		try {
			Membro membro = new Membro();
			membroBean.alterar(membro);
			Assert.fail("Não deve alterar com objeto vazio");
		} catch (NegocioException e) {
			System.out.println(e.getErrosString());
		}
	}

	/** Não deve excluir objeto nulo. */
	@Test
	public void naoDeveExcluirNulo() {
		try {
			Membro membro = null;
			membroBean.excluir(membro);
			Assert.fail("Não deve excluir com objeto nulo");
		} catch (NegocioException e) {
			System.out.println(e.getErrosString());
		}
	}

	/** Não deve excluir objeto vazio. */
	@Test
	public void naoDeveExcluirVazio() {
		try {
			Membro membro = new Membro();
			membroBean.excluir(membro);
			Assert.fail("Não deve excluir com objeto vazio");
		} catch (NegocioException e) {
			System.out.println(e.getErrosString());
		}
	}

	/** Deve executar os testes em questão com sucesso. */
	@Test
	public void grupoCrudMembro() {
		Membro membro = TesteMembroUnidade.fabricar();
		membro.setId(null);
		membro.getEntidade().setId(null);
		membro.getTipo().setId(null);
		testeTipoMembro.deveInserirSucesso(membro.getTipo());
		testeEntidade.deveInserirSucesso(membro.getEntidade());
		deveInserirSucesso(membro);
		devePesquisarPorCodigoSucesso(membro.getId());
		devePesquisarPorNomeSucesso(membro.getNome());
		devePesquisarTodosSucesso();
		membro.setNome(membro.getNome() + " Alterado");
		deveAlterarSucesso(membro);
		deveExcluirSucesso(membro);
	}

	/** Deve inserir com sucesso. */
	public Membro deveInserirSucesso(Membro membro) {
		try {
			membroBean.inserir(membro);
		} catch (NegocioException e) {
			Assert.fail("Deveria ter inserido com sucesso - "
					+ e.getErrosString());
		}
		return membro;
	}

	/** Deve alterar com sucesso. */
	private void deveAlterarSucesso(Membro membro) {
		try {
			membroBean.alterar(membro);
		} catch (NegocioException e) {
			Assert.fail("Deveria ter alterado com sucesso - "
					+ e.getErrosString());
		}
	}

	/** Deve excluir com sucesso. */
	private void deveExcluirSucesso(Membro membro) {
		try {
			membroBean.excluir(membro);
		} catch (NegocioException e) {
			Assert.fail("Deveria ter excluido com sucesso - "
					+ e.getErrosString());
		}
	}

	/** Pesquisa todos os registros. */
	private void devePesquisarPorCodigoSucesso(Long codigo) {
		try {
			membroBean.getPorCodigo(codigo);
		} catch (NegocioException e) {
			Assert.fail("Deveria pesquisar por código: " + e.getErrosString());
		}
	}

	/** Pesquisa todos os registros. */
	private void devePesquisarTodosSucesso() {
		try {
			membroBean.get(null);
		} catch (NegocioException e) {
			Assert.fail("Deveria pesquisar todos: " + e.getErrosString());
		}
	}

	/** Deve pesquisar por código. */
	private void devePesquisarPorNomeSucesso(String nome) {
		try {
			membroBean.get(nome);
		} catch (NegocioException e) {
			Assert.fail("Deveria pesquisar por código: " + e.getErrosString());
		}
	}
}