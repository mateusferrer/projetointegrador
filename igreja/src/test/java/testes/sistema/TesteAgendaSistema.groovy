/**
 * Copyright (c) Uniprime Norte do Paranï¿½. Av Rio de Janeiro 1758 Londrina-PR
 * Brazil. Todos os direitos reservados. Este software contï¿½m informaï¿½ï¿½es
 * confidenciais e de propriedade exclusiva da Uniprime Norte do Paranï¿½ e nï¿½o
 * deve ser utilizado fora da corporaï¿½ï¿½o.
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
 * Teste de sistema do serviço de <b>Agenda</b>.
 * @author Lucas Francisquini
 * @version 1.0 - 27/11/2015
 * @since 27/11/2015
 */
class TesteAgendaSistema extends AbstractSistema {

	/** Armazena o objeto serviço a ser testado. **/
	@Inject
	AgendaBean bean

	/** Armazena o teste de tipo de evento. **/
	@Inject
	TesteTipoEventoSistema testeTipo;

	/**
	 * Não deve inserir.
	 */
	@Test
	void naoDeveInserir() {
		Agenda dominio = new Agenda()
		naoDeveInserir(dominio)
		dominio
	}

	/**
	 * Não deve alterar.
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