package sistema.visao.lancamento
import javax.faces.model.SelectItemimport javax.inject.Injectimport javax.inject.Namedimport org.springframework.context.annotation.Scopeimport sistema.infra.formularios.GListaDetalheFrmimport sistema.negocio.aplicacao.LancamentoBeanimport sistema.negocio.dominio.FiltroLancamentoimport sistema.negocio.dominio.Lancamentoimport com.forj.cirrus.infra.spring.Escopoimport com.forj.cirrus.util.Bean
/** * Gerenciador de formul�rios GUI JSF de manuten��o <b>Lancamento</b>. * @author Lucas Francisquini * @version 1.0 - 30/11/2015 * @since 30/11/2015 */@Named
@Scope(Escopo.SESSION)
class LancamentoFrm extends GListaDetalheFrm<Lancamento> {
    /** Gerenciador dos processos de neg�cio. **/    @Inject    LancamentoBean bean    /** Armazena o filtro da pesquisa. **/    FiltroLancamento filtro    /** Armazena o saldo de receitas ativas. **/    BigDecimal saldo
    /** Contrutor padr�o. **/
    LancamentoFrm() {
        titulo = "Manuten��o de Lan�amentos"
        dominio = new Lancamento()        filtro = new FiltroLancamento()    }    /** Mostra o saldo de receitas ativas em tela para visualiza��o do usu�rio. **/    void buscarSaldo() {        saldo = bean.getSaldo()    }    /** {@inheritDoc} */    @Override    public String alterar(Lancamento objeto) {        dominio.limpar()        objeto.alterarStatus()        Bean.copiarPropriedades(dominio, objeto)        alterar = true        super.gravar()        colecao.remove(objeto)    }
    /** {@inheritDoc} */
    @Override
    void pesquisar() {        println ""        try {            colecao = bean.get(filtro)        } catch (ex) {
            gerarErrosRia(ex)        }    }    /** Armazena op��es de sele��o para filtragem de tipo do lan�amento. **/    static final SelectItem[] tipoLancamento = [        new SelectItem("R", "Receita"),        new SelectItem("D", "Despesa")    ]    /** Armazena op��es de sele��o para filtragem de estorno. **/    static final SelectItem[] statusLancamento = [        new SelectItem("A", "Ativos"),        new SelectItem("I", "Estornos")    ]    /** Armazena op��es de sele��o para tipos de receita. **/    static final SelectItem[] tipoReceita = [        new SelectItem("D", "D�zimo"),        new SelectItem("O", "Oferta"),        new SelectItem("P", "Promo��o"),        new SelectItem("T", "Outros")    ]    /** Armazena op��es de sele��o para tipos de despesa. **/    static final SelectItem[] tipoDespesa = [        new SelectItem("A", "Administrativa"),        new SelectItem("S", "Sa�de"),        new SelectItem("D", "Dimens�o Religiosa"),        new SelectItem("T", "Outros")    ]}