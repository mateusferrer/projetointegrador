package testes.sistema;

import javax.inject.Inject;

import org.junit.Assert;
import org.junit.Test;

import sistema.negocio.aplicacao.membro.TipoMembroBeanImp;
import testes.global.AbstractSistema;

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
	private TipoMembroBeanImp tipoBean;

	/** Pesquisa todos os registros. */
	@Test
	public void devePesquisarTodos() {
		try {
			tipoBean.get();
		} catch (NegocioException e) {
			Assert.fail("Deveria pesquisar todos: " + e.getErrosString());
		}
	}

}