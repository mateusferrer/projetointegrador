package sistema.negocio.aplicacao;

import java.util.List;

import javax.inject.Named;

import sistema.negocio.dominio.Igreja;

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
public class IgrejaBeanImp extends DominioBeanImp<Igreja> implements IgrejaBean {

	/** Armazena a versão da classe. **/
	private static final long serialVersionUID = -1755569326302384160L;

	/** {@inheritDoc} */
	@Override
	public List<Igreja> get() throws NegocioException {
		return eao.get(Igreja.TODOS);
	}

	/** {@inheritDoc} */
	@Override
	public Igreja getPorCodigo(Integer codigo) throws NegocioException {
		return eao.getPorId(Igreja.class, codigo);
	}
}