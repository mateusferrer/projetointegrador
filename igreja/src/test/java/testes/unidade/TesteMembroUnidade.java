package testes.unidade;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Test;

import sistema.negocio.dominio.membro.Membro;
import sistema.negocio.enums.Decisao;
import sistema.negocio.enums.Sexo;
import sistema.negocio.enums.Status;
import testes.global.AbstractUnidade;
import testes.util.DadosSistema;

/**
 * Gerenciador de teste de unidade de {@link Membro}.
 * 
 * @version 1.0 - 16/05/2016
 * @since 16/05/2016
 */
public class TesteMembroUnidade extends AbstractUnidade {

	/** Deve validar todos os campos obrigatório. **/
	@Test
	public void deveValidarObrigatorios() {
		validarObrigatorios(new Membro());
	}

	/** Deve validar todos os campos com tamanho máximo. **/
	@Test
	public void deveValidarTamanhoMaximo() {
		validarInvalidos(fabricarInvalido());
	}

	/** Deve validar todos os campos com sucesso. **/
	@Test
	public void deveValidarSucesso() {
		Membro membro = fabricar();
		membro.setDataInclusao(new Date());
		membro.setDataAlteracao(new Date());
		membro.setUsuario(gerarTexto(10));
		validarSucesso(membro);
	}

	/**
	 * Fabrica um membro válido para teste.
	 * 
	 * @return membro válido para teste.
	 */
	public static Membro fabricar() {
		return new Membro(gerarLong(1), gerarTexto(50),
				gerarLong(9).toString(), gerarLong(11).toString(), new Date(),
				gerarLong(8), gerarTexto(50), gerarInteger(5), gerarTexto(50),
				gerarTexto(2), gerarTexto(50), Sexo.M, gerarTexto(100),
				gerarLong(11).toString(), gerarLong(11).toString(), Status.A,
				gerarTexto(100), TesteEntidadeUnidade.fabricar(),
				TesteTipoMembroUnidade.fabricar(), Decisao.N, null,
				DadosSistema.USUARIO);
	}

	/**
	 * Fabrica um membro válido para teste.
	 * 
	 * @return membro válido para teste.
	 */
	public static List<Membro> fabricarMembros() {
		List<Membro> membros = new ArrayList<>();
		for (int i = 0; i < 10; i++) {
			membros.add(new Membro(gerarLong(2), gerarTexto(50), gerarLong(9)
					.toString(), gerarLong(11).toString(), new Date(),
					gerarLong(8), gerarTexto(50), gerarInteger(5),
					gerarTexto(50), gerarTexto(2), gerarTexto(50), Sexo.M,
					gerarTexto(100), gerarLong(11).toString(), gerarLong(11)
							.toString(), Status.A, gerarTexto(100),
					TesteEntidadeUnidade.fabricar(), TesteTipoMembroUnidade
							.fabricar(), Decisao.N, null, DadosSistema.USUARIO));
		}
		return membros;
	}

	/**
	 * Fabrica um membro inválido para teste.
	 * 
	 * @return membro inválido para teste.
	 */
	public static Membro fabricarInvalido() {
		return new Membro(gerarLong(1), gerarTexto(51), gerarLong(10)
				.toString(), gerarLong(12).toString(), new Date(),
				gerarLong(9), gerarTexto(51), gerarInteger(6), gerarTexto(51),
				gerarTexto(3), gerarTexto(51), Sexo.M, gerarTexto(101),
				gerarLong(12).toString(), gerarLong(12).toString(), Status.A,
				gerarTexto(151), TesteEntidadeUnidade.fabricar(),
				TesteTipoMembroUnidade.fabricar(), Decisao.N, new Date(),
				DadosSistema.USUARIO);
	}
}