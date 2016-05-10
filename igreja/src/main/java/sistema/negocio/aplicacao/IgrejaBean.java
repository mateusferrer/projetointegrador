package sistema.negocio.aplicacao;

import java.io.Serializable;
import java.util.List;

import sistema.negocio.dominio.Igreja;

import com.forj.cirrus.infra.exceptions.NegocioException;

/**
 * Contrato de operações do caso de uso de manutenção de <b>Igreja</b> do
 * módulo <b>Igreja</b>.
 * @author Lucas Francisquini
 * @version 1.0 - 04/05/2016
 * @since 04/05/2016
 */
public interface IgrejaBean extends Serializable {

	/**
	 * Pesquisa igrejas.
	 * @return listagem de todas as igrejas.
	 * @throws NegocioException em caso de erros.
	 */
	public List<Igreja> get() throws NegocioException;

	/**
	 * Pesquisa a igreja pelo código.
	 * @return igreja encontrada com o código informado.
	 * @throws NegocioException em caso de erros.
	 */
	public Igreja getPorCodigo(Integer codigo) throws NegocioException;

}
