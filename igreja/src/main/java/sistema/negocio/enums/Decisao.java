package sistema.negocio.enums;

import com.forj.cirrus.infra.exceptions.NegocioException;

/**
 * Gerenciador de flags para decis�o Sim ou N�o.
 * @version 1.0 - 16/05/2016
 * @since 16/05/2016
 */
public enum Decisao {
	S, 
	N;

	/**
	 * Converte a flag na descri��o do enum.
	 * @param flag a ser convertida.
	 * @return descricao da flag informada.
	 */
	public static String getInstance(Decisao flag) {
		String instance = "";
		switch (flag) {
		case S:
			instance = "Sim";
		case N:
			return instance = "N�o";
		default:
			new NegocioException("Valor inv�lido!");
			break;
		}
		return instance;
	}
	
}
