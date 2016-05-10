package testes.unidade

import org.junit.Test

import sistema.negocio.dominio.FiltroLancamento
import sistema.negocio.dominio.TipoEvento
import testes.global.AbstractUnidade

/**
 * Gerenciador de teste de unidade de {@link FiltroLancamento}.
 * @author Lucas Francisquini
 * @version 1.0 - 27/11/2015
 * @since 27/11/2015
 */
class TesteFiltroLancamentoUnidade extends AbstractUnidade {

    /** Deve validar todos os campos obrigatório. **/
    @Test
    void deveValidarObrigatorios() {
        validarObrigatorios(new FiltroLancamento())
    }

    /** Deve validar todos os campos com sucesso. **/
    @Test
    void deveValidarSucesso() {
        validarSucesso(fabricar())
    }

    /**
     * Fabrica um cargo válido para teste.
     * @return cargo válido para teste.
     */
    static def fabricar() {
        new FiltroLancamento(status: "A", tipoLancamento: "R")
    }
}