package sistema.negocio.aplicacao.entidade;

import java.io.Serializable;
import java.util.List;

import sistema.negocio.dominio.entidade.Entidade;

import com.forj.cirrus.infra.exceptions.NegocioException;

/**
 * Contrato de operações do caso de uso de manutenção de <b>Entidade</b>.
 * 
 * @version 1.0 - 15/05/2016
 * @since 15/05/2016
 */
public interface EntidadeBean extends Serializable {

	/**
	 * Pesquisa todas as entidades.
	 * @return listagem de todas as entidades.
	 * @throws NegocioException em caso de erros.
	 */
	public List<Entidade> get() throws NegocioException;

	/**
	 * Pesquisa a entidade pelo código.
	 * @return entidade encontrada com o código informado.
	 * @throws NegocioException em caso de erros.
	 */
	public Entidade getPorCodigo(Integer codigo) throws NegocioException;

}
