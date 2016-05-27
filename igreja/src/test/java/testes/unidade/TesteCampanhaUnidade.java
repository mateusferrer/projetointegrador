package testes.unidade;

import java.math.BigDecimal;
import java.util.Date;

import org.junit.Test;

import sistema.negocio.dominio.campanha.Campanha;
import sistema.negocio.dominio.membro.Membro;
import sistema.negocio.enums.StatusCampanha;
import testes.global.AbstractUnidade;
import testes.util.DadosSistema;

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
		Campanha campanha = fabricarInvalido();
		campanha.setUsuario(gerarTexto(11));
		validarInvalidos(campanha);
	}

	/** Deve validar todos os campos com sucesso. **/
	@Test
	public void deveValidarSucesso() {
		Campanha campanha = fabricar();
		campanha.setDataInclusao(new Date());
		campanha.setDataAlteracao(new Date());
		campanha.setUsuario(gerarTexto(10));
		validarSucesso(campanha);
	}

	/**
	 * Fabrica um membro válido para teste.
	 * @return membro válido para teste.
	 */
	public static Campanha fabricar() {
		return new Campanha(gerarLong(1), gerarTexto(30), new BigDecimal(
				"1400.00"), 10, FacadeData.adicionarMeses(new Date(), 1),
				StatusCampanha.AB, TesteEntidadeUnidade.fabricar(),
				DadosSistema.USUARIO);
	}

	/**
	 * Fabrica um membro válido para teste.
	 * @return membro válido para teste.
	 */
	public static Campanha fabricarInvalido() {
		return new Campanha(gerarLong(1), gerarTexto(51), gerarValor(13),
				gerarInteger(3), FacadeData.adicionarMeses(new Date(), 1),
				StatusCampanha.AB, TesteEntidadeUnidade.fabricar(),
				DadosSistema.USUARIO + gerarTexto(1));
	}

}