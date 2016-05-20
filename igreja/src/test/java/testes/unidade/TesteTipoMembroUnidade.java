package testes.unidade;

import java.util.Date;

import org.junit.Test;

import sistema.negocio.dominio.membro.TipoMembro;
import testes.global.AbstractUnidade;

/**
 * Gerenciador de teste de unidade de {@link TipoMembro}.
 * @version 1.0 - 16/05/2016
 * @since 16/05/2016
 */
public class TesteTipoMembroUnidade extends AbstractUnidade {

    /** Deve validar todos os campos obrigatório. **/
    @Test
    public void deveValidarObrigatorios() {
        validarObrigatorios(new TipoMembro());
    }

    /** Deve validar todos os campos com tamanho máximo. **/
    @Test
    public void deveValidarTamanhoMaximo() {
        TipoMembro tipo = fabricar();
        tipo.setDescricao(gerarTexto(51));
        tipo.setUsuario(gerarTexto(11));
        validarInvalidos(tipo);
    }

    /** Deve validar todos os campos com sucesso. **/
    @Test
    public void deveValidarSucesso() {
        TipoMembro tipo = fabricar();
        tipo.setDataInclusao(new Date());
        tipo.setDataAlteracao(new Date());
        tipo.setUsuario(gerarTexto(10));
        validarSucesso(tipo);
    }

    /**
     * Fabrica um tipo de membro válido para teste.
     * @return tipo membro válido para teste.
     */
    public static TipoMembro fabricar() {
        return new TipoMembro(gerarLong(1), "Pastor");
    }
}