package sistema.negocio.aplicacao.entidade;

import java.util.Date;
import java.util.List;

import javax.inject.Named;

import sistema.negocio.dominio.Usuario;
import sistema.negocio.dominio.entidade.Entidade;

import com.forj.cirrus.infra.exceptions.NegocioException;
import com.forj.cirrus.negocio.aplicativo.DominioBeanImp;
import com.forj.cirrus.util.WebUtils;
import com.forj.cirrus.util.validacao.Param;
import com.forj.cirrus.util.validacao.Val;

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

	/** {@inheritDoc} */
	@Override
	public List<Entidade> get(String nome) throws NegocioException {
		if (!Val.vazio(nome)) {
			return eao.get(Entidade.POR_NOME, nome);
		}
		return eao.get(Entidade.TODOS);
	}

	/** {@inheritDoc} */
	@Override
	public Entidade getPorCodigo(Long codigo) throws NegocioException {
		Param.validar(codigo, "Código Entidade");
		return eao.getPrimeiro(Entidade.POR_CODIGO, codigo);
	}

	/** {@inheritDoc} */
	@Override
	public void inserir(Entidade entidade) throws NegocioException {
		Param.validar(entidade, "Entidade");
		entidade.setDataInclusao(new Date());
		entidade.setDataAlteracao(new Date());
		entidade.setUsuario(getUsuarioSessao());
		super.inserir(entidade);
	}

	/** {@inheritDoc} */
	@Override
	public void alterar(Entidade entidade) throws NegocioException {
		Param.validar(entidade, "Entidade");
		entidade.setDataAlteracao(new Date());
		entidade.setUsuario(getUsuarioSessao());
		super.alterar(entidade);
	}

	/**
	 * Recupera o usuário da sessão.
	 * 
	 * @return usuario da sessão.
	 */
	private String getUsuarioSessao() {
		Usuario usuario = (Usuario) WebUtils
				.getSessionAttribute("usuarioLogado");
		return usuario.getNome();
	}

}