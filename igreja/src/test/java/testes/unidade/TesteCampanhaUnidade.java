package testes.unidade;

import java.math.BigDecimal;
import java.util.Date;

import org.junit.Assert;
import org.junit.Test;

import sistema.negocio.dominio.campanha.Campanha;
import sistema.negocio.dominio.membro.Membro;
import sistema.negocio.enums.StatusCampanha;
import testes.global.AbstractUnidade;
import testes.util.DadosSistema;

import com.forj.cirrus.infra.exceptions.NegocioException;
import com.forj.cirrus.util.facades.FacadeData;

/**
 * Gerenciador de teste de unidade de {@link Campanha}.
 * @version 1.0 - 30/05/2016
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
        validarInvalidos(fabricarInvalido());
    }

    /** Deve validar todos os campos com sucesso. **/
    @Test
    public void deveValidarSucesso() {
        validarSucesso(fabricar());
    }

    /** Não deve adicionar contribuinte com dados inválidos. */
    @Test
    public void naoDeveAdicionarContribuinteComDadosInvalidos() {
        try {
            Campanha campanha = new Campanha();
            campanha.addContribuinte(null);
            Assert.fail("Não deve adicionar contribuinte com dados inválidos.");
        } catch (NegocioException e) {
            System.out.println(e.getErrosString());
        }
    }

    /** Não deve adicionar contribuinte já adicionado. */
    @Test
    public void naoDeveAdicionarContribuinteJaAdicionado() {
        try {
            Campanha campanha = fabricar();
            Membro membro = TesteMembroUnidade.fabricar();
            campanha.addContribuinte(membro);
            campanha.addContribuinte(membro);
            Assert.fail("Não deve adiciona r contribuinte ja adicionado.");
        } catch (NegocioException e) {
            System.out.println(e.getErrosString());
        }
    }

    /** Não deve adicionar contribuinte com dados inválidos. */
    @Test
    public void deveAdicionarContribuinteSucesso() {
        try {
            Campanha campanha = fabricar();
            campanha.addContribuinte(TesteMembroUnidade.fabricar());
        } catch (NegocioException e) {
            Assert.fail("Deveria ter adicionado o contribuinte com sucesso - " + e.getErrosString());
        }
    }

    /** Não deve adicionar contribuinte com dados inválidos. */
    @Test
    public void deveAplicarValorPorContribuinteSucesso() {
        Campanha campanha = fabricarComContribuintes();
        campanha.aplicarValorPorContribuinte();
        campanha.getContribuintes().stream().forEach(
                c -> Assert.assertEquals(new BigDecimal("140.00"), c.getValor()));
    }

    /**
     * Fabrica uma campanha válida para os testes.
     * @return campanha válida para teste.
     */
    public static Campanha fabricar() {
        return new Campanha(
                gerarLong(1), gerarTexto(30), new BigDecimal("1400.00"), 10, FacadeData.adicionarMeses(
                        new Date(), 1), StatusCampanha.AB, TesteEntidadeUnidade.fabricar(), new Date(),
                new Date(), DadosSistema.USUARIO);
    }

    /**
     * Fabrica uma campanha inválida para os testes.
     * @return campanha inválida para teste.
     */
    public static Campanha fabricarInvalido() {
        return new Campanha(
                gerarLong(1), gerarTexto(51), gerarValor(13), gerarInteger(3), FacadeData.adicionarMeses(
                        new Date(), 1), StatusCampanha.AB, TesteEntidadeUnidade.fabricar(), new Date(),
                new Date(), DadosSistema.USUARIO + gerarTexto(1));
    }

    /**
     * Fabrica uma campanha válida com contribuintes para os testes.
     * @return campanha válida com contribuintes para teste.
     */
    public static Campanha fabricarComContribuintes() {
        Campanha campanha = fabricar();
        campanha.setContribuintes(TesteContribuinteUnidade.fabricar());
        return campanha;
    }

}