package sistema.negocio.aplicacao;

import java.util.List;

import javax.inject.Named;

import sistema.negocio.dominio.Congregacao;

import com.forj.cirrus.infra.exceptions.NegocioException;
import com.forj.cirrus.negocio.aplicativo.DominioBeanImp;

/**
 * Gerenciador de processos de negócio para o domínio <b>Igreja</b>.
 * 
 * @author Lucas Francisquini
 * @version 1.0 - 26/11/2015
 * @since 26/11/2015
 */
@Named
public class IgrejaBeanImp extends DominioBeanImp<Congregacao> implements IgrejaBean {

	/** Armazena a versão da classe. **/
	private static final long serialVersionUID = -1755569326302384160L;

	/** {@inheritDoc} */
	@Override
	public List<Congregacao> get() throws NegocioException {
		return eao.get(Congregacao.TODOS);
	}

	/** {@inheritDoc} */
	@Override
	public Congregacao getPorCodigo(Integer codigo) throws NegocioException {
		return eao.getPorId(Congregacao.class, codigo);
	}
}