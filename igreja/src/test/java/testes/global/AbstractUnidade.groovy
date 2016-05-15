package testes.global

import org.junit.Assert

import com.forj.cirrus.infra.testes.Tdd

/**
 * Centralizador de testes genéricos de unidades cobrindo operações CRUD.
 * @author Lucas Francisquini
 * @version 1.0 - 05/08/2015
 * @since 05/08/2015
 */
abstract class AbstractUnidade extends Tdd {

	/**
	 * Valida os campos obrigatórios de um dominio.
	 * @param dominio a ser validado.
	 */
	void validarObrigatorios(dominio) {
		try {
			dominio.validar()
			Assert.fail "Deve validar campos obrigatórios."
		} catch ( e) {
			println e.errosString
		}
	}

	/**
	 * Valida os campos inválidos de um dominio.
	 * @param dominio a ser validado.
	 */
	void validarInvalidos(dominio) {
		try {
			dominio.validar()
			Assert.fail "Deve validar campos inválidos."
		} catch ( e) {
			println e.errosString
		}
	}

	/**
	 * Valida os campos com sucesso.
	 * @param dominio a ser validado.
	 */
	void validarSucesso(dominio) {
		try {
			dominio.validar()
		} catch ( e) {
			Assert.fail "Deveria validar com sucesso : " + e.errosString
		}
	}
}