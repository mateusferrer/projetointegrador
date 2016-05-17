package sistema.negocio.aplicacao.membro;

import java.io.Serializable;
import java.util.List;

import sistema.negocio.dominio.membro.Membro;

import com.forj.cirrus.infra.exceptions.NegocioException;

/**
 * Contrato de operações do caso de uso de manutenção de <b>Membro</b>.
 * 
 * @version 1.0 - 16/05/2016
 * @since 16/05/2016
 */
public interface MembroBean extends Serializable {

	/**
	 * Pesquisa o membro pelo nome.
	 * @return membro encontrado com o nome informado.
	 * @throws NegocioException
	 *             em caso de erros.
	 */
	public List<Membro> get(String nome) throws NegocioException;

}
