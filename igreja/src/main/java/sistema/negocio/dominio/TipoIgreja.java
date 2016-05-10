package sistema.negocio.dominio;

import com.forj.cirrus.infra.exceptions.NegocioException;

/**
 * Gerenciador de flags para o dominio {@link TipoIgreja} do módulo
 * <b>Igreja</b>.
 * 
 * @author Lucas Francisquini
 * @version 1.0 - 04/05/2016
 * @since 04/05/2016
 */
public enum TipoIgreja {
	MATRIZ("M"), FILIAL("F");

	/** Armazena a flag. **/
	private String flag;

	/**
	 * Cria um novo objeto com valores padrões.
	 */
	private TipoIgreja(String value) {
		this.flag = value;
	}

	/**
	 * Recupera o valor encontrado na propriedade <b>flag</b>.
	 * 
	 * @return valor armazenado na propriedade <b>flag</b>.
	 */
	public String getFlag() {
		return flag;
	}

	/**
	 * Converte a flag na descrição do enum.
	 * 
	 * @param flag
	 *            a ser convertida.
	 * @return descricao da flag informada.
	 */
	public static String getInstance(TipoIgreja flag) {
		String instance = "";
		switch (flag) {
		case MATRIZ:
			instance = "Matriz";
		case FILIAL:
			return instance = "Filial";
		default:
			new NegocioException("Valor inválido!");
			break;
		}
		return instance;
	}

}
