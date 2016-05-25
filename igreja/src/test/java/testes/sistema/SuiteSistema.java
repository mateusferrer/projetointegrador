package testes.sistema;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

/**
 * Suite de testes de sistema da solução.
 * @author Lucas Francisquini
 * @version 1.0 - 27/11/2015
 * @since 27/11/2015
 */
@RunWith(Suite.class)
@SuiteClasses({ TesteEntidadeSistema.class, TesteCampanhaSistema.class })
public class SuiteSistema {
}