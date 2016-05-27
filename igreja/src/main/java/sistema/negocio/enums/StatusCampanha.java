package sistema.negocio.enums;


/**
 * Gerenciador de flags para status Aberto, Em Andamento, Finalizado e
 * Cancelado.
 * 
 * @version 1.0 - 16/05/2016
 * @since 16/05/2016
 */
public enum StatusCampanha {
	AB, EA, FI, CA;

	/**
	 * Converte a flag na descrição do enum.
	 * @param flag
	 *            a ser convertida.
	 * @return descricao da flag informada.
	 */
	public static String getInstance(StatusCampanha flag) {
		String instance = "";
		switch (flag) {
		case AB:
			instance = "Aberto";
		case EA:
			instance = "Em Andamento";
		case FI:
			instance = "Finalizado";
		case CA:
			instance = "Cancelado";
		default:
			instance = "";
		}
		return instance;
	}

}
