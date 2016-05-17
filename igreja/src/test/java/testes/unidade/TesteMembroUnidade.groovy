package testes.unidade

import org.junit.Test

import sistema.negocio.dominio.membro.Membro
import sistema.negocio.enums.Estado
import sistema.negocio.enums.Sexo
import sistema.negocio.enums.Status
import testes.global.AbstractUnidade

/**
 * Gerenciador de teste de unidade de {@link Membro}.
 * @version 1.0 - 16/05/2016
 * @since 16/05/2016
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
		Membro membro = fabricar()
		membro.entidade.id = 1
		membro.tipo.id = 1
		validarSucesso(membro)
	}

	/**
	 * Fabrica um membro válido para teste.
	 * @return membro válido para teste.
	 */
	static def fabricar() {
		new Membro(nome: gerarTexto(50), rg: gerarTexto(9), cpf: gerarTexto(11), cep: gerarLong(8),
		endereco: gerarTexto(100), numero: gerarInteger(5), estado: Estado.PR.toString(), cidade: gerarTexto(50),
		email: gerarTexto(100), telefone: gerarTexto(11), celular: gerarTexto(11), status: Status.A,
		motivo: gerarTexto(500), entidade: TesteEntidadeUnidade.fabricar(),
		tipo: TesteTipoMembroUnidade.fabricar(), sexo: Sexo.M, dataInclusao: new Date(),
		dataAlteracao: new Date(), usuario: gerarTexto(10))
	}

	/**
	 * Fabrica um membro inválido para teste.
	 * @return membro inválido para teste.
	 */
	static def fabricarTamanhoInvalido() {
		new Membro(nome: gerarTexto(51), rg: gerarTexto(10), cpf: gerarTexto(12), cep: gerarLong(9),
		endereco: gerarTexto(101), numero: gerarInteger(6), estado: null, cidade: gerarTexto(51),
		email: gerarTexto(101), telefone: gerarTexto(12), celular: gerarTexto(12), status: null,
		motivo: gerarTexto(501), entidade: null, tipo: null, sexo: null, dataInclusao: new Date(),
		dataAlteracao: null, usuario: gerarTexto(11))
	}
}