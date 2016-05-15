package sistema.negocio.aplicacao.membro;

import java.io.Serializable;
import java.util.List;

import sistema.negocio.dominio.membro.TipoMembro;

import com.forj.cirrus.infra.exceptions.NegocioException;

/**
 * Contrato de operações do caso de uso de manutenção de <b>TipoMembro</b>.
 * @version 1.0 - 15/05/2016
 * @since 15/05/2016
 */
public interface TipoMembroBean extends Serializable {

	/**
	 * Pesquisa o todos os tipos de membro.
	 * @return listagem de tipos de membro.
	 * @throws NegocioException em caso de erros.
	 */
	public List<TipoMembro> get() throws NegocioException;

}
