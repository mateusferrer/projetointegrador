package testes.unidade

import org.junit.Test

import com.forj.cirrus.negocio.dominio.servicos.Dominio;

import sistema.negocio.dominio.CargoEclesiastico
import sistema.negocio.dominio.Igreja
import sistema.negocio.dominio.Membro
import sistema.negocio.dominio.TipoEvento
import testes.global.AbstractUnidade

/**
 * Gerenciador de teste de unidade de {@link TipoEvento}.
 * @author Lucas Francisquini
 * @version 1.0 - 27/11/2015
 * @since 27/11/2015
 */
class TesteTipoEventoUnidade extends AbstractUnidade {

    /** Deve validar todos os campos obrigatório. **/
    @Test
    void deveValidarObrigatorios() {
        validarObrigatorios(new TipoEvento())
    }

    /** Deve validar todos os campos com tamanho máximo. **/
    @Test
    void deveValidarTamanhoMaximo() {
        TipoEvento dominio = fabricar()
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
        new TipoEvento(id: 10, descricao: gerarTexto(40))
    }
}