package sistema.negocio.aplicacao.membro;

import java.util.Date;
import java.util.List;

import javax.inject.Named;

import sistema.negocio.dominio.membro.TipoMembro;

import com.forj.cirrus.infra.exceptions.NegocioException;
import com.forj.cirrus.negocio.aplicativo.DominioBeanImp;
import com.forj.cirrus.util.validacao.Param;
import com.forj.cirrus.util.validacao.Val;

/**
 * Gerenciador de processos de negócio para o domínio <b>TipoMembro</b>.
 * 
 * @version 1.0 - 15/05/2016
 * @since 15/05/2016
 */
@Named
public class TipoMembroBeanImp extends DominioBeanImp<TipoMembro> implements
		TipoMembroBean {

	/** {@inheritDoc} */
	@Override
	public List<TipoMembro> get(String descricao) throws NegocioException {
		if (!Val.vazio(descricao)) {
			return eao.get(TipoMembro.POR_DESCRICAO, descricao);
		}
		return eao.get(TipoMembro.TODOS);
	}

	/** {@inheritDoc} */
	@Override
	public TipoMembro getPorCodigo(Long codigo) throws NegocioException {
		Param.validar(codigo, "Código Tipo Membro");
		return eao.getPorId(TipoMembro.class, codigo);
	}

	/** {@inheritDoc} */
	@Override
	public void inserir(TipoMembro tipoMembro) throws NegocioException {
		Param.validar(tipoMembro, "Tipo Membro");
		tipoMembro.setDataInclusao(new Date());
		tipoMembro.setDataAlteracao(new Date());
		super.inserir(tipoMembro);
	}

	/** {@inheritDoc} */
	@Override
	public void alterar(TipoMembro tipoMembro) throws NegocioException {
		Param.validar(tipoMembro, "Tipo Membro");
		tipoMembro.setDataAlteracao(new Date());
		super.alterar(tipoMembro);
	}

	/** {@inheritDoc} */
	@Override
	public void excluir(TipoMembro tipoMembro) throws NegocioException {
		Param.validar(tipoMembro, "Tipo Membro");
		super.excluir(tipoMembro);
	}
}