package testes.unidade;

import org.junit.runner.RunWith
import org.junit.runners.Suite
import org.junit.runners.Suite.SuiteClasses

import testes.sistema.TesteTipoMembroSistema;

/**
 * Suite de testes de unidade da solução.
 * @version 1.0 - 27/11/2015
 * @since 27/11/2015
 */
@RunWith(Suite.class)
@SuiteClasses([TesteEntidadeUnidade, TesteMembroUnidade, TesteTipoEventoUnidade])
class SuiteUnidade {
}