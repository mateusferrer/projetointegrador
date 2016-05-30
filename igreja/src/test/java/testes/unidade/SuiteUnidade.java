package testes.unidade;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

/**
 * Suite de testes de unidade da solução.
 * 
 * @version 1.0 - 29/05/2016
 * @since 16/05/2016
 */
@RunWith(Suite.class)
@SuiteClasses({ TesteEntidadeUnidade.class, TesteTipoMembroUnidade.class,
		TesteMembroUnidade.class, TesteCampanhaUnidade.class })
public class SuiteUnidade {
}