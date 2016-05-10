package sistema.visao.agenda
import groovy.transform.TypeCheckedimport javax.faces.model.SelectItemimport javax.inject.Injectimport javax.inject.Namedimport org.springframework.context.annotation.Scopeimport sistema.infra.formularios.GListaDetalheFrmimport sistema.negocio.aplicacao.AgendaBeanimport sistema.negocio.dominio.Agendaimport com.forj.cirrus.infra.spring.Escopo
/** * Gerenciador de formul�rios GUI JSF de manuten��o <b>Agenda</b>. * @author Lucas Francisquini * @version 1.0 - 29/11/2015 * @since 29/11/2015 */@Named
@Scope(Escopo.SESSION)class AgendaFrm extends GListaDetalheFrm<Agenda> {
	/** Armazena o servi�o de negocio. **/	@Inject	AgendaBean bean
	/** Contrutor padr�o. **/
	AgendaFrm() {
		titulo = "Manuten��o de Agenda"
		dominio = new Agenda()	}

	/** {@inheritDoc} */
	@Override
	void pesquisar() {
		try {
			colecao = bean.get(Agenda.TODOS)		} catch (ex) {
			gerarErrosRia(ex)		}	}	/** Armazena op��es de sele��o para tipo de agenda. **/	static final SelectItem[] tipoAgenda = [		new SelectItem("E", "Evento"),		new SelectItem("R", "Reuni�o")	]	/** Armazena op��es de sele��o para status. **/	static final SelectItem[] status = [		new SelectItem("A", "Aguardando Confirma��o"),		new SelectItem("C", "Confirmado"),		new SelectItem("D", "Cancelado"),		new SelectItem("F", "Finalizado")	]}