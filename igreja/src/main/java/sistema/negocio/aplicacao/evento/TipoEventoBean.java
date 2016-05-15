package sistema.negocio.aplicacao.evento;

import java.io.Serializable;
import java.util.List;

import sistema.negocio.dominio.evento.TipoEvento;

import com.forj.cirrus.infra.exceptions.NegocioException;

/**
 * Contrato de operações do caso de uso de manutenção de <b>TipoEvento</b>.
 * @version 1.0 - 15/05/2016
 * @since 15/05/2016
 */
public interface TipoEventoBean extends Serializable {

	/**
	 * Pesquisa todos os tipos de evento.
	 * 
	 * @return listagem de todos os tipos de evento.
	 * @throws NegocioException
	 *             em caso de erros.
	 */
	public List<TipoEvento> get() throws NegocioException;

}
