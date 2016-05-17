package testes.unidade

import org.junit.Test

import sistema.negocio.dominio.evento.TipoEvento;
import sistema.negocio.dominio.membro.TipoMembro
import testes.global.AbstractUnidade


/**
 * Gerenciador de teste de unidade de {@link TipoMembro}.
 * @version 1.0 - 16/05/2016
 * @since 16/05/2016
 */
class TesteTipoMembroUnidade extends AbstractUnidade {

	/** Deve validar todos os campos obrigatório. **/
	@Test
	void deveValidarObrigatorios() {
		validarObrigatorios(new TipoMembro())
	}

	/** Deve validar todos os campos com tamanho máximo. **/
	@Test
	void deveValidarTamanhoMaximo() {
		TipoMembro dominio = fabricar()
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
	 * Fabrica um tipo de membro válido para teste.
	 * @return tipo membro válido para teste.
	 */
	static TipoMembro fabricar() {
		new TipoMembro("Pastor", new Date(), new Date(),
				"LFRANCISQU")
	}
}