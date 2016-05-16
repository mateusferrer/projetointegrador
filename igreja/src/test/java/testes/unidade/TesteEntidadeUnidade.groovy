package testes.unidade;

import org.junit.Test

import sistema.negocio.dominio.entidade.Entidade;
import sistema.negocio.enums.TipoEntidade;
import testes.global.AbstractUnidade

/**
 * Gerenciador de teste de unidade de {@link Entidade}.
 * @version 1.0 - 15/05/2016
 * @since 15/05/2016
 */
class TesteEntidadeUnidade extends AbstractUnidade {

	/** Deve validar todos os campos obrigatório. **/
	@Test
	void deveValidarObrigatorios() {
		validarObrigatorios(new Entidade())
	}

	/** Deve validar todos os campos com tamanho máximo. **/
	@Test
	void deveValidarTamanhoMaximo() {
		validarInvalidos(fabricarInvalido())
	}

	/** Deve validar todos os campos com sucesso. **/
	@Test
	void deveValidarSucesso() {
		validarSucesso(fabricar())
	}

	/**
	 * Fabrica uma entidade válida para teste.
	 * @return entidade válida para teste.
	 */
	static Entidade fabricar() {
		new Entidade(razao: "Lucas Francisquini", fantasia: "IGREJA BATISTA DE LONDRINA",
		cnpj: gerarLong(14).toString(), cep: gerarLong(8),
		endereco: "R. da Entidade", numero: gerarLong(3), estado: "PR", cidade: "Londrina",
		email: "entidade@crista.com.br", telefone: gerarLong(11).toString(),
		tipo: TipoEntidade.M, matriz: null)
	}

	/**
	 * Fabrica uma entidade inválida para teste.
	 * @return entidade inválida para teste.
	 */
	static Entidade fabricarInvalido() {
		new Entidade(razao: gerarTexto(101), fantasia: gerarTexto(101),
		cnpj: gerarLong(15).toString(), cep: gerarLong(9),
		endereco: gerarTexto(101), numero: gerarLong(6), estado: gerarTexto(3), cidade: gerarTexto(51),
		email: gerarTexto(101), telefone: gerarLong(12).toString(),
		tipo: TipoEntidade.M, matriz: null)
	}
}