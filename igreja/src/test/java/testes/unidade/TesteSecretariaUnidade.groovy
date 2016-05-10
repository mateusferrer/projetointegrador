package testes.unidade

import org.junit.Test

import sistema.negocio.dominio.Membro
import sistema.negocio.dominio.MembroAdministrativo
import sistema.negocio.dominio.Secretaria
import testes.global.AbstractUnidade

/**
 * Gerenciador de teste de unidade de {@link Secretaria}.
 * @author Lucas Francisquini
 * @version 1.0 - 27/11/2015
 * @since 27/11/2015
 */
class TesteSecretariaUnidade extends AbstractUnidade {

    /** Deve validar todos os campos obrigatório. **/
    @Test
    void deveValidarObrigatorios() {
        validarObrigatorios(new Secretaria())
    }

    /** Deve validar todos os campos com sucesso. **/
    @Test
    void deveValidarSucesso() {
        validarSucesso(fabricar())
    }

    /**
     * Fabrica um membro administrativo válido para teste.
     * @return membro administrativo válido para teste.
     */
    static def fabricar() {
        new Secretaria(id: 1, dataInicio: new Date(), igrejaResponsavel: TesteIgrejaUnidade.fabricar(),
        pastorResponsavel: TesteMembroUnidade.fabricar())
    }
}