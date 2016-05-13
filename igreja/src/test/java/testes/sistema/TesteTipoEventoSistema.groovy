package testes.sistema

import javax.inject.Inject
import javax.inject.Named

import org.junit.Assert
import org.junit.Test

import sistema.negocio.aplicacao.TipoEventoBean
import sistema.negocio.dominio.TipoEvento
import testes.global.AbstractSistema
import testes.unidade.TesteTipoEventoUnidade

/**
 * Teste de sistema do servi�o de <b>TipoEvento</b>.
 * @author Lucas Francisquini
 * @version 1.0 - 27/11/2015
 * @since 27/11/2015
 */
class TesteTipoEventoSistema extends AbstractSistema {

	/** Armazena o objeto servi�o a ser testado. **/
	@Inject
	TipoEventoBean bean

	/**
	 * N�o deve inserir.
	 */
	@Test
	void naoDeveInserir() {
		TipoEvento dominio = new TipoEvento()
		naoDeveInserir(dominio)
		dominio
	}

	/**
	 * N�o deve alterar.
	 */
	@Test
	void naoDeveAlterar() {
		TipoEvento dominio = new TipoEvento()
		naoDeveAlterar(dominio)
		dominio
	}

	/**
	 * Teste de inserir.
	 * @return dominio gravado no banco.
	 */
	def inserir() {
		TipoEvento dominio = TesteTipoEventoUnidade.fabricar();
		deveInserir(dominio)
		dominio
	}

	/**  Agrupador de testes: inserir, alterar e deletar.  */
	@Test
	void grupoCrud() {
		TipoEvento dominio = inserir();
		dominio.descricao += " alterado"
		deveAlterar(dominio)
		deveExcluir(dominio)
	}

	/** Pesquisa todos os registros.  */
	@Test
	void devePesquisarTodos() {
		try {
			println bean.get();
		} catch (e) {
			Assert.fail("Deveria pesquisar todos: " + e.message)
		}
	}
}