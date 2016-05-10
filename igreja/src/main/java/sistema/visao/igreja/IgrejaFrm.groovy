package sistema.visao.igrejaimport javax.annotation.Resourceimport javax.faces.model.SelectItem;import javax.inject.Inject;import javax.inject.Namedimport org.springframework.context.annotation.Scopeimport sistema.infra.formularios.GListaDetalheFrmimport sistema.negocio.dominio.Cidade;import sistema.negocio.dominio.Estado;import sistema.negocio.dominio.Igrejaimport com.forj.cirrus.infra.spring.Escopo;import com.forj.cirrus.negocio.aplicativo.DominioBeanimport com.forj.cirrus.util.Cirrus;/** * Gerenciador de formul�rios GUI JSF de manuten��o <b>Igreja</b>. * @author Lucas Francisquini * @version 1.0 - 26/11/2015 * @since 26/11/2015 */@Named
@Scope(Escopo.SESSION)
class IgrejaFrm extends GListaDetalheFrm<Igreja> {	List<Estado> estados	List<Cidade> cidades	@Inject	DominioBean<Estado> estadoBean	/** Armazena op��es de sele��o para tipo de igreja. **/	static final SelectItem[] tipoIgreja = [		new SelectItem("M", "Matriz"),		new SelectItem("F", "Filial")	]	/** Armazena o servi�o de negocio. **/	@Resource(name = Cirrus.FACADE)	DominioBean<Igreja> bean	/** Contrutor padr�o. **/	IgrejaFrm() {		titulo = "Manuten��o de Igreja"		dominio = new Igreja()		estados = estadoBean.get(Estado.TODOS)	}	/** {@inheritDoc} */	@Override	public void pesquisar() {		try {			colecao = bean.get(Igreja.TODOS)		} catch (ex) {			gerarErrosRia(ex)		}	}	void buscarCidade() {	}}