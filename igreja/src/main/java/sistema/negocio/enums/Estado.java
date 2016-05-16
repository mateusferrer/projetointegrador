package sistema.negocio.enums;

import com.forj.cirrus.infra.exceptions.NegocioException;

/**
 * Gerenciador de flags para estado.
 * @version 1.0 - 16/05/2016
 * @since 16/05/2016
 */
public enum Estado {
	AC,	AL,	AP,	AM,	BA,	CE,	DF,	ES,	GO,	MA,	MT,	MS,	MG,	PA,	PB,	PR,
	PE,	PI,	RJ,	RN,	RS,	RO,	RR,	SC,	SP,	SE,	TO;

	/**
	 * Converte a flag na descri��o do enum.
	 * @param flag a ser convertida.
	 * @return descricao da flag informada.
	 */
	public static String getInstance(Estado flag) {
		String instance = "";
		switch (flag) {
		case AC: instance = "Acre";
		case AL: instance = "Alagoas";
		case AP: instance = "Amap�";
		case AM: instance = "Amazonas";
		case BA: instance = "Bahia";
		case CE: instance = "Cear�";
		case DF: instance = "Distrito Federal";
		case ES: instance = "Esp�rito Santo";
		case GO: instance = "Goi�s";
		case MA: instance = "Maranh�o";
		case MT: instance = "Mato Grosso";
		case MS: instance = "Mato Grosso do Sul";
		case MG: instance = "Minas Gerais";
		case PA: instance = "Par�";
		case PB: instance = "Para�ba";
		case PR: instance = "P�ran�";
		case PE: instance = "Pernambuco";
		case PI: instance = "Piau�";
		case RJ: instance = "Rio de Janeiro";
		case RN: instance = "Rio Grande do Norte";
		case RS: instance = "Rio do Grande do Norte";
		case RO: instance = "Rond�nia";
		case RR: instance = "Roraima";
		case SC: instance = "Santa Catarina";
		case SP: instance = "S�o Paulo";
		case SE: instance = "Sergipe";
		case TO: instance = "Tocantins";
		default:
			new NegocioException("Valor inv�lido!");
			break;
		}
		return instance;
	}
	
}
