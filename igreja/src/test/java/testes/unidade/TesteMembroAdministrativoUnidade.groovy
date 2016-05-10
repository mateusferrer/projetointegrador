package testes.unidade

import org.junit.Test

import sistema.negocio.dominio.Membro
import sistema.negocio.dominio.MembroAdministrativo
import testes.global.AbstractUnidade

/**
 * Gerenciador de teste de unidade de {@link MembroAdministrativo}.
 * @author Lucas Francisquini
 * @version 1.0 - 27/11/2015
 * @since 27/11/2015
 */
class TesteMembroAdministrativoUnidade extends AbstractUnidade {

    /** Deve validar todos os campos obrigat�rio. **/
    @Test
    void deveValidarObrigatorios() {
        validarObrigatorios(new MembroAdministrativo())
    }

    /** Deve validar todos os campos com tamanho m�ximo. **/
    @Test
    void deveValidarTamanhoMaximo() {
        validarInvalidos(fabricarTamanhoInvalido())
    }

    /** Deve validar todos os campos com sucesso. **/
    @Test
    void deveValidarSucesso() {
        validarSucesso(fabricar())
    }

    /**
     * Fabrica um membro administrativo v�lido para teste.
     * @return membro administrativo v�lido para teste.
     */
    static def fabricar() {
        new MembroAdministrativo(id: 1, membro: TesteMembroUnidade.fabricar(),
        cargo: TesteCargoAdministrativoUnidade.fabricar(), posicao: gerarTexto(20))
    }

    /**
     * Fabrica um membro administrativo inv�lido para teste.
     * @return membro administrativo inv�lido para teste.
     */
    static def fabricarTamanhoInvalido() {
        new MembroAdministrativo(membro: TesteMembroUnidade.fabricar(),
        cargo: TesteCargoAdministrativoUnidade.fabricar(), posicao: gerarTexto(52))
    }
}