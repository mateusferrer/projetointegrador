package testes.unidade

import org.junit.Test

import sistema.negocio.dominio.membro.Membro;
import sistema.negocio.enums.Status;
import testes.global.AbstractUnidade

/**
 * Gerenciador de teste de unidade de {@link Membro}.
 * @author Lucas Francisquini
 * @version 1.0 - 26/11/2015
 * @since 26/11/2015
 */
class TesteMembroUnidade extends AbstractUnidade {

	/** Deve validar todos os campos obrigatório. **/
	@Test
	void deveValidarObrigatorios() {
		validarObrigatorios(new Membro())
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
	 * Fabrica um membro válido para teste.
	 * @return membro válido para teste.
	 */
	static def fabricar() {
		//        new Membro(nome: gerarTexto(50), rg: gerarTexto(9), cpf: gerarTexto(11), cep: gerarLong(8),
		//			endereco: gerarTexto(100), gerarInteger(5), estado: , cidade, email, telefone, celular, status, motivo, entidade, tipo, sexo, dataInclusao, dataAlteracao, usuario)
	}

	/**
	 * Fabrica um membro inválido para teste.
	 * @return membro inválido para teste.
	 */
	static def fabricarTamanhoInvalido() {
		new Membro(nome: gerarTexto(120), cpf: gerarLong(12).toString(), cep: gerarLong(10),
		logradouro: gerarTexto(120), numLogradouro: gerarInteger(8), estado: gerarTexto(60),
		cidade: gerarTexto(60), email: gerarTexto(120), telefone: gerarTexto(20),
		celular: gerarTexto(20), sexo: "MM", dataNascimento: new Date(), dataBatismo: new Date(),
		dataCadastro: new Date(), registroBatismo: gerarLong(5), status: Status.A,
		cargo: TesteCargoEclesiasticoUnidade.fabricar(), igreja: TesteEntidadeUnidade.fabricar())
	}
}