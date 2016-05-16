package sistema.negocio.enums;

import com.forj.cirrus.infra.exceptions.NegocioException;

/**
 * Gerenciador de flags para o dominio {@link TipoEntidade} do módulo
 * <b>Igreja</b>.
 * 
 * @version 1.0 - 04/05/2016
 * @since 04/05/2016
 */
public enum TipoEntidade {
	M, F;

	/**
	 * Converte a flag na descrição do enum.
	 * @param flag a ser convertida.
	 * @return descricao da flag informada.
	 */
	public static String getInstance(TipoEntidade flag) {
		String instance = "";
		switch (flag) {
		case M:
			instance = "Matriz";
		case F:
			return instance = "Filial";
		default:
			new NegocioException("Valor inválido!");
			break;
		}
		return instance;
	}

}
