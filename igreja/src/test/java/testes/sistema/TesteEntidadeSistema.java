package testes.sistema;

import javax.inject.Inject;
import javax.inject.Named;

import org.junit.Assert;
import org.junit.Test;

import sistema.negocio.aplicacao.entidade.EntidadeBean;
import testes.global.AbstractSistema;

import com.forj.cirrus.infra.exceptions.NegocioException;

/**
 * Teste de sistema do serviço de <b>Entidade</b>.
 * 
 * @version 1.0 - 15/05/2016
 * @since 15/05/2016
 */
@Named
public class TesteEntidadeSistema extends AbstractSistema {

	/** Armazena o objeto serviço a ser testado. **/
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

	/** Não deve pesquuisar entidade sem código. */
	@Test
	public void naoDevePesquisarSemCodigo() {
		try {
			bean.getPorCodigo(null);
			Assert.fail("Não deve pesquisar sem código");
		} catch (NegocioException e) {
			System.out.println(e.getErrosString());
		}
	}

	/** Deve pesquisar por código. */
	@Test
	public void devePesquisarPorCodigo() {
		try {
			bean.getPorCodigo(1);
		} catch (NegocioException e) {
			Assert.fail("Deveria pesquisar por código: " + e.getErrosString());
		}
	}

}