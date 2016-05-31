package testes.sistema;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

/**
 * Suite de testes de sistema da solução.
 * @version 1.0 - 30/05/2016
 * @since 27/11/2015
 */
@RunWith(Suite.class)
@SuiteClasses({ TesteEntidadeSistema.class, TesteCampanhaSistema.class, TesteTipoMembroSistema.class,
        TesteMembroSistema.class, TesteCampanhaSistema.class })
public class SuiteSistema {
}