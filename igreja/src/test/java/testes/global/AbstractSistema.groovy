package testes.global;

import javax.annotation.Resource

import org.junit.Assert
import org.junit.Before
import org.junit.runner.RunWith
import org.springframework.test.context.ContextConfiguration
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner
import org.springframework.test.context.transaction.TransactionConfiguration

import com.forj.cirrus.infra.autenticacao.exception.CredencialException
import com.forj.cirrus.infra.exceptions.NegocioException
import com.forj.cirrus.infra.persistencia.RepositorioException
import com.forj.cirrus.infra.persistencia.jdbc.FacadeJdbc
import com.forj.cirrus.infra.testes.Tdd
import com.forj.cirrus.jsf.gui.AbstractCirrusFrm
import com.forj.cirrus.util.Cirrus
import com.forj.cirrus.util.validacao.MsgErro

/**
 * Centralizador de testes genericos de sistema cobrindo operações CRUD.
 * @author Lucas Francisquini
 * @version 1.0 - 05/08/2015
 * @since 05/08/2015
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = [ "spring-junit.xml" ])
@TransactionConfiguration(transactionManager = Cirrus.TRANSACAO, defaultRollback = false)
abstract class AbstractSistema extends Tdd {

	/** Armazena a flag singleton de controle de criação da base. **/
	static def zeraBase = true

	/** Armazena o arquivo de banco de dados. **/
	static final String PATH_SCRIPT = "/testes/global/base.sql"

	/** Gerenciador de persistencia jdbc. **/
	@Resource(name = Cirrus.JDBC)
	protected FacadeJdbc facadeJdbc;

	/** Recria a base a ciclo de testes. */
	@Before
	void zeraBase() {
		if (zeraBase) {
			String script = new File(getClass().getResource(PATH_SCRIPT).getFile()).text
			script.split(";").each {
				owner.facadeJdbc.execute(it + ";")
			}
			zeraBase = false
			mockErrosJSF()
		}
	}

	/**
	 * Testa o serviço de inserir.
	 * @param dominio a ser inserido.
	 */
	void deveInserir(dominio) {
		println ""
		try {
			bean.inserir(dominio)
		} catch (e) {
			Assert.fail("Deve inserir: " + e.message)
		}
	}

	/**
	 * Testa o serviço de inserir.
	 * @param dominio a ser inserido.
	 */
	void naoDeveInserir(dominio) {
		try {
			bean.inserir(dominio)
			Assert.fail("Deve inserir: " + e.message)
		} catch (e) {
			println e.getMessage()
		}
	}

	/**
	 * Testa o serviço de alterar.
	 * @param dominio a ser alterado.
	 */
	void naoDeveAlterar(dominio) {
		try {
			bean.alterar(dominio)
			Assert.fail("Deve alterar: " + e.getMessage())
		} catch (e) {
			e.getMessage()
		}
	}

	/**
	 * Testa o serviço de alterar.
	 * @param dominio a ser alterado.
	 */
	void deveAlterar(dominio) {
		try {
			bean.alterar(dominio)
		} catch (e) {
			Assert.fail("Deve alterar: " + e.getMessage())
		}
	}

	/**
	 * Testa o serviço de deletar.
	 * @param dominio a ser deletado.
	 */
	void deveExcluir(dominio) {
		try {
			bean.excluir(dominio)
		} catch (e) {
			Assert.fail("Deve deletar: " + e.getMessage())
		}
	}

	/** Mocka os erros emitidos em jsf e ajax para o ambiente de testes. **/
	void mockErrosJSF() {
		AbstractCirrusFrm.metaClass {
			gerarErro = { RepositorioException e -> throw e }
			gerarErro = { String e ->  throw new Exception(e) }
			gerarErros = { Exception e -> throw e }
			gerarErros = { NegocioException e -> throw e }
			gerarErros = { String[] e -> throw new Exception(e)}
			gerarErrosRia = { NegocioException e -> throw e }
			gerarErrosRia = { CredencialException e -> throw e }
			gerarErrosRia = { RepositorioException e -> throw e }
			gerarErrosRia = { MsgErro e -> throw new Exception(e.getValidacao()) }
			gerarErrosRia = { String e -> throw new Exception(e) }
			gerarMensagemRia = { String m -> println m }
			gerarMensagem = { String m -> println m }
		}
	}
}