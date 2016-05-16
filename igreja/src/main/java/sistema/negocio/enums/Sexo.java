package sistema.negocio.enums;

import com.forj.cirrus.infra.exceptions.NegocioException;

/**
 * Gerenciador de flags para decis�o Sim ou N�o.
 * @version 1.0 - 16/05/2016
 * @since 16/05/2016
 */
public enum Sexo {
	M,
	F;

	/**
	 * Converte a flag na descri��o do enum.
	 * @param flag a ser convertida.
	 * @return descricao da flag informada.
	 */
	public static String getInstance(Sexo flag) {
		String instance = "";
		switch (flag) {
		case M:
			instance = "Masculino";
		case F:
			return instance = "Feminino";
		default:
			new NegocioException("Valor inv�lido!");
			break;
		}
		return instance;
	}
	
}
