package sistema.negocio.aplicacao.membro;

import java.util.List;

import javax.inject.Named;

import sistema.negocio.dominio.membro.Membro;

import com.forj.cirrus.infra.exceptions.NegocioException;
import com.forj.cirrus.negocio.aplicativo.DominioBeanImp;
import com.forj.cirrus.util.validacao.Val;

/**
 * Gerenciador de processos de negócio para o domínio <b>Membro</b>.
 * @version 1.0 - 16/05/2016
 * @since 16/05/2016
 */
@Named
public class MembroBeanImp extends DominioBeanImp<Membro> implements MembroBean {

	/** {@inheritDoc} */
	@Override
	public List<Membro> get(String nome) throws NegocioException {
		if (!Val.vazio(nome)) {
			return eao.get(Membro.POR_NOME, nome);
		} else {
			return eao.get(Membro.TODOS);
		}
	}
}