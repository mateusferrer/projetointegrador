package testes.sistema;

import javax.inject.Inject;

import org.junit.Assert;
import org.junit.Test;

import sistema.negocio.aplicacao.membro.MembroBean;
import testes.global.AbstractSistema;

import com.forj.cirrus.infra.exceptions.NegocioException;

/**
 * Teste de sistema do serviço de <b>Membro</b>.
 * 
 * @version 1.0 - 16/05/2016
 * @since 16/05/2016
 */
public class TesteMembroSistema extends AbstractSistema {

	/** Armazena o objeto serviço a ser testado. **/
	@Inject
	private MembroBean membroBean;

	/** Deve pesquisar por nome. */
	@Test
	public void devePesquisarTodos() {
		try {
			membroBean.get("");
		} catch (NegocioException e) {
			Assert.fail("Deveria pesquisar por nome: " + e.getErrosString());
		}
	}

	/** Deve pesquisar por nome. */
	@Test
	public void devePesquisarPorNome() {
		try {
			membroBean.get("Lucas");
		} catch (NegocioException e) {
			Assert.fail("Deveria pesquisar por nome: " + e.getErrosString());
		}
	}

}