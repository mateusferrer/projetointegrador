package testes.unidade;

import java.util.Date;

import org.junit.Test;

import sistema.negocio.dominio.entidade.Entidade;
import sistema.negocio.enums.TipoEntidade;
import testes.global.AbstractUnidade;
import testes.util.DadosSistema;

/**
 * Gerenciador de teste de unidade de {@link Entidade}.
 * @version 1.0 - 15/05/2016
 * @since 15/05/2016
 */
public class TesteEntidadeUnidade extends AbstractUnidade {

    /** Deve validar todos os campos obrigatório. **/
    @Test
    public void deveValidarObrigatorios() {
        validarObrigatorios(new Entidade());
    }

    /** Deve validar todos os campos com tamanho máximo. **/
    @Test
    public void deveValidarTamanhoMaximo() {
        Entidade entidade = fabricarInvalido();
        entidade.setUsuario(gerarTexto(11));
        validarInvalidos(fabricarInvalido());
    }

    /** Deve validar todos os campos com sucesso. **/
    @Test
    public void deveValidarSucesso() {
        Entidade entidade = fabricar();
        entidade.setDataInclusao(new Date());
        entidade.setDataAlteracao(new Date());
        entidade.setUsuario(gerarTexto(10));
        validarSucesso(entidade);
    }

    /**
     * Fabrica uma entidade válida para teste.
     * @return entidade válida para teste.
     */
    public static Entidade fabricar() {
        return new Entidade(
                gerarLong(1), gerarTexto(30), gerarLong(14).toString(), gerarLong(8), gerarTexto(50),
                gerarInteger(5), gerarTexto(50), gerarTexto(2), gerarTexto(50), null, gerarLong(11)
                        .toString(), TipoEntidade.M, null, DadosSistema.USUARIO);
    }

    /**
     * Fabrica uma entidade inválida para teste.
     * @return entidade inválida para teste.
     */
    public static Entidade fabricarInvalido() {
        return new Entidade(
                gerarLong(1), gerarTexto(51), gerarLong(15).toString(), gerarLong(9), gerarTexto(51),
                gerarInteger(6), gerarTexto(51), gerarTexto(3), gerarTexto(51), null, gerarLong(12)
                        .toString(), TipoEntidade.M, null, DadosSistema.USUARIO + gerarTexto(1));
    }

}