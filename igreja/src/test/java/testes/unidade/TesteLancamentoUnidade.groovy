package testes.unidade

import org.junit.Test

import sistema.negocio.dominio.Lancamento
import testes.global.AbstractUnidade

/**
 * Gerenciador de teste de unidade de {@link Lancamento}.
 * @author Lucas Francisquini
 * @version 1.0 - 30/11/2015
 * @since 30/11/2015
 */
class TesteLancamentoUnidade extends AbstractUnidade {

	/** Deve validar todos os campos obrigat�rio. **/
	@Test
	void deveValidarObrigatorios() {
		validarObrigatorios(new Lancamento())
	}

	/** Deve validar todos os campos com tamanho m�ximo. **/
	@Test
	void deveValidarTamanhoMaximo() {
		validarInvalidos(fabricarTamanhosInvalidos())
	}

	/** Deve validar todos os campos com sucesso. **/
	@Test
	void deveValidarSucesso() {
		validarSucesso(fabricar())
	}

	/**
	 * Fabrica um lan�amento para teste.
	 * @return lan�amento v�lido para teste.
	 */
	static def fabricar() {
		new Lancamento(id: 1, descricao: gerarTexto(20), valor: 100,
		tipoLancamento: Lancamento.LANC_RECEITA, tipoReceita: "D",
		dataInclusao: new Date(), registroMembro: gerarLong(8), status: Lancamento.ATIVO)
	}

	/**
	 * Fabrica um lan�amento inv�lido para teste.
	 * @return lan�amento inv�lido para teste.
	 */
	static def fabricarTamanhosInvalidos() {
		new Lancamento(descricao: gerarTexto(51), valor: gerarLong(11), observacao: gerarTexto(501),
		registroMembro: gerarLong(11))
	}
}