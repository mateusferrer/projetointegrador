package testes.unidade

import org.junit.Test

import com.forj.cirrus.negocio.dominio.servicos.Dominio;

import sistema.negocio.dominio.CargoAdministrativo
import sistema.negocio.dominio.CargoEclesiastico
import sistema.negocio.dominio.Congregacao
import sistema.negocio.dominio.Membro
import testes.global.AbstractUnidade

/**
 * Gerenciador de teste de unidade de {@link CargoAdministrativo}.
 * @author Lucas Francisquini
 * @version 1.0 - 27/11/2015
 * @since 27/11/2015
 */
class TesteCargoAdministrativoUnidade extends AbstractUnidade {

    /** Deve validar todos os campos obrigatório. **/
    @Test
    void deveValidarObrigatorios() {
        validarObrigatorios(new CargoAdministrativo())
    }

    /** Deve validar todos os campos com tamanho máximo. **/
    @Test
    void deveValidarTamanhoMaximo() {
        CargoAdministrativo dominio = fabricar()
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
        new CargoAdministrativo(id: 10, descricao: gerarTexto(40))
    }

    /**
     * Fabrica um cargo inválido para teste.
     * @return cargo inválido para teste.
     */
    static def fabricarTamanhoInvalido() {
        new CargoAdministrativo(id: 10, descricao: gerarTexto(40))
    }
}