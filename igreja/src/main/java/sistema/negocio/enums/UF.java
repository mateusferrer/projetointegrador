package sistema.negocio.enums;


/**
 * Gerenciador de flags para estado.
 * @version 1.0 - 16/05/2016
 * @since 16/05/2016
 */
public enum UF {
	AC,	AL,	AP,	AM,	BA,	CE,	DF,	ES,	GO,	MA,	MT,	MS,	MG,	PA,	PB,	PR,
	PE,	PI,	RJ,	RN,	RS,	RO,	RR,	SC,	SP,	SE,	TO;

	/**
	 * Converte a flag na descrição do enum.
	 * @param flag a ser convertida.
	 * @return descricao da flag informada.
	 */
	public static String getInstance(UF flag) {
		String instance = "";
		switch (flag) {
		case AC: instance = "Acre";
		case AL: instance = "Alagoas";
		case AP: instance = "Amapá";
		case AM: instance = "Amazonas";
		case BA: instance = "Bahia";
		case CE: instance = "Ceará";
		case DF: instance = "Distrito Federal";
		case ES: instance = "Espírito Santo";
		case GO: instance = "Goiás";
		case MA: instance = "Maranhão";
		case MT: instance = "Mato Grosso";
		case MS: instance = "Mato Grosso do Sul";
		case MG: instance = "Minas Gerais";
		case PA: instance = "Pará";
		case PB: instance = "Paraíba";
		case PR: instance = "Páraná";
		case PE: instance = "Pernambuco";
		case PI: instance = "Piauí";
		case RJ: instance = "Rio de Janeiro";
		case RN: instance = "Rio Grande do Norte";
		case RS: instance = "Rio do Grande do Norte";
		case RO: instance = "Rondônia";
		case RR: instance = "Roraima";
		case SC: instance = "Santa Catarina";
		case SP: instance = "São Paulo";
		case SE: instance = "Sergipe";
		case TO: instance = "Tocantins";
		default: instance = "";
		}
		return instance;
	}
	
}
