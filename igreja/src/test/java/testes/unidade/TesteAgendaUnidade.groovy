package testes.unidade

import org.junit.Test

import com.forj.cirrus.negocio.dominio.servicos.Dominio;

import sistema.negocio.dominio.Agenda
import sistema.negocio.dominio.CargoEclesiastico
import sistema.negocio.dominio.Congregacao
import sistema.negocio.dominio.Membro
import sistema.negocio.dominio.TipoEvento
import testes.global.AbstractUnidade

/**
 * Gerenciador de teste de unidade de {@link TipoEvento}.
 * @author Lucas Francisquini
 * @version 1.0 - 27/11/2015
 * @since 27/11/2015
 */
class TesteAgendaUnidade extends AbstractUnidade {

    /** Deve validar todos os campos obrigatório. **/
    @Test
    void deveValidarObrigatorios() {
        validarObrigatorios(new Agenda())
    }

    /** Deve validar todos os campos com tamanho máximo. **/
    @Test
    void deveValidarTamanhoMaximo() {
        Agenda dominio = fabricarTamanhosInvalidos()
        validarInvalidos(dominio)
    }

    /** Deve validar todos os campos com sucesso. **/
    @Test
    void deveValidarSucesso() {
        validarSucesso(fabricar())
    }

    /**
     * Fabrica uma agenda para teste.
     * @return agenda válida para teste.
     */
    static def fabricar() {
        new Agenda(id: 10, descricao: gerarTexto(40), data: new Date(),
        nome: gerarTexto(50), tipo: "E", status: "A", local: gerarTexto(50),
        tipoEvento: TesteTipoEventoUnidade.fabricar())
    }

    /**
     * Fabrica uma agenda inválida para teste.
     * @return agenda inválida para teste.
     */
    static def fabricarTamanhosInvalidos() {
        new Agenda(nome: gerarTexto(101), descricao: gerarTexto(501))
    }
}