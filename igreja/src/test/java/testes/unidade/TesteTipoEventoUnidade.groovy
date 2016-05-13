package testes.unidade

import org.junit.Test

import sistema.negocio.dominio.TipoEvento
import testes.global.AbstractUnidade

/**
 * Gerenciador de teste de unidade de {@link TipoEvento}.
 * 
 * @author Lucas Francisquini
 * @version 1.0 - 27/11/2015
 * @since 27/11/2015
 */
class TesteTipoEventoUnidade extends AbstractUnidade {

	/** Deve validar todos os campos obrigat�rio. **/
	@Test
	void deveValidarObrigatorios() {
		validarObrigatorios(new TipoEvento())
	}

	/** Deve validar todos os campos com tamanho m�ximo. **/
	@Test
	void deveValidarTamanhoMaximo() {
		TipoEvento dominio = fabricar()
		dominio.setDescricao(gerarTexto(51))
		dominio.setUsuario(gerarTexto(11))
		validarInvalidos(dominio)
	}

	/** Deve validar todos os campos com sucesso. **/
	@Test
	void deveValidarSucesso() {
		validarSucesso(fabricar())
	}

	/**
	 * Fabrica um cargo v�lido para teste.
	 * 
	 * @return cargo v�lido para teste.
	 */
	static TipoEvento fabricar() {
		new TipoEvento("Conex�o Jovem", new Date(), new Date(),
				"LFRANCISQU")
	}
}