package sistema.negocio.aplicacao.evento;

import java.util.List;

import javax.inject.Named;

import sistema.negocio.dominio.evento.TipoEvento;

import com.forj.cirrus.infra.exceptions.NegocioException;
import com.forj.cirrus.negocio.aplicativo.DominioBeanImp;

/**
 * Gerenciador de processos de negócio para o domínio <b>TipoEvento</b>.
 * 
 * @version 1.0 - 15/05/2016
 * @since 15/05/2016
 */
@Named
public class TipoEventoBeanImp extends DominioBeanImp<TipoEvento> implements
		TipoEventoBean {

	/**
	 * Pesquisa o todos os tipos de evento.
	 * 
	 * @return listagem de tipos de evento.
	 * @throws NegocioException
	 *             em caso de erros.
	 */
	public List<TipoEvento> get() throws NegocioException {
		return eao.get(TipoEvento.TODOS);
	}
}