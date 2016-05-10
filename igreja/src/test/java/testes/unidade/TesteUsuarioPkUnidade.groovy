package testes.unidade

import org.junit.Test

import sistema.negocio.dominio.UsuarioPk
import testes.global.AbstractUnidade

/**
 * Gerenciador de teste de unidade de {@link TipoEvento}.
 * @author Lucas Francisquini
 * @version 1.0 - 27/11/2015
 * @since 27/11/2015
 */
class TesteUsuarioPkUnidade extends AbstractUnidade {

	/** Deve validar todos os campos obrigatórios. **/
	@Test
	void deveValidarObrigatorios() {
		validarObrigatorios(new UsuarioPk())
	}

	/** Deve validar todos os campos com tamanho máximo. **/
	@Test
	void deveValidarTamanhoMaximo() {
		UsuarioPk dominio = fabricar()
		dominio.setSenha(gerarTexto(5))
		dominio.setNome(gerarTexto(11))
		validarInvalidos(dominio)
	}

	/** Deve validar todos os campos com sucesso. **/
	@Test
	void deveValidarSucesso() {
		validarSucesso(fabricar())
	}

	/**
	 * Fabrica um usuário válido para teste.
	 * @return usuário válido para teste.
	 */
	static def fabricar() {
		new UsuarioPk(nome: "admin", senha: gerarTexto(4))
	}
}