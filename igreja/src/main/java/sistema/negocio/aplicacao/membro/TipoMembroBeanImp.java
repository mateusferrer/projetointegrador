package sistema.negocio.aplicacao.membro;

import java.util.List;

import javax.inject.Named;

import sistema.negocio.dominio.membro.TipoMembro;

import com.forj.cirrus.infra.exceptions.NegocioException;
import com.forj.cirrus.negocio.aplicativo.DominioBeanImp;

/**
 * Gerenciador de processos de neg�cio para o dom�nio <b>TipoMembro</b>.
 * @version 1.0 - 15/05/2016
 * @since 15/05/2016
 */
@Named
public class TipoMembroBeanImp extends DominioBeanImp<TipoMembro> implements
		TipoMembroBean {

	@Override
	public List<TipoMembro> get() throws NegocioException {
		return eao.get(TipoMembro.TODOS);
	}
}