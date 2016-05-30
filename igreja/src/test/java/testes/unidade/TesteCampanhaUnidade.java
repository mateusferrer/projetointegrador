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
 * Gerenciador de teste de unidade de {@link Membro}.
 * 
 * @version 1.0 - 16/05/2016
 * @since 16/05/2016
 */
public class TesteCampanhaUnidade extends AbstractUnidade {

	/** Deve validar todos os campos obrigatório. **/
	@Test
	public void deveValidarObrigatorios() {
		validarObrigatorios(new Campanha());
	}

	/** Deve validar membro contribuinte obrigatório. **/
	@Test
	public void deveValidarContribuinteObrigatorio() {
		Campanha campanha = new Campanha();
		try {
			campanha.addContribuinte(null);
			Assert.fail("Deve validar membro contribuinte obrigatório.");
		} catch (NegocioException e) {
			System.out.println(e.getErrosString());
		}
	}

	/** Deve validar o valor unitário de cada membro contribuinte. **/
	@Test
	public void deveValidarValorUnitario() {
		Campanha campanha = fabricar();
		campanha.getContribuintes().stream()
				.forEach(c -> c.getValor().equals(new BigDecimal("140.00")));
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
	 * 
	 * @return membro válido para teste.
	 */
	public static Campanha fabricar() {
		Campanha campanha = new Campanha(gerarLong(1), gerarTexto(30),
				new BigDecimal("1400.00"), 10, FacadeData.adicionarMeses(
						new Date(), 1), StatusCampanha.AB,
				TesteEntidadeUnidade.fabricar(), DadosSistema.USUARIO);
		for (Membro membro : TesteMembroUnidade.fabricarMembros()) {
			try {
				campanha.addContribuinte(membro);
			} catch (NegocioException e) {
				System.out.println(e.getErrosString());
			}
		}
		return campanha;
	}

	/**
	 * Fabrica um membro válido para teste.
	 * 
	 * @return membro válido para teste.
	 */
	public static Campanha fabricarInvalido() {
		return new Campanha(gerarLong(1), gerarTexto(51), gerarValor(13),
				gerarInteger(3), FacadeData.adicionarMeses(new Date(), 1),
				StatusCampanha.AB, TesteEntidadeUnidade.fabricar(),
				DadosSistema.USUARIO + gerarTexto(1));
	}

}