package testes.sistema;

import javax.inject.Inject;

import org.junit.Assert;
import org.junit.Test;

import sistema.negocio.aplicacao.evento.TipoEventoBean;
import testes.global.AbstractSistema;

import com.forj.cirrus.infra.exceptions.NegocioException;

/**
 * Teste de sistema do serviço de <b>TipoEvento</b>.
 * 
 * @author Lucas Francisquini
 * @version 1.0 - 27/11/2015
 * @since 27/11/2015
 */
public class TesteTipoEventoSistema extends AbstractSistema {

	/** Armazena o objeto serviço a ser testado. **/
	@Inject
	private TipoEventoBean tipoBean;

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