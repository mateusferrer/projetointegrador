package testes.unidade;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Test;

import sistema.negocio.dominio.campanha.Contribuinte;
import testes.global.AbstractUnidade;

/**
 * Gerenciador de teste de unidade de {@link Contribuinte}.
 * @version 1.0 - 30/05/2016
 * @since 30/05/2016
 */
public class TesteContribuinteUnidade extends AbstractUnidade {

    /** Deve validar todos os campos obrigat�rio. **/
    @Test
    public void deveValidarObrigatorios() {
        validarObrigatorios(new Contribuinte());
    }

    /** Deve validar todos os campos com tamanho m�ximo. **/
    @Test
    public void deveValidarTamanhoMaximo() {
        validarInvalidos(fabricarInvalido());
    }

    /** Deve validar todos os campos com sucesso. **/
    @Test
    public void deveValidarSucesso() {
        validarSucesso(fabricar().get(0));
    }

    /**
     * Fabrica umcontribuinte v�lido para os testes.
     * @return contribuinte v�lido para teste.
     */
    public static List<Contribuinte> fabricar() {
        List<Contribuinte> contribuintes = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            contribuintes.add(new Contribuinte(
                    gerarLong(1), TesteCampanhaUnidade.fabricar(), TesteMembroUnidade.fabricar(),
                    BigDecimal.TEN, new Date(), new Date()));
        }
        return contribuintes;
    }

    /**
     * Fabrica um contribuinte inv�lido para os testes.
     * @return contribuinte inv�lido para teste.
     */
    public static Contribuinte fabricarInvalido() {
        return new Contribuinte(gerarLong(1), null, null, gerarValor(13), null, null);
    }

}