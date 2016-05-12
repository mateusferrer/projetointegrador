package sistema.visao.igreja;import java.util.ArrayList;import java.util.List;import javax.faces.model.SelectItem;import javax.inject.Inject;import javax.inject.Named;import org.springframework.context.annotation.Scope;import sistema.infra.formularios.GListaDetalheFrm;import sistema.negocio.aplicacao.IgrejaBean;import sistema.negocio.dominio.Cidade;import sistema.negocio.dominio.Estado;import sistema.negocio.dominio.Congregacao;import sistema.negocio.dominio.TipoIgreja;import com.forj.cirrus.infra.exceptions.NegocioException;import com.forj.cirrus.infra.spring.Escopo;import com.forj.cirrus.negocio.aplicativo.DominioBean;/** * Gerenciador de formul�rios GUI JSF de manuten��o <b>Igreja</b>. * @author Lucas Francisquini * @version 1.0 - 26/11/2015 * @since 26/11/2015 */@Named@Scope(Escopo.SESSION)public class IgrejaFrm extends GListaDetalheFrm<Congregacao> {    /** Armazena uma cole��o de estados. **/    private List<Estado> estados;    /** Armazena uma cole��o de cidades. **/    private List<Cidade> cidades;    /** Armazena o estado selecionado. **/    private Estado estadoSelecionado;    /** Armazena a cidade selecionada. **/    private Cidade cidadeSelecionada;    /** Listagem do combo de sele��o do status. **/    private List<SelectItem> cmboTipoIgreja;    private String valueEstado;    /** Armazena o gerenciador dos processos de neg�cio. **/    @Inject    private DominioBean<Estado> estadoBean;    /** Armazena o gerenciador dos processos de neg�cio. **/    @Inject    private DominioBean<Cidade> cidadeBean;    /** Armazena o gerenciador dos processos de neg�cio. **/    @Inject    private IgrejaBean igrejaBean;    /** Contrutor padr�o. **/    public IgrejaFrm() {        titulo = "Manuten��o de Igreja";        dominio = new Congregacao();    }    /** {@inheritDoc} */    @Override    public String novo() {        prepararNovo();        return super.novo();    }    /** Entra no detalhe executando as opera��es indicadas. */    private void prepararNovo() {        try {            cmboTipoIgreja = new ArrayList<>();            preencherCmboTipoIgreja();            estados = estadoBean.get(Estado.TODOS);            cidades = new ArrayList<>();            estadoSelecionado = new Estado();        } catch (NegocioException e) {            gerarErrosRia(e);        }    }    /** Preenche a combo de tipos de igreja. */    private void preencherCmboTipoIgreja() {        cmboTipoIgreja.add(new SelectItem(TipoIgreja.MATRIZ, TipoIgreja.getInstance(TipoIgreja.MATRIZ)));        cmboTipoIgreja.add(new SelectItem(TipoIgreja.FILIAL, TipoIgreja.getInstance(TipoIgreja.FILIAL)));    }    /** {@inheritDoc} */    @Override    public void pesquisar() {        try {            colecao = igrejaBean.get();        } catch (NegocioException e) {            gerarErrosRia(e);        }    }    /** Busca as cidades com base no id do estado selecionado. */    public void buscarCidades() {        try {            Long codEstado = Long.parseLong(this.valueEstado);            this.cidades = cidadeBean.get(Cidade.POR_ESTADO, codEstado);            System.out.println(cidades);        } catch (NegocioException e) {            gerarErrosRia(e);        }    }    // /**    // * Procura o(s) estado(s) de acordo com o texto indormado.    // * @param o valor a ser informado.    // * @return listagem dos estados encontrados.    // */    // public List<Estado> pesquisarPorNome(Object o) {    // String nome = (String) o;    // try {    //    // } catch (NegocioException e) {    // e.printStackTrace();    // }    // return this.estados;    // }    public DominioBean<Estado> getEstadoBean() {        return estadoBean;    }    public DominioBean<Cidade> getCidadeBean() {        return cidadeBean;    }    public Estado getEstadoSelecionado() {        return estadoSelecionado;    }    public List<Estado> getEstados() {        return estados;    }    public List<Cidade> getCidades() {        return cidades;    }    public Cidade getCidadeSelecionada() {        return cidadeSelecionada;    }    public List<SelectItem> getCmboTipoIgreja() {        return cmboTipoIgreja;    }    public void setCmboTipoIgreja(List<SelectItem> cmboTipoIgreja) {        this.cmboTipoIgreja = cmboTipoIgreja;    }    public void setEstadoSelecionado(Estado estadoSelecionado) {        this.estadoSelecionado = estadoSelecionado;    }    /**     * Retorna o valor existente na propriedade <b>valueEstado</b>.     * @return valor existente na <b>valueEstado</b>.     */    public String getValueEstado() {        return valueEstado;    }    /**     * Informa um novo valor na propriedade <b>valueEstado</b>.     * @param valueEstado novo valor a ser informado.     */    public void setValueEstado(String valueEstado) {        this.valueEstado = valueEstado;    }}