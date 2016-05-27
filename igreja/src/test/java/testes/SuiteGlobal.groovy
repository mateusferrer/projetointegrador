package testes;

import org.junit.runner.RunWith
import org.junit.runners.Suite
import org.junit.runners.Suite.SuiteClasses

import testes.sistema.SuiteSistema
import testes.unidade.SuiteUnidade
import testes.visao.SuiteVisao

/**
 * Suite de testes global da solução.
 * @author Lucas Francisquini
 * @version 1.0 - 27/11/2015
 * @since 27/11/2015
 */
@RunWith(Suite)
@SuiteClasses([SuiteUnidade, SuiteSistema])
class SuiteGlobal {
}