package sistema.negocio.aplicacao.campanha;

import java.util.Date;
import java.util.List;

import javax.inject.Named;

import sistema.negocio.dominio.Campanha;
import sistema.negocio.dominio.Usuario;

import com.forj.cirrus.infra.exceptions.NegocioException;
import com.forj.cirrus.negocio.aplicativo.DominioBeanImp;
import com.forj.cirrus.util.WebUtils;
import com.forj.cirrus.util.validacao.Param;
import com.forj.cirrus.util.validacao.Val;

/**
 * Gerenciador de processos de negócio para o domínio <b>Campanha</b>.
 * @version 1.0 - 18/05/2016
 * @since 18/05/2016
 */
@Named
public class CampanhaBeanImp extends DominioBeanImp<Campanha> implements
		CampanhaBean {

	/** {@inheritDoc} */
	@Override
	public List<Campanha> get(String descricao) throws NegocioException {
		if (Val.vazio(descricao)) {
			return eao.get(Campanha.TODOS);
		} else {
			return eao.get(Campanha.POR_DESCRICAO, descricao);
		}

	}

	/** {@inheritDoc} */
	@Override
	public Campanha getPorCodigo(Long codigo) throws NegocioException {
		Param.validar(codigo, "Código Campanha");
		return eao.getPrimeiro(Campanha.POR_CODIGO, codigo);
	}

	/** {@inheritDoc} */
	@Override
	public void inserir(Campanha campanha) throws NegocioException {
		Param.validar(campanha, "Campanha");
		campanha.setDataInclusao(new Date());
		campanha.setDataAlteracao(new Date());
		campanha.setUsuario(getUsuarioSessao());
		super.inserir(campanha);
	}

	/** {@inheritDoc} */
	@Override
	public void alterar(Campanha campanha) throws NegocioException {
		Param.validar(campanha, "Campanha");
		campanha.setDataAlteracao(new Date());
		campanha.setUsuario(getUsuarioSessao());
		super.alterar(campanha);
	}

	/**
	 * Recupera o usuário da sessão.
	 * @return usuario da sessão.
	 */
	private String getUsuarioSessao() {
		Usuario usuario = (Usuario) WebUtils
				.getSessionAttribute("usuarioLogado");
		return usuario.getNome();
	}

}