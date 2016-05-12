package testes.unidade

import org.junit.Test

import com.forj.cirrus.negocio.dominio.servicos.Dominio;

import sistema.negocio.dominio.CargoEclesiastico
import sistema.negocio.dominio.Congregacao
import sistema.negocio.dominio.Membro
import testes.global.AbstractUnidade

/**
 * Gerenciador de teste de unidade de {@link CargoEclesiastico}.
 * @author Lucas Francisquini
 * @version 1.0 - 26/11/2015
 * @since 26/11/2015
 */
class TesteCargoEclesiasticoUnidade extends AbstractUnidade {

    /** Deve validar todos os campos obrigatório. **/
    @Test
    void deveValidarObrigatorios() {
        validarObrigatorios(new CargoEclesiastico())
    }

    /** Deve validar todos os campos com tamanho máximo. **/
    @Test
    void deveValidarTamanhoMaximo() {
        CargoEclesiastico dominio = fabricar()
        dominio.setDescricao(gerarTexto(52))
        validarInvalidos(dominio)
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
        new CargoEclesiastico(id: 10, descricao: gerarTexto(40))
    }
}