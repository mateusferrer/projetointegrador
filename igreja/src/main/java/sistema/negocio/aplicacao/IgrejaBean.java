package sistema.negocio.aplicacao;

import java.io.Serializable;
import java.util.List;

import sistema.negocio.dominio.Igreja;

import com.forj.cirrus.infra.exceptions.NegocioException;

/**
 * Contrato de opera��es do caso de uso de manuten��o de <b>Igreja</b> do
 * m�dulo <b>Igreja</b>.
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
	 * Pesquisa a igreja pelo c�digo.
	 * @return igreja encontrada com o c�digo informado.
	 * @throws NegocioException em caso de erros.
	 */
	public Igreja getPorCodigo(Integer codigo) throws NegocioException;

}
