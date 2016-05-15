package sistema.negocio.aplicacao.entidade;

import java.util.List;

import javax.inject.Named;

import sistema.negocio.dominio.entidade.Entidade;

import com.forj.cirrus.infra.exceptions.NegocioException;
import com.forj.cirrus.negocio.aplicativo.DominioBeanImp;
import com.forj.cirrus.util.validacao.Param;

/**
 * Gerenciador de processos de negócio para o domínio <b>Entidade</b>.
 * 
 * @author Lucas Francisquini
 * @version 1.0 - 26/11/2015
 * @since 26/11/2015
 */
@Named
public class EntidadeBeanImp extends DominioBeanImp<Entidade> implements
		EntidadeBean {

	/** Armazena a versão da classe. **/
	private static final long serialVersionUID = -1755569326302384160L;

	/** {@inheritDoc} */
	@Override
	public List<Entidade> get() throws NegocioException {
		return eao.get(Entidade.TODOS);
	}

	/** {@inheritDoc} */
	@Override
	public Entidade getPorCodigo(Integer codigo) throws NegocioException {
		Param.validar(codigo, "Código Entidade");
		return eao.getPorId(Entidade.class, codigo);
	}
}