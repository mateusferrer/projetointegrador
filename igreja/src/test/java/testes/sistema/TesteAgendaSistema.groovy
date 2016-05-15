/**
 * Copyright (c) Uniprime Norte do Paran�. Av Rio de Janeiro 1758 Londrina-PR
 * Brazil. Todos os direitos reservados. Este software cont�m informa��es
 * confidenciais e de propriedade exclusiva da Uniprime Norte do Paran� e n�o
 * deve ser utilizado fora da corpora��o.
 */
package testes.sistema

import javax.inject.Inject
import javax.inject.Named

import org.junit.Assert
import org.junit.Test

import sistema.negocio.aplicacao.AgendaBean
import sistema.negocio.dominio.Agenda
import sistema.negocio.dominio.FiltroAgenda
import sistema.negocio.dominio.evento.TipoEvento;
import testes.global.AbstractSistema
import testes.unidade.TesteAgendaUnidade

/**
 * Teste de sistema do servi�o de <b>Agenda</b>.
 * @author Lucas Francisquini
 * @version 1.0 - 27/11/2015
 * @since 27/11/2015
 */
class TesteAgendaSistema extends AbstractSistema {

	/** Armazena o objeto servi�o a ser testado. **/
	@Inject
	AgendaBean bean

	/** Armazena o teste de tipo de evento. **/
	@Inject
	TesteTipoEventoSistema testeTipo;

	/**
	 * N�o deve inserir.
	 */
	@Test
	void naoDeveInserir() {
		Agenda dominio = new Agenda()
		naoDeveInserir(dominio)
		dominio
	}

	/**
	 * N�o deve alterar.
	 */
	@Test
	void naoDeveAlterar() {
		Agenda dominio = new Agenda()
		naoDeveAlterar(dominio)
		dominio
	}

	/**
	 * Teste de inserir.
	 * @return dominio gravado no banco.
	 */
	def inserir() {
		Agenda dominio = TesteAgendaUnidade.fabricar();
		dominio.id = null
		dominio.tipoEvento = testeTipo.inserir()
		deveInserir(dominio)
		dominio
	}

	/**  Agrupador de testes: inserir, alterar e deletar.  */
	@Test
	void grupoCrud() {
		Agenda dominio = inserir();
		dominio.descricao += " alterado"
		deveAlterar(dominio)
		deveExcluir(dominio)
	}

	/** Deve pesquisar os registros.  */
	@Test
	void devePesquisarTodos() {
		try {
			println bean.get(new FiltroAgenda(tipo: "E"));
		} catch (e) {
			Assert.fail("Deveria pesquisar: " + e.message)
		}
	}
}