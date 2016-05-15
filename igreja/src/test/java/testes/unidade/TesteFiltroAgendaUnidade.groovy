package testes.unidade

import org.junit.Test

import sistema.negocio.dominio.FiltroAgenda
import sistema.negocio.dominio.FiltroLancamento
import sistema.negocio.dominio.evento.TipoEvento;
import testes.global.AbstractUnidade

/**
 * Gerenciador de teste de unidade de {@link FiltroAgenda}.
 * @author Lucas Francisquini
 * @version 1.0 - 05/12/2015
 * @since 05/12/2015
 */
class TesteFiltroAgendaUnidade extends AbstractUnidade {

	/** Deve validar todos os campos obrigatório. **/
	@Test
	void deveValidarObrigatorios() {
		validarObrigatorios(new FiltroAgenda())
	}

	/** Deve validar todos os campos com sucesso. **/
	@Test
	void deveValidarSucesso() {
		validarSucesso(fabricar())
	}

	/**
	 * Fabrica um cargo válido para teste.
	 * @return cargo válido para teste.
	 */
	static def fabricar() {
		new FiltroAgenda(tipo: "E")
	}
}