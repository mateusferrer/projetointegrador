package testes.unidade

import org.junit.Test

import sistema.negocio.dominio.Usuario
import testes.global.AbstractUnidade

/**
 * Gerenciador de teste de unidade de {@link TipoEvento}.
 * @author Lucas Francisquini
 * @version 1.0 - 27/11/2015
 * @since 27/11/2015
 */
class TesteUsuarioUnidade extends AbstractUnidade {

	/** Deve validar todos os campos obrigat�rios. **/
	@Test
	void deveValidarObrigatorios() {
		validarObrigatorios(new Usuario())
	}

	/** Deve validar todos os campos com tamanho m�ximo. **/
	@Test
	void deveValidarTamanhoMaximo() {
		Usuario dominio = fabricar()
		dominio.setPk(TesteUsuarioPkUnidade.fabricar())
		validarInvalidos(dominio)
	}

	/** Deve validar todos os campos com sucesso. **/
	@Test
	void deveValidarSucesso() {
		validarSucesso(fabricar())
	}

	/**
	 * Fabrica um usu�rio v�lido para teste.
	 * @return usu�rio v�lido para teste.
	 */
	static def fabricar() {
		new Usuario()
	}
}