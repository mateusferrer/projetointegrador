package testes.unidade;

import org.junit.runner.RunWith
import org.junit.runners.Suite
import org.junit.runners.Suite.SuiteClasses

/**
 * Suite de testes de unidade da solução.
 * @author Lucas Francisquini
 * @version 1.0 - 27/11/2015
 * @since 27/11/2015
 */
@RunWith(Suite.class)
@SuiteClasses([TesteEntidadeUnidade, TesteCargoEclesiasticoUnidade, TesteMembroUnidade,
	TesteCargoAdministrativoUnidade, TesteTipoEventoUnidade, TesteMembroAdministrativoUnidade,
	TesteSecretariaUnidade, TesteAgendaUnidade, TesteLancamentoUnidade, TesteFiltroLancamentoUnidade,
	TesteFiltroAgendaUnidade])
class SuiteUnidade {
}