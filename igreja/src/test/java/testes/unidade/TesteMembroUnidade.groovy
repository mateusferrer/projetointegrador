package testes.unidade

import org.junit.Test

import sistema.negocio.dominio.Membro
import testes.global.AbstractUnidade

/**
 * Gerenciador de teste de unidade de {@link Membro}.
 * @author Lucas Francisquini
 * @version 1.0 - 26/11/2015
 * @since 26/11/2015
 */
class TesteMembroUnidade extends AbstractUnidade {

    /** Deve validar todos os campos obrigatório. **/
    @Test
    void deveValidarObrigatorios() {
        validarObrigatorios(new Membro())
    }

    /** Deve validar todos os campos com tamanho máximo. **/
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
     * Fabrica um membro válido para teste.
     * @return membro válido para teste.
     */
    static def fabricar() {
        new Membro(id: 1, nome: "Wagner Soares", cpf: gerarLong(11).toString(), cep: gerarLong(8),
        logradouro: gerarTexto(30), numLogradouro: gerarInteger(2), estado: gerarTexto(50),
        cidade: gerarTexto(50), email: gerarTexto(30), telefone: gerarTexto(10),
        celular: gerarTexto(10), sexo: "M", dataNascimento: new Date(), dataBatismo: new Date(),
        dataCadastro: new Date(), registroBatismo: gerarLong(5), status: "A",
        cargo: TesteCargoEclesiasticoUnidade.fabricar(), igreja: TesteIgrejaUnidade.fabricar())
    }

    /**
     * Fabrica um membro inválido para teste.
     * @return membro inválido para teste.
     */
    static def fabricarTamanhoInvalido() {
        new Membro(nome: gerarTexto(120), cpf: gerarLong(12).toString(), cep: gerarLong(10),
        logradouro: gerarTexto(120), numLogradouro: gerarInteger(8), estado: gerarTexto(60),
        cidade: gerarTexto(60), email: gerarTexto(120), telefone: gerarTexto(20),
        celular: gerarTexto(20), sexo: "MM", dataNascimento: new Date(), dataBatismo: new Date(),
        dataCadastro: new Date(), registroBatismo: gerarLong(5), status: "AA",
        cargo: TesteCargoEclesiasticoUnidade.fabricar(), igreja: TesteIgrejaUnidade.fabricar())
    }
}