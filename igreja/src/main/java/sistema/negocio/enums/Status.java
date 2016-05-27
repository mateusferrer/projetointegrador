package sistema.negocio.enums;


/**
 * Gerenciador de flags para status Ativo e Inativo.
 * @version 1.0 - 16/05/2016
 * @since 16/05/2016
 */
public enum Status {
	A, I;

	/**
	 * Converte a flag na descrição do enum.
	 * @param flag a ser convertida.
	 * @return descricao da flag informada.
	 */
	public static String getInstance(Status flag) {
		String instance = "";
		switch (flag) {
		case A:
			instance = "Ativo";
		case I:
			instance = "Inativo";
		default:
			instance = "";
		}
		return instance;
	}

}
