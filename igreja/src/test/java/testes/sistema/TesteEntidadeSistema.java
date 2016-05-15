package testes.sistema;

import javax.inject.Inject;
import javax.inject.Named;

import org.junit.Assert;
import org.junit.Test;

import sistema.negocio.aplicacao.entidade.EntidadeBean;
import testes.global.AbstractSistema;

import com.forj.cirrus.infra.exceptions.NegocioException;

/**
 * Teste de sistema do servi�o de <b>Entidade</b>.
 * 
 * @version 1.0 - 15/05/2016
 * @since 15/05/2016
 */
@Named
public class TesteEntidadeSistema extends AbstractSistema {

	/** Armazena o objeto servi�o a ser testado. **/
	@Inject
	private EntidadeBean bean;

	/** Pesquisa todos os registros. */
	@Test
	public void devePesquisarTodos() {
		try {
			bean.get();
		} catch (NegocioException e) {
			Assert.fail("Deveria pesquisar todos: " + e.getErrosString());
		}
	}

	/** N�o deve pesquuisar entidade sem c�digo. */
	@Test
	public void naoDevePesquisarSemCodigo() {
		try {
			bean.getPorCodigo(null);
			Assert.fail("N�o deve pesquisar sem c�digo");
		} catch (NegocioException e) {
			System.out.println(e.getErrosString());
		}
	}

	/** Deve pesquisar por c�digo. */
	@Test
	public void devePesquisarPorCodigo() {
		try {
			bean.getPorCodigo(1);
		} catch (NegocioException e) {
			Assert.fail("Deveria pesquisar por c�digo: " + e.getErrosString());
		}
	}

}