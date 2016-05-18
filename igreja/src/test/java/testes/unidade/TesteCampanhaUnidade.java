package testes.unidade;

import java.math.BigDecimal;
import java.util.Date;

import org.junit.Test;

import sistema.negocio.dominio.Campanha;
import sistema.negocio.dominio.entidade.Entidade;
import sistema.negocio.dominio.membro.Membro;
import sistema.negocio.enums.Status;
import testes.global.AbstractUnidade;

import com.forj.cirrus.util.facades.FacadeData;

/**
 * Gerenciador de teste de unidade de {@link Membro}.
 * @version 1.0 - 16/05/2016
 * @since 16/05/2016
 */
public class TesteCampanhaUnidade extends AbstractUnidade {

    /** Deve validar todos os campos obrigatório. **/
    @Test
    public void deveValidarObrigatorios() {
        validarObrigatorios(new Campanha());
    }

    /** Deve validar todos os campos com tamanho máximo. **/
    @Test
    public void deveValidarTamanhoMaximo() {
        Campanha campanha = fabricar();
        campanha.setDescricao(gerarTexto(51));
        campanha.setNumParcelas(gerarInteger(3));
        campanha.setUsuario(gerarTexto(11));
        validarInvalidos(campanha);
    }

    /** Deve validar todos os campos com sucesso. **/
    @Test
    public void deveValidarSucesso() {
        validarSucesso(fabricar());
    }

    /**
     * Fabrica um membro válido para teste.
     * @return membro válido para teste.
     */
    public static Campanha fabricar() {
        return new Campanha("Aquisição Ar Condicionado", new BigDecimal("1400.00"), 10, FacadeData
                .adicionarMeses(new Date(), 1), Status.A, new Entidade());
    }
}