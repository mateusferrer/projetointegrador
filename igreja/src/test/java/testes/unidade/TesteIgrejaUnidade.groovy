package testes.unidade

import org.junit.Test

import sistema.negocio.dominio.Cidade
import sistema.negocio.dominio.Estado
import sistema.negocio.dominio.Congregacao
import sistema.negocio.dominio.TipoIgreja
import testes.global.AbstractUnidade

/**
 * Gerenciador de teste de unidade de {@link Igreja}.
 * @author Lucas Francisquini
 * @version 1.0 - 26/11/2015
 * @since 26/11/2015
 */
class TesteIgrejaUnidade extends AbstractUnidade {

	/** Deve validar todos os campos obrigatório. **/
	@Test
	void deveValidarObrigatorios() {
		validarObrigatorios(new Congregacao())
	}

	/** Deve validar igreja obrigatória. **/
	@Test
	void deveValidarFilial() {
		Congregacao igreja = fabricar()
		igreja.setTipo(TipoIgreja.FILIAL)
		validarObrigatorios(igreja)
	}

	/** Deve validar todos os campos com tamanho máximo. **/
	@Test
	void deveValidarTamanhoMaximo() {
		validarInvalidos(fabricarTamanhoInvalido())
	}

	/** Deve validar todos os campos com sucesso. **/
	@Test
	void deveValidarSucesso() {
		validarSucesso(fabricar())
	}

	/**
	 * Fabrica um log válido para teste.
	 * @return log válido para teste.
	 */
	static def fabricar() {
		new Congregacao(razao: "Wagner Soares", fantasia: "Luz do Mundo", cnpj: gerarTexto(14), logradouro: gerarTexto(30),
		numLogradouro: gerarInteger(5), tipo: TipoIgreja.MATRIZ, cidade: new Cidade(id: 1), estado: new Estado(id: 1),
		cep: gerarLong(8), telefone: gerarTexto(10))
	}

	/**
	 * Fabrica um log inválido para teste.
	 * @return log inválido para teste.
	 */
	static def fabricarTamanhoInvalido() {
		new Congregacao(razao: gerarTexto(101), fantasia: gerarTexto(101), cnpj: gerarTexto(15), logradouro: gerarTexto(101),
		numLogradouro: gerarInteger(6), tipo: TipoIgreja.MATRIZ, cidade: new Cidade(), estado: new Estado(),
		cep: gerarLong(10), telefone: gerarTexto(12))
	}
}