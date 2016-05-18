package sistema.visao.entidade;import java.util.ArrayList;import java.util.List;import javax.faces.model.SelectItem;import javax.inject.Inject;import javax.inject.Named;import org.springframework.context.annotation.Scope;import sistema.infra.formularios.GListaDetalheFrm;import sistema.negocio.aplicacao.entidade.EntidadeBean;import sistema.negocio.dominio.entidade.Entidade;import sistema.negocio.enums.TipoEntidade;import com.forj.cirrus.infra.spring.Escopo;/** * Gerenciador de formul�rios GUI JSF de manuten��o de <b>Entidade</b>. *  * @version 1.0 - 16/05/2016 * @since 16/05/2016 */@Named@Scope(Escopo.SESSION)public class EntidadeFrm extends GListaDetalheFrm<Entidade> {	/** Listagem do combo de sele��o do status. **/	private List<SelectItem> cmboTipoIgreja;	/** Armazena o gerenciador dos processos de neg�cio. **/	@Inject	private EntidadeBean entidadeBean;	/** Armazena o nome da entidade para filtragem. **/	private String nomeEntidade;	/** Contrutor padr�o. **/	public EntidadeFrm() {		titulo = "Entidade";		dominio = new Entidade();		entrar();	}	/** Entra no detalhe executando as opera��es indicadas. */	public void prepararNovo() {		cmboTipoIgreja = new ArrayList<>();		preencherCmboTipoIgreja();	}	/** Preenche a combo de tipos de igreja. */	private void preencherCmboTipoIgreja() {		cmboTipoIgreja.add(new SelectItem(TipoEntidade.M, TipoEntidade				.getInstance(TipoEntidade.M)));		cmboTipoIgreja.add(new SelectItem(TipoEntidade.F, TipoEntidade				.getInstance(TipoEntidade.F)));	}	/** {@inheritDoc} */	@Override	public void pesquisar() {	}	/** {@inheritDoc} */	@Override	public void entrar() {		super.entrar();	}	public List<SelectItem> getCmboTipoIgreja() {		return cmboTipoIgreja;	}	public String getNomeEntidade() {		return nomeEntidade;	}	/**	 * Informa um novo valor na propriedade <b>nomeEntidade</b>.	 * 	 * @param nomeEntidade	 *            novo valor a ser informado.	 */	public void setNomeEntidade(String nomeEntidade) {		this.nomeEntidade = nomeEntidade;	}}